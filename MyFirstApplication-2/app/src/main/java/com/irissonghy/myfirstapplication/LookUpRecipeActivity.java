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


public class LookUpRecipeActivity extends Activity {
    //an array to show the names of the recipes in the listView
    private static final String[] strs = new String[]{
            "Chicken Soup", "Beef Tomato","McNuggets","Cheesecake"
    };

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up_recipe);

        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,strs));

        lv.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {
                switch(position)
                {
                    case 0:
                        Intent newActivity1 = new Intent(LookUpRecipeActivity.this, RecipeDetailActivity.class);
                        startActivity(newActivity1);
                        break;
                    case 1:
                        Intent newActivity2 = new Intent(LookUpRecipeActivity.this, RecipeDetailActivity.class);
                        startActivity(newActivity2);
                        break;
                    case 2:
                        Intent newActivity3 = new Intent(LookUpRecipeActivity.this, RecipeDetailActivity.class);
                        startActivity(newActivity3);
                        break;
                    case 3:
                        Intent newActivity4 = new Intent(LookUpRecipeActivity.this, RecipeDetailActivity.class);
                        startActivity(newActivity4);
                        break;
                }

            }
        });
        Intent intent = getIntent();
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
