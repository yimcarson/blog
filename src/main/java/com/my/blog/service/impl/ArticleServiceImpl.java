package com.my.blog.service.impl;

import com.my.blog.entity.Article;
import com.my.blog.entity.User;
import com.my.blog.repository.ArticleRepository;
import com.my.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article get(Article record) {
        Example<Article> example = Example.of(record);
        Optional<Article> articleOptional = articleRepository.findOne(example);
        return articleOptional.get();
    }

    @Override
    public Article edit(Article record) {
        return articleRepository.save(record);
    }

    @Override
    public Page<Article> get(User user) {
        Example<Article> example = Example.of(new Article.Builder().user(user).build());
        int page = 1;
        int limit = 10;
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.Direction.DESC,"id");
        Page<Article> articlePage = articleRepository.findAll(example, pageable);
        return articlePage;
    }
}
