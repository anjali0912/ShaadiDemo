package com.example.shaadidemo.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    @SerializedName("results")
    private ArrayList<Results> results;
    @SerializedName("info")
    private Info info;

    public void setResults(ArrayList<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
    public void setInfo(Info info){
        this.info = info;
    }
    public Info getInfo(){
        return this.info;
    }
}
