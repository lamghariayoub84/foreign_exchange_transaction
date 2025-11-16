package com.forxt.foreign_exchange_transaction.service;

import com.forxt.foreign_exchange_transaction.dto.DealRequestDto;
import com.forxt.foreign_exchange_transaction.model.Fx_deal;
import com.forxt.foreign_exchange_transaction.repository.FxDealRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class FXDealImportService {
    public ArrayList<String>  importCSV(File fileName) {
        ArrayList<String> listISO =new ArrayList<>() ;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                listISO.add(line.trim());
            }

        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return listISO;
    }
}
