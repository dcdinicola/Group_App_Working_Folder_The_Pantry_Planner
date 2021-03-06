//Lavanya Kumar
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.provider.MediaStore;
import android.provider.MediaStore.Files;


import android.view.View;

public class AddRecipeActivity extends Activity {

    //@Override
   // protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_add_recipe);
    //}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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
    public void onCreate(Bundle savedInstanceState) {
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
    }


    //ACTIVITY 3
    //when user clicks "Submit" button (id: AddRecipe_RecipeDetail), all the data from the UI must get passed on to the recipe detail page
    //Ingredients, Difficulty, Name, Directions

}
