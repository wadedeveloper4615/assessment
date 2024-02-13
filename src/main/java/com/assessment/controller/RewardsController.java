package com.assessment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.model.*;
import com.assessment.repository.TransactionRepository;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class RewardsController {
    @Autowired
    private TransactionRepository transactionRepository;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

    @GetMapping("/addRewardsData")
    public ResponseEntity<String> addRewardsData() throws ParseException{
        Transaction transaction1 = new Transaction("Customer 1",120.00d, format.parse("2023-11-11"));
        Transaction transaction2 = new Transaction("Customer 1",120.00d, format.parse("2023-11-12"));

        Transaction transaction3 = new Transaction("Customer 1",120.00d, format.parse("2023-12-11"));
        Transaction transaction4 = new Transaction("Customer 1",120.00d, format.parse("2023-12-12"));

        Transaction transaction5 = new Transaction("Customer 1",120.00d, format.parse("2024-01-11"));
        Transaction transaction6 = new Transaction("Customer 1",120.00d, format.parse("2024-01-12"));

        Transaction transaction7 = new Transaction("Customer 1",120.00d, format.parse("2024-02-11"));
        Transaction transaction8 = new Transaction("Customer 1",120.00d, format.parse("2024-02-12"));

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        transactionRepository.save(transaction3);
        transactionRepository.save(transaction4);
        transactionRepository.save(transaction5);
        transactionRepository.save(transaction6);
        transactionRepository.save(transaction7);
        transactionRepository.save(transaction8);

        return ResponseEntity.ok().body("OK");
    }
    
    @GetMapping("/getRewardsData")
        public Collection<TransactionDTO> getAllTransactions() throws ParseException {
            Collection<Transaction> data = transactionRepository.findAllTransactionsByNameAndDate("Customer 1",format.parse("2023-11-11") );
            Collection<TransactionDTO> result = new ArrayList<>();
            for(Transaction t : data){
             Double temp = ((t.getAmount()-100.00)*2) + (t.getAmount()-50.00);
             int points = temp.intValue();
             TransactionDTO obj = new TransactionDTO(points,t.getName(),t.getAmount(),t.getCreatedAt());
             result.add(obj);                
            }
            return result;
    }
}
