CREATE DATABASE  IF NOT EXISTS `scodinzolando` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scodinzolando`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: scodinzolando
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CALENDAR_EVENT`
--

DROP TABLE IF EXISTS `CALENDAR_EVENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CALENDAR_EVENT` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `END_DATE` datetime DEFAULT NULL,
  `FACEBOOK_ID` varchar(4000) DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `TITLE` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CALENDAR_EVENT`
--

LOCK TABLES `CALENDAR_EVENT` WRITE;
/*!40000 ALTER TABLE `CALENDAR_EVENT` DISABLE KEYS */;
INSERT INTO `CALENDAR_EVENT` VALUES (1,'2015-11-29 18:00:00','433929500093979','2015-11-28 09:00:00','TOSCANA - Coltano (Pisa) - 28 e 29 novembre - AGGRESSIVITA\' INTERSPECIFICA INTRAGRUPPO, relatore Dr. Aldo Violet'),(2,'2015-10-11 18:00:00','1394247577538137','2015-10-10 09:00:00','TOSCANA - Coltano (Pisa) - 10-11 ottobre - SECONDA MISCELLANEA PROBLEMI COMPORTAMENTALI NEL CANE, relatore Dr.ssa Alessandra Cerri'),(3,'2015-06-21 18:00:00','636737933118652','2015-06-20 09:00:00','TOSCANA - Coltano (Pisa) - 20 e 21 giugno - PRIMA MISCELLANEA PROBLEMI COMPORTAMENTALI NEL CANE, relatore Dr. Alessandro Bindi'),(4,'2015-05-10 18:00:00','778750075525812','2015-05-09 09:00:00','TOSCANA - Coltano (PI) - 9 e 10 maggio 2015 - Stage pratico \"L\'attivazione mentale e la discriminazione olfattiva\", con Paolo Villani e Jessica Ciminnisi'),(5,'2015-04-26 18:00:00','995763367119113','2015-04-25 09:00:00','Toscana – 25 e 26 aprile 2015 – Stage avanzato di Disc Dog con Fabio Sacco'),(6,NULL,'943176259034911','2015-03-28 01:00:00','TOSCANA - Coltano (Pisa) - 28 e 29 marzo - TECNICHE DI RIABILITAZIONE COMPORTAMENTALE, relatore Fabrizio Ruffinatto'),(7,NULL,'1531398123797243','2015-03-14 09:00:00','Coltano (Pisa) - In partenza a marzo 2015 - Corso INSCA per Educatore Cinofilo Professionista'),(8,'2015-03-01 18:00:00','1563723240538676','2015-02-28 09:00:00','Toscana – 28 febbraio e 1 marzo 2015 – Stage teorico/pratico “Disc Dog: dall’introduzione ai primi tricks” Relatori Riccardo Gaido e Irene Benedino');
/*!40000 ALTER TABLE `CALENDAR_EVENT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-16 23:34:15