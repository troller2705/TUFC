package com.example.fcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AdminActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    EditText locationEt, dateEt, codeEt;
    Button uploadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("");

        locationEt = findViewById(R.id.locationEt);
        dateEt = findViewById(R.id.dateEt);
        codeEt = findViewById(R.id.codeEt);
        uploadBtn = findViewById(R.id.uploadBtn);

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Object, String> hashMap = new HashMap<>();
                hashMap.put("location", locationEt.getText().toString());
                hashMap.put("date", dateEt.getText().toString());
                hashMap.put("code", codeEt.getText().toString());
                hashMap.put("null", "null");
                ref.setValue(hashMap);
            }
        });

    }

}