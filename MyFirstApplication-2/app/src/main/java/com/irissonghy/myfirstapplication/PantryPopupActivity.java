//Dan DiNicola

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PantryPopupActivity extends Activity{
    ListView PantrylistView;
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_popup);
        PantrylistView = (ListView) findViewById(R.id.PantrylistView);
        //  still having trouble with red "R"s)
       String[]veggies= new String[]  {
        "Carrots", "Celery", "Onions", "Potatoes"};
      ArrayAdapter<String> adapter = new ArrayAdapter<~>(this,android.R.layout.simple_list_item_1, veggies);
      PantrylistView.SetAdapter(ArrayAdapter);
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

