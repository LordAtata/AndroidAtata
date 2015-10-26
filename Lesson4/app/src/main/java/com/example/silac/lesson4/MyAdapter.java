package com.example.silac.lesson4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<MainData> dataSet;
    public Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextView1 = (TextView)itemView.findViewById(R.id.tv1);
            mTextView2 = (TextView)itemView.findViewById(R.id.tv2);
            mTextView3 = (TextView)itemView.findViewById(R.id.tv3);
        }
    }

    public MyAdapter(Context context, List<MainData> data){
        this.dataSet = data;
        mContext = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rv, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        final TextView tvZag1 = holder.mTextView1;
        final TextView tvZag2 = holder.mTextView2;
        final TextView tvText = holder.mTextView3;
        tvZag1.setText(dataSet.get(listPosition).zag1);
        tvZag2.setText(dataSet.get(listPosition).zag2);
        tvText.setText(dataSet.get(listPosition).text);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class); //Не хочет переходить на следующую активити
                intent.putExtra("zag1", dataSet.get(listPosition).zag1);
                intent.putExtra("zag2", dataSet.get(listPosition).zag2);
                intent.putExtra("text", dataSet.get(listPosition).text);
                v.getContext().startActivity(intent);                             //Я не знаю почему... Я вытался...
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
