package com.example.lv1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;


import com.example.lv1.CustomDataStorage;
import com.example.lv1.R;
import com.example.lv1.adapters.RecyclerViewAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String listTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadLocale();
        setContentView(R.layout.activity_main);

        final Button btn = (Button)findViewById(R.id.button);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.app_name));

        listTitle = getResources().getString(R.string.studenti);

        initRecyclerView();

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.lang, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String locale = parent.getSelectedItem().toString();
                locale = locale.substring(locale.indexOf("(") + 1, locale.indexOf(")"));

                setLocale(locale);

                ActionBar ab = getSupportActionBar();
                ab.setTitle(getResources().getString(R.string.app_name));
                listTitle = getResources().getString(R.string.studenti);

                btn.setText(getResources().getString(R.string.buttonDalje));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent person = new Intent(MainActivity.this, CreateNewRecordActivity.class);
                startActivity(person);
            }
        });
    }

    private void initRecyclerView(){
        CustomDataStorage students = CustomDataStorage.getInstance();
        List<Object> list =  students.getStudents();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }
}
