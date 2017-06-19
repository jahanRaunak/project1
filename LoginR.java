package com.example.pkg.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginR extends AppCompatActivity
{
    EditText et1,et2;
    TextInputLayout til1,til2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_r);

        et1 = (EditText)findViewById(R.id.login_r_companyname);
        et2 = (EditText)findViewById(R.id.login_r_password);

        til1 = (TextInputLayout)findViewById(R.id.til1);
        til2 = (TextInputLayout)findViewById(R.id.til2);
    }

    public void Loginc(View v)
    {
        String cname = et1.getText().toString().trim();
        String pass = et2.getText().toString().trim();

        if(cname.isEmpty())
        {
            til1.setError("Empty");
        }
        else
        {
            til1.setErrorEnabled(false);
            if(pass.isEmpty())
            {
              til2.setError("Empty");
            }
            else
            {
                til2.setErrorEnabled(false);

                CompanyDatabase cd = new CompanyDatabase(this);
                SQLiteDatabase db = cd.getWritableDatabase();

                String qry = "select * from company_details";

                Cursor c = db.rawQuery(qry,null);

                if(c.moveToFirst())
                {
                    String companyname = c.getString(0);
                    String password = c.getString(1);
                    if( (companyname.equals(cname)) && (password.equals(pass)) )
                    {
                        Intent i = new Intent(this,CompanyWelcome.class);
                        i.putExtra("k1",cname);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Not Registered", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void createAccount(View v)
    {
        Intent i = new Intent(this,Create_Company_Account.class);
        startActivity(i);
    }
}
