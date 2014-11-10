package com.irissonghy.myfirstapplication;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lavanyakumar on 11/10/14.
 */
public class MyDialog extends DialogFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
        return inflater.inflate(R.layout.addrecipedialog, null);
    };
}
//yes = (Button) view.findViewById(R.id.yes);
//cancel = (Button) view.findViewById(R.id.cancel);
//return view;


//    @Override
//    public void onClick(View view) {
//        if (view.getId()==R.id.yes){
//            dismiss();
//            //Intent intent = new Intent(this,RecipeDetailActivity.class);
//
//        }
//        else if (view.getId()==R.id.cancel){
//            dismiss();
//        }
//    }