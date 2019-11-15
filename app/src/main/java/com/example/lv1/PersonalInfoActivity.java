package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oBtn = (Button)findViewById(R.id.button);

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText etImePrezime = (TextInputEditText)findViewById(R.id.etIme);
                String sImePrezime = etImePrezime.getText().toString();

                if(!sImePrezime.matches("")){
                    Intent student = new Intent(PersonalInfoActivity.this, StudentInfoActivity.class);
                    student.putExtra("imeStudenta", sImePrezime);
                    startActivity(student);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Morate upisati ime!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*@Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Morate upisati ime!", Toast.LENGTH_SHORT).show();
    }*/
}
