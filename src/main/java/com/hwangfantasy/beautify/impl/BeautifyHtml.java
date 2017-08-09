package com.hwangfantasy.beautify.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by hwangfantasy on 2017/8/9.
 * 采用jsoup格式化HTML
 */
public class BeautifyHtml {
    public BeautifyHtml() {
    }

    public static String beautifyHtml(String sourceHtml){
        Document document = Jsoup.parseBodyFragment(sourceHtml);
        String output = document.html();
        return output;
    }
}
