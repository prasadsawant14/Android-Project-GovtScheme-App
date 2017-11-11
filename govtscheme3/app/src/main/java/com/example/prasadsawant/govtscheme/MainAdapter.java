package com.example.prasadsawant.govtscheme;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasad sawant on 12-04-2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    /*private ArrayList<String> mDataset;

    public MainAdapter(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }*/
    //constructor============
    private static   List<TrendingData> entry;
    public MainAdapter(List<TrendingData> entry){
        this.entry = entry;
    }
    //==========================================


    @Override
    public int getItemCount() {
        return entry.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return  vh;
    }






    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTitle.setText(entry.get(position).data);
        holder.mimageView.setImageResource(entry.get(position).photoId);




    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public  class  ViewHolder extends  RecyclerView.ViewHolder {

        public TextView mTitle;
        public CardView mcardView;
        public ImageView mimageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mTitle.setClickable(true);
            mTitle.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href='http://stackoverflow.com/questions/9290651/make-a-hyperlink-textview-in-android'> </a>";
            mTitle.setText(Html.fromHtml(text));
            mcardView =(CardView) itemView.findViewById(R.id.cardView);
            mimageView =(ImageView) itemView.findViewById(R.id.newsImage);
        }

        public void onClick(View v){

        }


    }
}
