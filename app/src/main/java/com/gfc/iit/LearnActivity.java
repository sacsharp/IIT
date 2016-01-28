package com.gfc.iit;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LearnActivity extends AppCompatActivity {

    Button mBtnLearn;
    Button mBtnLearnGK;
    Button mBtnTakeQuizGK;
    Button mBtnAddQuestions;
    Button mBtnTakeQuizEng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        mBtnLearn =(Button) findViewById(R.id.btnLearn);
        mBtnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LearnSubjectActivity.class);
                intent.putExtra("SubjectID",1);
                startActivity(intent);
            }
        });

        mBtnLearnGK = (Button) findViewById(R.id.btnLearnGK);
        mBtnLearnGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LearnSubjectActivity.class);
                intent.putExtra("SubjectID",2);
                startActivity(intent);
            }
        });

        mBtnTakeQuizGK =(Button) findViewById(R.id.btnTakeQuizGK);
        mBtnTakeQuizGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),QuizHomeActivity.class);
                intent.putExtra("SubjectID",2);
                startActivity(intent);
            }
        });

        mBtnAddQuestions = (Button) findViewById(R.id.btn_add_questions);
        mBtnAddQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c=0;
                QuestionsDBAdapter questionsDBAdapter = new QuestionsDBAdapter(getApplicationContext());
                Question q1=new Question("Which company is the largest manufacturer of network equipment?","HP", "IBM", "CISCO","MICROSOFT", "CISCO",1,1);
                questionsDBAdapter.addQuestion(q1);
                c++;
                Question q2=new Question("Which of the following is NOT an operating system?", "SuSe", "BIOS", "DOS","MAC", "BIOS",1,1);
                questionsDBAdapter.addQuestion(q2);
                c++;
                Question q3=new Question("Which of the following is the fastest writable memory?","RAM", "FLASH","Register","HARD DISK","Register",1,1);
                questionsDBAdapter.addQuestion(q3);
                c++;
                Question q4=new Question("Which of the following device regulates internet traffic?","Router", "Bridge", "Hub","Routing Table","Router",1,1);
                questionsDBAdapter.addQuestion(q4);
                c++;
                Question q5=new Question("Which of the following is NOT an interpreted language?","Ruby","Python","BASIC","C++","BASIC",1,1);
                questionsDBAdapter.addQuestion(q5);
                c++;
                Question q6=new Question("Which one is a bag?","<img src='bag.png' />","<img src='box.jpg' />","<img src='mine.jpg' />","<img src='apple.jpg' />","<img src='bag.png' />",1,1);
                questionsDBAdapter.addQuestion(q6);
                c++;
                Question q7=new Question("Who is founder of Microsoft?","Bill Gates","Steve Jobs","Bilinda Gates","Warren Buffet","Bill Gates",1,1);
                questionsDBAdapter.addQuestion(q7);
                c++;
                Question q8=new Question("Who is founder of Apple?","Bill Gates","Steve Jobs","Bilinda Gates","Warren Buffet","Steve Jobs",1,1);
                questionsDBAdapter.addQuestion(q8);
                c++;
                Question q9=new Question("What is the value of X<sup>2</sup>, where X=5?","15","25","10","35","25",1,1);
                questionsDBAdapter.addQuestion(q9);
                c++;
                Question q10=new Question("Who is the wife of Microsoft's founder?","Bill Gates","Steve Jobs","Bilinda Gates","Warren Buffet","Bilinda Gates",1,1);
                questionsDBAdapter.addQuestion(q10);
                c++;


                if(c==10)
                    Toast.makeText(getApplicationContext(), "10 Questions Added Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        mBtnTakeQuizEng = (Button) findViewById(R.id.btn_start_quiz_eng);
        mBtnTakeQuizEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),WebviewQuizActivity.class);
                startActivity(intent1);
            }
        });



    }
}
