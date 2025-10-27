-- ============================================
-- INSERT MOCK DATA FOR CLOTHING STORE DATABASE
-- ============================================

-- 1. INSERT ACCOUNT DATA
INSERT INTO
    `account` (
        `account_id`,
        `create_at`,
        `update_at`,
        `last_login`,
        `password`,
        `role`,
        `status`,
        `user_name`
    )
VALUES (
        1,
        '2025-01-15 10:30:00.000000',
        '2025-10-20 14:22:00.000000',
        '2025-10-26 09:15:00.000000',
        '$2a$10$encrypted_password_1',
        'ADMIN',
        'ACTIVE',
        'admin_001'
    ),
    (
        2,
        '2025-02-10 11:45:00.000000',
        '2025-10-19 16:30:00.000000',
        '2025-10-25 18:45:00.000000',
        '$2a$10$encrypted_password_2',
        'CUSTOMER',
        'ACTIVE',
        'customer_001'
    ),
    (
        3,
        '2025-03-05 08:20:00.000000',
        '2025-10-22 12:10:00.000000',
        '2025-10-26 14:30:00.000000',
        '$2a$10$encrypted_password_3',
        'CUSTOMER',
        'ACTIVE',
        'customer_002'
    ),
    (
        4,
        '2025-04-12 13:55:00.000000',
        '2025-10-21 10:05:00.000000',
        '2025-10-24 20:15:00.000000',
        '$2a$10$encrypted_password_4',
        'CUSTOMER',
        'ACTIVE',
        'customer_003'
    ),
    (
        5,
        '2025-05-20 09:30:00.000000',
        '2025-10-23 15:45:00.000000',
        '2025-10-26 11:20:00.000000',
        '$2a$10$encrypted_password_5',
        'CUSTOMER',
        'INACTIVE',
        'customer_004'
    );

-- 2. INSERT ADMIN DATA
INSERT INTO
    `admin` (
        `admin_id`,
        `create_at`,
        `update_at`,
        `address`,
        `date`,
        `email`,
        `full_name`,
        `gender`,
        `phone`,
        `account_id`
    )
VALUES (
        1,
        '2025-01-15 10:30:00.000000',
        '2025-10-20 14:22:00.000000',
        '123 Nguyễn Huệ, Quận 1, TP.HCM',
        '1985-03-15 00:00:00.000000',
        'admin@clothingstore.com',
        'Nguyễn Văn An',
        'MALE',
        '0912345678',
        1
    );

-- 3. INSERT CATEGORY DATA
INSERT INTO
    `category` (
        `category_id`,
        `create_at`,
        `update_at`,
        `category_name`,
        `description`,
        `status`
    )
VALUES (
        1,
        '2025-01-01 08:00:00.000000',
        '2025-10-15 10:30:00.000000',
        'T-Shirt',
        'Áo thun thường ngày',
        'ACTIVE'
    ),
    (
        2,
        '2025-01-01 08:15:00.000000',
        '2025-10-15 10:30:00.000000',
        'Jeans',
        'Quần jeans nam và nữ',
        'ACTIVE'
    ),
    (
        3,
        '2025-01-01 08:30:00.000000',
        '2025-10-15 10:30:00.000000',
        'Dress',
        'Váy đầm nữ',
        'ACTIVE'
    ),
    (
        4,
        '2025-01-01 08:45:00.000000',
        '2025-10-15 10:30:00.000000',
        'Hoodie',
        'Áo hoodie ấm áp',
        'ACTIVE'
    ),
    (
        5,
        '2025-01-01 09:00:00.000000',
        '2025-10-15 10:30:00.000000',
        'Jacket',
        'Áo khoác thời trang',
        'ACTIVE'
    );

-- 4. INSERT MEMBERSHIP TIER DATA
INSERT INTO
    `membership_tier` (
        `tied_id`,
        `create_at`,
        `update_at`,
        `description`,
        `discount_rate`,
        `minimum_spending`
    )
VALUES (
        1,
        '2025-01-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        'Thành viên Bạc',
        5,
        500000
    ),
    (
        2,
        '2025-01-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        'Thành viên Vàng',
        10,
        1500000
    ),
    (
        3,
        '2025-01-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        'Thành viên Bạch Kim',
        15,
        5000000
    );

-- 5. INSERT CUSTOMER DATA
INSERT INTO
    `customer` (
        `customer_id`,
        `create_at`,
        `update_at`,
        `date`,
        `email`,
        `full_name`,
        `gender`,
        `membership`,
        `phone`,
        `account_id`,
        `tied_id`
    )
VALUES (
        1,
        '2025-02-10 11:45:00.000000',
        '2025-10-19 16:30:00.000000',
        '1995-06-20 00:00:00.000000',
        'customer1@email.com',
        'Trần Thị Bình',
        'FEMALE',
        'MEMBER',
        '0901234567',
        2,
        1
    ),
    (
        2,
        '2025-03-05 08:20:00.000000',
        '2025-10-22 12:10:00.000000',
        '1992-11-05 00:00:00.000000',
        'customer2@email.com',
        'Lê Minh Tuấn',
        'MALE',
        'MEMBER',
        '0902345678',
        3,
        2
    ),
    (
        3,
        '2025-04-12 13:55:00.000000',
        '2025-10-21 10:05:00.000000',
        '1998-03-10 00:00:00.000000',
        'customer3@email.com',
        'Phạm Hương Giang',
        'FEMALE',
        'MEMBER',
        '0903456789',
        4,
        NULL
    ),
    (
        4,
        '2025-05-20 09:30:00.000000',
        '2025-10-23 15:45:00.000000',
        '1996-08-25 00:00:00.000000',
        'customer4@email.com',
        'Đỗ Quốc Huy',
        'MALE',
        'NOT_MEMBER',
        '0904567890',
        5,
        NULL
    );

-- 6. INSERT PRODUCT DATA
INSERT INTO
    `product` (
        `product_id`,
        `create_at`,
        `update_at`,
        `description`,
        `product_image`,
        `product_name`,
        `unit_price`
    )
VALUES (
        1,
        '2025-01-10 09:00:00.000000',
        '2025-10-20 11:30:00.000000',
        'Áo thun cotton 100% mềm mại',
        'tshirt_001.jpg',
        'Basic T-Shirt White',
        150000
    ),
    (
        2,
        '2025-01-12 09:15:00.000000',
        '2025-10-20 11:30:00.000000',
        'Áo thun có in hình độc đáo',
        'tshirt_002.jpg',
        'Graphic T-Shirt Black',
        200000
    ),
    (
        3,
        '2025-01-15 09:30:00.000000',
        '2025-10-20 11:30:00.000000',
        'Quần jeans xanh nam cơ bản',
        'jeans_001.jpg',
        'Classic Blue Jeans',
        450000
    ),
    (
        4,
        '2025-01-18 09:45:00.000000',
        '2025-10-20 11:30:00.000000',
        'Quần jeans nữ ôm body',
        'jeans_002.jpg',
        'Skinny Jeans Women',
        500000
    ),
    (
        5,
        '2025-01-20 10:00:00.000000',
        '2025-10-20 11:30:00.000000',
        'Váy đầm dạo phố thời trang',
        'dress_001.jpg',
        'Casual Summer Dress',
        350000
    ),
    (
        6,
        '2025-01-25 10:30:00.000000',
        '2025-10-20 11:30:00.000000',
        'Áo hoodie ấm áp mùa đông',
        'hoodie_001.jpg',
        'Cozy Gray Hoodie',
        400000
    ),
    (
        7,
        '2025-02-01 11:00:00.000000',
        '2025-10-20 11:30:00.000000',
        'Áo khoác denim cổ điển',
        'jacket_001.jpg',
        'Denim Jacket',
        600000
    );

-- 7. INSERT PRODUCT COLOR DATA
INSERT INTO
    `product_color` (
        `color_id`,
        `color`,
        `product_image`,
        `product_id`
    )
VALUES (
        1,
        'White',
        'tshirt_001_white.jpg',
        1
    ),
    (
        2,
        'Black',
        'tshirt_002_black.jpg',
        2
    ),
    (
        3,
        'Blue',
        'tshirt_002_blue.jpg',
        2
    ),
    (
        4,
        'Light Blue',
        'jeans_001_lightblue.jpg',
        3
    ),
    (
        5,
        'Dark Blue',
        'jeans_001_darkblue.jpg',
        3
    ),
    (
        6,
        'Blue',
        'jeans_002_blue.jpg',
        4
    ),
    (
        7,
        'Black',
        'jeans_002_black.jpg',
        4
    ),
    (
        8,
        'Beige',
        'dress_001_beige.jpg',
        5
    ),
    (
        9,
        'Gray',
        'hoodie_001_gray.jpg',
        6
    ),
    (
        10,
        'Blue',
        'jacket_001_blue.jpg',
        7
    );

-- 8. INSERT PRODUCT DETAIL DATA
INSERT INTO
    `product_detail` (
        `detail_id`,
        `create_at`,
        `update_at`,
        `quantity`,
        `size`,
        `product_color`
    )
VALUES (
        1,
        '2025-01-10 09:00:00.000000',
        '2025-10-20 11:30:00.000000',
        50,
        'S',
        1
    ),
    (
        2,
        '2025-01-10 09:00:00.000000',
        '2025-10-20 11:30:00.000000',
        45,
        'M',
        1
    ),
    (
        3,
        '2025-01-10 09:00:00.000000',
        '2025-10-20 11:30:00.000000',
        40,
        'L',
        1
    ),
    (
        4,
        '2025-01-12 09:15:00.000000',
        '2025-10-20 11:30:00.000000',
        30,
        'S',
        2
    ),
    (
        5,
        '2025-01-12 09:15:00.000000',
        '2025-10-20 11:30:00.000000',
        35,
        'M',
        2
    ),
    (
        6,
        '2025-01-12 09:15:00.000000',
        '2025-10-20 11:30:00.000000',
        25,
        'L',
        3
    ),
    (
        7,
        '2025-01-15 09:30:00.000000',
        '2025-10-20 11:30:00.000000',
        60,
        '30',
        4
    ),
    (
        8,
        '2025-01-15 09:30:00.000000',
        '2025-10-20 11:30:00.000000',
        55,
        '32',
        4
    ),
    (
        9,
        '2025-01-15 09:30:00.000000',
        '2025-10-20 11:30:00.000000',
        50,
        '34',
        5
    ),
    (
        10,
        '2025-01-18 09:45:00.000000',
        '2025-10-20 11:30:00.000000',
        40,
        '26',
        6
    ),
    (
        11,
        '2025-01-18 09:45:00.000000',
        '2025-10-20 11:30:00.000000',
        35,
        '28',
        6
    ),
    (
        12,
        '2025-01-18 09:45:00.000000',
        '2025-10-20 11:30:00.000000',
        30,
        '30',
        7
    ),
    (
        13,
        '2025-01-20 10:00:00.000000',
        '2025-10-20 11:30:00.000000',
        45,
        'S',
        8
    ),
    (
        14,
        '2025-01-25 10:30:00.000000',
        '2025-10-20 11:30:00.000000',
        70,
        'M',
        9
    ),
    (
        15,
        '2025-02-01 11:00:00.000000',
        '2025-10-20 11:30:00.000000',
        55,
        'M',
        10
    );

-- 9. INSERT CATEGORY_PRODUCT DATA
INSERT INTO
    `category_product` (`category_id`, `product_id`)
VALUES (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (4, 6),
    (5, 7);

-- 10. INSERT PROMOTION DATA
INSERT INTO
    `promotion` (
        `promotion_id`,
        `create_at`,
        `update_at`,
        `apply_condition`,
        `apply_type`,
        `description`,
        `end_date`,
        `promotion_name`,
        `promotion_type`,
        `start_date`
    )
VALUES (
        1,
        '2025-09-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        'MIN_AMOUNT_500K',
        'ALL_PRODUCTS',
        'Giảm giá mùa thu',
        '2025-10-31 23:59:59.000000',
        'Autumn Sale 2025',
        'DISCOUNT_PERCENTAGE',
        '2025-09-01 00:00:00.000000'
    ),
    (
        2,
        '2025-10-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        'MIN_AMOUNT_1M',
        'SPECIFIC_PRODUCTS',
        'Ưu đãi mùa đông',
        '2025-12-31 23:59:59.000000',
        'Winter Special',
        'DISCOUNT_AMOUNT',
        '2025-10-15 00:00:00.000000'
    ),
    (
        3,
        '2025-10-10 08:00:00.000000',
        '2025-10-20 10:00:00.000000',
        'NONE',
        'SPECIFIC_PRODUCTS',
        'Khuyến mãi mua kèm',
        '2025-11-10 23:59:59.000000',
        'Buy More Save More',
        'GIFT',
        '2025-10-10 00:00:00.000000'
    );

-- 11. INSERT DISCOUNT DATA
INSERT INTO
    `discount` (
        `discount_id`,
        `create_at`,
        `update_at`,
        `discount_amount`,
        `discount_percentage`,
        `max_discount`,
        `promotion_id`
    )
VALUES (
        1,
        '2025-09-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        NULL,
        10,
        100000,
        1
    ),
    (
        2,
        '2025-10-01 08:00:00.000000',
        '2025-10-15 10:00:00.000000',
        50000,
        NULL,
        50000,
        2
    );

-- 12. INSERT PROMOTION_GROUP DATA
INSERT INTO
    `promotion_group` (
        `group_id`,
        `create_at`,
        `update_at`,
        `description`,
        `group_name`,
        `min_purchase_quantity`,
        `promotion_id`
    )
VALUES (
        1,
        '2025-10-10 08:00:00.000000',
        '2025-10-20 10:00:00.000000',
        'Mua 2 áo thun giảm 5%',
        'T-Shirt Bundle',
        2,
        1
    ),
    (
        2,
        '2025-10-10 08:00:00.000000',
        '2025-10-20 10:00:00.000000',
        'Mua 1 quần jeans tặng áo',
        'Jeans Promo',
        1,
        3
    );

-- 13. INSERT PROMOTION_GROUP_PRODUCT_DETAIL DATA
INSERT INTO
    `promotion_group_product_detail` (`group_id`, `detail_id`)
VALUES (1, 1),
    (1, 2),
    (1, 3),
    (2, 7),
    (2, 8);

-- 14. INSERT GIFT DATA
INSERT INTO
    `gift` (
        `gift_id`,
        `create_at`,
        `update_at`,
        `gift_quantity`,
        `max_gift`,
        `detail_id`,
        `promotion_id`
    )
VALUES (
        1,
        '2025-10-10 08:00:00.000000',
        '2025-10-20 10:00:00.000000',
        100,
        5,
        4,
        3
    ),
    (
        2,
        '2025-10-10 08:00:00.000000',
        '2025-10-20 10:00:00.000000',
        50,
        3,
        5,
        3
    );

-- 15. INSERT ORDER DATA
INSERT INTO
    `orders` (
        `order_id`,
        `create_at`,
        `update_at`,
        `delivery_date`,
        `detailed_address`,
        `payment_method`,
        `phone_number`,
        `province`,
        `recipient_name`,
        `shipping_fee`,
        `status`,
        `total_amount`,
        `vnpay_code`,
        `ward`,
        `customer_id`
    )
VALUES (
        1,
        '2025-10-15 14:30:00.000000',
        '2025-10-20 16:45:00.000000',
        '2025-10-22 10:00:00.000000',
        '123 Nguyễn Hữu Cảnh',
        'VNPAY',
        '0901234567',
        'Hồ Chí Minh',
        'Trần Thị Bình',
        25000,
        'DELIVERED',
        625000,
        'VNP20251015001',
        'Phường 22',
        1
    ),
    (
        2,
        '2025-10-16 10:15:00.000000',
        '2025-10-21 09:30:00.000000',
        '2025-10-23 14:00:00.000000',
        '456 Lê Văn Sỹ',
        'COD',
        '0902345678',
        'Hồ Chí Minh',
        'Lê Minh Tuấn',
        30000,
        'DELIVERED',
        930000,
        NULL,
        'Phường 14',
        2
    ),
    (
        3,
        '2025-10-18 11:45:00.000000',
        '2025-10-23 13:20:00.000000',
        '2025-10-25 15:30:00.000000',
        '789 Trần Hưng Đạo',
        'VNPAY',
        '0903456789',
        'Hà Nội',
        'Phạm Hương Giang',
        20000,
        'SHIPPED',
        750000,
        'VNP20251018002',
        'Phường Tây Hồ',
        3
    ),
    (
        4,
        '2025-10-20 09:00:00.000000',
        '2025-10-20 09:05:00.000000',
        NULL,
        '321 Nguyễn Trãi',
        'COD',
        '0904567890',
        'Hà Nội',
        'Đỗ Quốc Huy',
        35000,
        'PENDING',
        1000000,
        NULL,
        'Phường Thanh Xuân',
        4
    );

-- 16. INSERT ORDER_DETAIL DATA
INSERT INTO
    `order_detail` (
        `detail_id`,
        `create_at`,
        `update_at`,
        `price`,
        `quantity`,
        `order_id`,
        `product_detail_id`
    )
VALUES (
        1,
        '2025-10-15 14:30:00.000000',
        '2025-10-20 16:45:00.000000',
        150000,
        2,
        1,
        1
    ),
    (
        2,
        '2025-10-15 14:30:00.000000',
        '2025-10-20 16:45:00.000000',
        200000,
        1,
        1,
        5
    ),
    (
        3,
        '2025-10-15 14:30:00.000000',
        '2025-10-20 16:45:00.000000',
        150000,
        1,
        1,
        2
    ),
    (
        4,
        '2025-10-16 10:15:00.000000',
        '2025-10-21 09:30:00.000000',
        450000,
        1,
        2,
        7
    ),
    (
        5,
        '2025-10-16 10:15:00.000000',
        '2025-10-21 09:30:00.000000',
        500000,
        1,
        2,
        10
    ),
    (
        6,
        '2025-10-18 11:45:00.000000',
        '2025-10-23 13:20:00.000000',
        350000,
        1,
        3,
        13
    ),
    (
        7,
        '2025-10-18 11:45:00.000000',
        '2025-10-23 13:20:00.000000',
        400000,
        1,
        3,
        14
    ),
    (
        8,
        '2025-10-20 09:00:00.000000',
        '2025-10-20 09:05:00.000000',
        600000,
        1,
        4,
        15
    ),
    (
        9,
        '2025-10-20 09:00:00.000000',
        '2025-10-20 09:05:00.000000',
        400000,
        1,
        4,
        14
    );

-- 17. INSERT REVIEW DATA
INSERT INTO
    `review` (
        `review_id`,
        `create_at`,
        `update_at`,
        `rating`,
        `review_content`,
        `customer_id`,
        `product_id`
    )
VALUES (
        1,
        '2025-10-16 15:30:00.000000',
        '2025-10-20 10:00:00.000000',
        5,
        'Sản phẩm chất lượng tốt, giao hàng nhanh',
        1,
        1
    ),
    (
        2,
        '2025-10-17 10:00:00.000000',
        '2025-10-20 10:00:00.000000',
        4,
        'Áo đẹp, vừa vặn, mua lần nữa',
        1,
        2
    ),
    (
        3,
        '2025-10-19 16:45:00.000000',
        '2025-10-20 10:00:00.000000',
        5,
        'Quần jeans chất lượng cao',
        2,
        3
    ),
    (
        4,
        '2025-10-20 09:30:00.000000',
        '2025-10-20 09:30:00.000000',
        4,
        'Váy đẹp nhưng hơi chật',
        3,
        5
    ),
    (
        5,
        '2025-10-20 11:00:00.000000',
        '2025-10-20 11:00:00.000000',
        5,
        'Hoodie rất ấm và thoải mái',
        1,
        6
    );

-- 18. INSERT SHIPPING_ADDRESS DATA
INSERT INTO
    `shipping_address` (
        `address_id`,
        `create_at`,
        `update_at`,
        `detailed_address`,
        `phone_number`,
        `province`,
        `recipient_name`,
        `ward`,
        `customer_id`
    )
VALUES (
        1,
        '2025-02-10 11:45:00.000000',
        '2025-10-19 16:30:00.000000',
        '123 Nguyễn Hữu Cảnh',
        '0901234567',
        'Hồ Chí Minh',
        'Trần Thị Bình',
        'Phường 22',
        1
    ),
    (
        2,
        '2025-02-10 11:45:00.000000',
        '2025-10-19 16:30:00.000000',
        '456 Lê Văn Sỹ',
        '0901234567',
        'Hồ Chí Minh',
        'Trần Thị Bình',
        'Phường 14',
        1
    ),
    (
        3,
        '2025-03-05 08:20:00.000000',
        '2025-10-22 12:10:00.000000',
        '456 Lê Văn Sỹ',
        '0902345678',
        'Hồ Chí Minh',
        'Lê Minh Tuấn',
        'Phường 14',
        2
    ),
    (
        4,
        '2025-03-05 08:20:00.000000',
        '2025-10-22 12:10:00.000000',
        '789 Trần Hưng Đạo, Hà Nội',
        '0902345678',
        'Hà Nội',
        'Lê Minh Tuấn',
        'Phường Thanh Xuân',
        2
    ),
    (
        5,
        '2025-04-12 13:55:00.000000',
        '2025-10-21 10:05:00.000000',
        '789 Trần Hưng Đạo',
        '0903456789',
        'Hà Nội',
        'Phạm Hương Giang',
        'Phường Tây Hồ',
        3
    ),
    (
        6,
        '2025-05-20 09:30:00.000000',
        '2025-10-23 15:45:00.000000',
        '321 Nguyễn Trãi',
        '0904567890',
        'Hà Nội',
        'Đỗ Quốc Huy',
        'Phường Thanh Xuân',
        4
    );

-- ============================================
-- END OF MOCK DATA INSERTION
-- ============================================