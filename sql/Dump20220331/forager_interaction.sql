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
-- Table structure for table `interaction`
--

DROP TABLE IF EXISTS `interaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interaction` (
  `interaction_id` int NOT NULL AUTO_INCREMENT,
  `message_id` int NOT NULL,
  `reply_of` int DEFAULT NULL,
  `to_id` int NOT NULL,
  `from_id` int NOT NULL,
  `date_created` datetime NOT NULL,
  PRIMARY KEY (`interaction_id`),
  UNIQUE KEY `message_id` (`message_id`),
  KEY `to_id` (`to_id`),
  KEY `from_id` (`from_id`),
  KEY `reply_of` (`reply_of`),
  CONSTRAINT `interaction_ibfk_1` FOREIGN KEY (`to_id`) REFERENCES `users` (`ID`),
  CONSTRAINT `interaction_ibfk_2` FOREIGN KEY (`from_id`) REFERENCES `users` (`ID`),
  CONSTRAINT `interaction_ibfk_3` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`),
  CONSTRAINT `interaction_ibfk_4` FOREIGN KEY (`reply_of`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interaction`
--

LOCK TABLES `interaction` WRITE;
/*!40000 ALTER TABLE `interaction` DISABLE KEYS */;
INSERT INTO `interaction` VALUES (1,1,NULL,21,12,'2015-06-24 00:00:00'),(2,2,NULL,12,21,'2015-06-24 00:00:00'),(3,3,NULL,3,1,'2015-06-24 00:00:00'),(4,4,NULL,3,4,'2018-06-25 00:00:00'),(5,5,4,2,5,'2019-06-25 00:00:00');
/*!40000 ALTER TABLE `interaction` ENABLE KEYS */;
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
