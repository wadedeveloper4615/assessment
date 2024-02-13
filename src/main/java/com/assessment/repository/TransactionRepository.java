package com.assessment.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assessment.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
   @Query(value = "SELECT t FROM Transaction t where t.name = :name and t.createdAt >= :start")
   Collection<Transaction> findAllTransactionsByNameAndDate(@Param("name") String name, @Param("start")Date start);
}
