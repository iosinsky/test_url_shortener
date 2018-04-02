package com.lotto.url_shortener.controller;

import com.lotto.url_shortener.utils.UrlShortenerBase62;
import com.lotto.url_shortener.service.UrlService;
import com.mysql.jdbc.StringUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by iosinsky on 31.03.2018.
 */
@RestController
public class UrlShortRetrievalController {
    @Autowired
    UrlService urlService;

    @RequestMapping("/lotto.lt/**")
    public RedirectView urlShortRetreival(HttpServletRequest request, RedirectAttributes attributes) {
        String mvcPath = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        String[] pathParts = mvcPath.split("/");
        String shortUrlSuffix = pathParts[pathParts.length - 1];
        String regularUrl = urlService.getUrlRegular(shortUrlSuffix);
//        if (StringUtils.isNullOrEmpty(regularUrl)) {
//return ResponseEntity.badRequest();
//        }
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView(regularUrl);

        // return new RedirectView("https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html");
        // return   ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html").build();
//      String x=  UrlShortenerBase62.fromBase10(9897919989199l);
//        Long y = UrlShortenerBase62.toBase10(x);
//     //   urlService.test();/// test temp to delete
//        return x+"1Greetings  Spring Boot"+y;
    }

}
