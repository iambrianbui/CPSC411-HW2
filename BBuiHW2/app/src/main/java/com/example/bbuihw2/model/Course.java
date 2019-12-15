/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Course extends PersistentObject{
    protected String courseID;
    protected String grade;
    protected String owner;

    public Course(){}

    public Course(String incCourseID, String incGrade, String incOwner){
        courseID = incCourseID;
        grade = incGrade;
        owner = incOwner;
    }

    public String getCourseId(){
        return courseID;
    }

    public void setCourseId(String incCourseID){
        this.courseID = incCourseID;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String incGrade){
        this.grade = incGrade;
    }

    @Override
    public void insert(SQLiteDatabase db){
        ContentValues vals = new ContentValues();
        vals.put("CourseID",courseID);
        vals.put("Grade",grade);
        vals.put("Owner", owner);
        db.insert("Course",null,vals);
    }
    @Override
    public void initFrom(Cursor c, SQLiteDatabase db){}
}