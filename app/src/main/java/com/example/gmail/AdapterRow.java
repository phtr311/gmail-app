package com.example.gmail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class AdapterRow extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Row> arr;

    public AdapterRow(Context context, int layout, List<Row> arr) {
        this.context = context;
        this.layout = layout;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater l_inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = l_inf.inflate(layout, null);
        Row row = arr.get(position);

        TextView icon = (TextView) convertView.findViewById(R.id.app-icon);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView body = (TextView) convertView.findViewById(R.id.body);

        title.setText(row.getTitle());
        body.setText(row.getBody());
        icon.setText(String.valueOf(title.getText().toString().charAt(0)));

        Random rnd = new Random();
        int colorB = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        int colorT = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        while (colorT == colorB){
            colorT = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }
        Drawable background = icon.getBackground();
        GradientDrawable shape = (GradientDrawable) background;
        shape.setColor(colorB);
        icon.setTextColor(colorT);

        Random rnd = new Random();
        int colorB = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        int colorT = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        while (colorT == colorB){
            colorT = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }
        Drawable background = icon.getBackground();
        GradientDrawable shape = (GradientDrawable) background;
        shape.setColor(colorB);
        icon.setTextColor(colorT);

        return convertView;

    }
}
