package ru.ksh.patchanalyzer.logics;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import ru.ksh.patchanalyzer.constants.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileContentAnalyzer
{
    public static String getResult(String jiraid, String pathToPatchXmlFile)
    {
        //region get root element
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        try
        {
            document = builder.build(pathToPatchXmlFile);
        }
        catch (JDOMException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Element rootElement = document.getRootElement();
        //endregion

        List<String> ourServicesNames = getCurrentPatchServicesNames(jiraid, rootElement);

        StringBuilder resultBuilder = new StringBuilder();

        if (Objects.nonNull(jiraid) && Objects.nonNull(rootElement))
        {
            for (Element rfc : rootElement.getChildren(Constants.RFC.getName()))
            {
                //if attribute "jiraid" and "version" doesn't exist
                Attribute jiraidAttr = rfc.getAttribute(Constants.JIRAID.getName());
                Attribute versionAttr = rfc.getAttribute(Constants.VERSION.getName());
                if(Objects.isNull(jiraidAttr) || Objects.isNull(versionAttr)) continue;

                //if attribute "jiraid" is empty or equals null
                if(Objects.isNull(jiraidAttr.getValue()) || jiraidAttr.getValue().isEmpty()) continue;
                //if attribute "version" is empty or equals null
                if(Objects.isNull(versionAttr.getValue()) || versionAttr.getValue().isEmpty()) continue;

                String jiraidAttrValue = rfc.getAttribute(Constants.JIRAID.getName()).getValue();
                String versionAttrValue = rfc.getAttribute(Constants.VERSION.getName()).getValue();
                if (!Pattern.compile("SP-[0-9]{2}.[0-9]{3}.[0-9]{2}").matcher(versionAttrValue).matches()) continue;

                if (!jiraidAttrValue.equalsIgnoreCase(jiraid) && Objects.nonNull(jiraidAttrValue) && !jiraidAttrValue.isEmpty() && Objects.nonNull(versionAttrValue) && !versionAttrValue.isEmpty())
                {
                    if (Objects.nonNull(rfc.getChild(Constants.APPLICATIONS.getName())))
                    {
                        Element applications = rfc.getChild(Constants.APPLICATIONS.getName());
                        if (Objects.nonNull(applications.getChildren(Constants.APPLICATION.getName())))
                        {
                            out1:
                            for (Element application : applications.getChildren(Constants.APPLICATION.getName()))
                            {
                                String serviceName = application.getValue();

                                if (ourServicesNames.contains(serviceName))
                                {
                                    resultBuilder.append(jiraidAttrValue + ", ");
                                    break out1;
                                }
                            }
                        }
                    }
                }
            }
        }

        String resultString = resultBuilder.toString();
        return resultString.isEmpty() ? null : resultString.substring(0, resultBuilder.length() - 2);
    }

    private static List<String> getCurrentPatchServicesNames(String jiraid, Element rootElement)
    {
        List<String> servicesNames = new ArrayList<>();

        if (Objects.nonNull(jiraid) && Objects.nonNull(rootElement))
        {
            Element currentRfc = null;

            try
            {
                currentRfc = rootElement.getChildren(Constants.RFC.getName())
                                                .stream()
                                                .filter(rfc -> rfc.getAttribute(Constants.JIRAID.getName()).getValue().equalsIgnoreCase(jiraid))
                                                .findFirst()
                                                .get();
            }
            catch (NoSuchElementException e){
                System.out.println("Invalid jiraid");
                System.exit(-1);
            }

            servicesNames = currentRfc.getChild(Constants.APPLICATIONS.getName())
                                             .getChildren(Constants.APPLICATION.getName())
                                             .stream()
                                             .filter(app -> !app.getValue().equalsIgnoreCase(Constants.UPDATECACHE.getName()))
                                             .map(app -> app.getValue())
                                             .collect(Collectors.toList());
        }

        return servicesNames;
    }


}
