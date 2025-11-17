package com.forxt.foreign_exchange_transaction.service;

import com.forxt.foreign_exchange_transaction.dto.DealRequestDto;
import com.forxt.foreign_exchange_transaction.model.Fx_deal;
import com.forxt.foreign_exchange_transaction.repository.FxDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FXDealService {


    private final FxDealRepository fxDealRepository;
    private final FXDealImportService fxDealImportService;
    private final IsoListeService isoListeService;

    public FXDealService(FxDealRepository fxDealRepository,FXDealImportService fxDealImportService,IsoListeService isoListeService) {
       this.fxDealImportService = fxDealImportService;
       this.isoListeService = isoListeService;
       this.fxDealRepository=fxDealRepository;
    }




    public Fx_deal saveDeal(DealRequestDto dealRequestDto) {

        ArrayList<String> iso = isoListeService.getlistISO();


        if (dealRequestDto.getDealUniqueid() == null || dealRequestDto.getDealUniqueid().isEmpty()) {
            throw new IllegalArgumentException("Deal unique ID is missing");
        }


        Optional<Fx_deal> existing = fxDealRepository.findByDealUniqueId(dealRequestDto.getDealUniqueid());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Deal already exists with ID: " + dealRequestDto.getDealUniqueid());
        }


        if (!iso.contains(dealRequestDto.getFromCurrency())) {
            throw new IllegalArgumentException("Invalid fromCurrency ISO: " + dealRequestDto.getFromCurrency());
        }

        if (!iso.contains(dealRequestDto.getToCurrency())) {
            throw new IllegalArgumentException("Invalid toCurrency ISO: " + dealRequestDto.getToCurrency());
        }


        if (dealRequestDto.getFromCurrency().equals(dealRequestDto.getToCurrency())) {
            throw new IllegalArgumentException("fromCurrency and toCurrency must be different");
        }


        Fx_deal deal = new Fx_deal(
                dealRequestDto.getDealUniqueid(),
                dealRequestDto.getFromCurrency(),
                dealRequestDto.getToCurrency(),
                dealRequestDto.getDealTimestamp(),
                dealRequestDto.getAmount()
        );


        return fxDealRepository.save(deal);
    }

}
