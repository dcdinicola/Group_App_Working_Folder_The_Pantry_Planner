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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailActivity extends Activity {
    //
    int[] imagesDetail = {R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,
            R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10};

    public String reviewText = "";
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";

    List<String> favoritesList = new ArrayList<String>();

    List<Recipe> myProfItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);


        initFavoritesList();

        Intent intent = getIntent();
        String message = intent.getStringExtra(LookUpRecipeActivity.EXTRA_MESSAGE);

        initRecipeList();

        String recipeMessage = intent.getStringExtra(AddRecipeActivity.EXTRA_MESSAGE);


        String messageFav = intent.getStringExtra(FavoritesActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.recipeName);


        if (message != null) {
            textView.setText(message);

        } else if (messageFav != null) {
            String[] mixMsg = messageFav.split(";");

            String displayName = mixMsg[0];
            TextView nameView = (TextView) findViewById(R.id.recipeName);
            nameView.setText(displayName);

            String displayDes = mixMsg[1]+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do";
            TextView ingView = (TextView) findViewById(R.id.ingredientsTextArea);
            ingView.setText(displayDes);
            TextView desView = (TextView) findViewById(R.id.directionsTextArea);
            desView.setText(displayDes);

            ImageView imgView = (ImageView) findViewById(R.id.recipeImage);
            imgView.setImageResource(imagesDetail[9]);


        } else if (recipeMessage != null) {

            int recipeId = (int) Long.parseLong(recipeMessage);
            textView.setText(myProfItems.get(recipeId).getRecipeName());

        }


        //rating bar
        RatingBar ratings = (RatingBar) findViewById(R.id.recipeStar);
        ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            public void onRatingChanged(RatingBar ratings, float rating, boolean fromUser)
            {

            }
        });

        //textView clickable userName
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


    private void initFavoritesList(){
        favoritesList = SharedPreferencesUtility.getStringList(this, "favs");
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