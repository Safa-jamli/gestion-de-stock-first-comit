package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.ArticleApi;
import com.jamli.gestiondestoks.dto.ArticleDto;
import com.jamli.gestiondestoks.services.srategy.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {
   //field injection
    private ArticleService articleService;

   //setter injection
    //@Autowired
    //public void setArticleService(ArticleService articleService) {
       // this.articleService = articleService;

    //constructeur injection
    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService=articleService;

    }


    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto) ;
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
      articleService.delete(id);
    }
}
