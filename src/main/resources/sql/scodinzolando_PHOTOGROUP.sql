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
-- Table structure for table `PHOTOGROUP`
--

DROP TABLE IF EXISTS `PHOTOGROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PHOTOGROUP` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(4000) DEFAULT NULL,
  `NAME` varchar(4000) DEFAULT NULL,
  `FACEBOOK_ID` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PHOTOGROUP`
--

LOCK TABLES `PHOTOGROUP` WRITE;
/*!40000 ALTER TABLE `PHOTOGROUP` DISABLE KEYS */;
INSERT INTO `PHOTOGROUP` VALUES (11,'/home/maria/Immagini/Festa del bastardino','Festa del bastardino',NULL),(12,'/home/maria/Immagini/Foto cani corsi educazione','Foto cani corsi educazione',NULL),(26,NULL,'Timeline Photos','400643406691254'),(27,NULL,'Allenamenti di Disc Dog','775408512548073'),(28,NULL,'Mobile Uploads','524411740981086'),(29,'12 dicembre 2014','Gara Scent Game','753362868085971'),(30,NULL,'Seminario \"Problemi comportamentali del cane adottato dal canile\"','745858685503056'),(31,NULL,'Classe di socializzazione cuccioli e cuccioloni!','734063940015864'),(32,NULL,'CanCamminiamo all\'Eremo della Sambuca','708634662558792'),(33,'Settembre 2014','Classe di socializzazione Junior','708540712568187'),(34,NULL,'Classe di socializzazione puppy e junior!','680595802029345'),(35,NULL,'L\'album dei pelosi..','437389963016598'),(36,NULL,'Stage Scent Game','655645344524391'),(37,NULL,'Gara Scent Game','654542321301360'),(38,NULL,'CanCamminiamo Parco di San Rossore','637721546316771'),(39,NULL,'Gara Dog Endurance/CaniCross','627079677380958'),(40,NULL,'Sport di simulazione venatoria - Byte in riserva','621306581291601'),(41,NULL,'CanCamminiamo al lago!','615688445186748'),(42,NULL,'Classi di socializzazione','613373885418204'),(43,'Carnevale di Coltano','Sfilata mascherata a 6 zampe','603339363088323'),(44,NULL,'Profile Pictures','394323940656534'),(45,'Ricerca su scatole e su ambiente','Allenamento Scent Game','531542353601358');
/*!40000 ALTER TABLE `PHOTOGROUP` ENABLE KEYS */;
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
