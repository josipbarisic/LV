package com.example.lv1;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.lv1.ApiClasses.CourseResponse;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse> {

    //API
    CourseResponse courses = new CourseResponse();

    TextInputEditText etPredmet;
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

    public interface StudentInfoInterface{
        void onStudentInput(String predmet, String profesor, String godina, String br_pred, String br_lab);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        etPredmet = view.findViewById(R.id.etPredmet);
        etProfesor = view.findViewById(R.id.etProfesor);
        etGodina = view.findViewById(R.id.etGodina);
        etBrojPredavanja = view.findViewById(R.id.etBrojPredavanja);
        etBrojLV = view.findViewById(R.id.etBrojLV);

        etPredmet.addTextChangedListener(textWatcher);
        etProfesor.addTextChangedListener(textWatcher);
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
            sPredmet = etPredmet.getText().toString();
            sProfesor = etProfesor.getText().toString();
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
            printCoursesToConsole(courses);
        }
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    private void printCoursesToConsole(CourseResponse courses){
        String TAG = "apicall";
        Log.d(TAG, courses.toString());
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
