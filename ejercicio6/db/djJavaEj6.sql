
CREATE DATABASE `java_ejercicio_6` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `stock` int NOT NULL,
  `shippingIncluded` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `productos` WRITE;
INSERT INTO `productos` VALUES (1,'Locha','1L La Serenisima',450,5,1),(2,'Pan','Lactal Bimbo',510,13,0),(3,'CocaCola','1.25L Sabor Original',330,2,1);

UNLOCK TABLES;

