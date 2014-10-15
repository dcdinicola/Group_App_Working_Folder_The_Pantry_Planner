
//The Pantry Planner: Profile Java File (Pseudocode) by Lavanya Kumar
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



//code that is part of camera intent
private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
private Uri fileUri;



public class ProfileActivity extends Activity {


    //ACTIVITY 1
    //user interacts with spinner on the top right corner
    //clicking each of the options opens a explicit activity within the application
    //http://developer.android.com/guide/topics/ui/controls/spinner.html




    //ACTIVITY 2
    //user clicks camera icon with id addProfilePic
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



        //ACTIVITY 3
        //user can select each of the pictures of food items or the corresponding text next to it
        //this launches an explicit intent (Recipe Details Page)


        //rest of content on page are just text views



    }
