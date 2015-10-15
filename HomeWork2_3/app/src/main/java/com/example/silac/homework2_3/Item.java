package com.example.silac.homework2_3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Item extends AppCompatActivity {
    int img1;
    String name;
    int img2;
    String date;
    String text;
    int img3;
    int img4;
    int img5;

    Item(int _img1, String _name, int _img2, String _date, String _text, int _img3, int _img4, int _img5) {
        img1 = _img1;
        name = _name;
        img2 = _img2;
        date = _date;
        text = _text;
        img3 = _img3;
        img4 = _img4;
        img5 = _img5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }

}
