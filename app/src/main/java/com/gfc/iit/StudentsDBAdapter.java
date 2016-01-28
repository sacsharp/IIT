package com.gfc.iit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sachin on 11/19/2015.
 */
public class StudentsDBAdapter extends DBAdapter{


    public static final String STUDENTS_TABLE_NAME = "students";
    public static final String STUDENTS_COLUMN_ID = "id";
    public static final String STUDENTS_COLUMN_NAME = "name";
    public static final String STUDENTS_COLUMN_PHONE = "phone";
    public static final String STUDENTS_COLUMN_STANDARD = "standard";

    public StudentsDBAdapter(Context context){
        super(context);
    }

    public boolean insertStudent(Student student ){


        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENTS_COLUMN_NAME,student.get_name());
        contentValues.put(STUDENTS_COLUMN_STANDARD,student.get_standard());
        contentValues.put(STUDENTS_COLUMN_PHONE,student.get_phone());

        if(db.insert(STUDENTS_TABLE_NAME, null, contentValues)>0)
        return true;
        else return false;
    }
    public Student getStudent(int id)
    {
        Cursor cursor = db.rawQuery("SELECT * from "+STUDENTS_TABLE_NAME+" where "+STUDENTS_COLUMN_ID+"="+id,null);

        if(cursor !=null)
            cursor.moveToFirst();

        Student student = new Student(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3));
        cursor.close();
        return student;
    }

    public List<Student> getAllStudents ()
    {
        List<Student> studentList = new ArrayList<Student>();
        Cursor cursor = db.rawQuery("SELECT * from "+STUDENTS_TABLE_NAME,null);

        if(cursor != null)
        {
            if(cursor.moveToFirst())
                do {
                    Student student = new Student();
                    student.set_id(cursor.getInt(0));
                    student.set_name(cursor.getString(1));
                    student.set_standard(cursor.getInt(2));
                    student.set_phone(cursor.getInt(3));

                    studentList.add(student);

                }while(cursor.moveToNext());
        }

        return studentList;
    }

}
