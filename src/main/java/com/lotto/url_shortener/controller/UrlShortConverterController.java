package com.lotto.url_shortener.controller;

import com.lotto.url_shortener.service.UrlService;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by iosinsky on 02.04.2018.
 */
@RestController
public class UrlShortConverterController {

    @Autowired
    UrlService urlService;

    @RequestMapping("/shorturl/convert")
        public ResponseEntity<String> createShortUrl(@RequestParam("url") String url) {
        if (!validateUrl(url)) {
            return new ResponseEntity("invalid url", HttpStatus.PRECONDITION_FAILED);
        }
        String responseMessage = String.format("new short url is %s ", urlService.addNewUrlShort(url));
        return new ResponseEntity(responseMessage, HttpStatus.OK);
    }

    public boolean validateUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        if (urlValidator.isValid(url)) {
            return true;
        } else {
            return false;
        }
    }

}
