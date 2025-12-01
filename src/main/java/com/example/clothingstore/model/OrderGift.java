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

/**
 * Lưu trữ thông tin quà tặng mà khách hàng nhận được khi mua hàng
 * Đảm bảo tính toàn vẹn dữ liệu: nếu quà tặng bị xóa hoặc thay đổi,
 * vẫn giữ được thông tin quà tặng lịch sử của order
 */
@Entity
@Table(name = "OrderGift")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderGift extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderGiftId")
    private Integer orderGiftId;

    // Thông tin quà tặng tại thời điểm mua (de-normalize)
    @Column(name = "GiftName")
    private String giftName;

    @Column(name = "GiftQuantity")
    private Integer giftQuantity;

    @Column(name = "GiftImage")
    private String giftImage;

    @Column(name = "PromotionName")
    private String promotionName;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;
}
