package com.example.clothingstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CartItem")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class CartItem extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartDetailId")
    private Integer cartItemId;

    @Column(name = "Quantity")
    private Integer quantity;

    // @Column(name = "Price")
    // private Double price;

    // @Column(name = "IsSelected")
    // private Boolean isSelected;

    @ManyToOne
    @JoinColumn(name = "ProductDetailId")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "CartId")
    private Cart cart;
}
