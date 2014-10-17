//Sikang Li
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LookUpRecipeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up_recipe);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_look_up_recipe, menu);
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
    //Hamburger menu: generate menu
    public void burgerMenu(View view){
        //get on-click trigger
        //show drop-down menu

    }
    //Recipe clicked
    public void recipeOnClick(View view){
        //get which recipe is clicked

        //go the the recipe's detail page
        Intent RecipeDetailIntent = new Intent(this, RecipeDetailActivity.class);
        startActivity(RecipeDetailIntent);
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

    //Like clicked
    public boolean likeButtonOnClick(View view){
        //get which recipe's like is clicked
        //get the current "like" number this recipe has
        //current like number + 1
        //update this.recipe's like number
        return true;
    }
    //comment clicked
    public boolean commentButtonOnClick(View view){
        //get which recipe's comment button is clicked
        //go to that recipe's detail page
        //cursor put in the comment box
        //show keyboard
        return true;

    }
}
