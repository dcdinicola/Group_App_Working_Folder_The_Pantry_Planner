package com.irissonghy.myfirstapplication;

/**
 * Created by connielee on 11/22/14.
 */
public class FavRecipe {
    private String favRecipeName;
    private String favRecipeImage;



    public FavRecipe(String recipeName, String recipeImage) {

        this.favRecipeName = recipeName;
        this.favRecipeImage = recipeImage;
    }

    public String getFavRecipeName() {return favRecipeName;}

    public String getFavRecipeImage() {return favRecipeImage;}

}
