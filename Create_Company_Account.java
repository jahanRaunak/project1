package com.example.pkg.project;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Create_Company_Account extends AppCompatActivity
{
    EditText et1,et2;
    TextInputLayout til1,til2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__company__account);

        et1 = (EditText)findViewById(R.id.companyname);
        et2 = (EditText)findViewById(R.id.company_password);

        til1 = (TextInputLayout)findViewById(R.id.til_createacount_companyname);
        til2 = (TextInputLayout)findViewById(R.id.til_createacount_companypassword);
    }

    public void CreateAccount(View v)
    {
        String companyname = et1.getText().toString().trim();
        String companypass = et2.getText().toString().trim();

        if(companyname.isEmpty())
        {
            til1.setError("Empty");
        }
        else
        {
            til1.setErrorEnabled(false);
            if(companypass.isEmpty())
            {
                til2.setError("Empty");
            }
            else
            {
                til2.setErrorEnabled(false);

                //create account
                CompanyDatabase cd = new CompanyDatabase(this);
                SQLiteDatabase db = cd.getWritableDatabase();

                String qry = "insert into company_details values('" +companyname+ "','" + companypass + "')";

                db.execSQL(qry);

                Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show();
                et1.setText("");
                et2.setText("");
                et1.requestFocus();
            }
        }
    }
}
