package com.example.lv1;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class PersonalInfoFragment extends Fragment {

    EditText etDatumRodenja;
    TextInputEditText etPrezime;
    TextInputEditText etIme;
    String sIme;
    String sPrezime;
    private PersonalInfoInterface listener;

    public interface PersonalInfoInterface {
        void onImeInput(String ime);
        void onPrezimeInput(String prezime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        etIme = (TextInputEditText)view.findViewById(R.id.etIme);
        etPrezime = (TextInputEditText)view.findViewById(R.id.etPrezime);
        etDatumRodenja = (EditText)view.findViewById(R.id.etDatumRodenja);

        //text watcher
        etIme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getContext(), etIme.getText().toString(), Toast.LENGTH_SHORT).show();
                sIme = etIme.getText().toString();

                listener.onImeInput(sIme);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPrezime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getContext(), etPrezime.getText().toString(), Toast.LENGTH_SHORT).show();
                sPrezime = etPrezime.getText().toString();

                listener.onPrezimeInput(sPrezime);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof PersonalInfoInterface) {
            listener = (PersonalInfoInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement PersonalInfoInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
