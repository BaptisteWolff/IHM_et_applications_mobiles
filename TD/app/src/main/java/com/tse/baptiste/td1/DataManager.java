package com.tse.baptiste.td1;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;
//    private String name;
    private List<String> nameList;

    private DataManager(){
        nameList = new ArrayList<>();
    }

    static public DataManager getInstances() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public List<String> getNameList() {
        return nameList;
    }

    public void addName(String name) {
        this.nameList.add(name);
    }
}
