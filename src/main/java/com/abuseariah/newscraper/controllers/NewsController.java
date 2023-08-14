package com.abuseariah.newscraper.controllers;


import com.abuseariah.newscraper.NewsService;
import com.abuseariah.newscraper.models.Article;
import com.abuseariah.newscraper.models.NewsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class NewsController {


    @GetMapping("/news")
    public String getNews(Model model, NewsService newsService) {
        NewsResponse response = newsService.listArticles();
        model.addAttribute("articles", response.getArticles());
        return "news";
    }
    @GetMapping("/search")
    public ResponseEntity<List<Article>> searchNews(@RequestParam String query, @RequestParam(defaultValue = "1") int page,NewsService newsService) {
        List<Article> searchResults = newsService.searchArticles(query,page);

        return ResponseEntity.ok(searchResults);
    }
}