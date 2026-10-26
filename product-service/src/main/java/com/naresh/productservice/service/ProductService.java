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
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductResponse create(ProductRequest request) {
    if (productRepository.existsBySku(request.getSku())) {
      throw new IllegalArgumentException("Product with sku already exists");
    }
    Product product = new Product();
    product.setSku(request.getSku());
    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    product.setCategory(request.getCategory());
    product.setActive(request.isActive());
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
    ProductResponse response = new ProductResponse();
    response.setId(product.getId());
    response.setSku(product.getSku());
    response.setName(product.getName());
    response.setDescription(product.getDescription());
    response.setPrice(product.getPrice());
    response.setCategory(product.getCategory());
    response.setActive(product.isActive());
    return response;
  }
}
