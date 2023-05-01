package com.javatechbd.hibernatelazytest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseItemRest {
  private Long purchaseId;
  private LocalDate purchaseDate;
  private Long productId;
  private String productName;
}
