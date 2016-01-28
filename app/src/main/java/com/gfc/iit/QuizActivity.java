package com.gfc.iit;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.style.QuoteSpan;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    WebView mWebViewQuestion;

    WebView mWebViewA;
    WebView mWebViewB;
    WebView mWebViewC;
    WebView mWebViewD;
    Button mButtonNext;
    Boolean answered= false;

    Question currentQuestion;
    List<Question> mQuestionList;
    int correct=0;
    int qid=0;
    int buttonid;
    String answer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        final Intent intent = getIntent();
        buttonid = intent.getIntExtra("id",2001);


        int temp = buttonid-2000;
        int startid = temp*5-4;
        int endid = temp*5;
        setTitle("Quiz "+temp);
        mWebViewQuestion = (WebView) findViewById(R.id.web_view_question);
        mWebViewA = (WebView) findViewById(R.id.web_view_a);
        mWebViewB = (WebView) findViewById(R.id.web_view_b);
        mWebViewC = (WebView) findViewById(R.id.web_view_c);
        mWebViewD = (WebView) findViewById(R.id.web_view_d);

        mButtonNext = (Button) findViewById(R.id.btn_next_question);

        WebSettings webSettings = mWebViewQuestion.getSettings();
        Resources res = getResources();
        float fontSize = res.getDimension(R.dimen.question);
        webSettings.setDefaultFontSize((int)fontSize);

//        webSettings = mWebViewA.getSettings();
//        res = getResources();
//        fontSize = res.getDimension(R.dimen.answer);
//        webSettings.setDefaultFontSize((int)fontSize);
//
//        webSettings = mWebViewB.getSettings();
//        webSettings.setDefaultFontSize((int)fontSize);
//
//        webSettings = mWebViewC.getSettings();
//        webSettings.setDefaultFontSize((int)fontSize);
//
//        webSettings = mWebViewD.getSettings();
//        webSettings.setDefaultFontSize((int)fontSize);

        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBlockNetworkImage(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setGeolocationEnabled(false);
        webSettings.setNeedInitialFocus(false);
        webSettings.setSaveFormData(false);

        final QuestionsDBAdapter questionsDBAdapter= new QuestionsDBAdapter(getApplicationContext());
        mQuestionList= questionsDBAdapter.getQuestions(startid, endid);
        currentQuestion  = mQuestionList.get(qid);
        setQuestionView();


        mWebViewA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mWebViewA.setBackgroundColor(Color.GREEN);
                mWebViewB.setBackgroundColor(Color.WHITE);
                mWebViewC.setBackgroundColor(Color.WHITE);
                mWebViewD.setBackgroundColor(Color.WHITE);
                answer = mWebViewA.getTag().toString();
                answered = true;
                return true;
            }
        });
        mWebViewB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mWebViewA.setBackgroundColor(Color.WHITE);
                mWebViewB.setBackgroundColor(Color.GREEN);
                mWebViewC.setBackgroundColor(Color.WHITE);
                mWebViewD.setBackgroundColor(Color.WHITE);
                answer = mWebViewB.getTag().toString();
                answered= true;
                return true;
            }
        });
        mWebViewC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mWebViewA.setBackgroundColor(Color.WHITE);
                mWebViewB.setBackgroundColor(Color.WHITE);
                mWebViewC.setBackgroundColor(Color.GREEN);
                mWebViewD.setBackgroundColor(Color.WHITE);
                answer = mWebViewC.getTag().toString();
                answered = true;
                return true;
            }
        });
        mWebViewD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mWebViewA.setBackgroundColor(Color.WHITE);
                mWebViewB.setBackgroundColor(Color.WHITE);
                mWebViewC.setBackgroundColor(Color.WHITE);
                mWebViewD.setBackgroundColor(Color.GREEN);
                answer = mWebViewD.getTag().toString();
                answered = true;
                return true;
            }
        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer.isEmpty() && answered.equals(false))
                {
                    Toast.makeText(getApplicationContext(),"Please choose one option",Toast.LENGTH_LONG).show();
                }
                else {
                    if (currentQuestion.get_answer().equals(answer))
                        correct++;
                    if (qid < 5) {
                        currentQuestion = mQuestionList.get(qid);
                        mWebViewA.setBackgroundColor(Color.WHITE);
                        mWebViewB.setBackgroundColor(Color.WHITE);
                        mWebViewC.setBackgroundColor(Color.WHITE);
                        mWebViewD.setBackgroundColor(Color.WHITE);
                        setQuestionView();
                    } else {
                        Intent intent2 = new Intent(getApplicationContext(), ResultActivity.class);
                        intent2.putExtra("correct", correct);
                        intent2.putExtra("total",mQuestionList.size());
                        startActivity(intent2);
                    }
                }
            }
        });



    }

    private void setQuestionView()
    {
        answered=false;
        answer="";
        mWebViewQuestion.loadDataWithBaseURL("file:///android_asset/", currentQuestion.get_question(), "text/html", "UTF-8", null);
        mWebViewA.loadDataWithBaseURL("file:///android_asset/",currentQuestion.get_optA(),"text/html","UTF-8",null);
        mWebViewA.setTag(currentQuestion.get_optA());
        mWebViewB.loadDataWithBaseURL("file:///android_asset/", currentQuestion.get_optB(), "text/html", "UTF-8", null);
        mWebViewB.setTag(currentQuestion.get_optB());
        mWebViewC.loadDataWithBaseURL("file:///android_asset/", currentQuestion.get_optC(), "text/html", "UTF-8", null);
        mWebViewC.setTag(currentQuestion.get_optC());
        mWebViewD.loadDataWithBaseURL("file:///android_asset/", currentQuestion.get_optD(), "text/html", "UTF-8", null);
        mWebViewD.setTag(currentQuestion.get_optD());
        qid++;
    }
}
