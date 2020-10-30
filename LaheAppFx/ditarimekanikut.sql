-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.35-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ditarimekanikut
CREATE DATABASE IF NOT EXISTS `ditarimekanikut` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ditarimekanikut`;

-- Dumping structure for table ditarimekanikut.tblautomjet
CREATE TABLE IF NOT EXISTS `tblautomjet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `targa` varchar(45) NOT NULL,
  `nrshasi` varchar(45) DEFAULT NULL,
  `marka` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `cilindrata` varchar(45) NOT NULL,
  `fuqia` varchar(45) NOT NULL,
  `kambio` varchar(45) NOT NULL,
  `karburant` varchar(45) NOT NULL,
  `viti` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblkambio
CREATE TABLE IF NOT EXISTS `tblkambio` (
  `id` int(11) NOT NULL,
  `kambio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblkarburant
CREATE TABLE IF NOT EXISTS `tblkarburant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `karburanti` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblklient
CREATE TABLE IF NOT EXISTS `tblklient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emer` varchar(45) NOT NULL,
  `mbiemer` varchar(45) DEFAULT NULL,
  `kompania` varchar(45) DEFAULT NULL,
  `nrcelulari` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nrcelulari_klient_UNIQUE` (`nrcelulari`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblklient_automjet
CREATE TABLE IF NOT EXISTS `tblklient_automjet` (
  `klient_id` int(11) NOT NULL,
  `automjet_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tbllengje
CREATE TABLE IF NOT EXISTS `tbllengje` (
  `targa_automjet` varchar(45) NOT NULL,
  `tipi` varchar(45) DEFAULT NULL,
  `kodi` varchar(45) DEFAULT NULL,
  `sasia` varchar(45) DEFAULT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblmarka
CREATE TABLE IF NOT EXISTS `tblmarka` (
  `id` int(11) NOT NULL,
  `marka` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblmirembajtje
CREATE TABLE IF NOT EXISTS `tblmirembajtje` (
  `targa_automjet` varchar(45) NOT NULL,
  `data` date DEFAULT NULL,
  `kilometrat` varchar(150) DEFAULT NULL,
  `filter_ajri` tinyint(1) DEFAULT NULL,
  `filter_gabine` tinyint(1) DEFAULT NULL,
  `filter_vaji` tinyint(1) DEFAULT NULL,
  `filter_karburanti` tinyint(1) DEFAULT NULL,
  `sae_vaji` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblperdorues
CREATE TABLE IF NOT EXISTS `tblperdorues` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emri` varchar(50) DEFAULT '0',
  `mbiemri` varchar(50) DEFAULT '0',
  `email` varchar(50) DEFAULT '0',
  `telefon` varchar(50) DEFAULT '0',
  `adresa` varchar(100) DEFAULT '0',
  `username` varchar(50) DEFAULT '0',
  `password` varchar(50) DEFAULT '0',
  `isAdmin` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table ditarimekanikut.tblpjeskembimi
CREATE TABLE IF NOT EXISTS `tblpjeskembimi` (
  `targa_automjet` varchar(45) NOT NULL,
  `kod_pjese` varchar(45) DEFAULT NULL,
  `emer_pjese` varchar(45) DEFAULT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
