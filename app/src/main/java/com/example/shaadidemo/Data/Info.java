package com.example.shaadidemo.Data;

public class Info {

    private String seed;

    private String results;

    private String page;

    private String version;

    public void setSeed(String seed){
        this.seed = seed;
    }
    public String getSeed(){
        return this.seed;
    }
    public void setResults(String results){
        this.results = results;
    }
    public String getResults(){
        return this.results;
    }
    public void setPage(String page){
        this.page = page;
    }
    public String getPage(){
        return this.page;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return this.version;
    }
}
