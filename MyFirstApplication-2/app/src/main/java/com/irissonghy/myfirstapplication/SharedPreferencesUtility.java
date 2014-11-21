package com.irissonghy.myfirstapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

// Shared preferences has no methods that allow us to save lists of strings
// through a bit of string manipulation, we can create our own utility class that allows us to do that

public class SharedPreferencesUtility {

    public static List<String> getStringList(Activity activity, String key) {

        List<String> list = new ArrayList<String>();

        // grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");


        if (listString.length() != 0) {

            // string.split will create an array returning everything in between the provided "delimiter"
            // parameter

            String[] items = listString.split(";");

            // loop through the array and add it to a list so we can give it back to the method caller
            for (String i : items) {
                list.add(i);
            }

        }

        return list;

    }

    public static void putStringList(Activity activity, String key, List<String> list) {

        // for each string in the list, we want to add it to a new variable and separate the strings
        // by putting semicolons in between them

        // TextUtils.join takes a list or array of objects and places them into one string separated
        // by the string in the first parameter (semicolon in this case)

        String listString = TextUtils.join(";", list);

        // save the new combined string into preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, listString);
        editor.apply();

    }

    //retrieve username string
    public static String getString(Activity activity, String key) {
        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(activity);
        String string = preferences1.getString(key, "");
        return string;
    }

    //store username string in SharedPreferences
    public static void putString(Activity activity, String key, String value) {
        SharedPreferences usernamePreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = usernamePreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    //RECIPE DETAIL SHARED PREFERENCES (GET)
    public static List<Recipe> getRecipeList(Activity activity, String key) {

        List<Recipe> list = new ArrayList< ~ > ();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        if (listString.length() != 0) {
            String[] recipes = listString.split(";;");

            for (String r : recipes) {
                String[] recipeAttributes = r.split(";");
                String recipeName = recipeAttributes[0];
                String recipeIngredients = recipeAttributes[1];
                String recipeDirections = recipeAttributes[2];
                Recipe newRecipe = new Recipe(recipeName, recipeIngredients, recipeDirections);

                list.add(newRecipe);
            }
        }
        return list;
    }

    //RECIPE DETAIL SHARED PREFERENCES (PUT)
    public static void putRecipeList(Activity activity, String key, List<Recipe> list) {
        List<String> tempRecipeList = new ArrayList< ~ > ();
        for (Recipe r : list) {
            String tempRecipeString = r.getRecipeName() + ";" + r.getRecipeIngredients() + ";" + getRecipeDirections();

            tempRecipeList.add(tempRecipeString);

        }

        String listString = TextUtils.join(";;", tempRecipeList);

        myPutString(activity, key, listString);

    }

}