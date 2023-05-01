package com.javatechbd.hibernatelazytest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "purchases_items")
@Getter
@Setter
@NoArgsConstructor
public class PurchaseItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "purchase_id", foreignKey = @ForeignKey(name = "fk_purchases_items_purchase_id"))
  private PurchaseEntity purchase;

  @Column(name = "purchase_id", insertable = false, updatable = false)
  private Long purchaseId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_purchases_items_product_id"))
  private ProductEntity product;

  @Column(name = "product_id", insertable = false, updatable = false)
  private Long productId;

  @Column(name = "sales_price")
  private Double salesPrice;

  public PurchaseItemEntity(PurchaseEntity purchase, ProductEntity product, Double salesPrice) {
    this.purchase = purchase;
    this.product = product;
    this.salesPrice = salesPrice;
  }
}
