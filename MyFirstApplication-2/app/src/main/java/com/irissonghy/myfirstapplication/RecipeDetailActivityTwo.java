package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by lavanyakumar on 11/24/14.
 */
public class RecipeDetailActivityTwo extends Activity {

    public String reviewText = "";
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    List<Recipe> myProfItems;

    int recipeId;
    int profileId;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);


        Intent intent = getIntent();


        initRecipeList();

        String recipeMessage = intent.getStringExtra(AddRecipeActivity.EXTRA_MESSAGE);
        String profileMessage = intent.getStringExtra(ProfileActivity.EXTRA_MESSAGE);

        TextView recipeNameText = (TextView) findViewById(R.id.recipeName);
        TextView recipeIngredientsText = (TextView) findViewById(R.id.ingredientsTextArea);
        TextView recipeDirectionsText = (TextView) findViewById(R.id.directionsTextArea);

        int recipeId = (int) Long.parseLong(recipeMessage);
        int profileId = (int) Long.parseLong(profileMessage);

        recipeNameText.setText(myProfItems.get(recipeId).getRecipeName());
        recipeIngredientsText.setText(myProfItems.get(recipeId).getRecipeIngredients());
        recipeDirectionsText.setText(myProfItems.get(recipeId).getRecipeDirections());

        recipeNameText.setText(myProfItems.get(profileId).getRecipeName());
        recipeIngredientsText.setText(myProfItems.get(profileId).getRecipeIngredients());
        recipeDirectionsText.setText(myProfItems.get(profileId).getRecipeDirections());


        //rating bar
        RatingBar ratings = (RatingBar) findViewById(R.id.recipeStar);
        ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratings, float rating, boolean fromUser) {
                //Toast "Liked" message
                Toast.makeText(getApplicationContext(), "Liked!", Toast.LENGTH_SHORT).show();
            }
        });

        //Clickable userName
        final TextView userNameView = (TextView) this.findViewById(R.id.recipePoster);
        userNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userNameIntent = new Intent(view.getContext(), ProfileActivity.class);
                userNameIntent.putExtra("id", userNameView.getText());
                startActivity(userNameIntent);

            }
        });

    }


    private void initRecipeList() {
        myProfItems = SharedPreferencesUtility.getRecipeList(this,"recipes");
    }
    public void postReview()
    {
        TextView review = (TextView) findViewById(R.id.reviewTextArea);
        review.setText(reviewText);
        review.setBackgroundColor(0xFFF0F0F0);
    }

    public void showDialog(View v){
        //review dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please write down your review:");
        //create input box for users to input review
        final EditText inputBox = new EditText(this);
        builder.setView(inputBox);

        builder.setCancelable(true);

        builder.setPositiveButton("Post",
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        reviewText = inputBox.getText().toString();
                        postReview();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id)
                    {}
                });
        builder.show();

    }


    public void deleteRecipeDialog() {

        Intent intent = getIntent();


        String recipeMessage = intent.getStringExtra(AddRecipeActivity.EXTRA_MESSAGE);
        String profileMessage = intent.getStringExtra(ProfileActivity.EXTRA_MESSAGE);


        if (recipeMessage != null) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(RecipeDetailActivityTwo.this);

            //dialog title
            alertDialog.setTitle("Delete Item");

            //dialog content
            alertDialog.setMessage("Are you sure you want to delete this item?");

            //"Yes" Button
            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    deleteRecipeItem();
                }
            });

            // cancel
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        } else if (profileMessage != null) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(RecipeDetailActivityTwo.this);

            //dialog title
            alertDialog.setTitle("Delete Item");

            //dialog content
            alertDialog.setMessage("Are you sure you want to delete this item?");

            //"Yes" Button
            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    deleteProfileItem();
                }
            });

            // cancel
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();
            }
        }



    public void deleteRecipeItem() {
        myProfItems.remove(recipeId);
        SharedPreferencesUtility.putRecipeList(this,"recipes", myProfItems);

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

        finish();
    }

    public void deleteProfileItem() {
        myProfItems.remove(profileId);
        SharedPreferencesUtility.putRecipeList(this,"recipes", myProfItems);

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

        finish();
    }

    public void deleteItem(View view) {
        deleteRecipeDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe_detail, menu);
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
