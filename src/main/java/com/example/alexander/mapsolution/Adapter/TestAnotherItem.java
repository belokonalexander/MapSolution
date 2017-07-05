package com.example.alexander.mapsolution.Adapter;

/**
 * Created by Alexander on 05.07.2017.
 */

public class TestAnotherItem implements AdapterItem {

    private String name;

    public TestAnotherItem(String name){
      this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
