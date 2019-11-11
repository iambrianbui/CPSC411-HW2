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

public class SAdapter extends BaseAdapter{
    @Override
    public int getCount(){
        return StudentDB.getInstance().getStudentList().size();
    }

    @Override
    public Object getItem(int i){
        return StudentDB.getInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup vG){
        View row;

        if (v == null){
            LayoutInflater inflater = LayoutInflater.from(vG.getContext());
            row = inflater.inflate(R.layout.student_row, vG, false);
        } else row = v;

        Student s = StudentDB.getInstance().getStudentList().get(i);

        ((TextView) row.findViewById(R.id.firstname)).setText(s.getFirstName());
        ((TextView) row.findViewById(R.id.lastname)).setText(s.getLastName());
        return row;
    }
}