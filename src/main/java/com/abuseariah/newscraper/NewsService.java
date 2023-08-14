package com.abuseariah.newscraper;

import com.abuseariah.newscraper.models.Article;
import com.abuseariah.newscraper.models.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class NewsService {


    @Autowired
    NewsApiClient newsApiClient= new NewsApiClient();

    public List<Article> searchArticles(String query,int page) {
        int itemsPerPage = 5;
        int startIndex=(page)* itemsPerPage;
        int endIndex = startIndex+itemsPerPage;
        NewsResponse response = newsApiClient.getNewsByKeyword(query);
        List<Article> test=response.getArticles();
        List<Article> extract= new java.util.ArrayList<Article>();
        for(int i=startIndex;i<Math.min(endIndex,test.size());i++){
            extract.add(test.get(i));
        }
        return extract;
    }

    public NewsResponse listArticles() {

        return  newsApiClient.listArticle();
    }
}
