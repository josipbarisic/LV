package com.example.lv1;

import java.util.ArrayList;
import java.util.List;

public class CustomDataStorage {
    private List<Object> students;
    private CustomDataStorage(){
        students  = new ArrayList<>();
        students.add("STUDENTI");
    }
    static private CustomDataStorage instance;
    static CustomDataStorage getInstance(){
        if(instance == null)
        {
            instance = new CustomDataStorage();
        }
        return instance;
    }

    public List<Object> getStudents(){
        return students;
    }
    public void setStudents(Student newStudent){
        students.add(newStudent);
    }
}

class Student{
    public String sIme;
    public String sPrezime;
    public String sPredmet;

    public Student(String ime, String prezime, String predmet){
        this.sIme = ime;
        this.sPrezime = prezime;
        this.sPredmet = predmet;
    }
}