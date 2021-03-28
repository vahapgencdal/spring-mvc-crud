CREATE SCHEMA  IF NOT EXISTS `assignment`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `agree_to_terms` bit(1) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sector`;
CREATE TABLE `sector` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `user_sector`;
CREATE TABLE `user_sector` (
  `user_id` bigint(20) NOT NULL,
  `sector_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`sector_id`)
);

--sector--
alter table sector add CONSTRAINT `FKn6jfoe213mlnafoaiaolvh5c8` FOREIGN KEY (`parent_id`) REFERENCES `sector` (`id`);

--user_sector--
alter table user_sector add CONSTRAINT `FKajjtoc3nwpa9dhcy720g3bgxs` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`id`);
alter table user_sector add CONSTRAINT `FKot4oeus7wpkmfpmi23ugbect4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
