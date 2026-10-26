package com.naresh.orderservice;

import com.naresh.orderservice.client.InventoryClient;
import com.naresh.orderservice.client.InventoryResponse;
import com.naresh.orderservice.dto.OrderRequest;
import com.naresh.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

  static class FakeInventoryClient implements InventoryClient {
    private final boolean inStock;
    private final int qty;

    FakeInventoryClient(boolean inStock, int qty) {
      this.inStock = inStock;
      this.qty = qty;
    }

    @Override
    public InventoryResponse getInventory(String skuCode) {
      InventoryResponse r = new InventoryResponse();
      r.setSkuCode(skuCode);
      r.setInStock(inStock);
      r.setQuantity(qty);
      return r;
    }
  }

  @Test
  void placeOrderWhenInStock() {
    OrderService service = new OrderService(new FakeInventoryClient(true, 10));
    OrderRequest req = new OrderRequest();
    req.setSkuCode("IPHONE-15");
    req.setQuantity(1);
    req.setUserEmail("test@example.com");
    var res = service.placeOrder(req);
    assertEquals("PLACED", res.getStatus());
    assertNotNull(res.getOrderNumber());
  }

  @Test
  void rejectWhenOutOfStock() {
    OrderService service = new OrderService(new FakeInventoryClient(false, 0));
    OrderRequest req = new OrderRequest();
    req.setSkuCode("IPHONE-15");
    req.setQuantity(1);
    var res = service.placeOrder(req);
    assertEquals("REJECTED", res.getStatus());
  }

  @Test
  void rejectWhenQuantityExceeds() {
    OrderService service = new OrderService(new FakeInventoryClient(true, 2));
    OrderRequest req = new OrderRequest();
    req.setSkuCode("IPHONE-15");
    req.setQuantity(5);
    var res = service.placeOrder(req);
    assertEquals("REJECTED", res.getStatus());
  }
}
