package com.codewithme.resumecreator;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Saved_Resume extends AppCompatActivity {
    static ArrayList<String> arrayList;
    static String selected;
    SQLiteDatabase Db1;
    Spinner options;

    public void resumes(View view) {
        selected = this.options.getSelectedItem().toString();
        startActivity(new Intent(this, View_Resumes.class));
    }

    public void loadSpinner() {
        try {
            this.Db1 = openOrCreateDatabase("resumes", 0, (SQLiteDatabase.CursorFactory) null);
            this.Db1.execSQL("Create TABLE IF NOT EXISTS resumes (name VARCHAR ,gdate VARCHAR,marks INT(4),skills VARCHAR,extra VARCHAR)");
            Cursor s = this.Db1.rawQuery("SELECT * FROM resumes", (String[]) null);
            int nameindex = s.getColumnIndex("name");
            s.moveToFirst();
            Log.i("name", s.getString(nameindex));
            do {
                arrayList.add(s.getString(nameindex));
                Log.i("arraylist", arrayList.toString());
            } while (s.moveToNext());
            ArrayAdapter<String> wadapter = new ArrayAdapter<>(this, 17367048, arrayList);
            wadapter.setDropDownViewResource(17367049);
            this.options.setAdapter(wadapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0272R.layout.activity_saved__resume);
        arrayList = new ArrayList<>();
        this.options = (Spinner) findViewById(C0272R.C0274id.names);
        loadSpinner();
    }
}
