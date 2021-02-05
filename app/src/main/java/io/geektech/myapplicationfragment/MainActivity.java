package io.geektech.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements IFragments {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    public static String KEY_TITLE = "KEY";
    public static String KEY_DESC = "KEY desc";
    public static String KEY_IMAGE = "KEYs";
    private boolean isTablet = false;
    private View fragmentt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_first, new ChangeFragment());
        transaction.commit();
        fragmentt = findViewById(R.id.fragment_second);
        if (fragmentt != null) {
            isTablet = true;
        }

    }

    @Override
    public void displayDetails(String title, String subTitle, int image) {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (isTablet) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_second,TExtFragment.newInstance(title,subTitle,image)).commit();
            } else {
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra(KEY_TITLE, title);
                intent.putExtra(KEY_DESC, subTitle);
                intent.putExtra(KEY_IMAGE, image);
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(KEY_TITLE, title);
            intent.putExtra(KEY_DESC, subTitle);
            intent.putExtra(KEY_IMAGE, image);
            startActivity(intent);
        }
    }
}