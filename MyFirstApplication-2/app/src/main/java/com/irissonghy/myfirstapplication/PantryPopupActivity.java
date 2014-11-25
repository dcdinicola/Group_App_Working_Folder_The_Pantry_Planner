//Dan DiNicola

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import static com.irissonghy.myfirstapplication.R.layout.activity_pantry_popup;

public class PantryPopupActivity extends Activity{
      ListView PantrylistView;
      ListView SelectedPantrylistView;
private ArrayList selectedIngredientsArray;


      String[] ingredients= {
            "Carrots", "Celery", "Onions", "Potatoes", "Pot Roast", "Ground Beef", "Chicken", "Chicken Breast", "Salami",
            "Prosciutto", "Beef","Pork", "Salmon","Shrimp", "Tilapia", "Turkey Breast", "Bacon",
            "Multi-Grain Bread", "Wheat Bread", "French Bread", "Pepperoni", "Garlic", "Parsley", "Elbow Macaroni",
            "Romaine Lettuce", "Kale", "Spinach", "Broccoli", "Olive Oil", "Rice", "Grits", "Parmesan Cheese",
            "Sweet Potatoes", "Chives", "Asparagus", "Water Chestnuts","Zucchini", "Brussels Sprouts", "Flour", "Sugar",
            "Milk", "Eggs", "Arugula", "Cheese", "Ricotta Cheese", "White Wine", "Red Wine", "Marsala", "Evaporated Milk",
            "Condensed Milk", "Jalapeno", "Red Pepper", "Green Pepper", "Breadcrumbs", "Lemons", "Limes", "Tomato",
            "Avocado", "Tortillas", "Butter", "Linguine"};

      protected void onCreate (Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(activity_pantry_popup);
          Intent intent = getIntent();
          SelectedPantrylistView = (ListView) findViewById(R.id.SelectedPantryList);
          PantrylistView = (ListView) findViewById(R.id.PantrylistView);

          final ArrayList<String> ingredientsArray = new ArrayList<String>();
          for (String i : ingredients) {
              ingredientsArray.add(i);
          }
          selectedIngredientsArray = new ArrayList<String>();

          final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, ingredientsArray);
          final ArrayAdapter<String> selectedIngredientsAdapter = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, selectedIngredientsArray);
          SelectedPantrylistView.setAdapter(selectedIngredientsAdapter);
          SelectedPantrylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, final View view,
                 int position, long id) {
                 final String item = (String) parent.getItemAtPosition(position);
                 view.animate().setDuration(2000).alpha(0)
                 .withEndAction(new Runnable() {
                  @Override
                   public void run() {
                        selectedIngredientsArray.remove(item);
                        selectedIngredientsAdapter.notifyDataSetChanged();
                        ingredientsArray.add(item);
                        adapter.notifyDataSetChanged();
                        view.setAlpha(1);
                                       }
                                    });
                               }
                       }
          );
          PantrylistView.setAdapter(adapter);
          PantrylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, final View view,
                                      int position, long id) {
                  final String item = (String) parent.getItemAtPosition(position);
                  view.animate().setDuration(2000).alpha(0)
                          .withEndAction(new Runnable() {
                              @Override
                              public void run() {
                                ingredientsArray.remove(item);
                                adapter.notifyDataSetChanged();
                                  selectedIngredientsArray.add(item);
                                  selectedIngredientsAdapter.notifyDataSetChanged();
                                  view.setAlpha(1);
                              }
                          });
              }
      }
          );}


    public class MyCookingAdapter extends ArrayAdapter<String> {

    String[] ingredients;

    public MyCookingAdapter(Context context, String[] veggies) {
        super(context, 0, veggies); // runs the Array Adapter constructor
        this.ingredients  = veggies;
    }

}

    // upon select, send selected ingredients back to main activity
    public void goToMainActivity(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.putStringArrayListExtra("strings", selectedIngredientsArray);
    startActivity(intent);

    // I will pass back selectedIngredientsArray
    }

    // upon cancel, returns to main activity with no selected ingredients

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


