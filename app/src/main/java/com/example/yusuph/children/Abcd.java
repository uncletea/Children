package com.example.yusuph.children;

import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

public class Abcd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create a list word

       String [] str = {"one", "one", "one", "one","one","one",
               "G for Goat", "G for Goat","H for Goat","H for Goat",
               "H for Goat","H for Goat","H for Goat","H for Goat",
               "H for Goat","H for Goat","H for Goat","H for Goat",
               "H for Goat","H for Goat", "H for Goat", "H for Goat",
               "H for Goat", "H for Goat", "H for Goat", "H for Goat"


       };
        String [] str1 = {"A for Apple", "B for Ball", "C for Cat","D for Dog","E for Egg","F for fish", "G for Goat",
                "H for Horse","I for Ice Cream", "J for Jug", "K for Key", "L for Lion", "M for Mango", "N for Nail",
                "O for Orange", "P for Pen", "Q for Queen", "R for Ring", "S for Ship", "T for Telephone","U for Umbrella",
                "V for Van", "W for Watch", "X for Xylophone", "Y for Yam", "Z for Zebra"
        };
        Integer [] img = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
                R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.ll, R.drawable.mm,
                R.drawable.nn, R.drawable.oo, R.drawable.pp, R.drawable.qq, R.drawable.rr, R.drawable.ss,
                R.drawable.tt, R.drawable.uu, R.drawable.vv, R.drawable.ww, R.drawable.xx, R.drawable.yy, R.drawable.zz

        };



        WordAdapter wa = new WordAdapter(this, str, str1,img);

        setContentView(R.layout.word_list);
        ListView li = (ListView) findViewById(R.id.list_v);
        li.setAdapter(wa);


    }
}
