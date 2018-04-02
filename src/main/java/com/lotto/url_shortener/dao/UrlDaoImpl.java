package com.lotto.url_shortener.dao;

import com.lotto.url_shortener.utils.UrlShortenerBase62;
import com.lotto.url_shortener.model.Url;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.Objects;

/**
 * Created by iosinsky on 01.04.2018.
 */
@Component
public class UrlDaoImpl implements UrlDao {
    private static final Logger logger = LoggerFactory.getLogger(UrlDaoImpl.class);

    @Autowired
    // private SessionFactory sessionFactory;
    private EntityManagerFactory entityManagerFactory;

    @Override
    public String getUrlRegular(String shortUrl) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();// TODO: need to transfer session management to separate bean

        String queryStr = "select u.regularUrl from Url u where u.shortUrlSuffix= :shortUrl";
        Query query = session.createQuery(queryStr);
        query.setParameter("shortUrl", shortUrl);
        String fullUrl = (String) query.uniqueResult();
        return fullUrl;
    }

    @Override
    public String getUrlRegularById(Long id) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();// TODO: need to transfer session management to separate bean

        Url url = (Url) session.get(Url.class, id);
        if (Objects.isNull(url)) {
            logger.error(String.format("Url object with id = %s is not found in the persistency storage.", id.toString()));
            return null;
        }
        return url.getShortUrlSuffix();
    }

//    public void temp_add2items() {
//        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
//        Url newu1 = new Url("http:\\google.com", "12345");
//        Url newu2 = new Url("http:\\google.ru", "5rfvfg");
//        session.save(newu1);
//        session.save(newu2);
//    }

    // since this is basic it is purely functional. There is no transaction management etc.
    @Override
    public String addNewShortUrl(String regularUrl) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        Url newEntry = new Url(regularUrl);
        session.save(newEntry);//save to get newly generated id
        newEntry.setShortUrlSuffix(UrlShortenerBase62.fromBase10(newEntry.getId())); // here the magic happens
        session.update(newEntry);
        session.save(newEntry);
        return newEntry.getShortUrlSuffix();
    }

    @Override
    public String getUrlShort(String urlRegular) {// stub not implemented jet since not needed for current functionality
        return null;
    }
}
