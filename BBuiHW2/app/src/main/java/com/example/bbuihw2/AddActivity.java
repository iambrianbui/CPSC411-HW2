/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */


package com.example.bbuihw2;

import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;

import com.example.bbuihw2.model.Course;
import com.example.bbuihw2.model.Student;
import com.example.bbuihw2.model.StudentDB;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    protected Menu addMenu;
    ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        final GridLayout root = findViewById(R.id.course_grid);
        root.setBackgroundResource(R.drawable.border);

        final EditText courseID = new EditText(this);
        courseID.setSingleLine();
        courseID.setText("");
        courseID.setTextSize(14);
        root.addView(courseID);

        final EditText courseGrade = new EditText(this);
        courseGrade.setSingleLine();
        courseGrade.setText("");
        courseGrade.setTextSize(14);
        root.addView(courseGrade);

        //  adding new courses
        Button addButton = findViewById(R.id.add_course);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String tCourse = courseID.getText().toString();
                String tGrade = courseGrade.getText().toString();
                TextView c = findViewById(R.id.add_cwid);
                String cwid = c.getText().toString();
                if (!tCourse.equals("") && !tGrade.equals("") && !cwid.equals("")){
                    TextView id = new TextView(view.getContext());
                    id.setText(courseID.getText().toString());
                    id.setTextSize(14);
                    id.setSingleLine();
                    root.addView(id);

                    TextView grade = new TextView(view.getContext());
                    grade.setText(courseGrade.getText().toString());
                    grade.setTextSize(14);
                    grade.setSingleLine();
                    root.addView(grade);

                    courses.add(new Course(courseID.getText().toString(), courseGrade.getText().toString(), cwid));
                    courseID.setText("");
                    courseGrade.setText("");
                }
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

            if(!cwid.equals("") && !fn.equals("") && !ln.equals("") && !courses.isEmpty()){
                Student student = new Student(firstname,lastname,cwid,courses);
                StudentDB.getInstance().addStudent(student);
                finish();
            }
            else{
                final AlertDialog.Builder dAlert = new AlertDialog.Builder(this);
                dAlert.setMessage("Not all fields inputted!");
                dAlert.setTitle("Error");
                dAlert.setPositiveButton("OK", null);
                dAlert.create().show();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}