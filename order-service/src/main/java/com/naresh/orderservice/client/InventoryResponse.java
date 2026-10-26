package com.naresh.orderservice.client;

public class InventoryResponse {
  private String skuCode;
  private boolean isInStock;
  private Integer quantity;

  public String getSkuCode() { return skuCode; }
  public void setSkuCode(String skuCode) { this.skuCode = skuCode; }
  public boolean isInStock() { return isInStock; }
  public void setInStock(boolean inStock) { isInStock = inStock; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
