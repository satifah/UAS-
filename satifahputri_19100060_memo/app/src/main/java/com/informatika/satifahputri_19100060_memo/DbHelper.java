package com.informatika.satifahputri_19100060_memo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "republic";
    private static final int DB_VER = 1;
    private static final String DB_TABLE ="Task";
    private static final String DB_COLUMN = "TaskName";

    public  DbHelper (Context context){
        super(context, DB_NAME,null, DB_VER);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL);",DB_TABLE,DB_COLUMN);
      sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = String.format("DELETE TABLE IF EXISTS %s", DB_TABLE);
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }
    public void insertNewTask(String Task){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN, task);

        db.insertWithOnConflict(DB_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();

    }
    public void deleteTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, DB_COLUMN + "=?", new  String[]{task});
        db.close();
    }
    public ArrayList

}
