package com.gfc.iit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.ref.SoftReference;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextPhone;
    Spinner spinner;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        android.support.v7.widget.Toolbar toolbar1 = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(toolbar1);
        Intent intent = getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner = (Spinner) findViewById(R.id.registerClassSelector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.classes_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editTextName = (EditText) findViewById(R.id.registerName);
        editTextPhone = (EditText) findViewById(R.id.registerPhone);
        btnRegister = (Button) findViewById(R.id.registerButton);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("tapped", editTextPhone.getText().toString() + editTextName.getText().toString() + spinner.getSelectedItem().toString());

                StudentsDBAdapter studentsDBAdapter= new StudentsDBAdapter(getApplicationContext());
                String name = editTextName.getText().toString();
                int standard = Integer.parseInt(spinner.getSelectedItem().toString());
                int phone = Integer.parseInt( editTextPhone.getText().toString() );

                Student student = new Student(name,standard,phone);
                if(studentsDBAdapter.insertStudent(student))
                {
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();
                    Log.d("tapped", editTextName.getText().toString() + spinner.getSelectedItem().toString());
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Registration Unsuccessful",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
