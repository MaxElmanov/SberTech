package ru.ksh.patchanalyzer.constants;

public enum Constants
{
    RFC("rfc"), JIRAID("jiraid"), VERSION("version"), APPLICATIONS("applications"), APPLICATION("application"), UPDATECACHE("UpdateCache");

    private String name;

    Constants(String name){
        this.name = name;
    }

    public String getName(){return name;};
}
