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
-- Table structure for table `donor`
--
DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donor` (
  `users_id` int NOT NULL,
  `donor_type` varchar(50) NOT NULL,
  `no_of_times_donated` int NOT NULL DEFAULT '0',
  `donor_id` int NOT NULL,
  `avg_rating_recieved` int DEFAULT NULL,
  PRIMARY KEY (`donor_id`),
  UNIQUE KEY `users_id` (`users_id`),
  CONSTRAINT `donor_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (1,'restaurant',1,1,4),(2,'community',2,2,3),(3,'ngo',1,3,4),(5,'restaurant',5,8,3),(12,'restaurant',3,10,3);
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `food_id` int NOT NULL,
  `food_type` varchar(30) NOT NULL,
  `food_name` varchar(30) NOT NULL,
  `calorie_tracker` float DEFAULT NULL,
  `donor_id` int DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `donor_id` (`donor_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`donor_id`) REFERENCES `donor` (`donor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'veg','Lasagna',100,1),(2,'veg','Ravioli',85,2),(3,'veg','Ratatouille',100,1),(4,'veg','Pizza',120,3);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `message_content` varchar(200) NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'Hi'),(2,'How are you?'),(3,'Hi, may i know if the food(pizza) that you posted is vegetarian or not? '),(4,'Yes, It is veg'),(5,'ok, thanks i\'ll come for the pickup');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiver`
--

DROP TABLE IF EXISTS `receiver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receiver` (
  `users_id` int NOT NULL,
  `receiver_type` varchar(50) NOT NULL,
  `avg_rating_given` int DEFAULT NULL,
  `receiver_id` int NOT NULL,
  PRIMARY KEY (`receiver_id`),
  UNIQUE KEY `users_id` (`users_id`),
  CONSTRAINT `receiver_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiver`
--

LOCK TABLES `receiver` WRITE;
/*!40000 ALTER TABLE `receiver` DISABLE KEYS */;
INSERT INTO `receiver` VALUES (4,'ngo',4,1),(5,'ngo',4,2),(2,'ngo',5,3),(1,'individual',5,4),(21,'ngo',6,5);
/*!40000 ALTER TABLE `receiver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `restaurant_id` int NOT NULL AUTO_INCREMENT,
  `safety_rating` enum('1','2','3','4','5') DEFAULT NULL,
  `food_type` varchar(30) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'3','veg','#333 president road'),(2,'4','pizzaria','914 south miller'),(6,'2','fried chicken','819 times square, new york'),(7,'2','veg','2, west lane, punjab'),(11,'5','burgers','23 lafflin street');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abc','abc','abc@abc.com'),('test','test','test@Test.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name_of_organization` varchar(30) DEFAULT NULL,
  `org_id` int DEFAULT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `contact_number` bigint DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `password` (`password`),
  UNIQUE KEY `org_id` (`org_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`org_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'david_paul','pwd123!','',2,'David','Paul','davidpaul@gmail.com',1234567891,'8 Mile'),(2,'mariaant12','pwd123@','Italiano Pizza joint',1,'Mario','Antonio','marie12@gmail.com',1336587948,'Polk Street'),(3,'andreaJose','pwd123#','Nando s Grill',6,'Andrea','Jose','andyjose@gmail.com',3549875632,'S Morgan street'),(4,'alexm13','pwd123$','',7,'Alex','Michael','amichael@gmail.com',6598741236,'Claremont Ave'),(5,'sarahJ','pwd123%','',11,'Sarah','John','sarahaha@gmail.com',5658479687,'S Aberdeen'),(12,'sandreaJosee','pwd123#2s',NULL,NULL,'Andreaa','Josee','kandyjosee@gmail.com',6549875633,'C Morgan street'),(21,'andreaJosee','pwd123#2',NULL,NULL,'Andreaa','Josee','andyjosee@gmail.com',3549875633,'B Morgan street');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer` (
  `users_id` int NOT NULL,
  `volunteer_name` varchar(30) NOT NULL,
  `preferred_location` varchar(30) NOT NULL,
  `location_radius` decimal(3,1) NOT NULL,
  `availability_date` date NOT NULL,
  PRIMARY KEY (`users_id`),
  UNIQUE KEY `users_id` (`users_id`),
  UNIQUE KEY `volunteer_name` (`volunteer_name`),
  CONSTRAINT `volunteer_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (1,'David Paul','Downtown Chicago',20.0,'2022-03-21'),(2,'Mario Antonio','NEW york',22.3,'2022-03-25'),(3,'andreaJ','Boston',20.0,'2022-03-25');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-01 21:13:12
