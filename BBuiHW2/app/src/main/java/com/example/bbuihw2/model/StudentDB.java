/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class StudentDB{
    private static final StudentDB singleInstance = new StudentDB();
    private SQLiteDatabase tSQLiteDatabase;
    private ArrayList<Student> studentList;

    static public StudentDB getInstance(){
        return singleInstance;
    }

    public StudentDB(){
        File dbFile = AppContext.getAppContext().getDatabasePath("student.db");
        tSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(dbFile,null);
        createSQLTables();
        Cursor cursor = tSQLiteDatabase.query("STUDENT", null, null, null, null, null, null, null);
        if (cursor.getCount() < 1){
            this.createStudentObjects();
        }
    }

    public ArrayList<Student> retrieveStudentObjects(){
        ArrayList<Student> studentList = new ArrayList<>();
        Cursor cursor = tSQLiteDatabase.query("STUDENT", null, null, null, null, null,null );
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Student sObj = new Student();
                sObj.initFrom(cursor, tSQLiteDatabase);
                studentList.add(sObj);
            }
        }

        studentList = studentList;
        return studentList;
    }

    public void createStudentObjects(){
        studentList = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411","A+","111111111"));
        courses.add(new Course("KNES360", "B+","111111111"));
        Student student = new Student("Brian","Bui","111111111",courses);
        student.insert(tSQLiteDatabase);
        studentList.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411","C","222222222"));
        courses.add(new Course("KNES240", "F","222222222"));
        student = new Student("Henry","Tran","222222222",courses);
        student.insert(tSQLiteDatabase);
        studentList.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("KNES202","A","333333333"));
        courses.add(new Course("ENGL101C", "A-","333333333"));
        student = new Student("Henry","Tran","333333333",courses);
        student.insert(tSQLiteDatabase);
        studentList.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("KNES202","A","444444444"));
        courses.add(new Course("ENGL101C", "A-","444444444"));
        student = new Student("Gary","Nguyen","444444444",courses);
        student.insert(tSQLiteDatabase);
        studentList.add(student);
    }

    public void createSQLTables(){
        String sql = "CREATE TABLE IF NOT EXISTS STUDENT (FirstName Text, LastName Text, CWID Text)";
        tSQLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS COURSE (CourseID Text, Grade Text, Owner Text)";
        tSQLiteDatabase.execSQL(sql);
    }

    public ArrayList<Student> getStudentList(){
        return studentList;
    }

    public void setStudentList(ArrayList<Student> sl){
        studentList = sl;
    }

    public void addStudent(Student s) {
        studentList.add(s);
        s.insert(tSQLiteDatabase);
    }
}
