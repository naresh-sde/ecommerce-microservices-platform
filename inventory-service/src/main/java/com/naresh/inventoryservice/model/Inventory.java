package com.naresh.inventoryservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String skuCode;
  private Integer quantity;

  public Inventory() {}

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getSkuCode() { return skuCode; }
  public void setSkuCode(String skuCode) { this.skuCode = skuCode; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
