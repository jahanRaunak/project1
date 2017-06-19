package com.example.pkg.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by pkg on 13-Jun-17.
 */

public class JobDatabase extends SQLiteOpenHelper
{
    Context c;
    public JobDatabase(Context context)
    {
        super(context,"job_data",null,1);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry = "create table job_details(name text,pass text,email text,cno integer,sex text,graduation text,experience text,keyskills text,companyname text)";

        db.execSQL(qry);

        Toast.makeText(c, "Table Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
