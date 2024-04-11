package com.example.myassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myassignment.DataFragment;
import com.example.myassignment.R;

public class ProfileFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.sendBtn);
        EditText surnameEditText = view.findViewById(R.id.lastName);
        EditText nameEditText = view.findViewById(R.id.name);
        EditText patronEditText = view.findViewById(R.id.fatherName);
        EditText ageEditText = view.findViewById(R.id.age);
        Bundle bundle = new Bundle();
        DataFragment dataFragment = new DataFragment();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, dataFragment);
                ft.addToBackStack(null);
                ft.commit();
                dataFragment.setArguments(bundle);
                String surname = surnameEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String patron = patronEditText.getText().toString();
                String age = ageEditText.getText().toString();
                bundle.putString("surname", surname);
                bundle.putString("name", name);
                bundle.putString("patron", patron);
                bundle.putString("age", age);
                Log.d("FFF", surname);
                Log.d("FFF", name);
                Log.d("FFF", patron);
                Log.d("FFF", age);
            }
        });
    }
}