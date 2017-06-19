package com.example.pkg.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by pkg on 13-Jun-17.
 */

public class CompanyDatabase extends SQLiteOpenHelper
{
    Context c;
    public CompanyDatabase(Context c)
    {
        super(c,"company_data",null,1);
        this.c = c;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry = "create table company_details(companyname text,password text)";

        db.execSQL(qry);

        Toast.makeText(c, "Table Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
