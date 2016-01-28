package com.gfc.iit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sachin on 11/19/2015.
 */
public class ContentDBAdapter extends DBAdapter{


    public static final String GKLEARNING_TABLE_NAME  = "gklearning";
    public static final String GKLEARNING_COLUMN_ID = "cid";
    public static final String GKLEARNING_COLUMN_CONTENT = "name";
    public static final String GKLEARNING_COLUMN_TYPE = "typeid";

    public static final String CONTENTTYPE_TABLE_NAME = "contenttype";
    public static final String CONTENTTYPE_COLUMN_ID = "typeid";
    public static final String CONTENTTYPE_COLUMN_TYPE="typename";

    public static final String SUBJECTS_TABLE_NAME = "subjects";
    public static final String SUBJECTS_COLUMN_ID="subid";
    public static final String SUBJECTS_COLUMN_NAME="subjectname";


    public ContentDBAdapter(Context context){
        super(context);
    }

    public boolean insertType(Integer typeid,String typename){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTENTTYPE_COLUMN_ID,typeid);
        contentValues.put(CONTENTTYPE_COLUMN_TYPE,typename);

        db.insert(CONTENTTYPE_TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }
    public boolean insertStatement(String statement,Integer typeid){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GKLEARNING_COLUMN_CONTENT,statement);
        contentValues.put(GKLEARNING_COLUMN_TYPE,typeid);
        db.insert(GKLEARNING_TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }


    public ArrayList getAllStatements ()
    {
        ArrayList list = new ArrayList();
        Cursor cursor = db.rawQuery("SELECT "+GKLEARNING_COLUMN_CONTENT+" from "+GKLEARNING_TABLE_NAME,null);

        if(cursor != null)
        {
            if(cursor.moveToFirst())
                do {
                    list.add(cursor.getString(0));
                }while(cursor.moveToNext());
        }
        return list;
    }

}
