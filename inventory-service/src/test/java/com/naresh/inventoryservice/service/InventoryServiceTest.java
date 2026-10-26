package com.naresh.inventoryservice.service;

import com.naresh.inventoryservice.dto.InventoryResponse;
import com.naresh.inventoryservice.model.Inventory;
import com.naresh.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

  @Mock
  private InventoryRepository inventoryRepository;

  @InjectMocks
  private InventoryService inventoryService;

  @Test
  void isInStockWhenAvailable() {
    Inventory inv = new Inventory();
    inv.setSkuCode("IPHONE-15");
    inv.setQuantity(10);
    when(inventoryRepository.findBySkuCode("IPHONE-15")).thenReturn(Optional.of(inv));
    InventoryResponse res = inventoryService.isInStock("IPHONE-15");
    assertTrue(res.isInStock());
    assertEquals(10, res.getQuantity());
  }

  @Test
  void notInStockWhenEmpty() {
    Inventory inv = new Inventory();
    inv.setSkuCode("IPHONE-15");
    inv.setQuantity(0);
    when(inventoryRepository.findBySkuCode("IPHONE-15")).thenReturn(Optional.of(inv));
    InventoryResponse res = inventoryService.isInStock("IPHONE-15");
    assertFalse(res.isInStock());
  }

  @Test
  void notInStockWhenMissing() {
    when(inventoryRepository.findBySkuCode("UNKNOWN")).thenReturn(Optional.empty());
    InventoryResponse res = inventoryService.isInStock("UNKNOWN");
    assertFalse(res.isInStock());
    assertEquals(0, res.getQuantity());
  }
}
