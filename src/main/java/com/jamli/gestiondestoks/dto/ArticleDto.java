package com.jamli.gestiondestoks.dto;

import com.jamli.gestiondestoks.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {
    private Integer id;
    private String codeActicle;
    private String description;
    private BigDecimal prixUnitairehtva;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTC;
    private String photo;
    private CategoryDto category;
    private Integer idEntreprise;
    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeActicle(article.getCodeArticle())
                .description(article.getDescription())
                .photo(article.getPhoto())
                .prixUnitairehtva(article.getPrixUnitairehtva())
                .prixUnitaireTC(article.getPrixUnitaireTC())
                .tauxTva(article.getTauxTva())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeActicle());
        article.setDescription(articleDto.getDescription());
        article.setPhoto(articleDto.getPhoto());
        article.setPrixUnitairehtva(articleDto.getPrixUnitairehtva());
        article.setPrixUnitaireTC(articleDto.getPrixUnitaireTC());
        article.setTauxTva(articleDto.getTauxTva());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        return article;
    }

}
