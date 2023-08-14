package com.abuseariah.newscraper.models;

import lombok.Data;

@Data
public class Article {
    private String title;
    private String description;
    private String url;
}
