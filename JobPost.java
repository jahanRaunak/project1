package com.example.pkg.project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class JobPost extends AppCompatActivity
{
    Spinner spin1,spin2;
    EditText et1,et2,et3,et4;
    String cname;
    String graduations[] = {"B.E./B.Tech","MCA","B.Sc.","M.Sc.","M.E./M.Tech"};
    String KeySkills[] = {"Java Developer",".net Developer","php","oracle","networking"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_post);

        spin1 = (Spinner)findViewById(R.id.jp_spin1);
        spin2 = (Spinner)findViewById(R.id.jp_spin2);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,graduations);
        spin1.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,KeySkills);
        spin2.setAdapter(aa1);

        et1 = (EditText)findViewById(R.id.jp_exprnc);
        et2 = (EditText)findViewById(R.id.jp_intrvdate);
        et3 = (EditText)findViewById(R.id.jp_salary);
        et4 = (EditText)findViewById(R.id.jp_location);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        cname = b.getString("k1");
    }

    public void post(View v)
    {
        String exprnc = et1.getText().toString().trim();
        String intrvdate = et2.getText().toString().trim();
        String salary = et3.getText().toString().trim();
        String location = et4.getText().toString().trim();
        String eligibility = spin1.getSelectedItem().toString().trim();
        String position = spin2.getSelectedItem().toString().trim();

        if(exprnc.isEmpty())
        {
            et1.requestFocus();
            et1.setError("Empty");
        }
        else
        {
            if(intrvdate.isEmpty())
            {
                et2.requestFocus();
                et2.setError("Empty");
            }
            else
            {
                if(salary.isEmpty())
                {
                    et3.requestFocus();
                    et3.setError("Empty");
                }
                else
                {
                    if(location.isEmpty())
                    {
                        et4.requestFocus();
                        et4.setError("Empty");
                    }
                    else
                    {
                        double SALARY = Double.parseDouble(salary);
                        //save job details
                        CompanyDatabase2 cd2 = new CompanyDatabase2(this);
                        SQLiteDatabase db = cd2.getWritableDatabase();

                        String qry = "insert into jobpost_details values('"+cname+"','"+eligibility+"','"+exprnc+"','"+position+"','"+intrvdate+"',"+SALARY+",'"+location+"')";

                        db.execSQL(qry);

                        Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
