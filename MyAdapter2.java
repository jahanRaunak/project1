package com.example.pkg.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pkg on 14-Jun-17.
 */

public class MyAdapter2 extends BaseAdapter
{
    String cname;
    Context c;
    String names[];
    String email[];
    String graduation[];
    String skills[];
    String experience[];
    long cno[];
    int i,layout1;

    public MyAdapter2(Context c,String cname, String[] names, String[] email, long[] cno, String[] graduation, String[] skills, String[] experience, int i, int list_view_style1)
    {
        this.c = c;
        this.cname = cname;
        this.names = names;
        this.email = email;
        this.cno = cno;
        this.graduation = graduation;
        this.skills = skills;
        this.experience = experience;
        this.i = i;
        layout1 = list_view_style1;
    }

    @Override
    public int getCount() {
        return i;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater li = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v2 = li.inflate(layout1,parent,false);

        TextView tv4 = (TextView)v2.findViewById(R.id.tv4);
        tv4.setText(names[position]);

        TextView tv5 = (TextView)v2.findViewById(R.id.tv5);
        tv5.setText(email[position]);

        TextView tv6 = (TextView)v2.findViewById(R.id.tv6);
        tv6.setText(graduation[position]);

        Button b1 = (Button)v2.findViewById(R.id.view1);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(c,InviteJob.class);
                i.putExtra("k1",names[position]);
                i.putExtra("k2",experience[position]);
                i.putExtra("k3",cno[position]);
                i.putExtra("k4",skills[position]);
                i.putExtra("k5",graduation[position]);
                i.putExtra("k6",email[position]);
                i.putExtra("k7",cname);
                c.startActivity(i);
            }
        });

        return v2;
    }
}
