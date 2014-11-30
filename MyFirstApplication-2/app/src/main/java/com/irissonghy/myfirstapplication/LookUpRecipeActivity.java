//Sikang Li
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class LookUpRecipeActivity extends Activity {
    Map<String, Integer> map = new HashMap<String, Integer>();

    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up_recipe);
        map.put("Cheddar Pudding",0);
        map.put("Cheese Crackers",1);
        map.put("Veggie Soup",2);
        map.put("Baked Potato",3);
        map.put("Thai Rice",4);
        map.put("Roasted Chicken",5);

    }


    public void openDetail(View view)
    {
        int id = view.getId();
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        TextView recipeName = (TextView) findViewById(id);
        String displayName = recipeName.getText().toString();
        String imgIndex = map.get(displayName).toString();
        String recipeMsg = displayName + ";" + imgIndex;
        intent.putExtra(EXTRA_MESSAGE, recipeMsg);
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
            Intent intent=new Intent(this,PantryPopupActivity.class);
            startActivity (intent);
            return true;
        }
        else if (id == R.id.activity_profile) {
            Intent intent=new Intent(this,ProfileActivity.class);
            intent.putExtra("id", SharedPreferencesUtility.getString(this, "loginName"));
            startActivity (intent);

            return true;
        }
        else if (id == R.id.activity_favorites) {
            Intent intent=new Intent(this,FavoritesActivity.class);
            startActivity (intent);
            return true;
        }

        else if (id == R.id.activity_add_recipe) {
            Intent intent=new Intent(this,AddRecipeActivity.class);
            startActivity (intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
