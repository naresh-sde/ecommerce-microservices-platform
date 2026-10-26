package com.naresh.inventoryservice.service;

import com.naresh.inventoryservice.dto.InventoryResponse;
import com.naresh.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public InventoryResponse isInStock(String skuCode) {
    return inventoryRepository.findBySkuCode(skuCode)
      .map(inv -> new InventoryResponse(skuCode, inv.getQuantity() != null && inv.getQuantity() > 0, inv.getQuantity()))
      .orElse(new InventoryResponse(skuCode, false, 0));
  }
}
