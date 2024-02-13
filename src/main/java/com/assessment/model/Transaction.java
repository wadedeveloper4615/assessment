package com.assessment.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "count")
  private int count;

  @Column(name = "points")
  private int points;

  @Column(name = "name")
  private String name;

  @Column(name = "amount", precision = 10, scale = 2)
  private Double amount;

  @Temporal(TemporalType.DATE)
  @Column(name = "created_at")
  private Date createdAt;

  public Transaction() {
  }

  public Transaction(int count, int points, String name, Double amount, Date createdAt) {
    this.count = count;
    this.points = points;
    this.name = name;
    this.amount = amount;
    this.createdAt = createdAt;
  }

  public Transaction(String name, Double amount, Date createdAt) {
    this.name = name;
    this.amount = amount;
    this.createdAt = createdAt;
  }

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
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
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
    @Override
    public String toString() {
      return "Transaction [id=" + id + ", count=" + count + ", points=" + points + ", name=" + name + ", amount="
          + amount + ", createdAt=" + createdAt + "]";
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public int getPoints() {
      return points;
    }

    public void setPoints(int points) {
      this.points = points;
    }
}
