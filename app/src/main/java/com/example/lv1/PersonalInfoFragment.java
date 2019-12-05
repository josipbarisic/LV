package com.example.lv1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import static android.app.Activity.RESULT_OK;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PersonalInfoFragment extends Fragment {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    EditText etDatumRodenja;
    TextInputEditText etPrezime;
    TextInputEditText etIme;
    String sIme;
    String sPrezime;
    String sDatum;
    ImageView image;
    private PersonalInfoInterface listener;

    public interface PersonalInfoInterface {
        void onPersonalInfoInput(String ime, String prezime, String datum);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        image = view.findViewById(R.id.profilna);

        etIme = view.findViewById(R.id.etIme);
        etPrezime = view.findViewById(R.id.etPrezime);
        etDatumRodenja = view.findViewById(R.id.etDatumRodenja);

        etIme.addTextChangedListener(textWatcher);
        etPrezime.addTextChangedListener(textWatcher);
        etDatumRodenja.addTextChangedListener(textWatcher);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }
    //text watcher

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
//            Toast.makeText(getContext(), etIme.getText().toString(), Toast.LENGTH_SHORT).show();
            sIme = etIme.getText().toString();
            sPrezime = etPrezime.getText().toString();
            sDatum = etDatumRodenja.getText().toString();

            listener.onPersonalInfoInput(sIme, sPrezime, sDatum);
        }
    };


    @Override
    public void onAttach(@NonNull Context context){
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
        }
    }
}
