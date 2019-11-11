/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

import java.util.ArrayList;

public class Student{
    protected String firstName;
    protected String lastName;
    protected String cwid;
    protected ArrayList<Course> courses;

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

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void setCourses(ArrayList<Course> co){
        courses = co;
    }
}