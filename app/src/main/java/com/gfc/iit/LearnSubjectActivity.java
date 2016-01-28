package com.gfc.iit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LearnSubjectActivity extends AppCompatActivity {

    ListView mListView;
    String[] mClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_subject);

        Intent intent = getIntent();
        Integer subjectID = intent.getIntExtra("SubjectID",10);

        mListView = (ListView) findViewById(R.id.contentGK);

        switch (subjectID)
        {
            case 1:
                ContentDBAdapter contentDBAdapter = new ContentDBAdapter(getApplicationContext());
                contentDBAdapter.insertStatement("India's Capital is Delhi.",1);
                Toast.makeText(this,"Question Added",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                setTitle("General Knowledge");
                ContentDBAdapter contentDBAdapter1 = new ContentDBAdapter(getApplicationContext());
                ArrayList list = contentDBAdapter1.getAllStatements();

                mListView.setAdapter(new ArrayAdapter<>(this,R.layout.drawer_list_item,list));
                break;

            default:
               TextView mInfo = (TextView) findViewById(R.id.info_text1);
                mInfo.setText("No Content");

        }

    }
}
