package com.example.bbuihw2.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class PersistentManager {
    Context context;
    SQLiteDatabase tSQLiteDatabase;

    public PersistentManager(Context c) {
        context = c;
        File dbFile = context.getDatabasePath("person.db");
        SQLiteDatabase.openOrCreateDatabase(dbFile, null);

        // Create (Person/Vehicle) tables if necessary
        tSQLiteDatabase.execSQL("");
    }

    public ArrayList<PersistentObject> retrieveObjects(Class cls) throws Exception {
        ArrayList<PersistentObject> objList = new ArrayList<PersistentObject>();
        String tblName = cls.getSimpleName();
        Cursor cursor = tSQLiteDatabase.query(tblName, null,null,null,null,null,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PersistentObject pObj = (PersistentObject) cls.newInstance();
                pObj.initFrom(cursor, tSQLiteDatabase);
                objList.add(pObj);
            }
        }
        return objList;
    }
}