DROP DATABASE IF EXISTS souvenir0911;
DROP USER IF EXISTS 'souvenir0911'@'localhost';

CREATE DATABASE IF NOT EXISTS souvenir0911 CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'souvenir0911'@'localhost' IDENTIFIED BY 'souvenir0911';
GRANT ALL PRIVILEGES ON souvenir0911. * TO 'souvenir0911'@'localhost';

/*tables*/
CREATE TABLE `souvenir_categories` (
  `souvenir_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_category` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`souvenir_category_id`),
  UNIQUE KEY `souvenir_category_UNIQUE` (`souvenir_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `souvenirs` (
  `souvenir_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_category_id` int(11) NOT NULL,
  `souvenir_name` varchar(75) COLLATE utf8_bin NOT NULL,
  `souvenir_description` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `souvenir_visibility` tinyint(1) NOT NULL DEFAULT '0',
  `souvenir_price` decimal(7,2) NOT NULL,
  `souvenir_count_day_to_order` int(11) NOT NULL,
  PRIMARY KEY (`souvenir_id`),
  UNIQUE KEY `souvenir_name_UNIQUE` (`souvenir_name`),
  KEY `souvenirs_souvenir_category_id_fk_idx` (`souvenir_category_id`),
  CONSTRAINT `souvenirs_souvenir_category_id_fk` FOREIGN KEY (`souvenir_category_id`) REFERENCES `souvenir_categories` (`souvenir_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `souvenirs_photo` (
  `souvenir_photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_photo_path` varchar(500) COLLATE utf8_bin NOT NULL,
  `souvenir_photo_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `souvenir_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`souvenir_photo_id`),
  UNIQUE KEY `souvenir_photo_name_UNIQUE` (`souvenir_photo_name`),
  KEY `souvenirs_photo_souvenir_id_fk_idx` (`souvenir_id`),
  CONSTRAINT `souvenirs_photo_souvenir_id_fk` FOREIGN KEY (`souvenir_id`) REFERENCES `souvenirs` (`souvenir_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `souvenirs_audit` (
  `souvenir_id` int(11) NOT NULL,
  `created_datetime` datetime NOT NULL,
  `last_update_datetime` datetime NOT NULL,
  PRIMARY KEY (`souvenir_id`),
  CONSTRAINT `souvenirs_audit_souvenir_id_fk` FOREIGN KEY (`souvenir_id`) REFERENCES `souvenirs` (`souvenir_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
