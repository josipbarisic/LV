package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Intent personal = getIntent();
        final String studentIme = personal.getExtras().getString("imeStudenta");
        final String studentPrezime = personal.getExtras().getString("prezimeStudenta");
        final String datumRodenja = personal.getExtras().getString("datumRodenja");

        Button oBtn = (Button)findViewById(R.id.button);

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText etPredmet = (TextInputEditText)findViewById(R.id.etPredmet);
                EditText etProfesor = (EditText)findViewById(R.id.etProfesor);
                EditText etGodina = (EditText)findViewById(R.id.etGodina);
                EditText etBrojPredavanja = (EditText)findViewById(R.id.etBrojPredavanja);
                EditText etBrojLV = (EditText)findViewById(R.id.etBrojLV);

                String sPredmet = etPredmet.getText().toString();
                String sProfesor = etProfesor.getText().toString();
                String sGodina = etGodina.getText().toString();
                String sBrojPredavanja = etBrojPredavanja.getText().toString();
                String sBrojLV = etBrojLV.getText().toString();

                if(!sPredmet.matches("")){
                    Intent summary = new Intent(StudentInfoActivity.this, SummaryInfoActivity.class);
                    summary.putExtra("imeStudenta", studentIme);
                    summary.putExtra("prezimeStudenta", studentPrezime);
                    summary.putExtra("datumRodenja", datumRodenja);
                    summary.putExtra("imePredmeta", sPredmet);
                    summary.putExtra("imeProfesora", sProfesor);
                    summary.putExtra("godina", sGodina);
                    summary.putExtra("brojPredavanja", sBrojPredavanja);
                    summary.putExtra("brojLV", sBrojLV);

                    startActivity(summary);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Morate upisati ime predmeta!", Toast.LENGTH_SHORT).show();
                }


            }
        });
}
}
