package org.ua.parseReader;

import org.ua.properties.PropertiesReader;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by u0100 on 12.07.2016.
 */
public class ParseLinkKvartir {


    public void parseMethod(ParseTableKvartira client) {
        HttpClient httpClient = new HttpClient();
        PropertiesReader propertiesReader = new PropertiesReader();
        String link = propertiesReader.pathToApartament();
        String html = httpClient.getHTML(link);

        Pattern pattern = Pattern.compile("<td class=\"offer[\\s\\S]*?data-id=\"([0-9]*?)\"[\\s\\S]*?href=\"([\\s\\S]*?)\" title=\"\">");
        Matcher matcher = pattern.matcher(html);

        try {
                if (matcher.find()){
                    String i = matcher.group(1);
                    String s = matcher.group(2);
                    if (i != null || s != null) {
                            System.out.println(i + "  ID  "+  s + "  LINK");
                            client.analizeUrl(s);
                            Thread.sleep(9000);
                    }
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
