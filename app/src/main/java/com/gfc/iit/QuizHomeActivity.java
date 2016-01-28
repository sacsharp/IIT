package com.gfc.iit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizHomeActivity extends AppCompatActivity {

    private Button btnStartQuiz;
    private int totalQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quiz_home);
        setTitle("Take a Quiz");

        final Intent intent = getIntent();

        QuestionsDBAdapter questionsDBAdapter = new QuestionsDBAdapter(getApplicationContext());
        totalQuestions=questionsDBAdapter.getTotalCount();


        int temp = totalQuestions/5;
        ScrollView scrollView = new ScrollView(getApplicationContext());;
        scrollView.setFillViewport(true);
        LinearLayout ll = new LinearLayout(getApplicationContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(ll);

        if(temp>1)
        {

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300);
            for(int i=0;i<temp;i++)
            {
                CardView cardView = new CardView(getApplicationContext());
                params.setMargins(20,20,20,20);
                cardView.setLayoutParams(params);
                cardView.setCardBackgroundColor(Color.BLACK);
                cardView.setRadius(4);
                cardView.setMaxCardElevation(4);

                final LinearLayout insidell = new LinearLayout(getApplicationContext());
                insidell.setOrientation(LinearLayout.VERTICAL);

                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                TextView textView = new TextView(getApplicationContext());
                textView.setLayoutParams(params1);
                textView.setTextColor(Color.RED);
                textView.setText("Quiz " + (i + 1));
                textView.setTextSize(50);
                insidell.addView(textView);

                final Button button = new Button(getApplicationContext());
                button.setLayoutParams(params1);
                button.setText("Start Quiz");
                button.setId(2001 + i);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(getApplicationContext(),QuizActivity.class);
                        intent2.putExtra("id",button.getId());
                        startActivity(intent2);

                    }
                });
                insidell.addView(button);

                cardView.addView(insidell);
                ll.addView(cardView);
            }
            View view = scrollView;
            setContentView(view);
        }


    }
}
