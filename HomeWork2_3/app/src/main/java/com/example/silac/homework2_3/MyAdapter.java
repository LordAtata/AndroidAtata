package com.example.silac.homework2_3;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Item> objects;

    MyAdapter(Context context, ArrayList<Item> items) {
        ctx = context;
        objects = items;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.content_item, parent, false);
        }

        Item p = getItems(position);

        ((ImageView) view.findViewById(R.id.iv1)).setImageResource(p.img1);
        ((TextView) view.findViewById(R.id.name)).setText(p.name);
        ((ImageView) view.findViewById(R.id.iv2)).setImageResource(p.img2);
        ((TextView) view.findViewById(R.id.date)).setText(p.date);
        ((TextView) view.findViewById(R.id.text)).setText(p.text);
        ((ImageView) view.findViewById(R.id.iv3)).setImageResource(p.img3);
        ((ImageView) view.findViewById(R.id.iv4)).setImageResource(p.img4);
        ((ImageView) view.findViewById(R.id.iv5)).setImageResource(p.img5);

        return view;
    }

    Item getItems(int position) {
        return ((Item) getItem(position));
    }
}