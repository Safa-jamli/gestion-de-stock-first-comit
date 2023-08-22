package com.jamli.gestiondestoks.dto;

import com.jamli.gestiondestoks.model.MvtStock;
import com.jamli.gestiondestoks.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStockDto  {
    private Integer id;
    private ArticleDto article;
    private Instant dateMvt;
    private BigDecimal quantite;
    private TypeMvtStk typeMvt;
    private Integer idEntreprise;

    public static MvtStockDto fromEntity(MvtStock mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStockDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStock toEntity(MvtStockDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStock mvtStk = new MvtStock();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }
}

