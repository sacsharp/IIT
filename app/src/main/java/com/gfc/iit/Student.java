package com.gfc.iit;

/**
 * Created by Sachin on 11/18/2015.
 */
public class Student {
    int _id;
    String _name;
    int _standard;
    int _phone;

    public Student() {}

    public Student(int id, String name, int standard, int phone)
    {
        this._id = id;
        this._name= name;
        this._standard= standard;
        this._phone= phone;
    }
    public Student(String name, int standard, int phone)
    {
        this._name= name;
        this._standard= standard;
        this._phone= phone;
    }

    public int get_id(){
        return this._id;
    }

    public void set_id(int id){
        this._id = id;
    }

    public String get_name(){
        return this._name;
    }

    public void set_name(String name){
        this._name = name;
    }

    public int get_standard()
    {
        return this._standard;
    }

    public void set_standard(int standard)
    {
        this._standard=standard;
    }

    public int get_phone(){
        return this._phone;
    }

    public void set_phone(int phone_number){
        this._phone = phone_number;
    }
}
