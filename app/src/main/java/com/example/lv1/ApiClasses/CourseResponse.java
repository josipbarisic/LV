package com.example.lv1.ApiClasses;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class CourseResponse {
    ArrayList<Course> courses;


    public ArrayList<Course> getAllCourses(){
        return courses;
    }

    /*@NonNull
    @Override
    public String toString() {
        return courses.toString();
    }*/
}