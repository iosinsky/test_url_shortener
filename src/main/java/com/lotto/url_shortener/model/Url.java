package com.lotto.url_shortener.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by iosinsky on 01.04.2018.
 */
@Entity
@Table//(name="url")
public class Url implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column//(nullable = false)
    @JsonProperty
    private String shortUrlSuffix;

    @Column//(nullable = false)
    @JsonProperty
    private String regularUrl;

    // no-args constructor required by JPA spec and it is protected not to be used directly
    protected Url() {
    }

    public Url(String regularUrl, String shortUrlSuffix) {
        this.regularUrl = regularUrl;
        this.shortUrlSuffix = shortUrlSuffix;
    }

    public Url(String regularUrl) {
        this.regularUrl = regularUrl;
        this.shortUrlSuffix = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrlSuffix() {
        return shortUrlSuffix;
    }

    public void setShortUrlSuffix(String shortUrlSuffix) {
        this.shortUrlSuffix = shortUrlSuffix;
    }

    public String getRegularUrl() {
        return regularUrl;
    }

    public void setRegularUrl(String regularUrl) {
        this.regularUrl = regularUrl;
    }
}
