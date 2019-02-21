package com.my.blog.controller;

import com.my.blog.entity.Article;
import com.my.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/{username}/article/{id}")
    public String get(@PathVariable("id") String id,
                      @PathVariable("username") String username,
                      Model model) {
        Article article = articleService.get(new Article.Builder().id(Long.valueOf(id)).build());
        logger.debug("article:{}", article);
        model.addAttribute("article", article);
        return "article";
    }
}
