-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 09, 2022 at 03:26 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edu_hub`
--

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
CREATE TABLE IF NOT EXISTS `members` (
  `id` int(55) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(55) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(55) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pic` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='this table is to store user datas';

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `first_name`, `last_name`, `gender`, `email`, `pic`, `password`, `created_at`, `updated_at`) VALUES
(1, 'adeyinka', 'olakunle', 'male', 'adeyinka.o@gmail.com', NULL, 'aaa', '2022-06-03 14:29:19', '2022-06-03 14:29:19'),
(2, 'malik', 'abdullah', 'male', 'malik.a@gmail.com', NULL, 'mmm', '2022-06-03 15:59:20', '2022-06-03 15:59:20'),
(3, 'Emeka', 'Osinachi', 'female', 'emeks.o@gmail.com', NULL, 'eee', '2022-06-03 17:09:40', '2022-06-03 17:09:40');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
