package com.lotto.url_shortener.dao;

/**
 * Created by iosinsky on 01.04.2018.
 */
public interface UrlDao {
    String getUrlShort(String urlRegular);

    String getUrlRegularById(Long id);

    String getUrlRegular(String urlShort);

 //   void temp_add2items();

    String addNewShortUrl(String regularUrl);
}
