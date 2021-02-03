package io.geektech.myapplicationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TExtFragment extends Fragment {

    private TextView tExtView;
    private TextView txtSubTitle;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_t_ext, container, false);
        tExtView = view.findViewById(R.id.txtView);
        txtSubTitle = view.findViewById(R.id.txtSubTitle);
        imageView = view.findViewById(R.id.image1);
        return view;
    }

    public void showText(String text, String subTitle, int image) {
        tExtView.setText(text);
        txtSubTitle.setText(subTitle);
        imageView.setImageResource(image);

    }
}