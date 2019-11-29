package com.example.lv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class StudentInfoFragment extends Fragment {
    TextInputEditText etPredmet;
    EditText etProfesor;
    EditText etGodina;
    EditText etBrojPredavanja;
    EditText etBrojLV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        etPredmet = (TextInputEditText)view.findViewById(R.id.etPredmet);
        etProfesor = (EditText)view.findViewById(R.id.etProfesor);
        etGodina = (EditText)view.findViewById(R.id.etGodina);
        etBrojPredavanja = (EditText)view.findViewById(R.id.etBrojPredavanja);
        etBrojLV = (EditText)view.findViewById(R.id.etBrojLV);

        return view;
    }
}
