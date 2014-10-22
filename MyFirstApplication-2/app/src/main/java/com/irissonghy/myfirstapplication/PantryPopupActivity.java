//Dan DiNicola

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class PantryPopupActivity extends Activity{

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(Bundle savedInstanceState);
        //   setContentView(R.layout.activity_pantry_popup);

        //  still having trouble with red "R"s)
       // String[]veggies= new String[]  {
       //         "Carrots", "Celery", "Onions", "Potatoes"};
      //  ArrayAdapter<String> = new ArrayAdapter<String>(getListView.getContext(),android.R.layout.simple_expandable_list_item_1, veggies);
      //  getListView().setadapter.adapter;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu_pantry_popup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

