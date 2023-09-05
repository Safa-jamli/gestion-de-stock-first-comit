package com.jamli.gestiondestoks.controller.api;

import com.jamli.gestiondestoks.dto.MvtStockDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

import static com.jamli.gestiondestoks.utils.Constants.APP_ROOT;

@Api("APP_ROOT + /mvtstock")
public interface MvtStockApi {
    @GetMapping(APP_ROOT + "/mvtstk/stockreel/{idArticle}")
    BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(APP_ROOT + "/mvtstock/filter/article/{idArticle}")
    List<MvtStockDto> mvtStkArticle(@PathVariable("idArticle") Integer idArticle);

    @PostMapping(APP_ROOT + "/mvtstock/entree")
    MvtStockDto entreeStock(@RequestBody MvtStockDto dto);

    @PostMapping(APP_ROOT + "/mvtstock/sortie")
    MvtStockDto sortieStock(@RequestBody MvtStockDto dto);

    @PostMapping(APP_ROOT + "/mvtstock/correctionpos")
    MvtStockDto correctionStockPos(@RequestBody MvtStockDto dto);

    @PostMapping(APP_ROOT + "/mvtstock/correctionneg")
    MvtStockDto correctionStockNeg(@RequestBody MvtStockDto dto);

}


