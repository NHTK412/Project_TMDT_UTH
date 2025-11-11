package com.example.clothingstore.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private Integer customerId;

    @Column(name = "Email")
    private String email;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Membership")
    private String membership;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "TiedId")
    private MembershipTier membershipTier;

    @OneToMany(mappedBy = "customer")
    private List<ShippingAddress> shippingAddresses;
}
