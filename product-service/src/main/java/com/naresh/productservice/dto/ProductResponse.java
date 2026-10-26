package com.naresh.productservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {
  private Long id;
  private String sku;
  private String name;
  private String description;
  private BigDecimal price;
  private String category;
  private boolean active;
}
