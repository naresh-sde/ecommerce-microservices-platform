package com.naresh.productservice.service;

import com.naresh.productservice.dto.ProductRequest;
import com.naresh.productservice.dto.ProductResponse;
import com.naresh.productservice.model.Product;
import com.naresh.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public ProductResponse create(ProductRequest request) {
    if (productRepository.existsBySku(request.getSku())) {
      throw new IllegalArgumentException("Product with sku already exists");
    }
    Product product = Product.builder()
      .sku(request.getSku())
      .name(request.getName())
      .description(request.getDescription())
      .price(request.getPrice())
      .category(request.getCategory())
      .active(request.isActive())
      .build();
    Product saved = productRepository.save(product);
    return map(saved);
  }

  public ProductResponse getById(Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Product not found"));
    return map(product);
  }

  public List<ProductResponse> getAll() {
    return productRepository.findAll().stream().map(this::map).collect(Collectors.toList());
  }

  private ProductResponse map(Product product) {
    return ProductResponse.builder()
      .id(product.getId())
      .sku(product.getSku())
      .name(product.getName())
      .description(product.getDescription())
      .price(product.getPrice())
      .category(product.getCategory())
      .active(product.isActive())
      .build();
  }
}
