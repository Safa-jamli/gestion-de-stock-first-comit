package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;


}
