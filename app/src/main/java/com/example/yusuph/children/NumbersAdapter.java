package com.example.yusuph.children;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yusuph on 24/08/2017.
 */

public class NumbersAdapter extends ArrayAdapter<String> {

    private final String []str2;
    private  final String [] str22;
    private final Integer [] img22;
    private  Integer [] music;
    private  final Activity context;

    public NumbersAdapter(Activity context, String [] str2, String[]str22, Integer [] img22, Integer [] music){

        super(context, R.layout.activity_abc, str2);
        this.context = context;
        this.str2 = str2;
        this.str22 = str22;
        this.img22 = img22;
        this.music = music;

    }

    public View getView(int position, View contextView, ViewGroup parent){

        View r = contextView;
       ViewHolder viewHolder = null;
        if(r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.activity_abc,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) r.getTag();

        }

        viewHolder.tvw122.setText(str22[position]);
        viewHolder.tvw22.setText(str2[position]);
        viewHolder.imgv22.setImageResource(img22[position]);


        return r ;

    }
    public class ViewHolder{
        TextView tvw22;
        TextView tvw122;
        ImageView imgv22;
        ViewHolder(View v) {

            imgv22 = (ImageView) v.findViewById(R.id.imageView22);
            tvw22 = (TextView) v.findViewById(R.id.text22);
            tvw122 = (TextView) v.findViewById(R.id.textView22);

        }}
}
