package com.example.solinews.ui.favorites;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.example.solinews.R;

import java.util.ArrayList;

public class AddFavoritesDialog {

    Context mContext;
    ArrayList<String> categories;
    public AddFavoritesDialog (Context contex){
        mContext = contex;
        alertbox();
    }

    public  void alertbox(){
        String[] items = getCategories();
        for(int i=0 ; i< categories.size();i++){
            items[i] = categories.get(i);
        }
        boolean[] checkedItems = new boolean[items.length];

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getResources().getString(R.string.add_favorites));

        //Setup checkbox, it's required an array (not an array list)
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Log.d("ciao", "onClick: "  + items[which]);
            }
        });

        // add the buttons
        builder.setPositiveButton("Continua", null);
        builder.setNegativeButton("Cancella", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String[] getCategories() {
        categories = new ArrayList<>();
        //TO-DO should retrive from sharedPreference
        categories.add("Ciao");
        categories.add("va?");

        String[] items =new String[categories.size()];
        for(int i=0 ; i< categories.size();i++)
            items[i] = categories.get(i);

        return  items;
    }
}
