package com.naresh.orderservice.controller;

import com.naresh.orderservice.dto.OrderRequest;
import com.naresh.orderservice.dto.OrderResponse;
import com.naresh.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderResponse placeOrder(@Valid @RequestBody OrderRequest request) {
    return orderService.placeOrder(request);
  }
}
