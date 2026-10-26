package com.naresh.productservice.controller;

import com.naresh.productservice.dto.ProductRequest;
import com.naresh.productservice.dto.ProductResponse;
import com.naresh.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponse create(@Valid @RequestBody ProductRequest request) {
    return productService.create(request);
  }

  @GetMapping
  public List<ProductResponse> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public ProductResponse getById(@PathVariable Long id) {
    return productService.getById(id);
  }
}
