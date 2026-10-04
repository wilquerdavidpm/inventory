package com.example.product_service.dataloader;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception{
        Product product = Product.builder()
                .name("Samsung Galaxy S27")
                .description("Celular de alta gama")
                .quantityInStock(25)
                .price(BigDecimal.valueOf(1800))
                .build();

        //productRepository.save(product);
        System.out.println("Datos de prueba cargados" + product.getName());
    }

}
