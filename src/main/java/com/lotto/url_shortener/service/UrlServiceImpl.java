package com.lotto.url_shortener.service;

import com.lotto.url_shortener.dao.UrlDao;
import com.lotto.url_shortener.utils.UrlShortenerBase62;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by iosinsky on 01.04.2018.
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDao urlDao;

    @Override
    public String getUrlShort(String urlRegular) {
        return null;
    }

    @Override
    public String getUrlRegular(String urlShort) {//for fast db retrieval short url converted back to id (key)
        return urlDao.getUrlRegularById(UrlShortenerBase62.toBase10(urlShort));
    }

    @Override
    public String addNewUrlShort(String urlRegular) {
        return urlDao.addNewShortUrl(urlRegular);
    }

//    public void test() {
//        urlDao.temp_add2items();
//    }
}
