package ru.ksh.patchanalyzer;

import ru.ksh.patchanalyzer.logics.FileContentAnalyzer;

import java.util.Objects;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("started");

        checkArgs(args);

        String pathToPatchXmlFile = args[0];
        String jiraid = args[1];

        //analyze file content
        String result = FileContentAnalyzer.getResult(jiraid, pathToPatchXmlFile);

        //print out result
        System.out.println(result);
        System.out.println("done.");
    }

    private static void checkArgs(String[] args)
    {
        if (args == null) {
            throw new IllegalArgumentException("args is empty\n1-PathToPatchXml 2-CurrentPatchJiraId");
        }
        else if(args.length <= 1 || args.length >= 3) {
            throw new IllegalArgumentException("args is empty\n1-PathToPatchXml 2-CurrentPatchJiraId");
        }
        else if(Objects.isNull(args[0]) || Objects.isNull(args[1])) {
            throw new IllegalArgumentException("args is empty\n1-PathToPatchXml 2-CurrentPatchJiraId");
        }
        else if(args[0].isEmpty() || args[1].isEmpty()) {
            throw new IllegalArgumentException("args is empty\n1-PathToPatchXml 2-CurrentPatchJiraId");
        }
    }
}
