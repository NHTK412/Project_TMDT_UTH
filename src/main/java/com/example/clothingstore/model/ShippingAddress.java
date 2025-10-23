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
@Table(name = "ShippingAddress")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ShippingAddress extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressId")
    private Integer addressId;

    @Column(name = "RecipientName")
    private String recipientName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "DetailedAddress")
    private String detailedAdress;

    @Column(name = "Ward")
    private String ward;

    @Column(name = "Province")
    private String province;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

}
