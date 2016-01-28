package com.gfc.iit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView mTotalQuestions;
    TextView mCorrectAnswered;
    TextView mScore;

    Button mFinishQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Your Result");

        Intent intent = getIntent();
        int correct = intent.getIntExtra("correct", 0);
        int total = intent.getIntExtra("total",0);
        int score = correct*3 - total + correct;

        mTotalQuestions = (TextView)findViewById(R.id.total_questions);
        mCorrectAnswered = (TextView)findViewById(R.id.correct_answered);
        mScore = (TextView) findViewById(R.id.score);
        mFinishQuiz =(Button) findViewById(R.id.finish_quiz);

        mTotalQuestions.setText("Total Questions:"+total);
        mCorrectAnswered.setText("Correctly Answered:"+correct);
        mScore.setText("Your Score:"+score);

        mFinishQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
