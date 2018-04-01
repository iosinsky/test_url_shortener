package com.lotto.url_shortener.service;

/**
 * 
 * Created by iosinsky on 01.04.2018.
 */
public interface UrlService {

    // List<Url> getUrlAll();
    String getUrlShort(String urlRegular);

    String getUrlRegular(String urlShort);

    String addNewUrlShort(String urlRegular);

 //   void test();
}
