package com.example.alexander.mapsolution.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.alexander.mapsolution.Utils.LogHelper;

import java.util.List;

/**
 * Created by Alexander on 05.07.2017.
 */

public class CustomAdapter extends RecyclerView.Adapter {

    final int TEST_TYPE = 0;
    final int ANOTHER_TYPE = 1;

    TestDelegate testDelegate;
    AnotherDelegate anotherDelegate;

    Activity activity;



    List<AdapterItem> items;

    public CustomAdapter(Activity activity, List<AdapterItem> items) {
        this.items = items;
        this.activity = activity;

         testDelegate = new TestDelegate(TEST_TYPE);
         anotherDelegate = new AnotherDelegate(activity,ANOTHER_TYPE);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LogHelper.write(" Создал тип " + viewType);

        if(viewType==TEST_TYPE)
            return testDelegate.onCreateViewHolder(parent);
        if(viewType==ANOTHER_TYPE)
            return anotherDelegate.onCreateViewHolder(parent);

        else throw new IllegalArgumentException();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        LogHelper.write(" ITEM TYPE: " + viewType + " / " + position);
        if(viewType==TEST_TYPE) {
            LogHelper.write(" Создаю первый ");
            testDelegate.onBindViewHolder(items, position, holder);
        }
        if(viewType==ANOTHER_TYPE) {
            LogHelper.write(" Создаю второй ");
            anotherDelegate.onBindViewHolder(items, position, holder);
        }
    }


    @Override public int getItemViewType(int position) {
        if (testDelegate.isForViewType(items, position)){
            return testDelegate.getViewType();
        }
        else if (anotherDelegate.isForViewType(items, position)){
            return anotherDelegate.getViewType();
        }

        throw new IllegalArgumentException("No delegate found");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
