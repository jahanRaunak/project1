package com.example.pkg.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pkg on 13-Jun-17.
 */

public class CompanyDatabase2 extends SQLiteOpenHelper
{
    Context c;

    public CompanyDatabase2(Context c)
    {
        super(c,"company_data1",null,1);
        this.c = c;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry = "create table jobpost_details(companyname text,eligibility text,experience text,position text,interviewdate text,salary real,location text)";

        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
