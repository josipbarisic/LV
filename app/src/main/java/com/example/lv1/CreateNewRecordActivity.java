package com.example.lv1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class CreateNewRecordActivity extends AppCompatActivity implements PersonalInfoFragment.PersonalInfoInterface {
    private SummaryInfoFragment summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(this.getSupportFragmentManager()));

        summary = new SummaryInfoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.viewpager, summary).commit();

        //DODATI INTERFACE-E ZA SVAKI FRAGMENT (SPREMANJE PODATAKA)

    }


    public void onImeInput(String ime){
        summary.onImeInput(ime);
    }
    public void onPrezimeInput(String prezime){
        summary.onPrezimeInput(prezime);
    }
}
