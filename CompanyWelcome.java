package com.example.pkg.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CompanyWelcome extends AppCompatActivity
{
    TextView tv;
    String cname;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_welcome);

        tv = (TextView)findViewById(R.id.cw_tv);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        cname = b.getString("k1");

        tv.setText(cname);
    }

    public void jobPost(View v)
    {
        Intent i = new Intent(this,JobPost.class);
        i.putExtra("k1",cname);
        startActivity(i);
    }

    public void resume(View v)
    {
        Intent i = new Intent(this,ResumeList.class);
        i.putExtra("k1",cname);
        startActivity(i);
    }

    public void exitnow(View v)
    {
        finish();
    }
}
