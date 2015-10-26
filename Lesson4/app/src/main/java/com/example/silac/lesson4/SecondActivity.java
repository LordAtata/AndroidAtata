package com.example.silac.lesson4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public Button btnLike;
    public Button btnDislike;
    public TextView tv;
    private String res;
    private String str1;
    private String str2;
    private String str3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btnLike = (Button) findViewById(R.id.bLike);
        btnDislike = (Button) findViewById(R.id.bDislike);
        tv = (TextView) findViewById(R.id.tv4);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = (String) tv.getText();
                Integer resint = new Integer(res);
                resint++;
                String resstr = Integer.toString(resint);
                mResult(resint, resstr);
                str1 = getIntent().getExtras().getString("zag1");
                str2 = getIntent().getExtras().getString("zag2");
                str3 = getIntent().getExtras().getString("text");
                ((TextView) findViewById(R.id.tv1)).setText(str1);
                ((TextView) findViewById(R.id.tv2)).setText(str2);
                ((TextView) findViewById(R.id.tv3)).setText(str3);
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = (String) tv.getText();
                Integer resint = new Integer(res);
                resint--;
                String resstr = Integer.toString(resint);
                mResult(resint, resstr);
            }
        });
    }

    public void mResult(int resint, String resstr) {
        if (resint > 0) {
            tv.setText("+" + resstr);
            tv.setTextColor(Color.GREEN);
        } else {
            if (resint == 0) {
                tv.setText(resstr);
                tv.setTextColor(Color.GRAY);
            } else {
                tv.setText("-" + resstr);
                tv.setTextColor(Color.RED);
            }
        }

    }
}