package com.abuseariah.newscraper;

import com.abuseariah.newscraper.models.Article;
import com.abuseariah.newscraper.models.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsService {


    @Autowired
    NewsApiClient newsApiClient= new NewsApiClient();

    public List<Article> searchArticles(String query) {
        NewsResponse response = newsApiClient.getNewsByKeyword(query);
        return response.getArticles();
    }

    public NewsResponse listArticles() {

        return  newsApiClient.listArticle();
    }
}
