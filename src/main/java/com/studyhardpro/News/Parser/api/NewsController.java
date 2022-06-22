package com.studyhardpro.News.Parser.api;

import com.studyhardpro.News.Parser.models.News;
import com.studyhardpro.News.Parser.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping(value = "/news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
