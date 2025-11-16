package com.forxt.foreign_exchange_transaction;

import com.forxt.foreign_exchange_transaction.service.IsoListeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.forxt.foreign_exchange_transaction.service.FXDealImportService;

import java.io.File;
import java.util.ArrayList;

@SpringBootApplication
public class ForeignExchangeTransactionApplication {
    private final IsoListeService isoListeService;
    public ForeignExchangeTransactionApplication(IsoListeService isoListeService) {
        this.isoListeService = isoListeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ForeignExchangeTransactionApplication.class, args);
    }
    @Bean
    CommandLineRunner run(FXDealImportService importService) {
        return  args -> {
            ArrayList<String> listISO = new ArrayList<>();
            File filepath  = new File("iso_currency_codes_only.csv") ;
            listISO.addAll(importService.importCSV(filepath));
            isoListeService.getlistISO().addAll(listISO);

        };
    }




}
