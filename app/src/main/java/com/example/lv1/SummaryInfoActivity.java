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
        String sPredmet = last.getExtras().getString("imePredmeta");

        TextView tvIme = (TextView)findViewById(R.id.tvImePrezime);
        TextView tvPredmet = (TextView)findViewById(R.id.tvImePredmeta);
        tvIme.setText(sIme);
        tvPredmet.setText(sPredmet);

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
