/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

public class Course{
    protected String courseID;
    protected String grade;

    public Course(String incCourseID, String incGrade){
        courseID = incCourseID;
        grade = incGrade;
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
}