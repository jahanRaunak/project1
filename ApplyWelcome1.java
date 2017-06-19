package com.example.pkg.project;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ApplyWelcome1 extends AppCompatActivity
{
    EditText et1,et2,et3,et4;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_welcome1);

        et1 = (EditText)findViewById(R.id.aw1_name);
        et2 = (EditText)findViewById(R.id.aw1_password);
        et3 = (EditText)findViewById(R.id.aw1_email);
        et4 = (EditText)findViewById(R.id.aw1_contact);

        rg = (RadioGroup)findViewById(R.id.rg);
    }

    public void Next(View v)
    {
        String name = et1.getText().toString().trim();
        String password = et2.getText().toString().trim();
        String email = et3.getText().toString().trim();
        String contact = et4.getText().toString().trim();
        int id = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(id);
        String sex = rb.getText().toString().trim();

        if(name.isEmpty())
        {
            et1.requestFocus();
            et1.setError("Empty");
        }
        else
        {
            if(password.isEmpty())
            {
                et2.requestFocus();
                et2.setError("Empty");
            }
            else
            {
                if(email.isEmpty())
                {
                    et3.requestFocus();
                    et3.setError("Empty");
                }
                else
                {
                    if(contact.isEmpty())
                    {
                        et4.requestFocus();
                        et4.setError("Empty");
                    }
                    else
                    {
                        //open another activity to enter details
                        Intent i = new Intent(this,ApplyWelcome2.class);
                        i.putExtra("k1",name);
                        i.putExtra("k2",password);
                        i.putExtra("k3",email);
                        i.putExtra("k4",contact);
                        i.putExtra("k5",sex);
                        startActivity(i);
                    }
                }
            }
        }
    }
}
