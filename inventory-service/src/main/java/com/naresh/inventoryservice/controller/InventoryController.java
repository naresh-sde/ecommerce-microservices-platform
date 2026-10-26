package com.naresh.inventoryservice.controller;

import com.naresh.inventoryservice.dto.InventoryResponse;
import com.naresh.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
  private final InventoryService inventoryService;

  public InventoryController(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @GetMapping
  public InventoryResponse isInStock(@RequestParam String skuCode) {
    return inventoryService.isInStock(skuCode);
  }
}
