package com.example.pkg.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CompanyList extends AppCompatActivity
{
    int i = 0;
    String cname[] = new String[50];
    String experience[] = new String[50];
    String eligibility[] = new String[50];
    String position[] = new String[50];
    String location[] = new String[50];
    double salary[] = new double[50];
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        lv = (ListView)findViewById(R.id.lv);

        CompanyDatabase2 cd2 = new CompanyDatabase2(this);
        SQLiteDatabase db = cd2.getWritableDatabase();

        String qry = "select * from jobpost_details";

        Cursor c = db.rawQuery(qry,null);

        if(c.moveToFirst())
        {
            do
            {
                cname[i] = c.getString(0);
                eligibility[i] = c.getString(1);
                experience[i] = c.getString(2);
                position[i] = c.getString(3);
                salary[i] = c.getDouble(5);
                location[i] = c.getString(6);
                i++;
            }while(c.moveToNext());

            MyAdapter my = new MyAdapter(this,cname,eligibility,experience,position,salary,location,i,R.layout.list_view_style);
            lv.setAdapter(my);
        }
        else
        {
            Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
        }

    }
}
