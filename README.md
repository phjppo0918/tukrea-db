실행하면 DB 생성됨

<img width="694" alt="image" src="https://github.com/phjppo0918/tukrea-db/assets/55674648/e87244d0-95d4-4dc0-a537-a2e4be903a1f">

# dump 

``` bash
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` bigint NOT NULL,
  `question_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `writer_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8frr4bcabmmeyyu60qt7iiblo` (`question_id`),
  KEY `FKj16hlfi1umbj17ye5n1vc9dgx` (`writer_email`),
  CONSTRAINT `FK8frr4bcabmmeyyu60qt7iiblo` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FKj16hlfi1umbj17ye5n1vc9dgx` FOREIGN KEY (`writer_email`) REFERENCES `member` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer_vote`
--

DROP TABLE IF EXISTS `answer_vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer_vote` (
  `is_positive` bit(1) NOT NULL,
  `answer_id` bigint NOT NULL,
  `member_email` varchar(255) NOT NULL,
  PRIMARY KEY (`answer_id`,`member_email`),
  KEY `FKsx3aodm8mbftxk5cpu8niflc` (`member_email`),
  CONSTRAINT `FKp422lmglrcvet69832dmygyx8` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`),
  CONSTRAINT `FKsx3aodm8mbftxk5cpu8niflc` FOREIGN KEY (`member_email`) REFERENCES `member` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_vote`
--

LOCK TABLES `answer_vote` WRITE;
/*!40000 ALTER TABLE `answer_vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer_vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depart`
--

DROP TABLE IF EXISTS `depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `depart` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `univ_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FKgnn8whegf39epptwes8m5xavo` (`univ_code`),
  CONSTRAINT `FKgnn8whegf39epptwes8m5xavo` FOREIGN KEY (`univ_code`) REFERENCES `univ` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depart`
--

LOCK TABLES `depart` WRITE;
/*!40000 ALTER TABLE `depart` DISABLE KEYS */;
/*!40000 ALTER TABLE `depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture` (
  `code` varchar(255) NOT NULL,
  `depart_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FKrmtpxsuhcbgrc8eumhk3sdpx8` (`depart_code`),
  CONSTRAINT `FKrmtpxsuhcbgrc8eumhk3sdpx8` FOREIGN KEY (`depart_code`) REFERENCES `depart` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `depart_code` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `student_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`),
  KEY `FKlse3khdlwmd8tway950v5dmoy` (`depart_code`),
  CONSTRAINT `FKlse3khdlwmd8tway950v5dmoy` FOREIGN KEY (`depart_code`) REFERENCES `depart` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `lecture_code` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `writer_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq4l6aakjnn3ggic6f65jb21y9` (`lecture_code`),
  KEY `FK2b9rtfqh2wet03r038x2fvq8g` (`writer_email`),
  CONSTRAINT `FK2b9rtfqh2wet03r038x2fvq8g` FOREIGN KEY (`writer_email`) REFERENCES `member` (`email`),
  CONSTRAINT `FKq4l6aakjnn3ggic6f65jb21y9` FOREIGN KEY (`lecture_code`) REFERENCES `lecture` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_comment`
--

DROP TABLE IF EXISTS `question_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_comment` (
  `id` bigint NOT NULL,
  `question_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `writer_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgatho66t7ix04m6dothg6jaqh` (`question_id`),
  KEY `FKm2x4j3rq6tkphhmakkslgwvhp` (`writer_email`),
  CONSTRAINT `FKgatho66t7ix04m6dothg6jaqh` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FKm2x4j3rq6tkphhmakkslgwvhp` FOREIGN KEY (`writer_email`) REFERENCES `member` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_comment`
--

LOCK TABLES `question_comment` WRITE;
/*!40000 ALTER TABLE `question_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_tag`
--

DROP TABLE IF EXISTS `question_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_tag` (
  `question_id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`question_id`,`name`),
  CONSTRAINT `FK44ydihbi2qk8k96175quf5q63` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_tag`
--

LOCK TABLES `question_tag` WRITE;
/*!40000 ALTER TABLE `question_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_vote`
--

DROP TABLE IF EXISTS `question_vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_vote` (
  `is_positive` bit(1) NOT NULL,
  `question_id` bigint NOT NULL,
  `member_email` varchar(255) NOT NULL,
  PRIMARY KEY (`question_id`,`member_email`),
  KEY `FKods3t4kbbj86vnq5mif6fhmmk` (`member_email`),
  CONSTRAINT `FKast4xiggbs08xfqm2oltcl32l` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FKods3t4kbbj86vnq5mif6fhmmk` FOREIGN KEY (`member_email`) REFERENCES `member` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_vote`
--

LOCK TABLES `question_vote` WRITE;
/*!40000 ALTER TABLE `question_vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `univ`
--

DROP TABLE IF EXISTS `univ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `univ` (
  `code` varchar(255) NOT NULL,
  `email_domain` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `univ`
--

LOCK TABLES `univ` WRITE;
/*!40000 ALTER TABLE `univ` DISABLE KEYS */;
/*!40000 ALTER TABLE `univ` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-28 16:01:12
```
