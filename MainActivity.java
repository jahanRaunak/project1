package com.example.pkg.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void JobSeeker(View v)
    {
        Intent i = new Intent(this,LoginJS.class);
        startActivity(i);
    }

    public void Recruiter(View v)
    {
        Intent i = new Intent(this,LoginR.class);
        startActivity(i);
    }

    public void exit(View v)
    {
        finish();
    }
}
