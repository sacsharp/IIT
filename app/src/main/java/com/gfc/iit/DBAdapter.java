package com.gfc.iit;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sachin on 11/19/2015.
 */
public class DBAdapter {

    public static final String DATABASE_NAME = "IIT";
    public static final int DATABASE_VERSION = 1;




    public static final String CREATE_STUDENTS_TABLE = "create table students ("+StudentsDBAdapter.STUDENTS_COLUMN_ID+" integer primary key AUTOINCREMENT, "
            +StudentsDBAdapter.STUDENTS_COLUMN_NAME + " TEXT, "
            +StudentsDBAdapter.STUDENTS_COLUMN_STANDARD +" INTEGER, "
            +StudentsDBAdapter.STUDENTS_COLUMN_PHONE + " INTEGER);";

    public static final String CREATE_GKLEARNING_TABLE = "create table gklearning ("+ContentDBAdapter.GKLEARNING_COLUMN_ID+" integer primary key AUTOINCREMENT, "
            +ContentDBAdapter.GKLEARNING_COLUMN_CONTENT + " TEXT, "
            +ContentDBAdapter.GKLEARNING_COLUMN_TYPE + " INTEGER, FOREIGN KEY("+ContentDBAdapter.GKLEARNING_COLUMN_TYPE+") REFERENCES "+ContentDBAdapter.CONTENTTYPE_TABLE_NAME+"("+ContentDBAdapter.CONTENTTYPE_COLUMN_ID+"));";

    public static final String CREATE_CONTENTTYPE_TABLE = "create table contenttype ("+ContentDBAdapter.CONTENTTYPE_COLUMN_ID+" integer primary key AUTOINCREMENT, "
            +ContentDBAdapter.CONTENTTYPE_COLUMN_TYPE + " TEXT);";

    public static final String CREATE_SUBJECTS_TABLE = "create table subjects ("+ContentDBAdapter.SUBJECTS_COLUMN_ID+" integer primary key AUTOINCREMENT, "
            +ContentDBAdapter.SUBJECTS_COLUMN_NAME + " TEXT);";

    public static final String CREATE_QUESTIONS_TABLE = "create table questions ("+QuestionsDBAdapter.QUESTIONS_COLUMN_QID+" integer primary key AUTOINCREMENT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_QUESTION + " TEXT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_OPTA +" TEXT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_OPTB +" TEXT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_OPTC +" TEXT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_OPTD +" TEXT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_ANSWER +" TEXT, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_SUBID +" INTEGER, "
            +QuestionsDBAdapter.QUESTIONS_COLUMN_TYPEID +" INTEGER, " +
            "FOREIGN KEY("+QuestionsDBAdapter.QUESTIONS_COLUMN_SUBID+") REFERENCES "+ContentDBAdapter.SUBJECTS_TABLE_NAME+"("+ContentDBAdapter.SUBJECTS_COLUMN_ID+"), "+
            "FOREIGN KEY("+QuestionsDBAdapter.QUESTIONS_COLUMN_TYPEID+") REFERENCES "+ContentDBAdapter.CONTENTTYPE_TABLE_NAME+"("+ContentDBAdapter.CONTENTTYPE_COLUMN_ID+"));";




    public static Context context;
    public static DatabaseHelper DBHelper;
    public static SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        context = ctx;
        DBHelper = new DatabaseHelper(context);
        open();
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_STUDENTS_TABLE);
            db.execSQL(CREATE_CONTENTTYPE_TABLE);
            db.execSQL(CREATE_GKLEARNING_TABLE);
            db.execSQL(CREATE_SUBJECTS_TABLE);
            db.execSQL(CREATE_QUESTIONS_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // Adding any table mods to this guy here
        }
    }

    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }
}
