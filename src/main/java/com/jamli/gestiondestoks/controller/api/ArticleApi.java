package com.jamli.gestiondestoks.controller.api;

import com.jamli.gestiondestoks.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.jamli.gestiondestoks.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/Article")
public interface ArticleApi {

    @PostMapping(value=  APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregister un article",notes = "cette methode permet d'enregistrer un article",response =ArticleDto.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message = "l'objet article crèe/modifier"),
            @ApiResponse(code=400,message = "l'objet article n'est pas valide")
    })
    ArticleDto save( @RequestBody  ArticleDto articleDto);


    @GetMapping(value =  APP_ROOT +  "/articles/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="chercher un article par ID",notes = "cette methode permet de chercher  un article par son ID",response =ArticleDto.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message = "l'article a ete trouver dans la BDD"),
            @ApiResponse(code=404,message = "l'article n'exicte pas  dans la BDD avec l'id fourni")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer  id);

    @GetMapping(value =  APP_ROOT +  "/articles/code/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="chercher un article par  CODE",notes = "cette methode permet de chercher  un article par son CODE",response =ArticleDto.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message = "l'article a ete trouver dans la BDD"),
            @ApiResponse(code=404,message = "l'article n'exicte pas  dans la BDD avec le CODE fourni")
    })

    ArticleDto findByCodeArticle(@PathVariable("codeArticle")String codeArticle);

    @GetMapping(value =  APP_ROOT +  "/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="renvoi la liste des articles",notes = "cette methode permet de chercher et renvoyer la liste des article qui existe " + "dans la BDD",responseContainer = "List<ArticleDto>")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "La liste des article / Une liste vide"),

    })

    List<ArticleDto> findAll();
    @DeleteMapping(value = APP_ROOT +  "/articles/delete/{idArticle}")
    @ApiOperation(value="supprimer unh article pa Id",notes = "cette methode permet de supprimer un article par Id",response =ArticleDto.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message = "L'article a ete supprimer"),

    })

    void delete(@PathVariable("idArticle")  Integer id);
}