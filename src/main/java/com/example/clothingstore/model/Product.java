package com.example.clothingstore.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Integer productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "Description")
    private String description;

    @Column(name = "ProductImage")
    private String productImage;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
