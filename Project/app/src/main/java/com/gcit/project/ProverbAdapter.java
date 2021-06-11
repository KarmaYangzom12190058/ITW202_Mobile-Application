package com.gcit.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProverbAdapter extends RecyclerView.Adapter<ProverbAdapter.ViewHolder> {

    private ArrayList<ProverbItem> proverbItems;
    private Context context;
    private FavDB favDB;

    private RecyclerViewClickListener Listener;

    public ProverbAdapter(ArrayList<ProverbItem> proverbItems, Context context) {
        this.proverbItems = proverbItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new FavDB(context);

        SharedPreferences preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        boolean firstStart = preferences.getBoolean("firstStart", true);
        if (firstStart){
            createTableOnFirstStart();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proverbs_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProverbAdapter.ViewHolder holder, int position) {
        final ProverbItem proverbItem = proverbItems.get(position);

        readCursorData(proverbItem, holder);
        holder.pro_title.setText(proverbItem.getProverb());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                if (proverbItem.getKey_id().equals("0")){
                    intent = new Intent(context, proverbs_One.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("1")){
                    intent = new Intent(context, proverbs_Two.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("2")){
                    intent = new Intent(context, proverbs_Thre.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("3")){
                    intent = new Intent(context, proverbs_Four.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("4")){
                    intent = new Intent(context, proverbs_Five.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("5")){
                    intent = new Intent(context, proverbs_Six.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("6")){
                    intent = new Intent(context, proverbs_Seven.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("7")){
                    intent = new Intent(context, proverbs_Eight.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("8")){
                    intent = new Intent(context, proverbs_Nine.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("9")){
                    intent = new Intent(context, proverbs_Ten.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("10")){
                    intent = new Intent(context, proverbs_Eleven.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("11")){
                    intent = new Intent(context, proverbs_Tweleve.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("12")){
                    intent = new Intent(context, proverbs_Thirdteen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("13")){
                    intent = new Intent(context, proverbs_Fourteen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("14")){
                    intent = new Intent(context, proverbs_Fifthteen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("15")){
                    intent = new Intent(context, proverbs_Sixteen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("16")){
                    intent = new Intent(context, proverbs_Seventeen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("17")){
                    intent = new Intent(context, proverbs_Eightteen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("18")){
                    intent = new Intent(context, proverbs_Nineteen.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("19")){
                    intent = new Intent(context, proverbs_Twenty.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("20")){
                    intent = new Intent(context, proverbs_TwentyOne.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("21")){
                    intent = new Intent(context, proverbs_TwentyTwo.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("22")){
                    intent = new Intent(context, proverbs_TwentyThree.class);
                    context.startActivity(intent);
                }
                else if (proverbItem.getKey_id().equals("23")){
                    intent = new Intent(context, proverbs_TwnetyFour.class);
                    context.startActivity(intent);
                }
                else{
                    intent = new Intent(context, proverbs_TwentyFive.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return proverbItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pro_title;
        Button favBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pro_title = itemView.findViewById(R.id.pro_title);
            favBtn = itemView.findViewById(R.id.favBtn);

            //add to favorite section
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ProverbItem proverbItem = proverbItems.get(position);

                    if (proverbItem.getFavStatus().equals("0")){
                        proverbItem.setFavStatus("1");
                        favDB.insertIntoDatabase(proverbItem.getProverb(), proverbItem.getKey_id(),
                                proverbItem.getFavStatus());
                        favBtn.setBackgroundResource(R.drawable.ic_fav_2);
                    }
                    else {
                        proverbItem.setFavStatus("0");
                        favDB.removeFav(proverbItem.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.ic_favorite);
                    }
                }
            });
        }
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();

        SharedPreferences preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void readCursorData(ProverbItem proverbItem, ViewHolder holder) {
        Cursor cursor = favDB.readAlldata(proverbItem.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();

        try {
            while (cursor.moveToNext()){
                String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVOURITE_STATUS));
                proverbItem.setFavStatus(item_fav_status);

                if (item_fav_status != null && item_fav_status.equals("1")){
                    holder.favBtn.setBackgroundResource(R.drawable.ic_fav_2);

                }
                else if (item_fav_status != null && item_fav_status.equals("0")){
                    holder.favBtn.setBackgroundResource(R.drawable.ic_favorite);
                }
            }
        }finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
