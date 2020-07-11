package ru.ksh.patchanalyzer.constants;

public enum Constants
{
    RFC("rfc"), JIRAID("jiraid"), APPLICATIONS("applications"), APPLICATION("application");

    private String name;

    Constants(String name){
        this.name = name;
    }

    public String getName(){return name;};
}
