//Huaying Song
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


public class FavoritesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Intent intent = getIntent();
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
        if (id == R.id.action_settings) {
            // launch intent to go to settings screen
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
