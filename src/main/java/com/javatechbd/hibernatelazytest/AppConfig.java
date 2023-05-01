package com.javatechbd.hibernatelazytest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AppConfig {

  @Bean
  CommandLineRunner commandLineRunner(ProductRepository productRepository,
                                      PurchaseRepository purchaseRepository,
                                      PurchaseItemRepository purchaseItemRepository) {
    return args -> {

      var product = productRepository.save(new ProductEntity("Product-1"));

      var purchase = new PurchaseEntity(LocalDate.now());
      purchaseRepository.save(purchase);

      var purchaseItem = new PurchaseItemEntity(purchase, product, 12.00);
      purchaseItemRepository.save(purchaseItem);

    };
  }
}
