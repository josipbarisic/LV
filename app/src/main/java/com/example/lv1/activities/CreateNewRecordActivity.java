package com.example.lv1.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.lv1.R;
import com.example.lv1.fragments.SummaryInfoFragment;
import com.example.lv1.adapters.ViewPagerAdapter;
import com.example.lv1.interfaces.PersonalInfoInterface;
import com.example.lv1.interfaces.StudentInfoInterface;

public class CreateNewRecordActivity extends AppCompatActivity implements PersonalInfoInterface, StudentInfoInterface {

    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        viewPager = findViewById(R.id.viewpager);
        //load all fragments
        viewPager.setOffscreenPageLimit(2);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        //DODATI INTERFACE-E ZA SVAKI FRAGMENT (SPREMANJE PODATAKA)

    }


    @Override
    public void onPersonalInfoInput(String ime, String prezime, String datum) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
        SummaryInfoFragment fragment = (SummaryInfoFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.updatePersonalInfo(ime, prezime, datum);
//        Toast.makeText(getApplicationContext(), tag, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStudentInput(String predmet, String profesor, String godina, String br_pred, String br_lab) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
        SummaryInfoFragment fragment = (SummaryInfoFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.updateStudentInfo(predmet, profesor, godina, br_pred, br_lab);
//        Toast.makeText(getApplicationContext(), tag, Toast.LENGTH_SHORT).show();
    }
}
