//package com.lotto.url_shortener;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManagerFactory;
//
///**
// * Created by iosinsky on 01.04.2018.
// */
//@Configuration
//public class BeanConfig {
//    @Autowired
//    private static EntityManagerFactory entityManagerFactory;
//
//    @Bean
//    public SessionFactory getSessionFactory() {
//        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
//            throw new NullPointerException("factory is not a hibernate factory");
//        }
//        return entityManagerFactory.unwrap(SessionFactory.class);
//    }
//}
