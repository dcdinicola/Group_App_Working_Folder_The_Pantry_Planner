package com.irissonghy.myfirstapplication;

/**
 * Created by connielee on 11/22/14.
 */
public class FavRecipe {
    private String favRecipeName;
    private String favRecipeDescription;
    private int favRecipeImage;



    public FavRecipe(String recipeName, String recipeDescription, int recipeImage) {

        this.favRecipeName = recipeName;
        this.favRecipeDescription = recipeDescription;
        this.favRecipeImage = recipeImage;
    }

    public String getFavRecipeName() {return favRecipeName;}

    public String getFavRecipeDescription() {return favRecipeDescription;}

    public int getFavRecipeImage() {return favRecipeImage;}

}
