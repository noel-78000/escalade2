
LOCK TABLES `address` WRITE;
INSERT INTO `address` VALUES (1,'2 rue du mal de lattre de tassigny','paris','FRANCE','75001');
INSERT INTO `address` VALUES (2,'50 rue Leclerc','paris','FRANCE','75002');
INSERT INTO `address` VALUES (3,'43 rue du général mougin','paris','FRANCE','75003');
INSERT INTO `address` VALUES (4,'601 avenue du rang', 'paris','FRANCE','75004');
INSERT INTO `address` VALUES (5,'71 rue passant','paris','FRANCE','75005');
INSERT INTO `address` VALUES (6,'91 boulevard jean houdan','paris','FRANCE','75006');
INSERT INTO `address` VALUES (7,'14 rue du mont saint cric','paris','FRANCE','75007');
INSERT INTO `address` VALUES (8,'92 avenue tireblanc','paris','FRANCE','75008');
INSERT INTO `address` VALUES (9,'51 rue la promenade','paris','FRANCE','75009');
UNLOCK TABLES;



LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'noel@yahoo.fr','Noël','Dep','1234','0102030405',2,1);
INSERT INTO `user` VALUES (2,'user2@yahoo.fr','Jean','Durant','1234','0605033624',1,2);
INSERT INTO `user` VALUES (3,'user3l@yahoo.fr','Christophe','Dechamps','1234','0165235847',1,3);
INSERT INTO `user` VALUES (4,'user4@yahoo.fr','Pierre','Grand','1234','0723684525',1,4);
INSERT INTO `user` VALUES (5,'user5@yahoo.fr','Michael','Dupuis','1234','0132563547',1,5);
INSERT INTO `user` VALUES (6,'user6@yahoo.fr','Thierry','Hoareau','1234','0785696547',1,6);
INSERT INTO `user` VALUES (7,'user7@yahoo.fr','François','Labois','1234','0696354759',1,7);
INSERT INTO `user` VALUES (8,'asso1@yahoo.fr','Eric','Lundel','1234','0736254569',2,8);
INSERT INTO `user` VALUES (9,'asso2@yahoo.fr','Raphaël','mantoux','1234','0624530120',2,9);
UNLOCK TABLES;



LOCK TABLES `site` WRITE;
INSERT INTO `site` VALUES (1,'togo', 'Saint Leu');
INSERT INTO `site` VALUES (2,'ravine Bernica', 'Saint Pierre');
INSERT INTO `site` VALUES (3,'Bassin plat', 'Le Tampon');
INSERT INTO `site` VALUES (4, 'Ravine Grand étang', 'Piton saint Leu');
UNLOCK TABLES;



LOCK TABLES `secteur` WRITE;
INSERT INTO `secteur` VALUES (1,'secteur 1', 1);
INSERT INTO `secteur` VALUES (2,'secteur 2', 1);
INSERT INTO `secteur` VALUES (3,'secteur 3', 1);
INSERT INTO `secteur` VALUES (4,'secteur 4', 2);
INSERT INTO `secteur` VALUES (5,'secteur 5', 2);
INSERT INTO `secteur` VALUES (6,'secteur 6', 3);
INSERT INTO `secteur` VALUES (7,'secteur 5', 4);
UNLOCK TABLES;

LOCK TABLES `voie` WRITE;
INSERT INTO `voie` VALUES (1,'voie 1', 1);
INSERT INTO `voie` VALUES (2,'voie 2', 1);
INSERT INTO `voie` VALUES (3,'voie 3', 2);
INSERT INTO `voie` VALUES (4,'voie 4', 3);
INSERT INTO `voie` VALUES (5,'voie 5', 4);
INSERT INTO `voie` VALUES (6,'voie 6', 5);
INSERT INTO `voie` VALUES (7,'voie 7', 6);
INSERT INTO `voie` VALUES (8,'voie 8', 7);
UNLOCK TABLES;

LOCK TABLES `longueur` WRITE;
INSERT INTO `longueur` VALUES (1,'3a', 1);
INSERT INTO `longueur` VALUES (2,'7b+', 1);
INSERT INTO `longueur` VALUES (3,'6', 2);
INSERT INTO `longueur` VALUES (4,'5a', 3);
INSERT INTO `longueur` VALUES (5,'7c', 4);
INSERT INTO `longueur` VALUES (6,'4a', 5);
INSERT INTO `longueur` VALUES (7,'8b', 6);
INSERT INTO `longueur` VALUES (8,'3c', 7);
INSERT INTO `longueur` VALUES (9,'6b', 8);
UNLOCK TABLES;