package io.geektech.myapplicationfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    IFragments iFragments;

    private ArrayList<MainModel> list;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    public ChangeFragment() {
    }

//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        iFragments = (IFragments) context;
//    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        list = new ArrayList<>();
        list.add(new MainModel("Kyrgyzstan", "Мир здоровается", R.drawable.kyrgyzstan));
        list.add(new MainModel("America", "Мир здоровается", R.drawable.americaflag));
        list.add(new MainModel("United Kingdom", "Мир здоровается", R.drawable.uk));
        list.add(new MainModel("China", "Мир здоровается", R.drawable.china));
        list.add(new MainModel("Germany", "Мир здоровается", R.drawable.germany));
        list.add(new MainModel("Canada", "Мир здоровается", R.drawable.canada));
        list.add(new MainModel("South Korea", "Мир здоровается", R.drawable.southkorea));
        list.add(new MainModel("Russia", "Мир здоровается", R.drawable.russia));
        list.add(new MainModel("Turkey", "Мир здоровается", R.drawable.turkey));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list, getActivity());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetails(String title, String subTitle, int image) {
        MainActivity activity = (MainActivity) getActivity();
        activity.displayDetails(title, subTitle, image);
    }


}