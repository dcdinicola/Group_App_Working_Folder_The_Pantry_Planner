//Huaying Song....
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity {
    //Add the EXTRA_MESSAGE definition
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Since everyone has to pass through the login screen, we will initialize our data structures here
        initData();
        initRecipeData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void logIn(View view) {
        Intent loginIntent = new Intent(this, MainActivity.class);
        EditText userName = (EditText) findViewById(R.id.editTextName);
        String displayName = userName.getText().toString();
        loginIntent.putExtra(EXTRA_MESSAGE, displayName);
        startActivity(loginIntent);
        SharedPreferencesUtility.putString(this, "loginName", displayName);
    }
    private void initData() {
    List<String> favsList = new ArrayList<String>();
    favsList.add("Chicken Teriyaki");
    favsList.add("Duck Ramen");
    favsList.add("Chicken & Cheddar Sandwich");
    favsList.add("Cheesecake");
    favsList.add("Curry Rice");
    SharedPreferencesUtility.putStringList(this, "favs", favsList);

    }


    private void initRecipeData() {
        List<Recipe> myProfItems = new ArrayList<Recipe>();
        String defaultIngredients = "tomatoes carrots onions";
        String defaultDescription = "boil the tomatoes carrots and onions";

        myProfItems.add(new Recipe("Chicken Teriyaki", defaultIngredients, defaultDescription));
        myProfItems.add(new Recipe("Duck Ramen", defaultIngredients, defaultDescription));
        myProfItems.add(new Recipe("Chicken & Cheddar Sandwich",defaultIngredients, defaultDescription));

        SharedPreferencesUtility.putRecipeList(this,"recipes", myProfItems);
    }
}
