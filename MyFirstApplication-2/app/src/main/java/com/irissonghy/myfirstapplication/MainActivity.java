//Daniel DiNicola

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent mainIntent = getIntent();
    }
    // new intent to open pantry popup
    public void showMyPantry(View view) {
        Intent intent=new Intent(this,PantryPopupActivity.class);
        startActivity (intent);
    }
    // new intent to open AddRecipeActivity from main
    public void goToAddRecipe (View view) {
        Intent intent=new Intent(this, AddRecipeActivity.class);
        startActivity (intent);

    }

    // new intent to open FavoritesActivity from main
    public void goToFavorites (View view) {
        Intent intent=new Intent(this, FavoritesActivity.class);
        startActivity (intent);

    }
    // new intent to open ProfileActivity from main
    public void goToProfile (View view) {
        Intent intent=new Intent(this, ProfileActivity.class);
        startActivity (intent);

    }
    // new intent to open RecipeDetailActivity from main
    public void lookUpRecipe (View view) {
        Intent intent=new Intent(this, RecipeDetailActivity.class);
        startActivity (intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
