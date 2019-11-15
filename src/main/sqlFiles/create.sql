ALTER TABLE `user` DROP INDEX `index_email`;
DROP TABLE IF EXISTS `user`;

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
                        `phonenumber` varchar(10) DEFAULT NULL,
                        `role` tinyint(4) DEFAULT NULL,
                        `address_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_email` (`email`),
                        CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX `index_email` ON `user` (email);

DROP TABLE IF EXISTS `longueur`;
DROP TABLE IF EXISTS `voie`;
DROP TABLE IF EXISTS `secteur`;
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `nom` varchar(100) NOT NULL,
                        `lieu` varchar(100) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `secteur`;
CREATE TABLE `secteur` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `nom` varchar(100) NOT NULL,
                        `site_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        CONSTRAINT fk_site FOREIGN KEY (site_id) REFERENCES site(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `voie`;
CREATE TABLE `voie` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `nom` varchar(100) NOT NULL,
                        `secteur_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        CONSTRAINT fk_secteur FOREIGN KEY (secteur_id) REFERENCES secteur(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `longueur`;
CREATE TABLE `longueur` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `cotation` varchar(3) NOT NULL,
                           `voie_id` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           CONSTRAINT fk_voie FOREIGN KEY (voie_id) REFERENCES voie(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





