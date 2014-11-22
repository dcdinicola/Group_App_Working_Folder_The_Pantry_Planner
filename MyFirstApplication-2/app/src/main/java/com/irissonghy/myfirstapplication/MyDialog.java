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
