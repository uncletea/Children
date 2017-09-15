package com.example.yusuph.children;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView a = (TextView)findViewById(R.id.textView33);
       a.setOnClickListener(
               new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent numi = new Intent(MainActivity.this,Abcd.class);
               startActivity(numi);
           }
       });

        TextView ab = (TextView)findViewById(R.id.textView44);
           ab.setOnClickListener(
                   new View.OnClickListener(){
                       @Override
                       public void onClick(View view){
                           Intent numii = new Intent(MainActivity.this, Abc.class);
                           startActivity(numii);

                       }
                   }
           );



    }

}


