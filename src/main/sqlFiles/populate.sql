
LOCK TABLES `address` WRITE;
INSERT INTO `address` VALUES (1,'2 rue du mal de lattre de tassigny','paris','FRANCE','75001');
UNLOCK TABLES;



LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'noel@yahoo.fr','noel','DEP','1234',2,1);
UNLOCK TABLES;
