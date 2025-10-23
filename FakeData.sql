-- ==================== INSERT DATA FOR ACCOUNT ====================
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
        '2025-10-23 09:15:00.000000',
        'admin123',
        'ADMIN',
        'ACTIVE',
        'admin01'
    ),
    (
        2,
        '2025-02-10 08:45:00.000000',
        '2025-10-15 11:30:00.000000',
        '2025-10-22 16:45:00.000000',
        'hashed_pass_customer1',
        'CUSTOMER',
        'ACTIVE',
        'customer_john'
    ),
    (
        3,
        '2025-03-05 09:20:00.000000',
        '2025-10-18 13:15:00.000000',
        '2025-10-21 10:20:00.000000',
        'hashed_pass_customer2',
        'CUSTOMER',
        'ACTIVE',
        'customer_jane'
    ),
    (
        4,
        '2025-03-20 14:10:00.000000',
        '2025-10-19 15:40:00.000000',
        '2025-10-23 08:30:00.000000',
        'hashed_pass_customer3',
        'CUSTOMER',
        'ACTIVE',
        'customer_mike'
    ),
    (
        5,
        '2025-04-12 11:05:00.000000',
        '2025-10-20 09:50:00.000000',
        NULL,
        'hashed_pass_customer4',
        'CUSTOMER',
        'INACTIVE',
        'customer_sarah'
    ),
    (
        6,
        '2025-05-08 16:25:00.000000',
        '2025-10-22 12:35:00.000000',
        '2025-10-23 07:45:00.000000',
        'admin456',
        'ADMIN',
        'ACTIVE',
        'admin02'
    );

-- ==================== INSERT DATA FOR ADMIN ====================
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
        '123 Admin Street, Ho Chi Minh City',
        '1990-06-15 00:00:00.000000',
        'admin01@clothingstore.com',
        'Nguyen Van Admin',
        'Male',
        '0901234567',
        1
    ),
    (
        2,
        '2025-05-08 16:25:00.000000',
        '2025-10-22 12:35:00.000000',
        '456 Manager Ave, Ha Noi',
        '1992-03-22 00:00:00.000000',
        'admin02@clothingstore.com',
        'Tran Thi Manager',
        'Female',
        '0912345678',
        6
    );

-- ==================== INSERT DATA FOR MEMBERSHIP_TIER ====================
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
        '2025-01-01 00:00:00.000000',
        '2025-01-01 00:00:00.000000',
        'Bronze Member - 5% discount',
        0.05,
        0
    ),
    (
        2,
        '2025-01-01 00:00:00.000000',
        '2025-01-01 00:00:00.000000',
        'Silver Member - 10% discount',
        0.10,
        500000
    ),
    (
        3,
        '2025-01-01 00:00:00.000000',
        '2025-01-01 00:00:00.000000',
        'Gold Member - 15% discount',
        0.15,
        1500000
    ),
    (
        4,
        '2025-01-01 00:00:00.000000',
        '2025-01-01 00:00:00.000000',
        'Platinum Member - 20% discount',
        0.20,
        3000000
    );

-- ==================== INSERT DATA FOR CUSTOMER ====================
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
        '2025-02-10 08:45:00.000000',
        '2025-10-15 11:30:00.000000',
        '1990-05-20 00:00:00.000000',
        'john.doe@gmail.com',
        'Nguyen Van John',
        'Male',
        'Active',
        '0987654321',
        2,
        1
    ),
    (
        2,
        '2025-03-05 09:20:00.000000',
        '2025-10-18 13:15:00.000000',
        '1995-08-15 00:00:00.000000',
        'jane.smith@gmail.com',
        'Tran Thi Jane',
        'Female',
        'Active',
        '0987654322',
        3,
        2
    ),
    (
        3,
        '2025-03-20 14:10:00.000000',
        '2025-10-19 15:40:00.000000',
        '1988-12-10 00:00:00.000000',
        'mike.johnson@gmail.com',
        'Le Van Mike',
        'Male',
        'Active',
        '0987654323',
        4,
        3
    ),
    (
        4,
        '2025-04-12 11:05:00.000000',
        '2025-10-20 09:50:00.000000',
        '1998-02-28 00:00:00.000000',
        'sarah.williams@gmail.com',
        'Pham Thi Sarah',
        'Female',
        'Inactive',
        '0987654324',
        5,
        1
    );

-- ==================== INSERT DATA FOR CATEGORY ====================
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
        '2025-01-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'T-Shirts',
        'Casual and formal t-shirts',
        'ACTIVE'
    ),
    (
        2,
        '2025-01-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Jeans',
        'Premium denim jeans',
        'ACTIVE'
    ),
    (
        3,
        '2025-01-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Dresses',
        'Women formal and casual dresses',
        'ACTIVE'
    ),
    (
        4,
        '2025-01-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Jackets',
        'Winter and casual jackets',
        'ACTIVE'
    ),
    (
        5,
        '2025-01-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Accessories',
        'Hats, scarves, and bags',
        'ACTIVE'
    );

-- ==================== INSERT DATA FOR PRODUCT ====================
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
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Classic white cotton t-shirt',
        'tshirt_white_001.jpg',
        'White Cotton T-Shirt',
        189000
    ),
    (
        2,
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black graphic t-shirt',
        'tshirt_black_001.jpg',
        'Black Graphic T-Shirt',
        249000
    ),
    (
        3,
        '2025-01-12 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Blue slim fit jeans',
        'jeans_blue_001.jpg',
        'Blue Slim Jeans',
        599000
    ),
    (
        4,
        '2025-01-12 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black skinny jeans',
        'jeans_black_001.jpg',
        'Black Skinny Jeans',
        549000
    ),
    (
        5,
        '2025-01-15 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Summer floral dress',
        'dress_floral_001.jpg',
        'Floral Summer Dress',
        799000
    ),
    (
        6,
        '2025-01-15 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black evening dress',
        'dress_black_001.jpg',
        'Black Evening Dress',
        1299000
    ),
    (
        7,
        '2025-01-18 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Winter leather jacket',
        'jacket_leather_001.jpg',
        'Black Leather Jacket',
        1899000
    ),
    (
        8,
        '2025-01-18 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Denim jacket',
        'jacket_denim_001.jpg',
        'Blue Denim Jacket',
        749000
    );

-- ==================== INSERT DATA FOR CATEGORY_PRODUCT ====================
INSERT INTO
    `category_product` (`category_id`, `product_id`)
VALUES (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8);

-- ==================== INSERT DATA FOR PRODUCT_DETAIL ====================
INSERT INTO
    `product_detail` (
        `detail_id`,
        `create_at`,
        `update_at`,
        `color`,
        `product_image`,
        `quantity`,
        `size`,
        `product_id`
    )
VALUES (
        1,
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'White',
        'tshirt_white_001.jpg',
        50,
        'S',
        1
    ),
    (
        2,
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'White',
        'tshirt_white_001.jpg',
        75,
        'M',
        1
    ),
    (
        3,
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'White',
        'tshirt_white_001.jpg',
        60,
        'L',
        1
    ),
    (
        4,
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'tshirt_black_001.jpg',
        45,
        'M',
        2
    ),
    (
        5,
        '2025-01-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'tshirt_black_001.jpg',
        55,
        'L',
        2
    ),
    (
        6,
        '2025-01-12 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Blue',
        'jeans_blue_001.jpg',
        40,
        '30',
        3
    ),
    (
        7,
        '2025-01-12 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Blue',
        'jeans_blue_001.jpg',
        35,
        '32',
        3
    ),
    (
        8,
        '2025-01-12 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'jeans_black_001.jpg',
        30,
        '30',
        4
    ),
    (
        9,
        '2025-01-12 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'jeans_black_001.jpg',
        25,
        '32',
        4
    ),
    (
        10,
        '2025-01-15 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Floral',
        'dress_floral_001.jpg',
        20,
        'S',
        5
    ),
    (
        11,
        '2025-01-15 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Floral',
        'dress_floral_001.jpg',
        25,
        'M',
        5
    ),
    (
        12,
        '2025-01-15 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'dress_black_001.jpg',
        15,
        'S',
        6
    ),
    (
        13,
        '2025-01-15 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'dress_black_001.jpg',
        10,
        'M',
        6
    ),
    (
        14,
        '2025-01-18 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'jacket_leather_001.jpg',
        12,
        'M',
        7
    ),
    (
        15,
        '2025-01-18 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Black',
        'jacket_leather_001.jpg',
        8,
        'L',
        7
    ),
    (
        16,
        '2025-01-18 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Blue',
        'jacket_denim_001.jpg',
        18,
        'M',
        8
    ),
    (
        17,
        '2025-01-18 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Blue',
        'jacket_denim_001.jpg',
        14,
        'L',
        8
    );

-- ==================== INSERT DATA FOR PROMOTION ====================
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
        '2025-10-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Minimum purchase 500,000',
        'PERCENTAGE',
        'Autumn sale - 10% off',
        '2025-10-31 23:59:59.000000',
        'Autumn Sale',
        'DISCOUNT',
        '2025-10-01 00:00:00.000000'
    ),
    (
        2,
        '2025-10-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Minimum purchase 1,000,000',
        'FIXED',
        'Buy more save more',
        '2025-11-30 23:59:59.000000',
        'Flash Sale',
        'DISCOUNT',
        '2025-10-15 00:00:00.000000'
    ),
    (
        3,
        '2025-09-20 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Buy 2 items',
        'GIFT',
        'Free gift with purchase',
        '2025-12-31 23:59:59.000000',
        'Bundle Deal',
        'GIFT',
        '2025-09-20 00:00:00.000000'
    );

-- ==================== INSERT DATA FOR DISCOUNT ====================
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
        '2025-10-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        NULL,
        0.10,
        100000,
        1
    ),
    (
        2,
        '2025-10-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        100000,
        NULL,
        100000,
        2
    );

-- ==================== INSERT DATA FOR PROMOTION_GROUP ====================
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
        '2025-10-01 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Apply to all t-shirts',
        'T-Shirt Group',
        1,
        1
    ),
    (
        2,
        '2025-10-10 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Apply to dresses',
        'Dress Group',
        1,
        2
    ),
    (
        3,
        '2025-09-20 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        'Jackets bundle',
        'Jacket Bundle',
        2,
        3
    );

-- ==================== INSERT DATA FOR PROMOTION_GROUP_PRODUCT_DETAIL ====================
INSERT INTO
    `promotion_group_product_detail` (`group_id`, `detail_id`)
VALUES (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (2, 12),
    (2, 13),
    (3, 14),
    (3, 15),
    (3, 16),
    (3, 17);

-- ==================== INSERT DATA FOR GIT (GIFT) ====================
INSERT INTO
    `git` (
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
        '2025-09-20 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        50,
        100,
        1,
        3
    ),
    (
        2,
        '2025-09-20 00:00:00.000000',
        '2025-10-20 00:00:00.000000',
        30,
        50,
        16,
        3
    );

-- ==================== INSERT DATA FOR ORDER_DETAIL ====================
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
        '2025-10-15 10:20:00.000000',
        '2025-10-15 10:20:00.000000',
        189000,
        2,
        1,
        1
    ),
    (
        2,
        '2025-10-15 10:20:00.000000',
        '2025-10-15 10:20:00.000000',
        599000,
        1,
        1,
        6
    ),
    (
        3,
        '2025-10-16 14:35:00.000000',
        '2025-10-16 14:35:00.000000',
        1299000,
        1,
        2,
        12
    ),
    (
        4,
        '2025-10-17 09:10:00.000000',
        '2025-10-17 09:10:00.000000',
        249000,
        3,
        3,
        4
    ),
    (
        5,
        '2025-10-18 15:45:00.000000',
        '2025-10-18 15:45:00.000000',
        799000,
        1,
        4,
        10
    ),
    (
        6,
        '2025-10-19 11:30:00.000000',
        '2025-10-19 11:30:00.000000',
        1899000,
        1,
        5,
        14
    ),
    (
        7,
        '2025-10-19 11:30:00.000000',
        '2025-10-19 11:30:00.000000',
        749000,
        1,
        5,
        16
    ),
    (
        8,
        '2025-10-20 16:20:00.000000',
        '2025-10-20 16:20:00.000000',
        549000,
        2,
        6,
        8
    );

-- ==================== INSERT DATA FOR REVIEW ====================
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
        '2025-10-15 10:25:00.000000',
        '2025-10-15 10:25:00.000000',
        5,
        'Great quality and comfortable!',
        1,
        1
    ),
    (
        2,
        '2025-10-16 15:40:00.000000',
        '2025-10-16 15:40:00.000000',
        4,
        'Good fit but a bit pricey',
        2,
        3
    ),
    (
        3,
        '2025-10-18 12:15:00.000000',
        '2025-10-18 12:15:00.000000',
        5,
        'Excellent dress, perfect for parties!',
        2,
        5
    ),
    (
        4,
        '2025-10-19 18:50:00.000000',
        '2025-10-19 18:50:00.000000',
        4,
        'Nice jacket, great for winter',
        3,
        7
    ),
    (
        5,
        '2025-10-20 20:30:00.000000',
        '2025-10-20 20:30:00.000000',
        3,
        'Average quality',
        1,
        2
    );

-- ==================== INSERT DATA FOR SHIPPING_ADDRESS ====================
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
        '2025-02-10 08:45:00.000000',
        '2025-10-15 11:30:00.000000',
        '123 Nguyen Hue Street',
        '0987654321',
        'Ho Chi Minh City',
        'Nguyen Van John',
        'Ben Thanh Ward',
        1
    ),
    (
        2,
        '2025-03-05 09:20:00.000000',
        '2025-10-18 13:15:00.000000',
        '456 Tran Hung Dao Street',
        '0987654322',
        'Da Nang',
        'Tran Thi Jane',
        'Hai Chau Ward',
        2
    ),
    (
        3,
        '2025-03-20 14:10:00.000000',
        '2025-10-19 15:40:00.000000',
        '789 Ba Trieu Street',
        '0987654323',
        'Ha Noi',
        'Le Van Mike',
        'Hoan Kiem Ward',
        3
    ),
    (
        4,
        '2025-03-20 14:10:00.000000',
        '2025-10-19 15:40:00.000000',
        '321 Le Loi Street',
        '0987654323',
        'Ho Chi Minh City',
        'Le Van Mike 2',
        'District 1',
        3
    ),
    (
        5,
        '2025-04-12 11:05:00.000000',
        '2025-10-20 09:50:00.000000',
        '101 Pham Ngu Lao Street',
        '0987654324',
        'Nha Trang',
        'Pham Thi Sarah',
        'Vinh Phuong Ward',
        4
    );