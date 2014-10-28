//Huaying Song
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class FavoritesActivity extends Activity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Intent intent = getIntent();
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.FavoriteslistView);
        // Defined Array values to show in ListView
        String[] favorites = new String[] { "Chicken Teriyaki",
                "Duck Ramen",
                "Chicken & Cheddar Sandwich",
                "Cheese Cake",
                "Curry Rice",
                "BBQ Chicken Wings"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, favorites);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position){
                    case 0: Intent newActivity = new Intent(FavoritesActivity.this,RecipeDetailActivity.class);
                            startActivity(newActivity);
                            break;
                    case 1: Intent newActivity1 = new Intent(FavoritesActivity.this,RecipeDetailActivity.class);
                            startActivity(newActivity1);
                            break;
                    case 2: Intent newActivity2 = new Intent(FavoritesActivity.this,RecipeDetailActivity.class);
                        startActivity(newActivity2);
                        break;
                    case 3: Intent newActivity3 = new Intent(FavoritesActivity.this,RecipeDetailActivity.class);
                        startActivity(newActivity3);
                        break;
                    case 4: Intent newActivity4 = new Intent(FavoritesActivity.this,RecipeDetailActivity.class);
                        startActivity(newActivity4);
                        break;
                    case 5: Intent newActivity5 = new Intent(FavoritesActivity.this,RecipeDetailActivity.class);
                        startActivity(newActivity5);
                        break;
                }
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favorites, menu);
        return true;
    }

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

    //Recipe clicked
    public void recipeOnClick(View view){
        //get which recipe is clicked

        //go the the recipe's detail page
        Intent RecipeDetailIntent = new Intent(this, RecipeDetailActivity.class);
        startActivity(RecipeDetailIntent);
    }
    public void profileOnClick(View view){
        //get which profile is clicked

        //go the the profile page
        Intent ProfileIntent = new Intent(this, ProfileActivity.class);
        startActivity(ProfileIntent);
    }
    //Pseudocode for Nav Menu
    //START
    //The drop down menu with links to other activities opens
    //Get the id of the item that user selects
    //Respond to user selection: go to the activity that user selects
    //END

    //Pseudocode for Tapping on a recipe
    //START
    //Get the id of the recipe that user taps on
    //Retrieve the recipe detail from database
    //Go to the RecipeDetailActivity with the detail of the chosen recipe
    //END

    //Pseudocode for Tapping on a user avatar
    //START
    //Get the id of avatar that user taps on
    //Retrieve the user's profile from database
    //Go to the UserProfileActivity of the chosen user
    //END

}
