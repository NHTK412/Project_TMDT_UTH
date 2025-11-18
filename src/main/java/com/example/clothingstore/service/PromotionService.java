package com.example.clothingstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.promotion.PromotionRequestDTO;
import com.example.clothingstore.dto.promotion.PromotionResponseDTO;
import com.example.clothingstore.enums.PromotionTypeEnum;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.mapper.DiscountMapper;
import com.example.clothingstore.mapper.GiftMapper;
import com.example.clothingstore.mapper.PromotionGroupMapper;
import com.example.clothingstore.mapper.PromotionMapper;
import com.example.clothingstore.model.Discount;
import com.example.clothingstore.model.Gift;
import com.example.clothingstore.model.ProductDetail;
import com.example.clothingstore.model.Promotion;
import com.example.clothingstore.model.PromotionGroup;
import com.example.clothingstore.repository.ProductDetailRepository;
import com.example.clothingstore.repository.PromotionRepository;

import jakarta.transaction.Transactional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private PromotionMapper promotionMapper;

    @Autowired
    private PromotionGroupMapper promotionGroupMapper;

    @Autowired
    private GiftMapper giftMapper;

    @Autowired
    private DiscountMapper discountMapper;

    public PromotionResponseDTO getPromotionById(Integer promotionId) {
        Promotion promotion = promotionRepository.findById(promotionId)
                .orElseThrow(() -> new NotFoundException("Invalue Promotion Code"));

        return promotionMapper.convertModelToPromotionResponseDTO(promotion);
    }

    @Transactional
    public PromotionResponseDTO createPromotion(PromotionRequestDTO dto) {

        // Promotion promotion = ;

        // Convert DTO → Model
        Promotion promotion = promotionMapper.convertPromotionRequestDTOToModel(dto, new Promotion());

        List<PromotionGroup> groups = dto.getPromotionGroupRequestDTOs()
                .stream()
                .map(groupDTO -> {

                    // PromotionGroup group = new PromotionGroup();
                    PromotionGroup group = promotionGroupMapper
                            .convertProductGroupRequestDTOTOModel(groupDTO, new PromotionGroup());

                    // Lấy danh sách ProductDetail
                    List<ProductDetail> productDetails = productDetailRepository
                            .findAllById(groupDTO.getProductDetailIds());

                    group.setProductDetails(productDetails);

                    // Set quan hệ 2 chiều
                    group.setPromotion(promotion);

                    return group;
                })
                .collect(Collectors.toList());

        promotion.setPromotionGroups(groups);

        if (dto.getPromotionType() == PromotionTypeEnum.GIFT) {

            List<Gift> gifts = dto.getGiftRequestDTOs()
                    .stream()
                    .map(giftDTO -> {
                        // Gift gift = new Gift();

                        Gift gift = giftMapper.convertGiftRequestDTOToModel(giftDTO, new Gift());

                        gift.setProductDetail(
                                productDetailRepository.findById(giftDTO.getProductDetailId())
                                        .orElseThrow(() -> new NotFoundException("Invalid Product Code")));

                        gift.setPromotion(promotion);

                        return gift;
                    })
                    .collect(Collectors.toList());

            promotion.setGits(gifts);

        } else {
            // Discount discount = new Discount();

            boolean isAmount = dto.getPromotionType() == PromotionTypeEnum.DISCOUNT_AMOUNT;

            Discount discount = discountMapper.convertDiscountRequestDTOTOModel(
                    dto.getDiscountRequestDTO(),
                    new Discount(),
                    isAmount);

            discount.setPromotion(promotion);

            promotion.setDiscount(discount);
        }

        promotionRepository.save(promotion);

        return promotionMapper.convertModelToPromotionResponseDTO(promotion);
    }

}
