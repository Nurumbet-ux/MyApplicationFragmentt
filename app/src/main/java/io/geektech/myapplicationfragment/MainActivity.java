package io.geektech.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IFragments {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    public static String KEY_TITLE = "KEY";
    public static String KEY_DESC = "KEY desc";
    public static String KEY_IMAGE = "KEYs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_first, new ChangeFragment());
        transaction.commit();
    }

    @Override
    public void displayDetails(String title, String subTitle, int image) {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            TExtFragment fragment = (TExtFragment) fragmentManager.findFragmentById(R.id.fragment_second);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            fragment.showText(title, subTitle, image);
            transaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(KEY_TITLE, title);
            intent.putExtra(KEY_DESC, subTitle);
            intent.putExtra(KEY_IMAGE, image);
            startActivity(intent);
        }
    }
}