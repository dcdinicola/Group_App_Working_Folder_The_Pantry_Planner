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
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FavoritesActivity extends Activity {
    //Add the EXTRA_MESSAGE definition
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE1";

    // a list class type
    List<Map<String, String>> favoritesList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Intent intent = getIntent();

        registerForContextMenu((ListView) findViewById(R.id.FavoriteslistView));

        //initialize recipe list
        initFavoritesList();
        // adapters are what we use to associate the list variable and its contents with the list view
        ListView favoritesListView = (ListView) findViewById(R.id.FavoriteslistView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, favoritesList, android.R.layout.simple_list_item_1, new String[] {"favorites"}, new int[] {android.R.id.text1});
        favoritesListView.setAdapter(simpleAdpt);

        //look_up_recipe listView onClickListener
        favoritesListView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {

                openRecipeDetail(id);

            }
        });
    }
    private void initFavoritesList() {
        favoritesList.add(createRecipe("favorites", "Chicken Teriyaki"));
        favoritesList.add(createRecipe("favorites", "Duck Ramen"));
        favoritesList.add(createRecipe("favorites", "Chicken & Cheddar Sandwich"));
        favoritesList.add(createRecipe("favorites", "Cheesecake"));
        favoritesList.add(createRecipe("favorites", "Curry Rice"));
    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a recipe entry into the list
    private HashMap<String, String> createRecipe(String key, String name) {
        HashMap<String, String> recipe = new HashMap<String, String>();
        recipe.put(key, name);
        return recipe;
    }
    // openRecipeDetail is called whenever a list item is clicked on
    // it calls for an intent that starts up the team detail activity and sends the recipe's id over
    // to the activity with the message variable declared at the top of the activity
    public void openRecipeDetail(long id) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        String messageFav = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, messageFav);
        startActivity(intent);
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


}
