package com.naresh.orderservice.service;

import com.naresh.orderservice.client.InventoryClient;
import com.naresh.orderservice.client.InventoryResponse;
import com.naresh.orderservice.dto.OrderRequest;
import com.naresh.orderservice.dto.OrderResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
  private final InventoryClient inventoryClient;

  public OrderService(InventoryClient inventoryClient) {
    this.inventoryClient = inventoryClient;
  }

  @CircuitBreaker(name = "inventory", fallbackMethod = "placeOrderFallback")
  public OrderResponse placeOrder(OrderRequest request) {
    InventoryResponse inventory = inventoryClient.getInventory(request.getSkuCode());
    if (inventory != null && inventory.isInStock() && inventory.getQuantity() >= request.getQuantity()) {
      String orderNumber = UUID.randomUUID().toString();
      return new OrderResponse(orderNumber, "PLACED", "Order placed successfully");
    }
    return new OrderResponse(null, "REJECTED", "Product out of stock");
  }

  public OrderResponse placeOrderFallback(OrderRequest request, Exception ex) {
    return new OrderResponse(null, "PENDING_CONFIRMATION", "Inventory service unavailable. Order queued for confirmation.");
  }
}
