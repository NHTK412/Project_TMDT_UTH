package com.example.clothingstore.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Integer orderId;

    @Column(name = "TotalAmount")
    private Double totalAmount;

    @Column(name = "ShippingFee")
    private Double shippingFee;

    @Column(name = "DeliveryDate")
    private LocalDateTime deliveryDate;

    @Column(name = "Status")
    private String status;

    @Column(name = "RecipientName")
    private String recipientName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "DetailedAddress")
    private String detailedAddress;

    @Column(name = "Ward")
    private String ward;

    @Column(name = "Province")
    private String province;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "VnpayCode")
    private String vnpayCode;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;
}
