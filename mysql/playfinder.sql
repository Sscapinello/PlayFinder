CREATE DATABASE  IF NOT EXISTS `playfinder` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `playfinder`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: playfinder
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `campo`
--

DROP TABLE IF EXISTS `campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campo` (
  `idCampo` int(11) NOT NULL,
  `via` varchar(45) NOT NULL,
  `citta` varchar(45) NOT NULL,
  `regione` varchar(45) NOT NULL,
  PRIMARY KEY (`idCampo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campo`
--

LOCK TABLES `campo` WRITE;
/*!40000 ALTER TABLE `campo` DISABLE KEYS */;
/*!40000 ALTER TABLE `campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `nPartecipanti` int(11) NOT NULL,
  `durata` double NOT NULL,
  `rCasa` int(11) NOT NULL,
  `rTrasferta` int(11) NOT NULL,
  `sport_nomeSport` varchar(20) NOT NULL,
  `squadra_nome` varchar(50) NOT NULL,
  `squadra_nome1` varchar(50) NOT NULL,
  `terminato` tinyint(1) NOT NULL DEFAULT '0',
  `campo_idCampo` int(11) NOT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `fk_evento_sport_idx` (`sport_nomeSport`),
  KEY `fk_evento_squadra1_idx` (`squadra_nome`),
  KEY `fk_evento_squadra2_idx` (`squadra_nome1`),
  KEY `fk_campo_idCampo_idx` (`campo_idCampo`),
  CONSTRAINT `fk_campo_idCampo` FOREIGN KEY (`campo_idCampo`) REFERENCES `campo` (`idCampo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evento_sport` FOREIGN KEY (`sport_nomeSport`) REFERENCES `sport` (`nomeSport`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_squadra1` FOREIGN KEY (`squadra_nome`) REFERENCES `squadra` (`nome`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_squadra2` FOREIGN KEY (`squadra_nome1`) REFERENCES `squadra` (`nome`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport`
--

DROP TABLE IF EXISTS `sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport` (
  `nomeSport` varchar(20) NOT NULL,
  `nPartecipanti` int(11) NOT NULL COMMENT 'per squadra',
  PRIMARY KEY (`nomeSport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport`
--

LOCK TABLES `sport` WRITE;
/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `squadra`
--

DROP TABLE IF EXISTS `squadra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `squadra` (
  `nome` varchar(50) NOT NULL,
  `sport_nomeSport` varchar(20) NOT NULL,
  PRIMARY KEY (`nome`),
  KEY `fk_squadra_sport1_idx` (`sport_nomeSport`),
  CONSTRAINT `fk_squadra_sport1` FOREIGN KEY (`sport_nomeSport`) REFERENCES `sport` (`nomeSport`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `squadra`
--

LOCK TABLES `squadra` WRITE;
/*!40000 ALTER TABLE `squadra` DISABLE KEYS */;
/*!40000 ALTER TABLE `squadra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(40) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `cognome` varchar(60) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `eta` int(11) NOT NULL,
  `email` varchar(70) NOT NULL,
  `citta` varchar(30) NOT NULL,
  `regione` varchar(30) NOT NULL,
  `squadra_nome` varchar(50) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_user_squadra1_idx` (`squadra_nome`),
  CONSTRAINT `fk_user_squadra1` FOREIGN KEY (`squadra_nome`) REFERENCES `squadra` (`nome`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-18 15:51:03
