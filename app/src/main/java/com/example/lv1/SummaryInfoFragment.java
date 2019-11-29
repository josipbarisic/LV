package com.example.lv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SummaryInfoFragment extends Fragment {
    TextView tvIme;
    TextView tvPredmet;
    TextView tvDatumRodenja;
    TextView tvProfesor;
    TextView tvGodina;
    TextView tvBrojPredavanja;
    TextView tvBrojLV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_summary_info, container, false);

        tvIme = (TextView)view.findViewById(R.id.tvImePrezime);
        tvPredmet = (TextView)view.findViewById(R.id.tvImePredmeta);
        tvDatumRodenja = (TextView)view.findViewById(R.id.tvDatumRod);
        tvProfesor = (TextView)view.findViewById(R.id.tvImeProfesora);
        tvGodina = (TextView)view.findViewById(R.id.tvGodina);
        tvBrojPredavanja = (TextView)view.findViewById(R.id.tvBrojPredavanja);
        tvBrojLV = (TextView)view.findViewById(R.id.tvBrojLV);

        return view;
    }
}
