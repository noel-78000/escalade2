DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `address` varchar(255) DEFAULT NULL,
                           `city` varchar(50) DEFAULT NULL,
                           `country` varchar(50) DEFAULT NULL,
                           `zipcode` varchar(5) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `email` varchar(100) NOT NULL,
                        `firstName` varchar(50) DEFAULT NULL,
                        `lastName` varchar(50) DEFAULT NULL,
                        `pwd` varchar(100) NOT NULL,
                        `role` tinyint(4) DEFAULT NULL,
                        `address_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_email` (`email`),
                        CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

