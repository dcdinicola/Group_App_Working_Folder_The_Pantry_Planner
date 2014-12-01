//Dan DiNicola

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PantryPopupActivity extends Activity{
      ListView PantrylistView;
      ListView SelectedPantrylistView;
      ArrayList selectedIngredientsArray;

// provide initial values for ingredients (auto-fill the pantry)
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
      setContentView(R.layout.activity_pantry_popup);
//    Intent intent = getIntent();

        PantrylistView = (ListView) findViewById(R.id.PantrylistView);

 //   protected void onCreate(Bundle savedInstanceState) {
 //       super.onCreate(savedInstanceState);
 //       setContentView(R.layout.activity_pantry_popup);
 //       Intent mainIntent = getIntent();
 //       String displayName = mainIntent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
// get the intent and extract the username delivered by LoginActivity
 //       TextView userName = (TextView) findViewById(R.id.mainHeader);
// set the text of textViewUsername on main page
 //       userName.setText("Select Food Material From " + displayName +"'s Pantry");

// two list views.  PantrylistView consists of the sum of items in pantry
// SelectedPantrylistView consists of those items selected by user







// build ingredients string into an ArrayList in order to pass to main activity

          final ArrayList<String> ingredientsArray = new ArrayList<String>();
          for (String i : ingredients) {
              ingredientsArray.add(i);
          }
// add a boolean expression where if Add New Item button is clicked, calls an edit text for the user
// to add to selectedIngredientsArray
          // THIS IS SIMILAR TO THE TEAM EXAMPLE!
     //     public Boolean setOnClickItemListener
          selectedIngredientsArray = new ArrayList<String>();


          final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, ingredientsArray);
          final ArrayAdapter<String> selectedIngredientsAdapter = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, selectedIngredientsArray);

   // sets SelectedPantrylistView

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
                        selectedIngredientsAdapter.notifyDataSetChanged();
                        ingredientsArray.add(item);
                        adapter.notifyDataSetChanged();
                        view.setAlpha(1);
                                       }
                                    });
                               }
                       }

          );

   // changes PantrylistView (removes selected items)
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
          );
      }
    // upon select, send selected ingredients back to main activity


    // upon cancel, returns to main activity with no selected ingredients

//public void showDialog (View v) {
    //review dialog
  //  AlertDialog.Builder builder = new AlertDialog.Builder(this);
 //   builder.setTitle("Enter the name of your new item:");

//}


 public void goToLookupRecipe(View view) {
     Intent intent = new Intent (this,LookUpRecipeActivity.class);
     intent.putStringArrayListExtra("string", selectedIngredientsArray);
     startActivity(intent);
 }

// public void goToMainActivity(View view) {
//     Intent intent = new Intent (this, MainActivity.class);
//     intent.putStringArrayListExtra("string", selectedIngredientsArray);
//     startActivity(intent);
// }


 // if we decide to remove main activity
 //
 // public void goToLookUpRecipeActivity(View view) {
 //
 //     Intent intent = new Intent(this, LookUpRecipeActivity.class);
 //     intent.putStringArrayListExtra("string", selectedIngredientsArray);
 //     startActivity (intent);
 //}


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
            Intent intent=new Intent(this,PantryPopupActivity.class);
            startActivity (intent);
            return true;
        }
        else if (id == R.id.activity_profile) {
            // launch intent to go to user profile
            Intent intent=new Intent(this,ProfileActivity.class);
            intent.putExtra("id", SharedPreferencesUtility.getString(this, "loginName"));
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


