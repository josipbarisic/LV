package com.example.lv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class PersonalInfoFragment extends Fragment {

    EditText etDatumRodenja;
    TextInputEditText etPrezime;
    TextInputEditText etIme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        //text watcher

        etIme = (TextInputEditText)view.findViewById(R.id.etIme);
        etPrezime = (TextInputEditText)view.findViewById(R.id.etPrezime);
        etDatumRodenja = (EditText)view.findViewById(R.id.etDatumRodenja);

        return view;
    }
}
