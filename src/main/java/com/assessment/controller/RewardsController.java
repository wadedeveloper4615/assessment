package com.assessment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.model.Transaction;
import com.assessment.repository.TransactionRepository;

@RestController
public class RewardsController {
    @Autowired
    private TransactionRepository transactionRepository;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping("/addRewardsData")
    public void addRewardsData() throws ParseException{
        Transaction transaction1 = new Transaction("Customer 1",120.00d, format.parse("02/13/2024"));
        Transaction transaction2 = new Transaction("Customer 1",120.00d, format.parse("02/14/2024"));

        Transaction transaction3 = new Transaction("Customer 1",120.00d, format.parse("03/13/2024"));
        Transaction transaction4 = new Transaction("Customer 1",120.00d, format.parse("03/14/2024"));

        Transaction transaction5 = new Transaction("Customer 1",120.00d, format.parse("04/13/2024"));
        Transaction transaction6 = new Transaction("Customer 1",120.00d, format.parse("04/14/2024"));

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        transactionRepository.save(transaction3);
        transactionRepository.save(transaction4);
        transactionRepository.save(transaction5);
        transactionRepository.save(transaction6);
    }
    
    @RequestMapping("/getRewardsData")
        public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
