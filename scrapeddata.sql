/**
 * Author:  mmarifat
 * Created: Aug 30, 2019
 */ 

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- httpswww.phpmyadmin.net
--
-- Host localhost3306
-- Generation Time Aug 29, 2019 at 0302 PM
-- Server version 10.3.17-MariaDB
-- PHP Version 7.2.7

SET SQL_MODE = NO_AUTO_VALUE_ON_ZERO;
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = +0000;


!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT ;
!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS ;
!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION ;
!40101 SET NAMES utf8mb4 ;

--
-- Database `mma_scrap`
--

-- --------------------------------------------------------

--
-- Table structure for table `scrapeddata`
--

CREATE TABLE `scrapeddata` (
  `id` int(11) NOT NULL,
  `name` text DEFAULT NULL,
  `category` text DEFAULT NULL,
  `description` text DEFAULT NULL,
  `author` text DEFAULT NULL,
  `uploadDate` text DEFAULT NULL,
  `link` text DEFAULT NULL,
  `image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `scrapeddata`
--
ALTER TABLE `scrapeddata`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `scrapeddata`
--
ALTER TABLE `scrapeddata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT ;
!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS ;
!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION ;