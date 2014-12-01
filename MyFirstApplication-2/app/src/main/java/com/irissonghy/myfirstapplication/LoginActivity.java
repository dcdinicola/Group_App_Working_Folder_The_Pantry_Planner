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
        //initData();
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
        Intent loginIntent = new Intent(this, LookUpRecipeActivity.class);

        EditText userName = (EditText) findViewById(R.id.editTextName);
        String displayName = userName.getText().toString();
        loginIntent.putExtra(EXTRA_MESSAGE, displayName);

        startActivity(loginIntent);

        SharedPreferencesUtility.putString(this, "loginName", displayName);
    }

    private void initRecipeData() {
        List<Recipe> myProfItems = new ArrayList<Recipe>();

        myProfItems.add(new Recipe("Chicken Teriyaki", "chicken", "marinate the chicken in the teriyaki sauce"));
        myProfItems.add(new Recipe("Duck Ramen", "duck", "heat the duck with the ramen noodles"));
        myProfItems.add(new Recipe("Chicken & Cheddar Sandwich","chicken, cheese, bread", "place all the ingredients in a panini press"));

        SharedPreferencesUtility.putRecipeList(this,"recipes", myProfItems);
    }
}
