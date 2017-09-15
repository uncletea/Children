package com.example.yusuph.children;

import android.app.Activity;
import android.content.Context;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.x;
import static android.os.Build.VERSION_CODES.O;

/**
 * Created by Yusuph on 20/08/2017.
 */

    public class WordAdapter extends ArrayAdapter<String>{

    private final String []str;
    private  final String [] str1;
    private final Integer [] img;
    private  final Activity context;

    public   WordAdapter(Activity context, String [] str, String[]str1, Integer [] img){
        super(context, R.layout.activity_abcd, str);
        this.context = context;
        this.str = str;
        this.str1 = str1;
        this.img = img;
    }
    @NonNull
    @Override
    public View getView(int position, View contextView, ViewGroup parent){

    View r = contextView;
    ViewHolder viewHolder = null;
    if(r == null){
        LayoutInflater layoutInflater = context.getLayoutInflater();
        r = layoutInflater.inflate(R.layout.activity_abcd,null,true);
        viewHolder = new ViewHolder(r);
        r.setTag(viewHolder);
    }else{
        viewHolder = (ViewHolder) r.getTag();

    }

        viewHolder.tvw.setText(str[position]);
        viewHolder.tvw1.setText(str1[position]);
        viewHolder.imgv.setImageResource(img[position]);


    return r ;
}

   public class ViewHolder{
        TextView tvw;
        TextView tvw1;
        ImageView imgv;
        ViewHolder(View v) {
            imgv = (ImageView) v.findViewById(R.id.imageView);
            tvw = (TextView) v.findViewById(R.id.text1);
            tvw1 = (TextView) v.findViewById(R.id.textView22);

        }}

    }






