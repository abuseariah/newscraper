package com.abuseariah.newscraper;

import com.abuseariah.newscraper.models.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class NewsApiClient {
    private final String apiKey = "7cb888c51dd248f5ae8e4b3d2c0b67e3"; // Replace with your API key
    private final String baseUrl = "https://newsapi.org/v2/";
    private final String topHeadlinesUrl = baseUrl + "top-headlines?country=us&apiKey=" + apiKey;


    RestTemplate restTemplate= new RestTemplate();

    public NewsResponse getNewsByKeyword(String query) {
        restTemplate = new RestTemplate();
        NewsResponse response=restTemplate.getForObject(baseUrl+"everything?q="+query+"&apiKey="+apiKey,NewsResponse.class);
        return response;
    }
    public NewsResponse listArticle() {
        restTemplate = new RestTemplate();
        NewsResponse response=restTemplate.getForObject(topHeadlinesUrl,NewsResponse.class);
        return response;
    }

}
