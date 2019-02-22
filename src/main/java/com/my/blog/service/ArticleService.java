package com.my.blog.service;

import com.my.blog.entity.Article;
import com.my.blog.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {
    Article get(Article record);

    Article edit(Article record);

    Page<Article> get(User user);
}
