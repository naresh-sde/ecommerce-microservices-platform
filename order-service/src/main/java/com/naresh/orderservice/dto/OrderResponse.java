package com.naresh.orderservice.dto;

public class OrderResponse {
  private String orderNumber;
  private String status;
  private String message;

  public OrderResponse(String orderNumber, String status, String message) {
    this.orderNumber = orderNumber;
    this.status = status;
    this.message = message;
  }

  public String getOrderNumber() { return orderNumber; }
  public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }
}
