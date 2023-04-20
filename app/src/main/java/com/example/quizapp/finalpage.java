package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class finalpage extends AppCompatActivity {

    private TextView tvScore,wrong,final_s;
    public Button btnRestart;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalpage);

        tvScore = findViewById(R.id.textView5 );
        wrong = findViewById(R.id.textView11);
        final_s = findViewById(R.id.textView12 );
        btnRestart = findViewById(R.id.button);
//
//
//            // Retrieve user's score from quiz activity
        int score = getIntent().getIntExtra("score", 0);

//            // Display user's score in TextView
        tvScore.setText("Correct answers: " + Questions.count);
        wrong.setText("Wrong answers: "+(5-Questions.count));
        final_s.setText("Final score: "+Questions.count);

        // Set click listeners for buttons
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart quiz
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

