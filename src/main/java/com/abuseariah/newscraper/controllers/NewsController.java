package com.abuseariah.newscraper.controllers;


import com.abuseariah.newscraper.models.NewsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NewsController {

    private final String apiKey = "7cb888c51dd248f5ae8e4b3d2c0b67e3"; // Replace with your API key

    @GetMapping("/news")
    public String getNews(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + apiKey;

        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
        model.addAttribute("articles", response.getArticles());

        return "news";
    }
}