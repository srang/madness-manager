CREATE TABLE user_roles (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar (50) COLLATE utf8_unicode_ci  NOT NULL,
  `role` varchar(45) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY uni_username_role (`role`,`username`),
  KEY fk_username_idx (`username`),
  CONSTRAINT `user_roles_username_users` FOREIGN KEY (`username`) REFERENCES users (`username`))
;