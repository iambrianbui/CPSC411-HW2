/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */


package com.example.bbuihw2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bbuihw2.model.Course;
import com.example.bbuihw2.model.Student;
import com.example.bbuihw2.model.StudentDB;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    protected Menu addMenu;
    ArrayList<Course> courses = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        final GridLayout root = findViewById(R.id.course_grid);
        root.setBackgroundResource(R.drawable.border);

        //  adding new courses
        Button addButton = findViewById(R.id.add_course);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText courseID = new EditText(view.getContext());
                courseID.setSingleLine();
                courseID.setTextSize(14);
                root.addView(courseID);

                EditText courseGrade = new EditText(view.getContext());
                courseGrade.setSingleLine();
                courseGrade.setTextSize(14);
                root.addView(courseGrade);
                courses.add(new Course(courseID.getText().toString(), courseGrade.getText().toString()));
            }
        });
    }

    //  handling of the options menus on the top right
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_menu,menu);
        menu.findItem(R.id.action_done).setVisible(true);
        addMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.action_done){
            TextView fn = findViewById(R.id.add_firstname);
            TextView ln = findViewById(R.id.add_lastname);
            TextView ci = findViewById(R.id.add_cwid);

            String firstname = fn.getText().toString();
            String lastname = ln.getText().toString();
            String cwid = ci.getText().toString();

            if(cwid != "" && firstname != "" && lastname != ""){
                Student student = new Student(firstname,lastname,cwid,courses);
                StudentDB.getInstance().addStudent(student);
            }
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}