package com.naresh.productservice.dto;

import java.math.BigDecimal;

public class ProductResponse {
  private Long id;
  private String sku;
  private String name;
  private String description;
  private BigDecimal price;
  private String category;
  private boolean active;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getSku() { return sku; }
  public void setSku(String sku) { this.sku = sku; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }
  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }
  public boolean isActive() { return active; }
  public void setActive(boolean active) { this.active = active; }
}
