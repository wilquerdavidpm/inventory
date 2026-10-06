package com.example.product_service.service;

import com.example.product_service.dto.ProductRequestDTO;
import com.example.product_service.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(String id);
    void deleteProduct(String id);
}
