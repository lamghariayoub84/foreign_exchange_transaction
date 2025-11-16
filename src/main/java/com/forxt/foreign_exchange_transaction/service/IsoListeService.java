package com.forxt.foreign_exchange_transaction.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IsoListeService {
    private final ArrayList<String> isoListe=new ArrayList<>();

    public ArrayList<String> getlistISO()
    {
        return isoListe;
    }
}
