//Sikang Li

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class RecipeDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Intent recipeDetailGetIntent = getIntent();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe_detail, menu);
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
    //Hamburger menu: handle click
    /*public boolean onMenuItemClick(View view){
        //get which item on the menu is clicked

        //if item 1: main page is clicked
        //go to main page, delete current activity
        Intent mainIntent = new Intent(this, mainActivity.class);
        startActivity(mainIntent);
        return true;
        //if item 2: add recipe is clicked
        //go to add recipe page, delete current activity
        Intent addRecipeIntent = new Intent(this, addRecipeActivity.class);
        startActivity(addRecipeIntent);
        return true;
        //if item 3: my favorites is clicked
        //go to my favorites page, delete current activity
        Intent FavoritesIntent = new Intent(this, FavoritesActivity.class);
        startActivity(FavoritesIntent);
        return true;
        //if item 4: my profile is clicked
        //go to my profile page, delete current activity
        Intent ProfileIntent = new Intent(this, ProfileActivity.class);
        startActivity(ProfileIntent);
        return true;
    }*/
    //Like button clicked
    public boolean likeButtonOnClick(View view){
        //get which recipe's like is clicked
        //get the current "like" number this recipe has
        //current like number + 1
        //update this.recipe's like number
        return true;
    }
    //Favorite button clicked
    public boolean addToFavoritesOnClick(View view){
        //get the id of current recipe
        //add this.recipe to this.user's favorites page
        return true;
    }
    //Write a review button clicked
    public void writeReviewOnClick(View view){
        //get trigger
        //generate a pop-up review section
        //Intent writeReviewIntent = new Intent(this, reviewPopUpActivity.class);
        //startActivity(writeReviewIntent);
    }

}
