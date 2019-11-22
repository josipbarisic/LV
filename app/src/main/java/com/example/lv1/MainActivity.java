package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> studentiArray = new ArrayList<>();
    private ArrayList<String> predmetiArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadLocale();
        setContentView(R.layout.activity_main);

        final Button btn = (Button)findViewById(R.id.button);
        final TextView tvStudenti = (TextView)findViewById(R.id.tvStudenti);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.app_name));

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.lang, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String locale = parent.getSelectedItem().toString();
                locale = locale.substring(locale.indexOf("(") + 1, locale.indexOf(")"));

                setLocale(locale);

//                loadLocale();

                ActionBar ab = getSupportActionBar();
                ab.setTitle(getResources().getString(R.string.app_name));

                btn.setText(getResources().getString(R.string.buttonDalje));

                tvStudenti.setText(R.string.studenti);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent person = new Intent(MainActivity.this, PersonalInfoActivity.class);
                startActivity(person);
            }
        });
    }

    private void initList(){
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        String student = pref.getString("imeStudenta", "n/a");
        String predmet = pref.getString("predmet", "n/a");
        studentiArray.add(student);
        predmetiArray.add(predmet);

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, studentiArray, predmetiArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        /*SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();*/
    }

    /*public void loadLocale (){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");

        setLocale(language);
    }*/

}
