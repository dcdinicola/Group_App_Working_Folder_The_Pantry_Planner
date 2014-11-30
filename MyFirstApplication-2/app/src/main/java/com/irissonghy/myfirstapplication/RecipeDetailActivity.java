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

public class RecipeDetailActivity extends Activity {

    //banner images for detail page
    int[] imagesDetail = {R.drawable.meme1_banner,R.drawable.meme2_banner,R.drawable.meme7_banner,R.drawable.meme6_banner,R.drawable.meme9_banner};

    int[] imgResultsDetail = {R.drawable.result1_banner,R.drawable.result2_banner,R.drawable.result3_banner,R.drawable.result4_banner,R.drawable.result5_banner,R.drawable.result6_banner};

    public String reviewText = "";
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Intent intent = getIntent();
        String message = intent.getStringExtra(LookUpRecipeActivity.EXTRA_MESSAGE);
        String messageFav = intent.getStringExtra(FavoritesActivity.EXTRA_MESSAGE);


        if (message != null) {

            String[] mixMsg1 = message.split(";");

            String displayName1 = mixMsg1[0];
            TextView nameView1 = (TextView) findViewById(R.id.recipeName);
            nameView1.setText(displayName1);

            int position1 = Integer.parseInt(mixMsg1[1]);
            ImageView imgView1 = (ImageView) findViewById(R.id.recipeImage);
            imgView1.setImageResource(imgResultsDetail[position1]);

        } else if (messageFav != null) {

            String[] mixMsg = messageFav.split(";");

            String displayName = mixMsg[0];
            TextView nameView = (TextView) findViewById(R.id.recipeName);
            nameView.setText(displayName);

            String displayDes = mixMsg[1]+ ". " + mixMsg[1];
            TextView ingView = (TextView) findViewById(R.id.ingredientsTextArea);
            ingView.setText(displayDes);
            TextView desView = (TextView) findViewById(R.id.directionsTextArea);
            desView.setText(displayDes);

            int position = Integer.parseInt(mixMsg[2]);
            ImageView imgView = (ImageView) findViewById(R.id.recipeImage);
            imgView.setImageResource(imagesDetail[position]);

        }

        //rating bar
        RatingBar ratings = (RatingBar) findViewById(R.id.recipeStar);
        ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            public void onRatingChanged(RatingBar ratings, float rating, boolean fromUser)
            {
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