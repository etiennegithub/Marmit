package com.example.backup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NavbarActivity extends AppCompatActivity {

    private TextView mTextMessage;
    //public LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_navbar_layout);
    //public FrameLayout home_layout = (FrameLayout) findViewById(R.id.test);

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionHome.replace(R.id.navbar_wrapper, homeFragment);
                    fragmentTransactionHome.commit();
                    return true;
                case R.id.navigation_recipes:
                    RecipesFragment recipesFragment = new RecipesFragment();
                    FragmentTransaction fragmentTransactionRecipes = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionRecipes.replace(R.id.navbar_wrapper, recipesFragment);
                    fragmentTransactionRecipes.commit();
                    Log.d("test","RECIPES");
                    return true;
                case R.id.navigation_favorites:
                    FavoritesFragment favoritesFragment = new FavoritesFragment();
                    FragmentTransaction fragmentTransactionFavorites = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionFavorites.replace(R.id.navbar_wrapper, favoritesFragment);
                    fragmentTransactionFavorites.commit();
                    Log.d("test","FAVORITES");
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment profileFragments = new ProfileFragment();
                    FragmentTransaction fragmentTransactionProfile = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionProfile.replace(R.id.navbar_wrapper, profileFragments);
                    //fragmentTransactionProfile.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    fragmentTransactionProfile.commit();
                    Log.d("test","PROFILES");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
        fragmentTransactionHome.replace(R.id.navbar_wrapper, homeFragment);
        fragmentTransactionHome.commit();
    }

}
