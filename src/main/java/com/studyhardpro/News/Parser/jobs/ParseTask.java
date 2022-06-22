package com.studyhardpro.News.Parser.jobs;

import com.studyhardpro.News.Parser.models.News;
import com.studyhardpro.News.Parser.services.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 20000)
    public void parseNews() {
        String url = "https://news.ycombinator.com";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(50000)
                    .referrer("https://google.com")
                    .get();
            System.out.println("DOWNLOADED DOC");

            Elements news = doc.getElementsByClass("titlelink");
            for (Element element: news) {
                String title = element.ownText();
                if (!newsService.isAlreadySaved(title)) {
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FINISHED ADDING TO DATABASE");
    }
}
