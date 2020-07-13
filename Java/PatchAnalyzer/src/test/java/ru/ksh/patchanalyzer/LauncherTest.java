package ru.ksh.patchanalyzer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

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

    @Test(expected = NoSuchElementException.class)
    public void main3()
    {
        String[] strArr = new String[2];
        strArr[0] = LauncherTest.class.getClassLoader().getResource("patch2.xml").getFile();
        strArr[1] = "ESBKF-1234567890";
        launcher.main(strArr);
    }
}