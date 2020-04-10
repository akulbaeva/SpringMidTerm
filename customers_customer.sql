DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint NOT NULL,
  `city` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `job_title` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `mobile_phone` varchar(50) NOT NULL,
  `web_page` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;