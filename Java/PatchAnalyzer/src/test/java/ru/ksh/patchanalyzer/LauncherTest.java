package ru.ksh.patchanalyzer;

import org.junit.BeforeClass;
import org.junit.Test;

public class LauncherTest
{
    private static Launcher launcher;

    @BeforeClass
    public static void init(){
        launcher = new Launcher();
    }

    @Test(expected = IllegalArgumentException.class)
    public void main1()
    {
        launcher.main(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void main2()
    {
        String[] strArr = new String[2];
        strArr[0] = "123";
        launcher.main(strArr);
    }
}