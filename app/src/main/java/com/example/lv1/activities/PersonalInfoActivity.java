package com.example.lv1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        Button oBtn = (Button)findViewById(R.id.button);

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText etIme = (TextInputEditText)findViewById(R.id.etIme);
                TextInputEditText etPrezime = (TextInputEditText)findViewById(R.id.etPrezime);
                EditText etDatumRodenja = (EditText) findViewById(R.id.etDatumRodenja);

                String sIme = etIme.getText().toString();
                String sPrezime = etPrezime.getText().toString();
                String sDatumRodenja = etDatumRodenja.getText().toString();

                if(!sIme.matches("") && !sPrezime.matches("")){
                    Intent student = new Intent(PersonalInfoActivity.this, StudentInfoActivity.class);
                    student.putExtra("imeStudenta", sIme);
                    student.putExtra("prezimeStudenta", sPrezime);
                    student.putExtra("datumRodenja", sDatumRodenja);
                    startActivity(student);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Morate upisati ime i prezime!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*@Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Morate upisati ime!", Toast.LENGTH_SHORT).show();
    }*/
}
