//Daniel DiNicola
package com.irissonghy.myfirstapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
//    ListView SelectedIngredientsListView;


    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mainIntent = getIntent();
        String displayName = mainIntent.getStringExtra(LoginActivity.EXTRA_MESSAGE);//get the intent and extract the username delivered by LoginActivity
        TextView userName = (TextView) findViewById(R.id.mainHeader);//set the text of textViewUsername on main page
        userName.setText("Welcome, " + displayName + "!");
    }

    // calls Pantry popup when user clicks "Select from Pantry"
    public void goToPantryPopup(View view) {

        Intent intent = new Intent(this, PantryPopupActivity.class);
        startActivity(intent);

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




//    Upon returning to Main Activity, show list of items selected (the below code is not working)
//
//
//      public void setSelectedIngredientsListView(ListView selectedIngredientsListView) {
//        Bundle b = getIntent().getExtras();
//
//        if(b!=null){
//            String n =(String) b.get("ingredients");
//            selectedIngredientsListView.setText(n);
//           ArrayList<String> ingredients= new ArrayList<String>();
//            ingredients =getIntent().getExtras().getStringArrayList("string");
//
//}
//
//
//            new intent to open AddRecipeActivity from main
//            public void goToAddRecipe(View view) {
//                Intent intent = new Intent(this, AddRecipeActivity.class);
//                startActivity(intent);
//            }

//    new intent to open FavoritesActivity from main
//    public void goToFavorites (View view) {
//        Intent intent=new Intent(this, FavoritesActivity.class);
//        startActivity (intent);
//
//    }
//    // new intent to open ProfileActivity from main
//    public void goToProfile (View view) {
//        Intent intent=new Intent(this, ProfileActivity.class);
//        startActivity (intent);
//
//    }
//    // new intent to open RecipeDetailActivity from main
//    public void lookUpRecipe (View view) {
//        Intent intent=new Intent(this, LookUpRecipeActivity.class);
//        startActivity (intent);
//
//    }
//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
