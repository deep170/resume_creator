package com.codewithme.resumecreator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public void create(View view) {
        startActivity(new Intent(this, Create_Resume.class));
    }

    public void saved(View view) {
        startActivity(new Intent(this, Saved_Resume.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0272R.layout.activity_main);
    }
}
