package io.geektech.myapplicationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TExtFragment extends Fragment {
    private static final String ARG_TITLE = "argsTitle";
    private static final String ARG_SUBTITLE = "argsSubTitle";
    private static final String ARG_IMAGE = "argsImage";

    private TextView tExtView;
    private TextView txtSubTitle;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static TExtFragment newInstance(String title,String subTitle,int image){
        TExtFragment tExtFragment = new TExtFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE,title);
        args.putString(ARG_SUBTITLE,subTitle);
        args.putInt(ARG_IMAGE,image);
        tExtFragment.setArguments(args);
        return tExtFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_t_ext, container, false);
        tExtView = view.findViewById(R.id.txtView);
        txtSubTitle = view.findViewById(R.id.txtSubTitle);
        imageView = view.findViewById(R.id.image1);
        if (getArguments()!=null){
            tExtView.setText(getArguments().getString(ARG_TITLE));
            txtSubTitle.setText(getArguments().getString(ARG_SUBTITLE));
            imageView.setImageResource(getArguments().getInt(ARG_IMAGE));
        }
        return view;
    }

}