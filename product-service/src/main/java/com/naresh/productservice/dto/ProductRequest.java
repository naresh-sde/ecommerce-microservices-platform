package com.naresh.productservice.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductRequest {
  @NotBlank
  private String sku;
  @NotBlank
  private String name;
  private String description;
  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  private BigDecimal price;
  private String category;
  private boolean active = true;

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
