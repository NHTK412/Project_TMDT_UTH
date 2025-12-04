package com.example.clothingstore.model;

import java.util.ArrayList;
import java.util.List;

import com.example.clothingstore.enums.StatusEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProductColor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer colorId;

    @Column(name = "Color")
    private String color;

    @Column(name = "ProductImage")
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @OneToMany(mappedBy = "productColor", cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails = new ArrayList<>();

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "Status", columnDefinition = "varchar(255) default 'ACTIVE'")
    private StatusEnum status;
}
