package com.example.pkg.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class ResumeList extends AppCompatActivity
{
    ListView lv;
    String cname;
    String names[] = new String[50];
    String email[] = new String[50];
    String graduation[] = new String[50];
    String experience[] = new String[50];
    long cno[] = new long[50];
    String skills[] = new String[50];
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_list);

        lv = (ListView)findViewById(R.id.lv2);

        Intent i1 = getIntent();
        Bundle b = i1.getExtras();
        cname = b.getString("k1");

        JobDatabase jd = new JobDatabase(this);
        SQLiteDatabase db = jd.getWritableDatabase();

        String qry = "select * from job_details";

        Cursor c = db.rawQuery(qry,null);

        if(c.moveToFirst())
        {
            do
            {
                names[i] = c.getString(0);
                email[i] = c.getString(2);
                cno[i] = c.getLong(3);
                graduation[i] = c.getString(5);
                experience[i] = c.getString(6);
                skills[i] = c.getString(7);
                i++;
            }while (c.moveToNext());

            MyAdapter2 md2 = new MyAdapter2(this,cname,names,email,cno,graduation,skills,experience,i,R.layout.list_view_style1);
            lv.setAdapter(md2);
        }
        else
        {
            Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
        }
    }
}
