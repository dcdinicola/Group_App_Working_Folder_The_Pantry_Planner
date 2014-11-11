//Sikang Li

package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RatingBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

import org.w3c.dom.Text;

public class RecipeDetailActivity extends Activity {

    public String reviewText = "";
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    List<String> recipeList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        initRecipeList();

        //get message from intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(LookUpRecipeActivity.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message);

        //create the retrieved recipe name
        TextView textView = (TextView) findViewById(R.id.recipeName_1);
        textView.setText(recipeList.get(id));



        //rating bar
        RatingBar ratings = (RatingBar) findViewById(R.id.recipeRating_chickenSoup);
        ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            public void onRatingChanged(RatingBar ratings, float rating, boolean fromUser){

            }
        });

        //textView clickable userName
        TextView userNameView = (TextView) this.findViewById(R.id.recipePoster_1);
        userNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userNameIntent = new Intent(view.getContext(), ProfileActivity.class);
                startActivity(userNameIntent);

            }
        });

    }

    private void initRecipeList() {
        recipeList.add("Chicken Soup");
        recipeList.add("Beef Tomato");
        recipeList.add("McNuggets");
        recipeList.add("Cheesecake");
        recipeList.add("Chicken Teriyaki");
        recipeList.add("Duck Ramen");
        recipeList.add("Chicken & Cheddar Sandwich");
        recipeList.add("Curry Rice");
    }


    public void postReview() {

        //display reviews
        TextView review = (TextView) findViewById(R.id.reviewTextArea);
        review.setText(reviewText);


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
                         //dialogInterface.cancel();
                         reviewText = inputBox.getText().toString();
                         postReview();
                     }
                 });
         builder.setNegativeButton("Cancel",
                 new DialogInterface.OnClickListener()
                 {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int id) {
                         //dialogInterface.cancel();

                     }
                 });
         builder.show();


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


}
