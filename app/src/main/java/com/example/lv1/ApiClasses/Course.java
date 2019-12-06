package com.example.lv1.ApiClasses;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class Course {
    String title;
    ArrayList<Instructor> instructors;


    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
