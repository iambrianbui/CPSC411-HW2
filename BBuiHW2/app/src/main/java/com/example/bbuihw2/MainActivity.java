/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */


package com.example.bbuihw2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bbuihw2.model.Course;
import com.example.bbuihw2.model.SAdapter;
import com.example.bbuihw2.model.Student;
import com.example.bbuihw2.model.StudentDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    protected ListView mSummaryView;
    protected Menu addMenu;
    protected SAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list_view);

        mSummaryView = findViewById(R.id.summary_list_id);
        adapter = new SAdapter();
        mSummaryView.setAdapter(adapter);
    }

    @Override
    protected void onStart(){
        adapter.notifyDataSetChanged();
        super.onStart();
    }

    //  handling of the options menus on the top right
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.findItem(R.id.action_add).setVisible(true);
        addMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.action_add){
            Intent intent = new Intent(this,AddActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //  some test objects
    /*
    protected void createStudentObjects(){
        ArrayList<Student> students = new ArrayList<Student>();

        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411","A+"));
        courses.add(new Course("KNES360", "B+"));
        Student student = new Student("Brian","Bui","111111111",courses);
        students.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411","C"));
        courses.add(new Course("CPSC240","F"));
        student = new Student("Henry","Tran","222222222",courses);
        students.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("KNES202","A"));
        courses.add(new Course("ENGL101C","A-"));
        student = new Student("James","Shen","333333333",courses);
        students.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("KNES202","A"));
        courses.add(new Course("ENGL101C","A-"));
        student = new Student("John","Chang","444444444",courses);
        students.add(student);

        StudentDB.getInstance().setStudentList(students);
    }

     */
}