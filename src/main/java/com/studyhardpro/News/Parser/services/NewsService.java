package com.studyhardpro.News.Parser.services;

import com.studyhardpro.News.Parser.models.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    public void save(News news);
    public boolean isAlreadySaved(String newsTitle);
    public List<News> getAllNews();
}
