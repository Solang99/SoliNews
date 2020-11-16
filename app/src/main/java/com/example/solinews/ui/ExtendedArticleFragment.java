package com.example.solinews.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.solinews.R;


public class ExtendedArticleFragment extends Fragment {


    private static final String TAG = "ExtendedArticleFragment";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extended_article, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String title = ExtendedArticleFragmentArgs.fromBundle(getArguments()).getExtendedTitle();
        String content = ExtendedArticleFragmentArgs.fromBundle(getArguments()).getContent();
        TextView titleView = view.findViewById(R.id.extended_title);
        titleView.setText(title);
        TextView contentView = view.findViewById(R.id.extended_content);
        contentView.setText(content);

    }
}