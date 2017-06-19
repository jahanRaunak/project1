package com.example.pkg.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InviteJob extends AppCompatActivity
{
    TextView tv2,tv4,tv6,tv8,tv10;
    String email,name,cname;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_job);

        tv2 = (TextView)findViewById(R.id.ij_tv2);
        tv4 = (TextView)findViewById(R.id.ij_tv4);
        tv6 = (TextView)findViewById(R.id.ij_tv6);
        tv8 = (TextView)findViewById(R.id.ij_tv8);
        tv10 = (TextView)findViewById(R.id.ij_tv10);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        name = b.getString("k1");
        String experience = b.getString("k2");
        long cno = b.getLong("k3");
        String skill = b.getString("k4");
        String graduaiton = b.getString("k5");
        email = b.getString("k6");
        cname = b.getString("k7");

        tv2.setText(name);
        tv4.setText(experience);
        tv6.setText(cno+"");
        tv8.setText(skill);
        tv10.setText(graduaiton);
    }

    public void invite(View v)
    {
        Toast.makeText(this, "Invitaion Sent", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("text/plain");
        i.setData(Uri.parse(email));
        i.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
        i.putExtra(Intent.EXTRA_EMAIL,email);
        i.putExtra(Intent.EXTRA_SUBJECT,"Job Invitation");
        i.putExtra(Intent.EXTRA_TEXT,"Hello "+name+",\nYou are Invited for job from "+cname);
        startActivity(i);
    }
}
