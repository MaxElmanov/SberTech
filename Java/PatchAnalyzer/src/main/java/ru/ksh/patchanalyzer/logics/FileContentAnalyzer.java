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
import java.util.Objects;
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

        List<String> servicesNames = getCurrentPatchServicesNames(jiraid, rootElement);

        StringBuilder resultBuilder = new StringBuilder();

        if (Objects.nonNull(jiraid) && Objects.nonNull(rootElement))
        {
            for (Element rfc : rootElement.getChildren(Constants.RFC.getName()))
            {
                //if attribute "jiraid" doesn't exist
                Attribute jiraidAttr = rfc.getAttribute(Constants.JIRAID.getName());
                if(Objects.isNull(jiraidAttr)) continue;

                //if attribute "jiraid" is empty or equals null
                if(Objects.isNull(jiraidAttr.getValue()) || jiraidAttr.getValue().isEmpty()) continue;

                String rfcAttr = rfc.getAttribute(Constants.JIRAID.getName()).getValue();
                if (Objects.nonNull(rfcAttr) && !rfcAttr.isEmpty() && !rfcAttr.equalsIgnoreCase(jiraid))
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

                                out2:
                                for (String currentServiceName : servicesNames)
                                {
                                    if (serviceName.equalsIgnoreCase(currentServiceName))
                                    {
                                        resultBuilder.append(rfcAttr + ", ");
                                        break out1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return resultBuilder.toString().substring(0, resultBuilder.length() - 2);
    }

    private static List<String> getCurrentPatchServicesNames(String jiraid, Element rootElement)
    {
        List<String> servicesNames = new ArrayList<>();

        if (Objects.nonNull(jiraid) && Objects.nonNull(rootElement))
        {
            Element currentRfc = rootElement.getChildren(Constants.RFC.getName())
                                            .stream()
                                            .filter(rfc -> rfc.getAttribute(Constants.JIRAID.getName()).getValue().equalsIgnoreCase(jiraid))
                                            .findFirst()
                                            .get();

            servicesNames = currentRfc.getChild(Constants.APPLICATIONS.getName())
                                             .getChildren(Constants.APPLICATION.getName())
                                             .stream()
                                             .map(app -> app.getValue())
                                             .collect(Collectors.toList());
        }

        return servicesNames;
    }


}
