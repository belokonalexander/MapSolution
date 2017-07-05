package com.example.alexander.mapsolution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexander.mapsolution.Adapter.AdapterItem;
import com.example.alexander.mapsolution.Adapter.CustomAdapter;
import com.example.alexander.mapsolution.Adapter.TestAnotherItem;
import com.example.alexander.mapsolution.Adapter.TestItem;
import com.example.alexander.mapsolution.Utils.LogHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexander on 05.07.2017.
 */

public class ListFragment extends Fragment {

    @BindView(R.id.listView)
    RecyclerView listView;

    CustomAdapter testAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        testAdapter  = new CustomAdapter(getData());
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setAdapter(testAdapter);

    }

    public List<AdapterItem> getData(){
        ArrayList<AdapterItem> arrayList = new ArrayList<>();

        for(int i =0; i < 20; i++){
            if(i%2==0)
                arrayList.add(new TestItem("Test " + i));
            else arrayList.add(new TestAnotherItem("AnotherItem " + i));
        }

        LogHelper.write(" Items size: " + arrayList.size());

        return arrayList;
        //return Collections.emptyList();
    }
}
