package com.my.blog.service;

import com.my.blog.entity.Article;
import com.my.blog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testGet() {
        Page<Article> article = articleService.get(new User.Builder().username("Carson").build());
        System.out.println(article);
    }

    @Test
    public void testEdit() {
        Article article = articleService.edit(new Article.Builder()
//                .id(1L)
                .title("test")
                .content("Hello")
                .isDelete(false)
                .build());
        System.out.println(article);
    }
}
