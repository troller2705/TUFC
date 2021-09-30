package com.example.fcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    TextView locationTv, dateTv, codeTv;
    Button adminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("");

        locationTv = findViewById(R.id.locationTv);
        dateTv = findViewById(R.id.dateTv);
        codeTv = findViewById(R.id.codeTv);
        adminBtn = findViewById(R.id.adminBtn);

        adminBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AdminActivity.class));
            finish();
        });

        ref.addValueEventListener (new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                MainModel mainModel = dataSnapshot.getValue(MainModel.class);

                locationTv.setText("Location: "+mainModel.location);
                dateTv.setText("Date: "+mainModel.date);
                codeTv.setText("Code: "+mainModel.code);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}