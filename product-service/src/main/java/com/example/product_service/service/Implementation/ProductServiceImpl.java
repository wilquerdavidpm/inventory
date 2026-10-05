package com.example.product_service.service.Implementation;

import com.example.product_service.dto.ProductRequestDTO;
import com.example.product_service.dto.ProductResponseDTO;
import com.example.product_service.exception.ResourceNotFoundException;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        Product product = productMapper.toProduct(productRequestDTO);
        Product savedProduct = productRepository.save(product);

        return productMapper.toProductResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequestDTO) {

        Product productToUpdate = productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product","id",id)
        );

        productMapper.updateProductFromRequest(productRequestDTO, productToUpdate);

        Product productUpdated = productRepository.save(productToUpdate);

        return productMapper.toProductResponseDTO(productUpdated);
    }

    @Override
    public ProductResponseDTO getProductById(String id) {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product","id",id)
        );

        return productMapper.toProductResponseDTO(product);
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product","id",id);
        }
        productRepository.deleteById(id);
    }
}
