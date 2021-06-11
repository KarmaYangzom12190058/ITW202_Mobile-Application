package com.gcit.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FavDB extends SQLiteOpenHelper {
    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "DzongkhaProverbs.db";
    private static String TABLE_NAME = "favTable";
    public static String KEY_ID = "id";
    public static String ITEM_PROVERB = "itemProverb";
    public static String FAVOURITE_STATUS = "fStatus";

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + ITEM_PROVERB+ " TEXT, "
            + FAVOURITE_STATUS+" TEXT)";

    public FavDB(Context context){
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //required value
        for (int x=1; x<26; x++){
            contentValues.put(KEY_ID, x);
            contentValues.put(FAVOURITE_STATUS, "0");

            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    //inserting in database
    public void insertIntoDatabase(String item_proverb, String id, String fav_status){
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEM_PROVERB, item_proverb);
        contentValues.put(KEY_ID, id);
        contentValues.put(FAVOURITE_STATUS, fav_status);
        db.insert(TABLE_NAME, null, contentValues);
        Log.d("FavDB Status", item_proverb + ", favstatus - " +fav_status+" - . " + contentValues);
    }

    //reading all data
    public Cursor readAlldata(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID+"="+id+"";
        return db.rawQuery(sql, null, null);
    }

    //removing line from database
    public void removeFav(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET " + FAVOURITE_STATUS+" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());
    }

    //selecting all fav list
    public Cursor selectAllFav(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " +TABLE_NAME+ " WHERE " +FAVOURITE_STATUS+" ='1'";
        return db.rawQuery(sql, null, null);
    }

}
