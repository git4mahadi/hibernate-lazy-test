package com.javatechbd.hibernatelazytest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
public class PurchaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "purchase_date")
  private LocalDate purchaseDate;

  @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
  private List<PurchaseItemEntity> purchaseItemList;

  public PurchaseEntity(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
  }
}
