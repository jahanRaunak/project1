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

public class MyAdapter extends BaseAdapter
{
    Context c;
    String cname[];
    String eligibility[];
    String experience[];
    String positions[];
    String location[];
    double salary[];
    int i,layout;

    public MyAdapter(Context c, String[] cname, String[] eligibility, String[] experience, String[] position, double[] salary, String[] location, int i, int list_view_style)
    {
        this.c = c;
        this.cname = cname;
        this.eligibility = eligibility;
        this.experience = experience;
        positions = position;
        this.salary = salary;
        this.location = location;
        this.i = i;
        layout = list_view_style;
    }

    @Override
    public int getCount() {
        return i;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater li = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v1 = li.inflate(layout,parent,false);

        TextView tv1 = (TextView)v1.findViewById(R.id.tv1);
        tv1.setText(cname[position]);

        TextView tv2 = (TextView)v1.findViewById(R.id.tv2);
        tv2.setText(positions[position]);

        TextView tv3 = (TextView)v1.findViewById(R.id.tv3);
        tv3.setText(location[position]);

        Button b = (Button)v1.findViewById(R.id.view);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(c,ApplyJob.class);
                i.putExtra("k1",cname[position]);
                i.putExtra("k2",eligibility[position]);
                i.putExtra("k3",experience[position]);
                i.putExtra("k4",positions[position]);
                i.putExtra("k5",salary[position]);
                i.putExtra("k6",location[position]);
                c.startActivity(i);
            }
        });

        return v1;
    }
}
