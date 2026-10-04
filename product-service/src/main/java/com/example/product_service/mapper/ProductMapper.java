package com.example.product_service.mapper;

import com.example.product_service.dto.ProductRequestDTO;
import com.example.product_service.dto.ProductResponseDTO;
import com.example.product_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequestDTO productResponseDTO);

    ProductResponseDTO toProductResponseDTO(Product product);

    @Mapping(target = "id",ignore = true)
    void updateProductFromRequest(ProductRequestDTO productRequestDTO, @MappingTarget Product product);
}