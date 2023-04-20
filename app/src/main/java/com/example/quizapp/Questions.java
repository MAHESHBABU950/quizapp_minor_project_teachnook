package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Questions extends AppCompatActivity implements View.OnClickListener {

    Button next_question, quit;
    TextView nametext;
    public static int count=0;
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;

    int score = 0;
    int totalQuestion = QuestionAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        nametext=findViewById(R.id.textView6);

        questionTextView = findViewById(R.id.questionss);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);

        quit = (Button) findViewById(R.id.button3);
        next_question = (Button) findViewById(R.id.button2);
        String nam = getIntent().getStringExtra("name");
        nametext.setText("Hello " + nam);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        next_question.setOnClickListener(this);

        loadNewQuestion();

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), finalpage.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View v) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if (clickedButton.getId() == R.id.button2) {//clicking nextquestion button,if answer is crct...increses score
            if (selectedAnswer.equals(QuestionAnswers.correctAnswers[currentQuestionIndex])) {//for incresinf score for correct answers
                count++;
            }
            currentQuestionIndex++;//for moving next question
            loadNewQuestion();

        } else {
            //choices button closed
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            Intent intent = new Intent(getApplicationContext(), finalpage.class);
            startActivity(intent);
        }
        else {

            questionTextView.setText(QuestionAnswers.question[currentQuestionIndex]);//loading next questions
            ansA.setText(QuestionAnswers.choices[currentQuestionIndex][0]);
            ansB.setText(QuestionAnswers.choices[currentQuestionIndex][1]);
            ansC.setText(QuestionAnswers.choices[currentQuestionIndex][2]);
            ansD.setText(QuestionAnswers.choices[currentQuestionIndex][3]);
        }}

}