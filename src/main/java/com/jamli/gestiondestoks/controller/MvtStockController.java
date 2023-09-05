package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.MvtStockApi;
import com.jamli.gestiondestoks.dto.MvtStockDto;
import com.jamli.gestiondestoks.services.srategy.MvtStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MvtStockController implements MvtStockApi {
    private MvtStockService mvtStockService;
    @Autowired
    public MvtStockController(MvtStockService mvtStockService){
        this.mvtStockService=mvtStockService;
    }
    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        return mvtStockService.stockReelArticle(idArticle);
    }

    @Override
    public List<MvtStockDto> mvtStkArticle(Integer idArticle) {
        return mvtStockService.mvtStkArticle(idArticle);
    }

    @Override
    public MvtStockDto entreeStock(MvtStockDto dto) {
        return mvtStockService.entreeStock(dto);
    }

    @Override
    public MvtStockDto sortieStock(MvtStockDto dto) {

        return mvtStockService.sortieStock(dto);
    }

    @Override
    public MvtStockDto correctionStockPos(MvtStockDto dto) {

        return mvtStockService.correctionStockPos(dto);
    }

    @Override
    public MvtStockDto correctionStockNeg(MvtStockDto dto) {

        return mvtStockService.correctionStockNeg(dto);
    }
}

