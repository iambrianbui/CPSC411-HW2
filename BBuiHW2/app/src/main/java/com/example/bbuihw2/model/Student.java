/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Student extends PersistentObject{
    protected String firstName;
    protected String lastName;
    protected String cwid;
    protected ArrayList<Course> courses;


    public Student(){}
    public Student(String fname, String lname, String cw, ArrayList<Course> co){
        firstName = fname;
        lastName = lname;
        cwid = cw;
        courses = co;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String fname){
        firstName = fname;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lname){
        lastName = lname;
    }

    public String getCWID(){
        return cwid;
    }

    public void setCWID(String cw){
        cwid = cw;
    }

    @Override
    public void insert(SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FirstName", firstName);
        contentValues.put("LastName", lastName);
        contentValues.put("CWID", cwid);
        db.insert("Student",null,contentValues);
        for (int i=0;i<courses.size();i++){
            courses.get(i).insert(db);
        }
    }

    @Override
    public void initFrom(Cursor c, SQLiteDatabase db){
        firstName = c.getString(c.getColumnIndex("FirstName"));
        lastName = c.getString(c.getColumnIndex("LastName"));
        cwid = c.getString(c.getColumnIndex("CWID"));
        courses = new ArrayList<Course>();
        Cursor cursor = db.query("COURSE",null,"Owner=?",new String[]{cwid},null,null,null);
        if (cursor.getCount()>0){
            while(cursor.moveToNext()){
                Course cObj = new Course();
                cObj.initFrom(cursor, db);
                courses.add(cObj);
            }
        }
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void setCourses(ArrayList<Course> co){
        courses = co;
    }
}