package com.example.alexander.mapsolution.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexander.mapsolution.R;
import com.example.alexander.mapsolution.Utils.LogHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexander on 05.07.2017.
 */

public class AnotherDelegate implements AdapterDelegate<List<AdapterItem>>, OnItemClickListener<TestAnotherItem> {

    Integer viewType;

    public AnotherDelegate(Integer type) {
        this.viewType = type;
    }




    @Override
    public boolean isForViewType(@NonNull List<AdapterItem> items, int position) {
        return items.get(position) instanceof TestAnotherItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new AnotherViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_another,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<AdapterItem> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        AnotherViewHolder vh = (AnotherViewHolder) holder;
        TestAnotherItem testItem = (TestAnotherItem) items.get(position);
        vh.textView.setText(testItem.getName());
        vh.view.setOnClickListener(v -> AnotherDelegate.this.onClick(testItem));

    }

    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public void onClick(TestAnotherItem item) {
        LogHelper.write("Click: " + item.getName());
    }

    static class AnotherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.test_item)
        TextView textView;

        @BindView(R.id.some)
        View view;

        public AnotherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }

}
