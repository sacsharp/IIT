package com.gfc.iit;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sachin on 11/20/2015.
 */
public class Question implements Parcelable {

    private Integer _qid;
    private String _question;
    private String _optA;
    private String _optB;
    private String _optC;
    private String _optD;
    private String _answer;
    private Integer _subID;
    private Integer _typeid;

    public Question(){}

    private Question(Parcel in) {
        _qid = in.readInt();
        _question = in.readString();
        _optA=in.readString();
        _optB=in.readString();
        _optC=in.readString();
        _optD=in.readString();
        _answer=in.readString();
        _subID=in.readInt();
        _typeid=in.readInt();
    }

    public static final Parcelable.Creator<Question> CREATOR =
            new Parcelable.Creator<Question>() {

                @Override
                public Question createFromParcel(Parcel source) {
                    return new Question(source);
                }

                @Override
                public Question[] newArray(int size) {
                    return new Question[size];
                }

            };

    public Question(Integer qid, String question, String optA, String optB , String optC, String optD, String answer,Integer subid, Integer typeid)
    {
     this._qid=qid;
        this._question=question;
        this._optA=optA;
        this._optB=optB;
        this._optC=optC;
        this._optD=optD;
        this._answer=answer;
        this._subID=subid;
        this._typeid=typeid;
    }

    public Question(String question, String optA, String optB , String optC, String optD, String answer,Integer subid, Integer typeid)
    {
        this._question=question;
        this._optA=optA;
        this._optB=optB;
        this._optC=optC;
        this._optD=optD;
        this._answer=answer;
        this._subID=subid;
        this._typeid=typeid;
    }



    public Integer get_qid() {
        return _qid;
    }

    public void set_qid(Integer _qid) {
        this._qid = _qid;
    }

    public String get_question() {
        return _question;
    }

    public void set_question(String _question) {
        this._question = _question;
    }

    public String get_optA() {
        return _optA;
    }

    public void set_optA(String _optA) {
        this._optA = _optA;
    }

    public String get_optB() {
        return _optB;
    }

    public void set_optB(String _optB) {
        this._optB = _optB;
    }

    public String get_optC() {
        return _optC;
    }

    public void set_optC(String _optC) {
        this._optC = _optC;
    }

    public String get_optD() {
        return _optD;
    }

    public void set_optD(String _optD) {
        this._optD = _optD;
    }


    public Integer get_subID() {
        return _subID;
    }

    public void set_subID(Integer _subID) {
        this._subID = _subID;
    }

    public Integer get_typeid() {
        return _typeid;
    }

    public void set_typeid(Integer _typeid) {
        this._typeid = _typeid;
    }

    public String get_answer() {
        return _answer;
    }

    public void set_answer(String _answer) {
        this._answer = _answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_qid);
        dest.writeString(_question);
        dest.writeString(_optA);
        dest.writeString(_optB);
        dest.writeString(_optC);
        dest.writeString(_optD);
        dest.writeString(_answer);
        dest.writeInt(_subID);
        dest.writeInt(_typeid);
    }

}
