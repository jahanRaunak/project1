package com.example.pkg.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ApplyJob extends AppCompatActivity
{
    TextView tv2,tv4,tv6,tv8,tv10,tv12;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);

        tv2 = (TextView)findViewById(R.id.aj_tv2);
        tv4 = (TextView)findViewById(R.id.aj_tv4);
        tv6 = (TextView)findViewById(R.id.aj_tv6);
        tv8 = (TextView)findViewById(R.id.aj_tv8);
        tv10 = (TextView)findViewById(R.id.aj_tv10);
        tv12 = (TextView)findViewById(R.id.aj_tv12);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String cname = b.getString("k1");
        String eligibility = b.getString("k2");
        String experience = b.getString("k3");
        String position = b.getString("k4");
        double salary = b.getDouble("k5");
        String location = b.getString("k6");

        tv2.setText(cname);
        tv4.setText(eligibility);
        tv6.setText(experience);
        tv8.setText(position);
        tv10.setText(salary+"");
        tv12.setText(location);
    }

    public void apply(View v)
    {
        Toast.makeText(this, "Applied", Toast.LENGTH_SHORT).show();
    }
}
