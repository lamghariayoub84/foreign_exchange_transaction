package com.forxt.foreign_exchange_transaction.controller;

import com.forxt.foreign_exchange_transaction.dto.DealRequestDto;
import com.forxt.foreign_exchange_transaction.model.Fx_deal;
import com.forxt.foreign_exchange_transaction.service.FXDealService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fx-deals")
public class FXDealController {
    private final FXDealService fxDealService;

    public FXDealController(FXDealService fxDealService) {
        this.fxDealService = fxDealService;
    }
    @PostMapping
    public ResponseEntity<?> addDeal(@RequestBody  DealRequestDto dto) {
            Fx_deal saved = fxDealService.saveDeal(dto);
            return ResponseEntity.ok(saved);
    }

}
