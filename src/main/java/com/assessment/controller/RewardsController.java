package com.assessment.controller;

import java.util.Date;
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

    @RequestMapping("/addRewardsData")
    public void addRewardsData(){
        Transaction transaction1 = new Transaction("Customer 1",120.00d, new Date());
        transactionRepository.save(transaction1);
    }
    
    @RequestMapping("/getRewardsData")
        public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
