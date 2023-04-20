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

public class question4 extends AppCompatActivity implements View.OnClickListener{

    Button next_question,quit;
    EditText nametext;
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;

    int score=0;
    int totalQuestion = QuestionAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questionTextView = findViewById(R.id.questionss);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);

        quit = (Button) findViewById(R.id.button3);
        next_question = (Button) findViewById(R.id.button2);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        next_question.setOnClickListener(this);

        loadNewQuestion();

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View v) {
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.button3){//clicking nextquestion button,if answer is crct...increses score
            if(selectedAnswer.equals(QuestionAnswers.correctAnswers[currentQuestionIndex])){//for incresinf score for correct answers
                score++;
            }
            currentQuestionIndex++;//for moving next question
            loadNewQuestion();

        }else{
            //choices button closed
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion() {

        if(currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }


        questionTextView.setText(QuestionAnswers.question[currentQuestionIndex]);//loading next questions
        ansA.setText(QuestionAnswers.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswers.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswers.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswers.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = "";

        new AlertDialog.Builder(this)

                .setMessage("Score is "+score+" out of "+ totalQuestion)
                .setCancelable(false)
                .show();
    }
}