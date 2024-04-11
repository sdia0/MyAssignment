package com.example.myassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myassignment.R;


public class DataFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        TextView lastNameText = view.findViewById(R.id.surnameText);
        TextView nameText = view.findViewById(R.id.nameText);
        TextView patronText = view.findViewById(R.id.fatherNameText);
        TextView ageText = view.findViewById(R.id.ageText);
        Button btn = view.findViewById(R.id.goBack);
        if (bundle != null) {
            String gettingSurnameText = bundle.getString("surname");
            String gettingNameText = bundle.getString("name");
            String gettingPatronText = bundle.getString("patron");
            String gettingAgeText = bundle.getString("age");
            lastNameText.setText(gettingSurnameText);
            nameText.setText(gettingNameText);
            patronText.setText(gettingPatronText);
            ageText.setText(gettingAgeText);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }
}