package com.example.quizapp;

import static com.example.quizapp.R.id.editName;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start,about;
    EditText nametext;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametext=findViewById(R.id.name);
        about = (Button) findViewById(R.id.about);
        start = (Button) findViewById(R.id.start);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Developers_login.class);
                startActivity(intent);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getname = nametext.getText().toString().trim();
                if (getname.isEmpty() || getname.length() == 0 || getname.equals("") || getname== null) {
                    Toast.makeText(MainActivity.this, "First Enter Your Name To Start a Quiz", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Questions.class);
                    intent.putExtra("name", getname);
                    startActivity(intent);
                }
            }
        });
    }



}