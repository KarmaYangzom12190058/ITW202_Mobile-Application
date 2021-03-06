package com.gcit.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class sportsAdapter extends RecyclerView.Adapter<sportsAdapter.ViewHolder> {
    private ArrayList<sports> mSportsData;
    private Context mContext;

    sportsAdapter(Context context, ArrayList<sports> SportsData){
        this.mSportsData = SportsData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public sportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull sportsAdapter.ViewHolder holder, int position) {
        sports currentSport = mSportsData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subtitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);

        }

        void bindTo(sports currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());

            Glide.with(mContext).load(currentSport.getImageResources()).into(mSportsImage);
        }
    }
}
