package com.example.silac.homework2_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainHW extends AppCompatActivity {


    ArrayList<Item> item = new ArrayList<Item>();
    private String[] date;
    private String[] text;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hw);

        fillDate();
        fillText();
        fillAdapter();
        myAdapter = new MyAdapter(this, item);

        ListView lvMain = (ListView) findViewById(R.id.lv);
        lvMain.setAdapter(myAdapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Toast toast = Toast.makeText(getApplicationContext(), text[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void fillAdapter() {
        for (int i = 0; i < text.length; i++) {
            item.add(new Item(R.drawable.android, "Sumsung Android Lab", R.drawable.dots, date[i], text[i],
                    R.drawable.comment, R.drawable.bullhorn, R.drawable.like));
        }
    }

    private void fillDate() {
        date = getResources().getStringArray(R.array.dateArr);
    }

    private void fillText() {
        text = getResources().getStringArray(R.array.textArr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_hw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
