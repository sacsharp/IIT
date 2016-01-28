package com.gfc.iit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sachin on 11/20/2015.
 */
public class QuestionsDBAdapter extends DBAdapter {



    public static final String QUESTIONS_TABLE_NAME="questions";
    public static final String QUESTIONS_COLUMN_QID="qid";
    public static final String QUESTIONS_COLUMN_QUESTION="question";
    public static final String QUESTIONS_COLUMN_OPTA="opta";
    public static final String QUESTIONS_COLUMN_OPTB="optb";
    public static final String QUESTIONS_COLUMN_OPTC="optc";
    public static final String QUESTIONS_COLUMN_OPTD="optd";
    public static final String QUESTIONS_COLUMN_ANSWER="answer";
    public static final String QUESTIONS_COLUMN_SUBID="subid";
    public static final String QUESTIONS_COLUMN_TYPEID="tid";

    public QuestionsDBAdapter(Context cxt)
    {
        super(cxt);
    }


    public boolean addQuestion(Question question)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUESTIONS_COLUMN_QUESTION,question.get_question());
        contentValues.put(QUESTIONS_COLUMN_OPTA,question.get_optA());
        contentValues.put(QUESTIONS_COLUMN_OPTB,question.get_optB());
        contentValues.put(QUESTIONS_COLUMN_OPTC,question.get_optC());
        contentValues.put(QUESTIONS_COLUMN_OPTD,question.get_optD());
        contentValues.put(QUESTIONS_COLUMN_ANSWER,question.get_answer());
        contentValues.put(QUESTIONS_COLUMN_SUBID,question.get_subID());
        contentValues.put(QUESTIONS_COLUMN_TYPEID, question.get_typeid());

        if(db.insert(QUESTIONS_TABLE_NAME,null,contentValues)>0)
            return true;
        else return false;
    }

    public List<Question> getAllQuestions()
    {
        List<Question> questionList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * from "+QUESTIONS_TABLE_NAME,null);

        if(cursor!=null)
        {
            if(cursor.moveToFirst())
            do {
                Question question= new Question();
                question.set_qid(cursor.getInt(0));
                question.set_question(cursor.getString(1));
                question.set_optA(cursor.getString(2));
                question.set_optB(cursor.getString(3));
                question.set_optC(cursor.getString(4));
                question.set_optD(cursor.getString(5));
                question.set_answer(cursor.getString(6));
                question.set_subID(cursor.getInt(7));
                question.set_typeid(cursor.getInt(8));
                questionList.add(question);
            }while (cursor.moveToNext());
        }
        return questionList;
    }

    public List<Question> getQuestions(int startid, int endid){
        List<Question> questionList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * from "+QUESTIONS_TABLE_NAME+" where qid >="+startid+" and qid <="+endid,null);

        if(cursor!=null)
        {
            if(cursor.moveToFirst())
                do {
                    Question question= new Question();
                    question.set_qid(cursor.getInt(0));
                    question.set_question(cursor.getString(1));
                    question.set_optA(cursor.getString(2));
                    question.set_optB(cursor.getString(3));
                    question.set_optC(cursor.getString(4));
                    question.set_optD(cursor.getString(5));
                    question.set_answer(cursor.getString(6));
                    question.set_subID(cursor.getInt(7));
                    question.set_typeid(cursor.getInt(8));
                    questionList.add(question);
                }while (cursor.moveToNext());
        }
        return questionList;
    }

    public int getTotalCount()
    {
        int count;
        Cursor cursor = db.rawQuery("SELECT * FROM "+QUESTIONS_TABLE_NAME,null);
        count= cursor.getCount();
        return count;
    }

}
