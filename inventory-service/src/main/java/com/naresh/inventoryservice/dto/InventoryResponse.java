package com.naresh.inventoryservice.dto;

public class InventoryResponse {
  private String skuCode;
  private boolean isInStock;
  private Integer quantity;

  public InventoryResponse() {}

  public InventoryResponse(String skuCode, boolean isInStock, Integer quantity) {
    this.skuCode = skuCode;
    this.isInStock = isInStock;
    this.quantity = quantity;
  }

  public String getSkuCode() { return skuCode; }
  public void setSkuCode(String skuCode) { this.skuCode = skuCode; }
  public boolean isInStock() { return isInStock; }
  public void setInStock(boolean inStock) { isInStock = inStock; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
