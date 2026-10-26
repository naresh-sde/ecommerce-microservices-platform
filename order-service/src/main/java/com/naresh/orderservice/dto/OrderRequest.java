package com.naresh.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderRequest {
  @NotBlank
  private String skuCode;
  @Min(1)
  private int quantity;
  private String userEmail;

  public String getSkuCode() { return skuCode; }
  public void setSkuCode(String skuCode) { this.skuCode = skuCode; }
  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) { this.quantity = quantity; }
  public String getUserEmail() { return userEmail; }
  public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}
