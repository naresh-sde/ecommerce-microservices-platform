package com.naresh.productservice.service;

import com.naresh.productservice.dto.ProductRequest;
import com.naresh.productservice.dto.ProductResponse;
import com.naresh.productservice.model.Product;
import com.naresh.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  @Test
  void createProductSuccess() {
    ProductRequest req = new ProductRequest();
    req.setSku("IPHONE-15");
    req.setName("iPhone 15");
    req.setPrice(new BigDecimal("79999"));
    req.setActive(true);

    when(productRepository.existsBySku("IPHONE-15")).thenReturn(false);
    when(productRepository.save(any(Product.class))).thenAnswer(inv -> {
      Product p = inv.getArgument(0);
      p.setId(1L);
      return p;
    });

    ProductResponse res = productService.create(req);
    assertNotNull(res);
    assertEquals("IPHONE-15", res.getSku());
    assertEquals(1L, res.getId());
  }

  @Test
  void getProductById() {
    Product p = new Product();
    p.setId(1L);
    p.setSku("IPHONE-15");
    p.setName("iPhone 15");
    p.setPrice(new BigDecimal("79999"));
    p.setActive(true);

    when(productRepository.findById(1L)).thenReturn(Optional.of(p));
    ProductResponse res = productService.getById(1L);
    assertEquals("IPHONE-15", res.getSku());
  }
}
