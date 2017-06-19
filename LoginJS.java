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

public class LoginJS extends AppCompatActivity
{
    EditText et1,et2;
    TextInputLayout til1,til2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_js);

        et1 = (EditText)findViewById(R.id.login_username);
        et2 = (EditText)findViewById(R.id.login_password);

        til2 = (TextInputLayout)findViewById(R.id.til_password);
        til1 = (TextInputLayout)findViewById(R.id.til_username);
    }

    //login
    public void Login(View v)
    {
        String uname = et1.getText().toString().trim();
        String pass = et2.getText().toString().trim();

        if(uname.isEmpty())
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
                //check for user validation nd open new activity
                JobDatabase jd = new JobDatabase(this);
                SQLiteDatabase db = jd.getWritableDatabase();

                String qry = "select * from job_details";
                Cursor c = db.rawQuery(qry,null);

                if(c.moveToFirst())
                {
                    String username = c.getString(0);
                    String password = c.getString(1);

                    if( (username.equals(uname)) && (password.equals(pass)) )
                    {
                        //open company lists
                        Intent i = new Intent(this,CompanyList.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Not Reistered", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //create new user
    public void NewUser(View v)
    {
        startActivity(new Intent(this,ApplyWelcome1.class));
    }
}
