package com.example.lv1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv1.CustomDataStorage;
import com.example.lv1.R;
import com.example.lv1.Student;
import com.example.lv1.activities.MainActivity;

public class SummaryInfoFragment extends Fragment {
    TextView tvIme;
    TextView tvPredmet;
    TextView tvDatumRodenja;
    TextView tvProfesor;
    TextView tvGodina;
    TextView tvBrojPredavanja;
    TextView tvBrojLV;

    String sIme;
    String sPrezime;
    String sPredmet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_summary_info, container, false);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvIme = view.findViewById(R.id.tvImePrezime);
        tvPredmet = view.findViewById(R.id.tvImePredmeta);
        tvDatumRodenja = view.findViewById(R.id.tvDatumRod);
        tvProfesor = view.findViewById(R.id.tvImeProfesora);
        tvGodina = view.findViewById(R.id.tvGodina);
        tvBrojPredavanja = view.findViewById(R.id.tvBrojPredavanja);
        tvBrojLV = view.findViewById(R.id.tvBrojLV);

        Button oBtn = view.findViewById(R.id.backButton);
        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sIme == null || sPrezime == null || sPredmet == null) {
                    Toast.makeText(getContext(), R.string.warning, Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    CustomDataStorage students = CustomDataStorage.getInstance();
                    Student student = new Student(sIme, sPrezime, sPredmet);
                    students.setStudents(student);

                    startActivity(intent);
                }

            }
        });

    }

    public void updatePersonalInfo(String ime, String prezime, String datum){
        sIme = ime;
        sPrezime = prezime;

        tvIme.setText(ime + " " + prezime);
        tvDatumRodenja.setText(datum);
    }

    public void updateStudentInfo(String predmet, String profesor, String godina, String br_pred, String br_lab){
        sPredmet = predmet;

        tvPredmet.setText(predmet);
        tvProfesor.setText(profesor);
        tvGodina.setText(godina);
        tvBrojPredavanja.setText(br_pred);
        tvBrojLV.setText(br_lab);
    }
}
