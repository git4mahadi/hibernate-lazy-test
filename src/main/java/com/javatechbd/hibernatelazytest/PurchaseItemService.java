package com.javatechbd.hibernatelazytest;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseItemService {

  private final PurchaseRepository purchaseRepository;
  private final PurchaseItemRepository purchaseItemRepository;
  private final EntityManager entityManager;


  public List<PurchaseItemRest> getPurchaseList() {

    QProductEntity qProduct = QProductEntity.productEntity;
    QPurchaseEntity qPurchase = QPurchaseEntity.purchaseEntity;
    QPurchaseItemEntity qPurchaseItem = QPurchaseItemEntity.purchaseItemEntity;

    List<PurchaseItemEntity> items = new JPAQuery<PurchaseItemEntity>(entityManager)
        .from(qPurchaseItem)
        .leftJoin(qPurchaseItem.purchase, qPurchase).fetchJoin()
        .leftJoin(qPurchaseItem.product, qProduct).fetchJoin()
        .fetch();


    return items.stream().map(itm-> {
          var rest = new PurchaseItemRest();
          rest.setPurchaseId(itm.getPurchaseId());
          rest.setProductName(itm.getProduct().getProductName());
          rest.setProductId(itm.getProductId());
          return  rest;
        }).collect(Collectors.toList());
  }
}
