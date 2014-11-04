//Sikang Li
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LookUpRecipeActivity extends Activity {

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    // a list class type
    List<Map<String, String>> recipeList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up_recipe);

        //
        registerForContextMenu((ListView) findViewById(R.id.lv));
        //initialize recipe list
        initRecipeList();


        // adapters are what we use to associate the list variable and its contents with the list view
        ListView recipeListView = (ListView) findViewById(R.id.lv);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, recipeList, android.R.layout.simple_list_item_1, new String[] {"recipe"}, new int[] {android.R.id.text1});
        recipeListView.setAdapter(simpleAdpt);

        //look_up_recipe listView onClickListener
        recipeListView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {

                openRecipeDetail(id);

            }
        });
        Intent intent = getIntent();
    }

    private void initRecipeList() {
        recipeList.add(createRecipe("recipe", "Chicken Soup"));
        recipeList.add(createRecipe("recipe", "Beef Tomato"));
        recipeList.add(createRecipe("recipe", "McNuggets"));
        recipeList.add(createRecipe("recipe", "Cheesecake"));
    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a recipe entry into the list
    private HashMap<String, String> createRecipe(String key, String name) {
        HashMap<String, String> recipe = new HashMap<String, String>();
        recipe.put(key, name);
        return recipe;
    }

    // openTeamDetail is called whenever a list item is clicked on
    // it calls for an intent that starts up the team detail activity and sends the team's id over
    // to the activity with the message variable declared at the top of the activity
    public void openRecipeDetail(long id) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_look_up_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
    //Hamburger menu: generate menu
    public void burgerMenu(View view){
        //get on-click trigger
        //show drop-down menu

    }
    //Recipe clicked
    public void recipeOnClick(View view){

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
