
CREATE TABLE `upload_files` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `origin_url` varchar(500) DEFAULT NULL,
                                `thumb_url` varchar(500) DEFAULT NULL,
                                `type` varchar(40) NOT NULL,
                                `size` bigint DEFAULT NULL ,
                                `origin_name` varchar(255) DEFAULT null ,
                                `duration` int DEFAULT NULL,
                                `height` int DEFAULT NULL,
                                `width` int DEFAULT NULL,
                                `deleted` bit(1) NOT NULL DEFAULT 0,
                                `created_at` datetime NOT NULL,
                                `updated_at` datetime NOT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `roles` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `name` varchar(20) NOT NULL,
                         `title` varchar(60) DEFAULT NULL,
                         `description` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `phone` varchar(20) NOT NULL,
                         `email` varchar(40) DEFAULT NULL,
                         `name` varchar(40) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `image_url` varchar(500) DEFAULT NULL,
                         `avatar_id` bigint(20) DEFAULT NULL,
                         `cover_id` bigint(20) DEFAULT NULL,
                         `birthday` datetime DEFAULT NULL,
                         `gender` int DEFAULT NULL,
                         `deleted` bit(1) NOT NULL DEFAULT 0,
                         `created_at` datetime NOT NULL,
                         `updated_at` datetime NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY (`email`),
                         UNIQUE KEY (`phone`),
                         FOREIGN KEY (`avatar_id`) REFERENCES `upload_files` (`id`),
                         FOREIGN KEY (`cover_id`) REFERENCES `upload_files` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_roles` (
                              `user_id` bigint(20) NOT NULL,
                              `role_id` bigint(20) NOT NULL,
                              PRIMARY KEY (`user_id`,`role_id`),
                              FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
                              FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE  `Suppliers`(
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `title` varchar(500) NOT NULL,
                             `description` text DEFAULT NULL,
                             `media_id` bigint(20) DEFAULT NULL,
                             `deleted` bit(1) NOT NULL DEFAULT 0,
                             `status` int NOT NULL default 0,
                             `created_at` datetime NOT NULL,
                             `updated_at` datetime NOT NULL,
                             PRIMARY KEY (`id`),
                             FOREIGN KEY (`media_id`) REFERENCES `upload_files` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `payment`(
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `title` varchar(500) NOT NULL,
                          `pay_date` Date NOT NULL,
                          `type` int null,
                          `surcharges` bigint NOT NULL DEFAULT 0,
                          `Total` bigint NOT NULL DEFAULT 0,
                          `object_id` bigint(20) DEFAULT NULL,
                          `object_type` int default null ,
                          `description` text DEFAULT NULL,
                          `deleted` bit(1) NOT NULL DEFAULT 0,
                          `status` int NOT NULL default 0,
                          `created_at` datetime NOT NULL,
                          `updated_at` datetime NOT NULL,
                          PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `timesheet`(
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `user_id` bigint(20) NOT NULL,
                            `title` varchar(500) NOT NULL,
                            `DateUse` Date NOT NULL,
                            `release_time` Date NOT NULL,
                            `detail_time` varchar(500) DEFAULT NULL,
                            `description` text DEFAULT NULL,
                            `deleted` bit(1) NOT NULL DEFAULT 0,
                            `status` int NOT NULL default 0,
                            `created_at` datetime NOT NULL,
                            `updated_at` datetime NOT NULL,
                            FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                            PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `payroll`(
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `timesheet_id` bigint(20) NOT NULL,
                          `title` varchar(500) NOT NULL,
                          `Tax` bigint NULL,
                          `net_pay` bigint NOT NULL DEFAULT 0,
                          `gross_pay` bigint NOT NULL DEFAULT 0,
                          `allowance` bigint NOT NULL DEFAULT 0,
                          `fines` bigint NOT NULL DEFAULT 0,
                          `ReleaseTime` Date NOT NULL,
                          `description` text DEFAULT NULL,
                          `deleted` bit(1) NOT NULL DEFAULT 0,
                          `status` int NOT NULL default 0,
                          `created_at` datetime NOT NULL,
                          `updated_at` datetime NOT NULL,
                          FOREIGN KEY (`timesheet_id`) REFERENCES `Timesheet` (`id`),
                          PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `products_category`(
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `title` varchar(500) NOT NULL,
                                    `description` text DEFAULT NULL,
                                    `deleted` bit(1) NOT NULL DEFAULT 0,
                                    `status` int NOT NULL default 0,
                                    `created_at` datetime NOT NULL,
                                    `updated_at` datetime NOT NULL,
                                    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `location`(
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `title` varchar(500) NOT NULL,
                           `address` text DEFAULT NULL,
                           `deleted` bit(1) NOT NULL DEFAULT 0,
                           `status` int NOT NULL default 0,
                           `created_at` datetime NOT NULL,
                           `updated_at` datetime NOT NULL,
                           PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `products` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `title` varchar(500) NOT NULL,
                            `category_id` bigint(20) NOT NULL,
                            `description` text DEFAULT NULL,
                            `image_url` varchar(500) DEFAULT NULL,
                            `location_id` bigint(20) NOT NULL,
                            `media_id` bigint(20) DEFAULT NULL,
                            `media_ids` varchar (255) DEFAULT NULL,
                            `rating` int(1) NOT NULL DEFAULT 0,
                            `price_after_discount` bigint NOT NULL DEFAULT 0,
                            `deleted` bit(1) NOT NULL DEFAULT 0,
                            `price` bigint NOT NULL default 0,
                            `remain` int NOT NULL default 0,
                            `sold` int NULL default 0,
                            `supplier_id` bigint(20) NOT NULL,
                            `status` int NOT NULL default 0,
                            `created_at` datetime NOT NULL,
                            `updated_at` datetime NOT NULL,
                            PRIMARY KEY (`id`),
                            FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
                            FOREIGN KEY (`media_id`) REFERENCES `upload_files` (`id`),
                            FOREIGN KEY (`category_id`) REFERENCES `products_category` (`id`),
                            FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `orders` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `code` varchar(20) NOT NULL,
                          `phone` varchar(20) NOT NULL,
                          `email` varchar(60) DEFAULT NULL,
                          `username` varchar(60) DEFAULT NULL,
                          `owner_id` bigint(20) NOT NULL,
                          `address` varchar(500) DEFAULT NULL,
                          `note` text DEFAULT NULL,
                          `total_price` bigint(20) NOT NULL DEFAULT '0',
                          `pay_date` datetime DEFAULT NULL,
                          `payment_method` varchar(255) NOT NULL,
                          `payment_status` int(2) NOT NULL DEFAULT '0',
                          `status` varchar(40) NOT NULL,
                          `deleted` bit(1) NOT NULL DEFAULT 0,
                          `created_at` datetime NOT NULL,
                          `updated_at` datetime NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY (`code`),
                          FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_carts` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `product_id` bigint(20) NOT NULL,
                               `order_id` bigint(20) NOT NULL,
                               `price` bigint(20) NOT NULL DEFAULT '0',
                               `amount` int NOT NULL DEFAULT '0',
                               `status` int(2) NOT NULL DEFAULT 0,
                               `deleted` bit(1) NOT NULL DEFAULT 0,
                               `created_at` datetime NOT NULL,
                               `updated_at` datetime NOT NULL,
                               PRIMARY KEY (`id`),
                               FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
                               FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mobile_devices` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                  `os_type` varchar(20) NOT NULL,
                                  `firebase_token` varchar(255) NOT NULL,
                                  `owner_id` bigint(20) NOT NULL,
                                  `device_key` varchar(50) NOT NULL,
                                  `app_version` varchar(20) NOT NULL,
                                  `status` int NOT NULL,
                                  `deleted` bit(1) NOT NULL DEFAULT 0,
                                  `created_at` datetime NOT NULL,
                                  `updated_at` datetime NOT NULL,
                                  PRIMARY KEY (`id`),
                                  FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `notifications` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `title` varchar(255) NOT NULL,
                                 `content`text NOT NULL,
                                 `owner_id` bigint(20) NOT NULL,
                                 `receiver_id` bigint(20) DEFAULT NULL,
                                 `receiver_type` int NOT NULL,
                                 `object_type` int NOT NULL,
                                 `object_id` bigint(20) DEFAULT NULL,
                                 `seen` bit(1) NOT NULL DEFAULT 0,
                                 `deleted` bit(1) NOT NULL DEFAULT 0,
                                 `created_at` datetime NOT NULL,
                                 `updated_at` datetime NOT NULL,
                                 PRIMARY KEY (`id`),
                                 FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `configs` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `key` varchar(255) NOT NULL,
                           `value` varchar(255) NOT NULL,
                           `description` varchar(255) NOT NULL,
                           `status` int NOT NULL DEFAULT 0,
                           `deleted` bit(1) NOT NULL DEFAULT b'0',
                           `created_at` datetime NOT NULL,
                           `updated_at` datetime NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `banners` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `object_id` bigint(20) DEFAULT NULL,
                           `url` varchar(500) DEFAULT NULL,
                           `object_type` int(2) NOT NULL,
                           `owner_id` bigint(20) NOT NULL,
                           `media_id` bigint(20) NOT NULL,
                           `description` varchar(255) DEFAULT NULL,
                           `type` int(1) NOT NULL,
                           `deleted` bit(1) NOT NULL DEFAULT 0,
                           `created_at` datetime NOT NULL,
                           `updated_at` datetime NOT NULL,
                           PRIMARY KEY (`id`),
                           FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`),
                           FOREIGN KEY (`media_id`) REFERENCES `upload_files` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
