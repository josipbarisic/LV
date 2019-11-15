package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_info);

        Intent last = getIntent();
        String sIme = last.getExtras().getString("imeStudenta");
        String sPrezime = last.getExtras().getString("prezimeStudenta");
        String sDatum = last.getExtras().getString("datumRodenja");
        String sPredmet = last.getExtras().getString("imePredmeta");
        String sProfesor = last.getExtras().getString("imeProfesora");
        String sGodina = last.getExtras().getString("godina");
        String sBrojPredavanja = last.getExtras().getString("brojPredavanja");
        String sBrojLV = last.getExtras().getString("brojLV");

        TextView tvIme = (TextView)findViewById(R.id.tvImePrezime);
        TextView tvPredmet = (TextView)findViewById(R.id.tvImePredmeta);
        TextView tvDatumRodenja = (TextView)findViewById(R.id.tvDatumRod);
        TextView tvProfesor = (TextView)findViewById(R.id.tvImeProfesora);
        TextView tvGodina = (TextView)findViewById(R.id.tvGodina);
        TextView tvBrojPredavanja = (TextView)findViewById(R.id.tvBrojPredavanja);
        TextView tvBrojLV = (TextView)findViewById(R.id.tvBrojLV);

        tvIme.setText("Student: " + sIme + " " + sPrezime);
        tvDatumRodenja.setText("Datum rođenja: " + sDatum);
        tvPredmet.setText("Upisani predmet: " + sPredmet);
        tvProfesor.setText("Profesor: " + sProfesor);
        tvGodina.setText("Akademska godina: " + sGodina);
        tvBrojPredavanja.setText("Broj sati predavanja: " + sBrojPredavanja);
        tvBrojLV.setText("Broj sati laboratorijskih vježbi: " + sBrojLV);

        Button oBtn = (Button)findViewById(R.id.backButton);

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(SummaryInfoActivity.this, PersonalInfoActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);

            }
        });

    }
}
