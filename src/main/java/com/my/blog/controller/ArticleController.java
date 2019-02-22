package com.my.blog.controller;

import com.my.blog.entity.Article;
import com.my.blog.entity.User;
import com.my.blog.service.ArticleService;
import com.my.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{username}/article/{id}")
    public String get(@PathVariable("id") Long id,
                      @PathVariable("username") String username,
                      Model model) {
        User user = userService.get(new User.Builder()
                .username(username)
                .build());
        Article article = articleService.get(new Article.Builder()
                .id(id)
                .user(user)
                .build());
        logger.debug("article:{}", article);
        model.addAttribute("article", article);
        return "articleInfo";
    }

    @RequestMapping(value = "/{username}/article")
    public String list(@PathVariable("username") String username,
                      Model model) {
        User user = userService.get(new User.Builder()
                .username(username)
                .build());
        Page<Article> articlePage = articleService.get(user);
        logger.debug("article:{}", articlePage);
        model.addAttribute("articlePage", articlePage);
        model.addAttribute("user", user);
        return "articleList";
    }
}
