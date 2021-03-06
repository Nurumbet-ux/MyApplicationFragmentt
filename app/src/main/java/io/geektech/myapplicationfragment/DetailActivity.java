package io.geektech.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private String title;
    private String subTitle;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(MainActivity.KEY_TITLE);
            subTitle = intent.getStringExtra(MainActivity.KEY_DESC);
            image = intent.getIntExtra(MainActivity.KEY_IMAGE, 0);
        }
         TExtFragment fragment = TExtFragment.newInstance(title,subTitle,image);
         getSupportFragmentManager().beginTransaction().add(R.id.fragmentText,fragment).commit();
    }
}