package ru.ksh.patchanalyzer.logics;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class FileContentAnalyzerTest
{
    @Test
    public void getResult()
    {
        String jiraid = "ESBKF-6111";
        String pathToPatchXmlFile = FileContentAnalyzerTest.class.getClassLoader().getResource("patch0.xml").getFile();

        String actual = FileContentAnalyzer.getResult(jiraid, pathToPatchXmlFile);

        String expected = "ESBKF-6066, ESBKF-5905, ESBKF-6053, ESBKF-6077";

        Assert.assertEquals(expected, actual);
    }

    /**
     * delete @{jiraid} tag in pathc1.xml (version="SP-32.000.04")
     * and
     * assign null to single @{jiraid} tag (version="SP-32.000.08")
     */
    @Test
    public void getResult2()
    {
        String jiraid = "ESBKF-6111";
        String pathToPatchXmlFile = FileContentAnalyzerTest.class.getClassLoader().getResource("patch1.xml").getFile();

        String actual = FileContentAnalyzer.getResult(jiraid, pathToPatchXmlFile);

        String expected = "ESBKF-6066, ESBKF-6053";

        Assert.assertEquals(expected, actual);
    }

    /**
     * test @{version} tag in pathc2.xml
     * with invalid context, without the tag, with empty content
     */
    @Test
    public void getResult3()
    {
        String jiraid = "ESBKF-6066";
        String pathToPatchXmlFile = FileContentAnalyzerTest.class.getClassLoader().getResource("patch2.xml").getFile();

        String actual = FileContentAnalyzer.getResult(jiraid, pathToPatchXmlFile);

        String expected = "ESBKF-6101, ESBKF-6001";

        Assert.assertEquals(expected, actual);
    }
}