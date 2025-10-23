package com.example.clothingstore.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Promotion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Promotion extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PromotionId")
    private Integer promotionId;

    @Column(name = "PromotionName")
    private String promotionName;

    @Column(name = "PromotionType")
    private String promotionType;

    @Column(name = "Description")
    private String description;

    @Column(name = "ApplyCondition")
    private String applyCondition;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "ApplyType")
    private String applyType;

    @OneToMany(mappedBy = "promotion")
    private List<PromotionGroup> promotionGroups;

    @OneToOne(mappedBy = "promotion")
    private Discount discount;

    @OneToMany(mappedBy = "promotion")
    private List<Git> gits;

}
