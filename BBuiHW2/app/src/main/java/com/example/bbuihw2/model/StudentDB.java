/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

import java.util.ArrayList;

public class StudentDB{
    private static final StudentDB singleInstance = new StudentDB();

    private ArrayList<Student> studentList;

    static public StudentDB getInstance(){
        return singleInstance;
    }

    private StudentDB(){}

    public ArrayList<Student> getStudentList(){
        return studentList;
    }

    public void setStudentList(ArrayList<Student> sl){
        studentList = sl;
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }
}
