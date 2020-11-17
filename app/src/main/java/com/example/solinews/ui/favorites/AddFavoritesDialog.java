package com.example.solinews.ui.favorites;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.solinews.R;

public class AddFavoritesDialog {
    //To-Do Implementare listner e checkbox
    Context mContext;

    public AddFavoritesDialog (Context contex){
        mContext = contex;
    }

    public  void alertbox(){
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getResources().getString(R.string.add_favorites));
        builder.setMessage("CheckBox here");

        // add the buttons
        builder.setPositiveButton("Continua", null);
        builder.setNegativeButton("Cancella", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
