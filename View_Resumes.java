package com.codewithme.resumecreator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class View_Resumes extends AppCompatActivity {
    SQLiteDatabase Db1;
    TextView extra;
    TextView gdate;
    TextView marks;
    TextView name;
    TextView skills;

    public void loaddata() {
        try {
            this.Db1 = openOrCreateDatabase("resumes", 0, (SQLiteDatabase.CursorFactory) null);
            this.Db1.execSQL("Create TABLE IF NOT EXISTS resumes (name VARCHAR ,gdate VARCHAR,marks INT(4),skills VARCHAR,extra VARCHAR)");
            String name0 = Saved_Resume.selected;
            this.name.setText(name0);
            this.Db1.compileStatement("SELECT * FROM resumes WHERE name =?").bindString(1, name0);
            SQLiteDatabase sQLiteDatabase = this.Db1;
            Cursor c = sQLiteDatabase.rawQuery("SELECT * FROM resumes WHERE name ='" + name0 + "'", (String[]) null);
            int gdateindex = c.getColumnIndex("gdate");
            int marksindex = c.getColumnIndex("marks");
            int skillsindex = c.getColumnIndex("skills");
            int extraindex = c.getColumnIndex("extra");
            c.moveToFirst();
            do {
                this.gdate.setText(c.getString(gdateindex));
                this.marks.setText(Integer.toString(c.getInt(marksindex)));
                this.skills.setText(c.getString(skillsindex));
                this.extra.setText(c.getString(extraindex));
            } while (c.moveToNext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0272R.layout.activity_view__resumes);
        this.name = (TextView) findViewById(C0272R.C0274id.name);
        this.gdate = (TextView) findViewById(C0272R.C0274id.gdate);
        this.marks = (TextView) findViewById(C0272R.C0274id.marks);
        this.skills = (TextView) findViewById(C0272R.C0274id.skills);
        this.extra = (TextView) findViewById(C0272R.C0274id.extra);
        loaddata();
    }
}
