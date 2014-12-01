//The Pantry Planner: Profile Java File (Pseudocode) by Lavanya Kumar
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProfileActivity extends Activity {

//LISTADAPTER THAT CONNECTS PROFILE TO RECIPE DETAIL

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    //the string we use for storing the username
    String userName;

    // a list class type so that list view is altered programatically
    List<Map<String, String>> myProfItems = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //want to apply the contextmenu for each individual recipe that is in the user's profileListView();
        registerForContextMenu((ListView) findViewById(R.id.profileListViewItem));

        //filling in the list class variable (myProfItems) with the names of our recipes
        initString();

        //initialize recipe list in profile screen
        initProfileRecipeList();

        //this associates the contents in the listview with the variable ListItem (myProfItems)
        ListView profileList = (ListView) findViewById(R.id.profileListViewItem);
        SimpleAdapter profileAdapter = new SimpleAdapter(this, myProfItems, android.R.layout.simple_list_item_1, new String[]{"recipe"}, new int[]{android.R.id.text1});
        profileList.setAdapter(profileAdapter);

        //look_up_recipe listView onClickListener, tells ProfileActivity what to do when recipe is selected)
        profileList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parentAdapter, View view,
                                    int position, long id) {
                openRecipeDetail(id);

            }
        });


        Intent intent = getIntent();

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.recipeName);
        textView.setText(userName);

    }

    //grab the username from login
    private void initString() {

        //get the String transferred, which is the id of the profile owner
        Bundle extras = getIntent().getExtras();
        userName = extras.getString("id");
        TextView post_view = (TextView) findViewById(R.id.textView3);
        ListView listView = (ListView) findViewById(R.id.profileListViewItem);


        if(!userName.equals(SharedPreferencesUtility.getString(this, "loginName"))) {
            //post_view.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.INVISIBLE);
            post_view.setText("His/Her Posts:");
            TextView profile_about = (TextView) findViewById(R.id.profileAbout);
            profile_about.setText("I love cooking!");
            ImageView avatar = (ImageView) findViewById(R.id.imageView2);
            avatar.setImageResource(R.drawable.avatar_tommy);
        }

    }

    //adding recipe names to the list variable
    private void initProfileRecipeList() {

        List<Recipe> recipes = SharedPreferencesUtility.getRecipeList(this, "recipes");
        for (Recipe r: recipes) {
            myProfItems.add(createRecipe("recipe", r));
        }
    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a recipe entry into the list
    private HashMap<String, String> createRecipe(String key, Recipe r) {
        HashMap<String, String> recipe = new HashMap<String, String>();
        String name = r.getRecipeName();
        recipe.put(key, name);
        return recipe;
    }

    public void openRecipeDetail(long id) {
        Intent intent = new Intent(this, RecipeDetailActivityTwo.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
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

