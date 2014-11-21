//Lavanya Kumar
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddRecipeActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);


    }

    public void showRecipeDetail(View view) {

        List<Recipe> recipes = SharedPreferencesUtility.getRecipeList(this,"recipes");

        int id = recipes.size();

        EditText recipeName = (EditText) findViewById(R.id.recipeName);
        EditText recipeIngredients = (EditText) findViewById(R.id.recipeDetailIngredients);
        EditText recipeDirections = (EditText) findViewById(R.id.recipeDetailDirections);

        recipes.add(new Recipe(recipeName.getText().toString(), recipeIngredients.getText().toString(), recipeDirections.getText().toString() ));


        SharedPreferencesUtility.putRecipeList(this,"teams", teams);

        //toast message for successfully adding recipe
        Toast.makeText(getApplicationContext(), "A new recipe has been added!",Toast.LENGTH_LONG).show();


        Intent recipeIntent = new Intent(this,RecipeDetailActivity.class);
        String message = String.valueOf(id);

        recipeIntent.putExtra(EXTRA_MESSAGE,message);
        startActivity(recipeIntent);

        finish();

//        EditText recipeName = (EditText) findViewById(R.id.recipeName);
//        String displayRecipeName = recipeName.getText().toString();
//        recipeIntent.putExtra(EXTRA_MESSAGE, displayRecipeName);
//
//        EditText recipeIngredients = (EditText) findViewById(R.id.recipeDetailIngredients);
//        String displayRecipeIngredients = recipeIngredients.getText().toString();
//        recipeIntent.putExtra(EXTRA_MESSAGE,displayRecipeIngredients);
//
//        EditText recipeDirections = (EditText) findViewById(R.id.recipeDetailDirections);
//        String displayRecipeDirections = recipeDirections.getText().toString();
//        recipeIntent.putExtra(EXTRA_MESSAGE, displayRecipeDirections);
//
//        startActivity(recipeIntent);
    }

//    public void showDialog (View v) {

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Are you sure you would like to add this recipe?");
//
//        builder.setCancelable(true);
//
//        builder.setPositiveButton("Yes!",
//                 new DialogInterface.OnClickListener()
//        {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int id) {
//            Intent intent = new Intent(this, RecipeDetailActivity.class);
//            startActivity(intent);
//        });
//
//
//        builder.setNegativeButton("Cancel"new DialogInterface.OnClickListener()
//                     {
//                         @Override
//                         public void onClick(DialogInterface dialogInterface, int id))


//
//        FragmentManager manager = getFragmentManager();
//        MyDialog dialogFragment = new MyDialog();
//        dialogFragment.show(manager, "MyDialog");
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
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



    //ACTIVITY 1
    //user interacts with spinner on the top right corner
    //clicking each of the options opens a explicit activity within the application
    //http://developer.android.com/guide/topics/ui/controls/spinner.html

    //ACTIVITY 2
    //user clicks camera icon with id addRecipePic
    //android.developer code to open implicit camera intent
    /*public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    //android.developer code for camera to receive camera intent result
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Image saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }*/


    //ACTIVITY 3
    //when user clicks "Submit" button (id: AddRecipe_RecipeDetail), all the data from the UI must get passed on to the recipe detail page
    //Ingredients, Difficulty, Name, Directions

}
