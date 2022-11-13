package com.codewithme.resumecreator;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Create_Resume extends AppCompatActivity {
    private static final int SELECT_PICTURE = 0;
    static SQLiteDatabase mydatabase;
    EditText extra1;
    EditText gdate1;
    EditText marks1;
    EditText name1;
    EditText skills1;

    public void selectImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);
    }

    public boolean insertData(String name, String gdate, String marks, String skills, String extra) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("gdate", gdate);
        contentValues.put("marks", marks);
        contentValues.put("skills", skills);
        contentValues.put("extra", extra);
        if (mydatabase.insert("resumes", (String) null, contentValues) == -1) {
            return false;
        }
        return true;
    }

    public void insertData2(String name, String birth, String area, String receiver, String extra) {
        if (!insertData(name, birth, area, receiver, extra)) {
            Toast.makeText(this, "Something went wrong><", 1).show();
        } else {
            Toast.makeText(this, "SuccessFully Saved your Resume!", 1).show();
        }
    }

    public void create(View view) {
        if (this.name1.getText().toString().equals(BuildConfig.FLAVOR) || this.gdate1.getText().toString().equals(BuildConfig.FLAVOR) || this.marks1.getText().toString().equals(BuildConfig.FLAVOR) || this.extra1.getText().toString().equals(BuildConfig.FLAVOR)) {
            Toast.makeText(this, "PLEASE FILL ALL THE FIELDS", 0).show();
            return;
        }
        try {
            String name0 = this.name1.getText().toString();
            String date0 = this.gdate1.getText().toString();
            String marks0 = this.marks1.getText().toString();
            String skills0 = this.skills1.getText().toString();
            String extra0 = this.extra1.getText().toString();
            mydatabase = openOrCreateDatabase("resumes", 0, (SQLiteDatabase.CursorFactory) null);
            mydatabase.execSQL("Create TABLE IF NOT EXISTS resumes (name VARCHAR ,gdate VARCHAR,marks INT(4),skills VARCHAR,extra VARCHAR)");
            insertData2(name0, date0, marks0, skills0, extra0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.name1.setText(BuildConfig.FLAVOR);
        this.gdate1.setText(BuildConfig.FLAVOR);
        this.marks1.setText(BuildConfig.FLAVOR);
        this.skills1.setText(BuildConfig.FLAVOR);
        this.extra1.setText(BuildConfig.FLAVOR);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0272R.layout.activity_create__resume);
        this.name1 = (EditText) findViewById(C0272R.C0274id.name);
        this.gdate1 = (EditText) findViewById(C0272R.C0274id.date);
        this.marks1 = (EditText) findViewById(C0272R.C0274id.marks);
        this.skills1 = (EditText) findViewById(C0272R.C0274id.skills);
        this.extra1 = (EditText) findViewById(C0272R.C0274id.extra);
    }
}
