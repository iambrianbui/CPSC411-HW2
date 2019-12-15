package com.example.bbuihw2.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class PersistentObject {
    public abstract void insert(SQLiteDatabase database);
    public abstract void initFrom(Cursor cursor, SQLiteDatabase database);
}
