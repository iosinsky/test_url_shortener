package com.lotto.url_shortener.controller;

import com.lotto.url_shortener.utils.UrlShortenerBase62;
import com.lotto.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by iosinsky on 31.03.2018.
 */
@RestController
public class UrlShortController {
    @Autowired
    UrlService urlService;

    @RequestMapping("/lotto.lt")
    public String index() {

      String x=  UrlShortenerBase62.fromBase10(9897919989199l);
        Long y = UrlShortenerBase62.toBase10(x);
     //   urlService.test();/// test temp to delete
        return x+"Greetings from Spring Boot!"+y;
    }

}
