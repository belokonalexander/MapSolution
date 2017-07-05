package com.example.alexander.mapsolution.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexander.mapsolution.R;

import junit.framework.Test;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexander on 05.07.2017.
 */

public class TestDelegate implements AdapterDelegate<List<AdapterItem>> {

    Integer type;

    public TestDelegate(Integer type) {
        this.type = type;
    }



    @Override
    public boolean isForViewType(@NonNull List<AdapterItem> items, int position) {
        return items.get(position) instanceof TestItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new TestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<AdapterItem> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        TestViewHolder vh = (TestViewHolder) holder;
        TestItem testItem = (TestItem) items.get(position);
        vh.textView.setText(testItem.getName());

    }

    @Override
    public int getViewType() {
        return type;
    }

    static class TestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.test_item)
        TextView textView;

        public TestViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }

}
