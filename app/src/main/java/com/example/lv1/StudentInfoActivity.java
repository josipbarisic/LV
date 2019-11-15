package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Intent personal = getIntent();
        final String studentIme = personal.getExtras().getString("imeStudenta");

        Button oBtn = (Button)findViewById(R.id.button);

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText etPredmet = (TextInputEditText)findViewById(R.id.etPredmet);
                String sPredmet = etPredmet.getText().toString();

                if(!sPredmet.matches("")){
                    Intent summary = new Intent(StudentInfoActivity.this, SummaryInfoActivity.class);
                    summary.putExtra("imeStudenta", studentIme);
                    summary.putExtra("imePredmeta", sPredmet);
                    startActivity(summary);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Morate upisati ime predmeta!", Toast.LENGTH_SHORT).show();
                }


            }
        });
}
}
