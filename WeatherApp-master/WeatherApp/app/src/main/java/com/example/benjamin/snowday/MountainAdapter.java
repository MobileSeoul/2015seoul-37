package com.example.benjamin.snowday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 박정철 on 2015-09-14.
 */
public class MountainAdapter extends ArrayAdapter<Mountain>
{
    private int layout;
    private ArrayList<Mountain> mountainList;
    private LayoutInflater layoutInflater;

    public MountainAdapter(Context context, int textViewResourceId, ArrayList<Mountain> objects)
    {
        super(context, textViewResourceId, objects);
        this.layout = textViewResourceId;
        this.mountainList = objects;

        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.mountain_detail, null);
            convertView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 340));
        }

        Mountain mountain = mountainList.get(position);

        if(mountain != null)
        {

            ImageView detailImage = (ImageView)convertView.findViewById(R.id.mountain_detail_image);
            TextView detailName = (TextView)convertView.findViewById(R.id.mountain_detail_name);
            TextView detailAddress = (TextView)convertView.findViewById(R.id.mountain_detail_address);



            detailImage.setImageResource(mountain.getImage());

            detailName.setText(mountain.getName());
            detailAddress.setText(mountain.getAddress());

        }

        return convertView;
    }



}

