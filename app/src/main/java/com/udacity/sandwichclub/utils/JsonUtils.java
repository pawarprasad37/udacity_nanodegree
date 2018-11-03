package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            Sandwich sandwich = new Sandwich();
            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");
            sandwich.setMainName(mainName);

            ArrayList<String> alternateNamesList = new ArrayList<>();
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alternateNamesList.add(alsoKnownAs.getString(i));
            }
            sandwich.setAlsoKnownAs(alternateNamesList);

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            String description = jsonObject.getString("description");
            sandwich.setDescription(description);

            String imageURL = jsonObject.getString("image");
            sandwich.setImage(imageURL);

            ArrayList<String> ingredientsList = new ArrayList<>();
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }
            sandwich.setIngredients(ingredientsList);

            return sandwich;
        } catch (JSONException e) {
            return null;
        }
    }
}
