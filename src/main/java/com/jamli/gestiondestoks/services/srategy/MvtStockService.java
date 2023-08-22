package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.MvtStockDto;
import com.jamli.gestiondestoks.model.MvtStock;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStockService {
    BigDecimal stockReelArticle(Integer idArticle);

    List<MvtStockDto> mvtStkArticle(Integer idArticle);

    MvtStockDto entreeStock(MvtStockDto dto);

    MvtStockDto sortieStock(MvtStockDto dto);

    MvtStockDto correctionStockPos(MvtStockDto dto);

    MvtStockDto correctionStockNeg(MvtStockDto dto);


}
