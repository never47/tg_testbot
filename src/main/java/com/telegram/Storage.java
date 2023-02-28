package com.telegram;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Storage {
    private ArrayList<String> quoteList;
    Storage() throws IOException {
        quoteList = new ArrayList<>();
        parse();
    }

    private void parse() throws IOException {
        final String url = "https://citatnica.ru/citaty/mudrye-tsitaty-velikih-lyudej";

        Document page = Jsoup.parse(new URL(url),3000);
        Element element = page.select("div [class=post-content gp-clearfix]").first();
        Elements elements = element.select("div [class=su-note]");

        for(int i = 0; i< elements.size();i++){
            quoteList.add(elements.get(i).text());
        }
    }
    String getRandQuote()
    {
        //получаем случайное значение в интервале от 0 до самого большого индекса
        int randValue = (int)(Math.random() * quoteList.size());
        //Из коллекции получаем цитату со случайным индексом и возвращаем ее
        return quoteList.get(randValue);
    }


}