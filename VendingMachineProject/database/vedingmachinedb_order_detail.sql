-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: vedingmachinedb
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `idOrder` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_detail_order_idx` (`idOrder`),
  CONSTRAINT `id_detail_order` FOREIGN KEY (`idOrder`) REFERENCES `order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (11,'Fanta',20,38,1),(12,'Coca cola',20,38,2),(13,'Pepsi',10,38,1),(14,'Fanta',20,39,1),(15,'Coca cola',30,39,3),(16,'Fanta',20,40,1),(17,'Coca cola',20,40,2),(18,'Fanta',20,41,1),(19,'Coca cola',30,41,3),(20,'Fanta',20,42,1),(21,'Coca cola',30,42,3),(22,'Fanta',20,43,1),(23,'Coca cola',30,43,3),(24,'Fanta',20,44,1),(25,'Coca cola',30,44,3),(26,'Fanta',60,45,3),(27,'Coca cola',10,45,1),(28,'Fanta',20,46,1),(29,'Coca cola',30,46,3),(30,'Fanta',40,47,2),(31,'Coca cola',30,47,3),(32,'Fanta',20,48,1),(33,'Coca cola',30,48,3),(34,'Fanta',20,49,1),(35,'Coca cola',30,49,3),(36,'Fanta',20,50,1),(37,'Coca cola',30,50,3),(38,'Fanta',20,51,1),(39,'Coca cola',30,51,3),(40,'Fanta',20,52,1),(41,'Coca cola',10,52,1),(42,'Pepsi',10,52,1),(43,'Coca cola',30,52,3),(44,'Coca cola',20,53,2),(45,'Pepsi',30,53,3),(46,'Fanta',60,53,3),(47,'Fanta',60,53,3),(48,'Coca cola',10,53,1),(49,'Fanta',40,54,2),(50,'Coca cola',10,54,1),(51,'Fanta',60,54,3),(52,'Coca cola',30,54,3),(53,'Fanta',60,55,3),(54,'Coca cola',30,55,3);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01 15:43:35
