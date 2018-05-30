-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2018 at 03:20 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `capstonepos`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_number` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_category` varchar(50) NOT NULL,
  `product_type` tinyint(1) NOT NULL,
  `product_price` varchar(50) NOT NULL,
  `product_stock` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_number`, `product_name`, `product_category`, `product_type`, `product_price`, `product_stock`) VALUES
(15, 'CH001', 'BANQUET CHICKEN NUGGETS 456G', 'PRODUCED', 1, '350.00', 10),
(16, 'CH002', 'BANQUET CHICKEN BREAST NUGGETS', 'PRODUCED', 1, '300.00', 10),
(17, 'CH003', 'BELLA&EVANS BREADED CHICKEN BREAST NUGGETS', 'PRODUCED', 1, '210.00', 10);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_number` varchar(15) NOT NULL,
  `supplier_name` varchar(50) NOT NULL,
  `supplier_address` varchar(50) NOT NULL,
  `supplier_email` varchar(50) NOT NULL,
  `supplier_contactnumber` varchar(15) NOT NULL,
  `supplier_contactperson` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_number`, `supplier_name`, `supplier_address`, `supplier_email`, `supplier_contactnumber`, `supplier_contactperson`) VALUES
(1, 'SU001', 'Supplier', 'Mandaue', 'supplier@gmail.com', '091222111222', 'Miss Miss'),
(2, '0', 'null', 'null', 'null', '0', 'null'),
(3, '0', 'null', 'null', 'null', '0', 'null'),
(4, '0', 'null', 'null', 'null', '0', 'null'),
(5, '0', 'null', 'null', 'null', '0', 'null'),
(6, '0', 'null', 'null', 'null', '0', 'null'),
(7, '0', 'null', 'null', 'null', '0', 'null'),
(8, '0', 'null', 'null', 'null', '0', 'null'),
(9, '56789', 'GHJK', 'GHJK', 'VBNM,', '6789', 'GHJK'),
(10, 'SU19821', 'Dominic', 'Talamban', 'dominic@gmail.com', '09187216364', 'Dominic');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_number` varchar(15) NOT NULL,
  `user_firstname` varchar(50) NOT NULL,
  `user_lastname` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_contactnumber` varchar(15) NOT NULL,
  `user_address` varchar(50) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_number`, `user_firstname`, `user_lastname`, `username`, `password`, `user_email`, `user_contactnumber`, `user_address`, `isAdmin`) VALUES
(1, 'US10001', 'Admin', 'Admin', 'admin', 'admin', 'adminpos@gmail.com', '912345678', 'Nasipit, Talamban', 1),
(3, 'CA123', 'Kirby', 'Cataluna', 'kirby', '1234', 'kirby@gmail.com', '912123454', 'Guadalupe, Cebu City', 0),
(4, '0', 'Genale', 'Tagalog', 'genale', '1234', 'null', '0', 'null', 0),
(5, '0', 'null', 'null', 'null', 'null', 'null', '0', 'null', 0),
(6, '0', 'null', 'null', 'null', 'null', 'null', '0', 'null', 0),
(7, '0', 'null', 'null', 'null', 'null', 'null', '0', 'null', 0),
(8, '0', 'null', 'null', 'null', 'null', 'null', '0', 'null', 0),
(9, '0', 'null', 'null', 'null', 'null', 'null', '0', 'null', 0),
(10, '0', 'hhjk', 'hjkh', 'hjkh', '123', 'null', '0', 'null', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
