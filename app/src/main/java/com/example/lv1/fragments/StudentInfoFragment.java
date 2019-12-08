package com.example.lv1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lv1.ApiClasses.Course;
import com.example.lv1.ApiClasses.CourseResponse;
import com.example.lv1.ApiClasses.Instructor;
import com.example.lv1.ApiClasses.ApiManager;
import com.example.lv1.R;
import com.example.lv1.interfaces.StudentInfoInterface;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse> {

    //API
    CourseResponse courses = new CourseResponse();

//    TextInputEditText etPredmet;
    Spinner predmetSpinner;
    EditText etProfesor;
    EditText etGodina;
    EditText etBrojPredavanja;
    EditText etBrojLV;

    String sPredmet;
    String sProfesor;
    String sGodina;
    String sBrojPredavanja;
    String sBrojLabosa;

    private StudentInfoInterface studentInfoListener;
    final String TAG = "API_COURSES";

    private ArrayList<String> courseTitles = new ArrayList<>();

    private ArrayList<ArrayList<Instructor>> instructors = new ArrayList<>();

    private ArrayList<String> instructorNames = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        etGodina = view.findViewById(R.id.etGodina);
        etBrojPredavanja = view.findViewById(R.id.etBrojPredavanja);
        etBrojLV = view.findViewById(R.id.etBrojLV);

        etGodina.addTextChangedListener(textWatcher);
        etBrojPredavanja.addTextChangedListener(textWatcher);
        etBrojLV.addTextChangedListener(textWatcher);

        //API CALL
        ApiManager.getInstance().service().getCourses().enqueue(this);

        return view;
    }

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            sGodina = etGodina.getText().toString();
            sBrojPredavanja = etBrojPredavanja.getText().toString();
            sBrojLabosa = etBrojLV.getText().toString();

            studentInfoListener.onStudentInput(sPredmet, sProfesor, sGodina, sBrojPredavanja, sBrojLabosa);
        }
    };

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
        if (response.isSuccessful() && response.body() != null){
            courses = response.body();
            getCourseTitles(courses);
        }
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    private void getCourseTitles(CourseResponse response){
        ArrayList<Course> allCourses = response.getAllCourses();
        String courseTitle;

        for (Course course:allCourses){
            courseTitle = course.getTitle();

            if(!courseTitle.matches("")){
                courseTitles.add(courseTitle);
                instructors.add(course.getInstructors());
            }
        }

        makePredmetSpinner(getView().getRootView());

    }

    private Spinner makePredmetSpinner(View view){

        Spinner spinner = view.findViewById(R.id.spinnerPredmet);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(),R.layout.spinner_item, courseTitles);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_element);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                instructorNames.clear();
                sPredmet = parent.getSelectedItem().toString();

                studentInfoListener.onStudentInput(sPredmet, sProfesor, sGodina, sBrojPredavanja, sBrojLabosa);
//                Toast.makeText(getContext(), sPredmet, Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onCourseSelected: " + position);


                for(int i = 0; i < instructors.get(position).size(); i++){

                    Log.d(TAG, "onItemSelected: " + instructors.get(position).get(i).getInstructor());

                    Instructor instructor = instructors.get(position).get(i);

                    instructorNames.add(instructor.getInstructor());
                }

                makeProfesorSpinner(getView().getRootView());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return spinner;
    }

    public Spinner makeProfesorSpinner(View view){
        Spinner spinner = view.findViewById(R.id.spinnerProfesor);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(),R.layout.spinner_item, instructorNames);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_element);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sProfesor = parent.getSelectedItem().toString();

                studentInfoListener.onStudentInput(sPredmet, sProfesor, sGodina, sBrojPredavanja, sBrojLabosa);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return spinner;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  StudentInfoInterface) {
            studentInfoListener = (StudentInfoInterface) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        studentInfoListener = null;
    }
}
