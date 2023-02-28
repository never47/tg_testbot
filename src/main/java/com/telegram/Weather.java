package com.telegram;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Weather {
    // отсюда берется вся инфа
    final static String url = "https://sinoptik.ua/";

    // получение всей странички
    private static Document getPage() throws IOException {
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    // сама погода
    public static StringBuilder getWeather() throws IOException {
        StringBuilder weather = new StringBuilder("Погода в Гардабани:" + "\n");

        Document page = getPage();

        Element element = page.select("div[class=tabs]").first();

        // css сегодняшней погоды отличается
        Element today = element.select("div[class=main loaded]").first();
        Elements otherdays = element.select("div[class=main]");

        weather.append(today.text()+"\n");

        for(int i = 0 ; i < otherdays.size(); i++){
            weather.append(otherdays.get(i).text() + "\n");
        }

        return weather;
    }
}
