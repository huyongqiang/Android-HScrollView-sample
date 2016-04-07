package com.example.xie.stock.uitls;

import android.util.Xml;


import com.example.xie.stock.entity.Klist;
import com.example.xie.stock.entity.Stocklist;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class DataTools {

    public static ArrayList<Stocklist> getDatas(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        int i = conn.getResponseCode();
        if (i == 200) {
            InputStream in = conn.getInputStream();

            return parseXML(in);

        }
        return null;
    }

    public static ArrayList<Stocklist> parseXML(InputStream xml) throws Exception {
        ArrayList<Stocklist> list = null;
        Stocklist stocklist = null;
        XmlPullParser pullParser = Xml.newPullParser();
        pullParser.setInput(xml, "utf-8");
        int event = pullParser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) {
            switch (event) {
                case XmlPullParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;

                case XmlPullParser.START_TAG:

                    if ("name".equals(pullParser.getName())) {
                        stocklist = new Stocklist();
                        stocklist.setName(pullParser.nextText());
                    }

                    if ("code".equals(pullParser.getName())) {
                        stocklist.setCode(pullParser.nextText());
                    }

                    if ("price".equals(pullParser.getName())) {
                        stocklist.setPrice(new Double(pullParser.nextText()));
                    }
                    if ("rate".equals(pullParser.getName())) {
                        stocklist.setRate(new Double(pullParser.nextText()));
                    }
                    if ("rise".equals(pullParser.getName())) {
                        stocklist.setRise(new Double(pullParser.nextText()));
                    }
                    if ("preClose".equals(pullParser.getName())) {
                        stocklist.setPreClose(new Double(pullParser.nextText()));
                    }
                    if ("vol".equals(pullParser.getName())) {
                        stocklist.setVol(new Double(pullParser.nextText()));
                    }
                    if ("amount".equals(pullParser.getName())) {
                        stocklist.setAmount(new Double(pullParser.nextText()));
                    }
                    if ("open".equals(pullParser.getName())) {
                        stocklist.setOpen(new Double(pullParser.nextText()));
                    }
                    if ("high".equals(pullParser.getName())) {
                        stocklist.setHigh(new Double(pullParser.nextText()));
                    }
                    if ("low".equals(pullParser.getName())) {
                        stocklist.setLow(new Double(pullParser.nextText()));
                    }
                    break;

                case XmlPullParser.END_TAG:
                    if ("data".equals(pullParser.getName())) {
                        list.add(stocklist);
                        stocklist = null;
                    }
                    break;
            }
            event = pullParser.next();
        }

        return list;

    }


    public static ArrayList<Klist> getKDatas(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        int i = conn.getResponseCode();
        if (i == 200) {
            InputStream in = conn.getInputStream();

            return parseK_XML(in);

        }
        return null;
    }
    public static ArrayList<Klist> parseK_XML(InputStream xml) throws Exception {
        ArrayList<Klist> list = null;
        Klist klist = null;
        XmlPullParser pullParser = Xml.newPullParser();
        pullParser.setInput(xml, "utf-8");
        int event = pullParser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) {
            switch (event) {
                case XmlPullParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;

                case XmlPullParser.START_TAG:

                    if ("data".equals(pullParser.getName())) {
                        klist = new Klist();
                        klist.setDate(new Double(pullParser.nextText()));
                    }

                    if ("open".equals(pullParser.getName())) {
                        klist.setOpen(new Double(pullParser.nextText()));
                    }

                    if ("close".equals(pullParser.getName())) {
                        klist.setClose(new Double(pullParser.nextText()));
                    }
                    if ("high".equals(pullParser.getName())) {
                        klist.setHigh(new Double(pullParser.nextText()));
                    }
                    if ("low".equals(pullParser.getName())) {
                        klist.setLow(new Double(pullParser.nextText()));
                    }
                    if ("volume".equals(pullParser.getName())) {
                        klist.setVolume(new Double(pullParser.nextText()));
                    }
                    if ("turnover".equals(pullParser.getName())) {
                        klist.setTurnover(new Double(pullParser.nextText()));
                    }

                    break;

                case XmlPullParser.END_TAG:
                    if ("data".equals(pullParser.getName())) {
                        list.add(klist);
                        klist = null;
                    }
                    break;
            }
            event = pullParser.next();
        }

        return list;

    }
}



