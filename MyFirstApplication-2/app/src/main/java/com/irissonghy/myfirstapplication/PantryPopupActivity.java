//Dan DiNicola

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PantryPopupActivity extends Activity{
      ListView PantrylistView;
      String[]ingredients= new String[] {};
      protected void onCreate (Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_pantry_popup);
          Intent intent = getIntent();
          PantrylistView = (ListView) findViewById(R.id.PantrylistView);

        String[] ingredients= {
                "Carrots", "Celery", "Onions", "Potatoes", "Pot Roast", "Ground Beef", "Chicken", "Chicken Breast", "Salami",
                "Prosciutto", "Beef","Pork", "Salmon","Shrimp", "Tilapia", "Turkey Breast", "Bacon",
                "Multi-Grain Bread", "Wheat Bread", "French Bread", "Pepperoni", "Garlic", "Parsley", "Elbow Maccaroni",
                "Romaine Lettuce", "Kale", "Spinach", "Brocoli", "Olive Oil", "Rice", "Grits", "Parmesan Cheese",
                "Sweet Potatoes", "Chives", "Asparagus", "Water Chestnuts","Zucchini", "Brussels Sprouts", "Flour", "Sugar",
                "Milk", "Eggs", "Arugula", "Cheese", "Ricotta Cheese", "White Wine", "Red Wine", "Marsala", "Evaporated Milk",
                "Condensed Milk", "Jalapeno", "Red Pepper", "Green Pepper", "Breadcrumbs", "Lemons", "Limes", "Tomato",
                "Avocado", "Tortillas", "Butter", "Linguine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ingredients);

/*public class MyCookingAdapter extends ArrayAdapter<String> {

    String[] veggies;

    public MyCookingAdapter(Context context, String[] veggies) {
        super(context, 0, veggies); // runs the Array Adapter constructor
        this.veggies = veggies;
    }*/

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;



        if (v == null) {
            LayoutInflater li = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.list_item_cooking, null);

            TextView t = (TextView) v.findViewById(R.id.textView);
            t.setText(this.veggies[position]);


        }



        return v;

    }*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // action bar items here

        int id = item.getItemId();
        if (id == R.id.activity_mainpage) {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity (intent);
            return true;
        }
        else if (id == R.id.activity_profile) {
            // launch intent to go to user profile
            Intent intent=new Intent(this,ProfileActivity.class);
            startActivity (intent);

            return true;
        }
        else if (id == R.id.activity_favorites) {
            // launch intent to go to favorites
            Intent intent=new Intent(this,FavoritesActivity.class);
            startActivity (intent);
            return true;
        }

        else if (id == R.id.activity_add_recipe) {
            // launch intent to go to add recipe
            Intent intent=new Intent(this,AddRecipeActivity.class);
            startActivity (intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

