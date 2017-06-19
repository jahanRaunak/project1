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

public class ApplyWelcome2 extends AppCompatActivity
{
    String graduations[] = {"B.E./B.Tech","MCA","B.Sc.","M.Sc.","M.E./M.Tech"};
    String KeySkills[] = {"Java Developer",".net Developer","php","oracle","networking"};
    EditText et1,et2;
    Spinner spin1,spin2;
    String name,password,email,contact,sex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_welcome2);

        et1 = (EditText)findViewById(R.id.aw2_experience);
        et2 = (EditText)findViewById(R.id.aw2_companyname);

        spin1 = (Spinner)findViewById(R.id.aw2_spin1);
        spin2 = (Spinner)findViewById(R.id.aw2_spin2);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,graduations);
        spin1.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,KeySkills);
        spin2.setAdapter(aa1);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        name = b.getString("k1");
        password = b.getString("k2");
        email = b.getString("k3");
        contact = b.getString("k4");
        sex = b.getString("k5");
    }

    public void Submit(View v)
    {
        String graduation = spin1.getSelectedItem().toString().trim();
        String experience = et1.getText().toString().trim();
        String keyskills = spin2.getSelectedItem().toString().trim();
        String companyname = et2.getText().toString().trim();

        long CONTACT = Long.parseLong(contact);
        //save into JobDatabase
        JobDatabase jd = new JobDatabase(this);
        SQLiteDatabase db = jd.getWritableDatabase();

        String qry = "insert into job_details values('"+name+"','"+password+"','"+email+"',"+CONTACT+",'"+sex+"','"+graduation+"','"+experience+"','"+keyskills+"','"+companyname+"')";
        db.execSQL(qry);

        Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show();

        finish();
        startActivity(new Intent(this,LoginJS.class));
    }
}
