-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: forager
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `food_order`
--

DROP TABLE IF EXISTS `food_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_order` (
  `order_id` int NOT NULL,
  `pick_up_location` varchar(30) NOT NULL,
  `drop_location` varchar(30) NOT NULL,
  `transporter_id` int DEFAULT NULL,
  `food_id` int DEFAULT NULL,
  `pick_up_time` datetime NOT NULL,
  `drop_time` datetime NOT NULL,
  `receiver_id` int DEFAULT NULL,
  `donor_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `transporter_id` (`transporter_id`),
  KEY `food_id` (`food_id`),
  KEY `receiver_id` (`receiver_id`),
  KEY `donor_id` (`donor_id`),
  CONSTRAINT `food_order_ibfk_1` FOREIGN KEY (`transporter_id`) REFERENCES `volunteer` (`users_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `food_order_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `food_order_ibfk_3` FOREIGN KEY (`receiver_id`) REFERENCES `receiver` (`receiver_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `food_order_ibfk_4` FOREIGN KEY (`donor_id`) REFERENCES `donor` (`donor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_order`
--

LOCK TABLES `food_order` WRITE;
/*!40000 ALTER TABLE `food_order` DISABLE KEYS */;
INSERT INTO `food_order` VALUES (1,'8 Mile','S Oakley',1,1,'2022-02-18 10:30:00','2022-02-18 11:30:00',1,3),(2,'Polk Street','Paulina',2,2,'2022-03-27 22:30:00','2022-03-27 23:00:00',2,10),(3,'Morgan','Wolcott',1,3,'2022-04-09 18:30:00','2022-04-09 19:30:00',3,1),(4,'Aberdeen','Michigan Avenue',2,4,'2022-05-04 21:30:00','2022-05-04 22:40:00',4,2);
/*!40000 ALTER TABLE `food_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-31 22:47:28
