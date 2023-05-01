#CREATE DATABASE `java_ejercicio_7`;
USE `java_ejercicio_7`;

DROP TABLE IF EXISTS `rol_persona`;
DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_doc` varchar(10) NOT NULL,
  `nro_doc` varchar(45) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `habilitado` tinyint(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;



LOCK TABLES `persona` WRITE;
INSERT INTO `persona` VALUES (1,'dni','10101010','Juan','Perez','jp@gmail.com','4101010',1,'jperez'),(2,'dni','12121212','John','Doe','contacto@jd','4121212',0,'jdoe'),(3,'dni','13131313','Nadie','Sabe','ns@ns.com','4131313',1,'nsabe'),(4,'cuit','14141414141','Identidad','Desconocida','unknown@gmail.com','4141414',0,'idesconocida'),(5,'cuit','15151515151','Alguien','Más','am@gmail.com','4151515',1,'amas'),(6,'dni','16161616','Otra','Persona','op@gmail.com','4161616',0,'opersona');
UNLOCK TABLES;


DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


LOCK TABLES `rol` WRITE;
INSERT INTO `rol` VALUES (1,'admin'),(2,'user');
UNLOCK TABLES;


#DROP TABLE IF EXISTS `rol_persona`;

CREATE TABLE `rol_persona` (
  `id_persona` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`,`id_rol`),
  KEY `rol_persona_rol_fk` (`id_rol`),
  CONSTRAINT `rol_persona_persona_fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `rol_persona_rol_fk` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


LOCK TABLES `rol_persona` WRITE;
INSERT INTO `rol_persona` VALUES (1,1),(2,2),(3,1),(3,2),(4,2),(5,2),(6,2);
UNLOCK TABLES;