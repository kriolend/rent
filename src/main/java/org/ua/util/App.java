package org.ua.util;

import org.jboss.jandex.Main;
import org.ua.parseReader.ParseLinkKvartir;
import org.ua.parseReader.ParseTableKvartira;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by u0100 on 04.07.2016.
 */
public class App {
    public static void main(String[] args){

//        String password = "abc125";
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode(password));

        ParseTableKvartira kvartira = new ParseTableKvartira();

        while (true){
            kvartira.parseAll();
        }



//
//        String s = "1-ком.из квартира ,одно двуспальное место, хороший евро ремонт,есть холодильник,свч,кондиционер,газовая плита,WI-FI, телевизор.<br />Рядом с домом круглосуточный маркет,стоянка для машин.<br />5 мин от метро Холодная гора.<br />150 гр за 4 часа.";
//        String s1 = s.replaceAll("<br />", " ");
//        System.out.println(s1);






    }

}
