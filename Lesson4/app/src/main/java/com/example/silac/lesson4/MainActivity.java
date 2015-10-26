package com.example.silac.lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<MainData> dataSet;
    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //fillData();

        mAdapter = new MyAdapter(MainActivity.this, dataSet);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void fillData() {
        dataSet = new ArrayList<>();
        dataSet.add(new MainData("Пикабу", "22 октября в 9:40", "Увидел бывшую с другим и моё сердце сжалось. А потом разжалось. Оно так работает, бывшая тут не при чем."));
        dataSet.add(new MainData("Android. 2 курс", "вчера в 12:58", "Ура. Свободные выборы показали, что пара будет в 15:20. Кабинет 1412"));
        dataSet.add(new MainData("Mobiltelefon.ru", "вчера в 15:15", "Meizu MX5 получит Flyme OS 5.0 на Android 5.1 Lollipop"));
        dataSet.add(new MainData("Пикабу", "27 сентября в 17:46", "Краткий гид по языкам. Если речь звучил как нытье - это корейский. Если в речи одни согласные - это польский. Если вам кажется, что говорящий имитирует звук заводящегося автомобиля - это татарский."));
        dataSet.add(new MainData("КФУ, Высшая школа ИТИС", "22 октября в 13:38", "Студенты, желающие принять участие в хакатоне по обработке данных, обратитесь, пожалуйста, к Новикову Петру Андреевичу."));
    }
}
