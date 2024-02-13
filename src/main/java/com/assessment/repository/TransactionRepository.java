package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
