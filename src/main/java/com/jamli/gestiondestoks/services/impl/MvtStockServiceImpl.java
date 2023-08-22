package com.jamli.gestiondestoks.services.impl;

import com.jamli.gestiondestoks.dto.MvtStockDto;
import com.jamli.gestiondestoks.exeption.ErrorCodes;
import com.jamli.gestiondestoks.exeption.InvalidEntityException;
import com.jamli.gestiondestoks.model.TypeMvtStk;
import com.jamli.gestiondestoks.repository.MvtStockRepository;
import com.jamli.gestiondestoks.services.srategy.ArticleService;
import com.jamli.gestiondestoks.services.srategy.MvtStockService;
import com.jamli.gestiondestoks.validator.MvtStockValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStockServiceImpl implements MvtStockService {
    private MvtStockRepository repository;
    private ArticleService articleService;

    @Autowired
    public MvtStockServiceImpl(MvtStockRepository repository, ArticleService articleService) {
        this.repository = repository;
        this.articleService = articleService;
    }
    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        if (idArticle == null) {
            log.warn("ID article is NULL");
            return BigDecimal.valueOf(-1);
        }
        articleService.findById(idArticle);
        return repository.stockReelArticle(idArticle);
    }

    @Override
    public List<MvtStockDto> mvtStkArticle(Integer idArticle) {
        return repository.findAllByArticleId(idArticle).stream()
                .map(MvtStockDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MvtStockDto entreeStock(MvtStockDto dto) {

        return entreePositive(dto, TypeMvtStk.ENTREE);
    }

    private MvtStockDto entreePositive(MvtStockDto dto, TypeMvtStk typeMvtStk) {
        List<String> errors = MvtStockValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue())
                )
        );
        dto.setTypeMvt(typeMvtStk);
        return MvtStockDto.fromEntity(
                repository.save(MvtStockDto.toEntity(dto))
        );
    }


    @Override
    public MvtStockDto sortieStock(MvtStockDto dto) {
        return sortieNegative(dto, TypeMvtStk.SORTIE);
    }

    private MvtStockDto sortieNegative(MvtStockDto dto, TypeMvtStk typeMvtStk) {
        List<String> errors = MvtStockValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue()) * -1
                )
        );
        dto.setTypeMvt(typeMvtStk);
        return MvtStockDto.fromEntity(
                repository.save(MvtStockDto.toEntity(dto))
        );
    }

    @Override
    public MvtStockDto correctionStockPos(MvtStockDto dto) {
        return entreePositive(dto, TypeMvtStk.CORRECTION_POS);
    }
    @Override
    public MvtStockDto correctionStockNeg(MvtStockDto dto) {

        return sortieNegative(dto, TypeMvtStk.CORRECTION_NEG);
    }
}
