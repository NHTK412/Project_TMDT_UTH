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
@Table(name = "OrderDetail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDetail extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetailId")
    private Integer detailId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private Double price;

    // Lưu thông tin sản phẩm tại thời điểm mua (de-normalize)
    @Column(name = "ProductName")
    private String productName;

    @Column(name = "ProductImage")
    private String productImage;

    @Column(name = "Color")
    private String color;

    @Column(name = "Size")
    private String size;

    // Reference đến ProductDetail (dùng cho tham khảo, không dùng cập nhật giá)
    @ManyToOne
    @JoinColumn(name = "ProductDetailId")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;
}
