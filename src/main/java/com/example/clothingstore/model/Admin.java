package com.example.clothingstore.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Admin")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminId")
    private Integer adminId;

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

    @Column(name = "Address")
    private String address;

    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account account;

}
