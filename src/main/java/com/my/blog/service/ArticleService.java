package com.my.blog.service;

import com.my.blog.entity.Article;

public interface ArticleService {
    Article get(Article record);

    Article edit(Article record);
}
