package com.irissonghy.myfirstapplication;

/**
 * Created by lavanyakumar on 11/21/14.
 */
public class Recipe {

    private String recipeName;
    private  String recipeIngredients;
    private  String recipeDirections;


    public Recipe(String recipeName, String recipeIngredients, String recipeDirections) {

        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeDirections = recipeDirections;
    }

    public String getRecipeName() {return recipeName;}

    public String getRecipeIngredients() {return recipeIngredients;}

    public String getRecipeDirections() {return recipeDirections;}



}
