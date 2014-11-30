//Lavanya Kumar
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class AddRecipeActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";
    private static final int CAM_REQUEST = 1;
    Button btnTakePhoto;
    ImageView imgTakePhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        btnTakePhoto = (Button) findViewById(R.id.camButton);
        imgTakePhoto = (ImageView) findViewById(R.id.imageView2);

        btnTakePhoto.setOnClickListener(new btnTakePhoneClicker());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST)
        {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imgTakePhoto.setImageBitmap(thumbnail);
        }
    }

    class btnTakePhoneClicker implements Button.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,CAM_REQUEST);
        }
    }

    public void showRecipeDetail(View view) {

        List<Recipe> recipes = SharedPreferencesUtility.getRecipeList(this,"recipes");

        int id = recipes.size();

        EditText recipeName = (EditText) findViewById(R.id.recipeName);
        EditText recipeIngredients = (EditText) findViewById(R.id.recipeDetailIngredients);
        EditText recipeDirections = (EditText) findViewById(R.id.profileAbout);

        recipes.add(new Recipe(recipeName.getText().toString(), recipeIngredients.getText().toString(), recipeDirections.getText().toString() ));


        SharedPreferencesUtility.putRecipeList(this,"recipes", recipes);

        //toast message for successfully adding recipe
        Toast.makeText(getApplicationContext(), "A new recipe has been added!",Toast.LENGTH_LONG).show();


        Intent recipeIntent = new Intent(this,RecipeDetailActivityTwo.class);
        String recipeMessage = String.valueOf(id);

        recipeIntent.putExtra(EXTRA_MESSAGE,recipeMessage);
        startActivity(recipeIntent);

        finish();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
