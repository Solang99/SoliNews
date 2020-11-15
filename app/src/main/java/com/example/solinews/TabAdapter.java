package com.example.solinews;

import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.solinews.ui.news.NewsFragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStateAdapter {

    private static  List<String> categories = new ArrayList<>();



    public TabAdapter(@NonNull NewsFragment fragment) {
        super(fragment);
        buildCategories();
    }

    @NonNull @Override public Fragment createFragment(int position) {

        ArticleListFragment article =  ArticleListFragment.newInstance(categories.get(position));

        return  article;
    }


    private void buildCategories(){
        categories = new ArrayList<>();
        FileInputStream is;
        BufferedReader reader;
        File sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(sdcard, "categories.txt");

        try {
            if (file.exists()) {
                is = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                while(line != null){
                    categories.add(line);
                    line = reader.readLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }




    @Override public int getItemCount() {
        return categories.size();
    }

    public String getCategory(int position){
        return categories.get(position);
    }

}
