package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assessment.exception.ResourceNotFoundException;
import com.assessment.model.Transaction;
import com.assessment.repository.TransactionRepository;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TransactionController {
  @Autowired
  private TransactionRepository transactionRepository;

  @GetMapping("/transaction")
  public List<Transaction> getAllTransactions() {
    return transactionRepository.findAll();
  }

  @GetMapping("/transaction/{id}")
  public ResponseEntity<Transaction> getTransactionsById(@PathVariable(value = "id") long transactionId)
      throws ResourceNotFoundException {
    Transaction transaction =
    transactionRepository
            .findById(transactionId)
            .orElseThrow(() -> new ResourceNotFoundException("Transaction not found on :: " + transactionId));
    return ResponseEntity.ok().body(transaction);
  }

  @PostMapping("/transaction")
  public Transaction createUser(@Valid @RequestBody Transaction transaction) {
    if (transaction!=null){
            return transactionRepository.save(transaction);
    } else {
            return null;
    }
  }
}
