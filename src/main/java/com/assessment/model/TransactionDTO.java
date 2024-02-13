package com.assessment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.TemporalType;

public class TransactionDTO {
  private int points;
  private String name;
  private Double amount;
  private Date createdAt;
public TransactionDTO() {
}
public TransactionDTO(int points, String name, Double amount, Date createdAt) {
    this.points = points;
    this.name = name;
    this.amount = amount;
    this.createdAt = createdAt;
}
public int getPoints() {
    return points;
}
public void setPoints(int points) {
    this.points = points;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public Double getAmount() {
    return amount;
}
public void setAmount(Double amount) {
    this.amount = amount;
}
public Date getCreatedAt() {
    return createdAt;
}
public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
}
@Override
public String toString() {
    return "TransactionDTO [points=" + points + ", name=" + name + ", amount=" + amount + ", createdAt=" + createdAt
            + "]";
}

  
}