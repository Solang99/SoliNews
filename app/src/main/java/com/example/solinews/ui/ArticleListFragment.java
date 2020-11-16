package com.example.solinews.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.solinews.R;
import com.example.solinews.adapter.RecyclerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArticleListFragment extends Fragment {

    private static  String mCategory ;
    List<String> title;
    List<String> subTitle;


    public static ArticleListFragment newInstance(String category) {
        ArticleListFragment fragment = new ArticleListFragment();
        mCategory=category;

        return fragment;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title= new ArrayList<>();
        subTitle= new ArrayList<>();
        readArticle();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_article, container, false);


        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycle_article);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // 3. create an adapter
        Log.d("cate", "onCreateView: " + title);
        RecyclerAdapter mAdapter = new RecyclerAdapter(title,subTitle);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);



     return rootView;
    }

    private void readArticle(){

        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
                .toString()+"/"+mCategory;

        File directory = new File(path);
        File[] files = directory.listFiles();


        for(File f : files){
            title.add(f.getName());
            subTitle.add(readContentFromFile(f));

        }


    }

    private String readContentFromFile(File file){
        int length = (int) file.length();

        byte[] bytes = new byte[length];


        try {
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return new String(bytes);

    }


}