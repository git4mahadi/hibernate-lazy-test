package com.javatechbd.hibernatelazytest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

  private final PurchaseItemService purchaseItemService;

  @GetMapping
  public List<PurchaseItemRest> getPurchaseList() {
    return purchaseItemService.getPurchaseList();
  }
}
