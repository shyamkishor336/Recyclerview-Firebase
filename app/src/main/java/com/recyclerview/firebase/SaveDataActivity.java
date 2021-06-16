package com.recyclerview.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveDataActivity extends AppCompatActivity {
    EditText name, syllabus, notes,questions;
    Button saveBtn;
    DatabaseReference mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        name = findViewById(R.id.name);
        syllabus = findViewById(R.id.syllabus);
        notes = findViewById(R.id.notes);
        questions = findViewById(R.id.questions);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
            }
        });
    }
    private void saveData() {
        String  names = name.getText().toString();
        String  syllab = syllabus.getText().toString();
        String  note = notes.getText().toString();
        String  question = questions.getText().toString();

        Model model = new Model(names,syllab,note,question);
        mref = FirebaseDatabase.getInstance().getReference("courses");
        String  UserId = mref.push().getKey();
        mref.child(UserId).setValue(model);

        Toast.makeText(this, "User Saved", Toast.LENGTH_SHORT).show();
    }
}