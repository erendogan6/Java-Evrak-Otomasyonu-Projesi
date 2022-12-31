-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 31 Ara 2022, 19:45:55
-- Sunucu sürümü: 8.0.27
-- PHP Sürümü: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `evrakotomasyon`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `evrak`
--

DROP TABLE IF EXISTS `evrak`;
CREATE TABLE IF NOT EXISTS `evrak` (
  `seriNo` int NOT NULL,
  `dogrulamaKod` int NOT NULL,
  `tarih` varchar(255) NOT NULL,
  `tur` varchar(255) NOT NULL,
  `imzalayan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `olusturan` varchar(255) NOT NULL,
  `gecerlilik` tinyint(1) NOT NULL,
  UNIQUE KEY `dogrulamaKod` (`dogrulamaKod`),
  UNIQUE KEY `seriNo` (`seriNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `evrak`
--

INSERT INTO `evrak` (`seriNo`, `dogrulamaKod`, `tarih`, `tur`, `imzalayan`, `olusturan`, `gecerlilik`) VALUES
(14, 994, '2022-12-31', 'Nüfus', '12345678911', '12345678950', 1),
(13, 2864, '2022-12-31', 'İkametgah', NULL, '12345678950', 1),
(7, 2900, '2022-12-25', 'Taşıt', '12068132160', '12345678916', 0),
(11, 4968, '2022-12-31', 'Taşıt', '12345678911', '12345678950', 1),
(12, 5515, '2022-12-31', 'Gelir', NULL, '12345678950', 1),
(8, 7207, '2022-12-25', 'Gelir', NULL, '12345678916', 0),
(10, 8410, '2022-12-31', 'Nüfus', '12345678911', '12345678950', 0),
(15, 9719, '2022-12-31', 'Taşıt', NULL, '12345678950', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gorevli`
--

DROP TABLE IF EXISTS `gorevli`;
CREATE TABLE IF NOT EXISTS `gorevli` (
  `tcNo` varchar(255) NOT NULL,
  `ad` varchar(255) NOT NULL,
  `soyAd` varchar(255) NOT NULL,
  `dogumTarihi` varchar(255) NOT NULL,
  `maas` double NOT NULL,
  `sifre` varchar(255) NOT NULL,
  `isGirisTarihi` varchar(255) NOT NULL,
  `isCikisTarihi` varchar(255) DEFAULT NULL,
  `calismaDurumu` tinyint(1) DEFAULT NULL,
  UNIQUE KEY `tcNo` (`tcNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `gorevli`
--

INSERT INTO `gorevli` (`tcNo`, `ad`, `soyAd`, `dogumTarihi`, `maas`, `sifre`, `isGirisTarihi`, `isCikisTarihi`, `calismaDurumu`) VALUES
('12068132160', 'Mehmet', 'Akif', '2007-05-04', 7000, '789866', '2022-12-25', NULL, 1),
('12345678911', 'Hakan', 'Tunç', '2002-04-10', 6000, '123456', '2022-12-25', NULL, 1),
('12345678919', 'Yasin', 'Bilekçi', '2002-03-04', 6000, '197059', '2022-12-31', NULL, 1),
('12345679855', 'Akif', 'Avcu', '2004-07-10', 6800, '498843', '2022-12-30', NULL, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
CREATE TABLE IF NOT EXISTS `kullanici` (
  `tcNo` varchar(255) NOT NULL,
  `ad` varchar(255) NOT NULL,
  `soyAd` varchar(255) NOT NULL,
  `dogumTarihi` varchar(255) NOT NULL,
  `sifre` varchar(255) NOT NULL,
  `uyelikTarihi` varchar(255) NOT NULL,
  UNIQUE KEY `tcNo` (`tcNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`tcNo`, `ad`, `soyAd`, `dogumTarihi`, `sifre`, `uyelikTarihi`) VALUES
('12345678916', 'Anıl', 'Yılmaz', '2006-08-09', '123456', '2022-12-25'),
('12345678950', 'Eren', 'Doğan', '2001-01-01', '1234567', '2022-12-25');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `mudur`
--

DROP TABLE IF EXISTS `mudur`;
CREATE TABLE IF NOT EXISTS `mudur` (
  `tcNo` varchar(255) NOT NULL,
  `ad` varchar(255) NOT NULL,
  `soyAd` varchar(255) NOT NULL,
  `dogumTarihi` varchar(255) NOT NULL,
  `maas` double NOT NULL,
  `sifre` varchar(255) NOT NULL,
  UNIQUE KEY `tcNo` (`tcNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `mudur`
--

INSERT INTO `mudur` (`tcNo`, `ad`, `soyAd`, `dogumTarihi`, `maas`, `sifre`) VALUES
('12345678910', 'Emir', 'Doğan', '2001-05-05', 30000, '123456'),
('12345678915', 'Osman', 'Yaşar', '2000-06-09', 25000, '1234567');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
