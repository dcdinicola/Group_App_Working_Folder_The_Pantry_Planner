//Huaying Song
package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FavoritesActivity extends Activity {

    ListView list;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images = {R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,
            R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10};

    //Add the EXTRA_MESSAGE definition
    public final static String EXTRA_MESSAGE = "com.irissonghy.myfirstapplication.MESSAGE1";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Intent intent = getIntent();

        Resources res = getResources();
        memeTitles = res.getStringArray(R.array.titles);
        memeDescriptions = res.getStringArray(R.array.descriptions);

        list = (ListView) findViewById(R.id.favListView);
        FavAdapter adapter = new FavAdapter(this, images,memeTitles,memeDescriptions);
        list.setAdapter(adapter);

        //favorites listView onClickListener
        list.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id)
            {
                openRecipeDetail(position);
            }
        });
    }

    public void openRecipeDetail(int position)
    {
        Intent intent = new Intent(this, RecipeDetailActivity.class);

        String messageFav = memeTitles[position] + ";" +
                            memeDescriptions[position];

        intent.putExtra(EXTRA_MESSAGE, messageFav);

        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favorites, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.activity_mainpage) {
            Intent intent=new Intent(this,MainActivity.class);
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

// customized adapter for favorite listView
class FavAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;

    FavAdapter(Context c,int[] imgs, String[] titles, String[] descriptions)
    {
        super(c,R.layout.single_row,R.id.favListTitle,titles);
        this.context = c;
        this.images = imgs;
        this.titleArray = titles;
        this.descriptionArray = descriptions;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, parent, false);

        ImageView myImage = (ImageView) row.findViewById(R.id.favListImage);
        TextView myTitle = (TextView) row.findViewById(R.id.favListTitle);
        TextView myDescription = (TextView) row.findViewById(R.id.favListDescription);

        myImage.setImageResource(images[position]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descriptionArray[position]);

        return row;
    }
}