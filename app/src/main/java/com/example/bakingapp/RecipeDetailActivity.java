package com.example.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bakingapp.model.Recipe;
import com.example.bakingapp.model.Step;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {
    // variable for the Recipe
    private Recipe mRecipe;
    ArrayList<Step> mStepArrayList;
    RecyclerView mRecyclerView;
    DetailAdapter mAdapter;
    private Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        //intent that started this activity
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity == null) {
            closeOnError();
        }
        mRecipe = intentThatStartedThisActivity.getParcelableExtra("Recipe");
        generateList((List<Recipe>) mRecipe);

    }
    private void generateList(List<Recipe> jsonResponse) {
        Recipe recipe=null;
//loop through the list to get the recipe of id passed in the extra bundle
        for (Recipe r:jsonResponse) {
            if ((r.getId()==id)){
                recipe=r;
                break;
            }
        }
        if (recipe==null) return;
        mRecyclerView = findViewById(R.id.step);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(RecipeDetailActivity.this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new DetailAdapter(RecipeDetailActivity.this, (ArrayList<Step>) recipe.getSteps()); //<<<--- and here getting ingredients list
        mRecyclerView.setAdapter(mAdapter);
    }
    private void closeOnError() {
        finish();
        Toast.makeText(this, " no image available", Toast.LENGTH_SHORT).show();
    }
}
