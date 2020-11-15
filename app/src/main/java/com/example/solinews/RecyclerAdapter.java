package com.example.solinews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    // Store a member variable for the contacts
    private List<String> mTitle;
    private List<String> mSubTitle;

    public RecyclerAdapter(List<String> title,List<String> subTitle){

        mTitle = title;
        mSubTitle = subTitle;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.news_item, parent, false);

        //Open expanded fragment on touch
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("ciao", "onClick: ");
                return true;
            }
        });

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        String title = mTitle.get(position);
        String subTitle = mSubTitle.get(position);

        // Set item views based on your views and data model
        TextView titleView = holder.title;
        titleView.setText(title);
        TextView subTitleView = holder.subTitle;
        subTitleView.setText(subTitle);
    }



    // Returns the total count of items in the list
    @Override
    public int getItemCount() {

        return mTitle.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView title;
        public TextView subTitle;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.news_title);
            subTitle = (TextView) itemView.findViewById(R.id.news_subtitle);
        }
    }



}

