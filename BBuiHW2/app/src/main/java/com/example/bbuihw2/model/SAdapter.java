/*
Brian Bui
CPSC411 HW2
Due 11/11/2019

 */

package com.example.bbuihw2.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bbuihw2.R;

import java.util.ArrayList;

public class SAdapter extends BaseAdapter{
    ArrayList<Student> studentList;
    StudentDB studentDB = StudentDB.getInstance();

    public SAdapter(){
        studentList = studentDB.retrieveStudentObjects();
    }

    @Override
    public int getCount() {
        return studentDB.getStudentList().size();
    }

    @Override
    public Object getItem(int i) {
        return studentDB.getStudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        } else row_view = view;
        Student s = studentDB.getStudentList().get(i);

        ((TextView) row_view.findViewById(R.id.firstname)).setText(s.getFirstName());
        ((TextView) row_view.findViewById(R.id.lastname)).setText(s.getLastName());
        return row_view;
    }
}