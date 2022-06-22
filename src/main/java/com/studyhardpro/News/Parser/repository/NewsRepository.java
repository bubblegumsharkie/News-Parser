package com.studyhardpro.News.Parser.repository;

import com.studyhardpro.News.Parser.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
