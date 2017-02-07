package org.ua.parseReader;


import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.ua.dao.ApartamentDao;
import org.ua.model.realEstate.Apartament;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ua.util.HibernateUtil;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by u0100 on 08.07.2016.
 */


public class ParseTableKvartira {
//    @Autowired
//    ApartamentDao apartmentApartamentDao;

    HttpClient httpClient = new HttpClient();

    ParseLinkKvartir parseLinkKvartir = new ParseLinkKvartir();

    public void analizeUrl(String url){
        Connection conn = null;
        PreparedStatement prst = null;


//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
//        Apartament apartament = new Apartament();

        String html = httpClient.getHTML(url);

        String dataIdAdd = parseDataId(html);
        String urlsAdd = parseUrl(html);
        String titleAdd = parseTitle(html);
        String raionAdd = parsreRaion(html);
        String nameBossAdd = parseName(html);
        String timeAddAdd = parseAdd(html);
        String priceAdd = parsePrice(html);
        String komnatAdd = parseKomnat(html);
        String telephonAdd = parseTelefon(html);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/arenda_kvartir", "root",
                    "toor");
            String sql = "INSERT IGNORE INTO arenda_kvartir (data_id,link,title,raion,name_boss,addTime,price,koll_komnat,telephon) \n" +
                    " VALUES (?,?,?,?,?,?,?,?,?);";
            prst = conn.prepareStatement(sql);
            prst.setString(1, dataIdAdd);
            prst.setString(2, urlsAdd);
            prst.setString(3, titleAdd);
            prst.setString(4, raionAdd);
            prst.setString(5, nameBossAdd);
            prst.setString(6, timeAddAdd);
            prst.setString(7, priceAdd);
            prst.setString(8, komnatAdd);
            prst.setString(9, telephonAdd);
            prst.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }


//        apartament.setDataId(dataIdAdd);
//        apartament.setLink(urlsAdd);
//        apartament.setTitle(titleAdd);
//        apartament.setRaion(raionAdd);
//        apartament.setNameBoss(nameBossAdd);
//        apartament.setAddTime(timeAddAdd);
//        apartament.setPrice(priceAdd);
//        apartament.setKollKomnat(komnatAdd);
//        apartament.setTelephon(telephonAdd);
//        session.save(apartament);
//        session.getTransaction().commit();
//        session.close();

    }


    public void parseAll(){
        parseLinkKvartir.parseMethod(this);
    }

    public String parseHtml(String html){
        System.out.println(html);
        return html;
    }


    public String parseDataId(String html){
        String data = null;
        Pattern pattern = Pattern.compile("<span class=\"rel inlblk\">([\\s\\S]*?)</span></span>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            data = matcher.group(1);
        }
        System.out.println(data);

        return data;
    }

    public String parseUrl(String html){
        String url = "";
        Pattern pattern = Pattern.compile("<link rel=\"canonical\" href=\"([\\s\\S]*?)\" />");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            url = matcher.group(1);
        }
        System.out.println(url);
        return url;
    }

    public String parseTitle(String html){
        String s = "";
        String title2 = s.replaceAll("<br />", " ");
        String title = title2.replaceAll("&quot;", " ");
        Pattern pattern = Pattern.compile("<p class=\"pding10 lheight20 large\">[\\s]*([\\s\\S]*?)[\\s]*</p>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            String str = matcher.group(1);
            String newStr = str.replaceAll("<br />", " ");
            String newStr1 = newStr.replaceAll("&quot;", " ");

            s = newStr1;
        }
        System.out.println(s);
        return s;
    }

    public String parsreRaion(String html){
        String raion = "";
        Pattern pattern = Pattern.compile("<strong class=\"c2b small\">[\\s]*([\\s\\S]*?)[\\s]*</strong>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            raion = matcher.group(1);
        }
        System.out.println(raion);
        return raion;
    }

    public String parseName(String html){
        String name = "";
        Pattern pattern = Pattern.compile("<span class=\"block color-5 brkword xx-large\">([\\s\\S]*?)</span>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            name = matcher.group(1);
        }
        System.out.println(name);
        return name;
    }

    public String parseAdd(String html){
        String add = "";
        Pattern pattern = Pattern.compile("(Добавлено:[\\s]*в|Опубликовано с мобильного</span></a>[\\s]*в[\\s]*)[\\s]*([\\s\\S]*?)[\\s]*<span class");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            add = matcher.group(2);
        }
        System.out.println(add);
        return add;
    }

    public String parsePrice(String html){
        String price = "";
        Pattern pattern = Pattern.compile("(<strong class=\"xxxx-large margintop7 block not-arranged\">|<strong class=\"xxxx-large margintop7 block arranged\">)([\\s\\S]*?)</strong>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            price = matcher.group(2);
        }
        System.out.println(price);
        return price;
    }

    public String parseKomnat(String html){
        String komnat = "";
        Pattern pattern = Pattern.compile("<th>Количество комнат</th>[\\s\\S]*?<strong>[\\s]*([\\s\\S]*?)[\\s]*</strong>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            komnat = matcher.group(1);
        }
        System.out.println(komnat);
        return komnat;
    }

    public String parseTelefon(String html) {
        String postfix = null;
        String urlPost = "http://olx.ua/ajax/misc/contact/phone/";
        String telefon = "";
        Pattern pattern = Pattern.compile("id:[\\s\\S]'([\\s\\S]*?)'");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
                postfix = matcher.group(1);
        }
        String urlFull = urlPost+postfix+"/";
        String tel = null;
        String t = null;
        try {
            t = httpClient.getHTML(urlFull);
        }catch (Exception e){
            System.out.println("this is Skype");
        }


        if (t.isEmpty()) {
            tel = notTelephone();
        }else {
            tel = httpClient.getHTML(urlFull);
        }

        if ((tel.contains("block")) == true){
            Pattern pattern2 = Pattern.compile("\">([\\s\\S]*?)<");
            Matcher matcher1 = pattern2.matcher(tel);
            while (matcher1.find()){
                String count = matcher1.group(1);
                telefon = count + "; " + telefon;
            }
            System.out.println(telefon);
        }
        if((tel.contains("block")) == false) {
            Pattern pattern2 = Pattern.compile(":[\\s\\S]*\"([\\s\\S]*?)\"");
            Matcher matcher2 = pattern2.matcher(tel);
            while (matcher2.find()){
                String count = matcher2.group(1);
                telefon = count + "; " + telefon;
            }
            System.out.println(telefon);
        }

        return telefon;
    }

    public String notTelephone(){
        String notTel = "{\"value\": \"+3800-00-00-000\"}";
        return notTel;
    }

}
