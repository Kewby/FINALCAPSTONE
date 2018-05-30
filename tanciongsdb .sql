-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2018 at 07:27 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tanciongsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(1) NOT NULL,
  `branch_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `branch_name`) VALUES
(1, 'Cebu Branch'),
(2, 'Leyte Branch');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(1) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `description`) VALUES
(1, 'Dry Goods', 'Dry Goods'),
(2, 'Imported Goods', 'Imported Goods'),
(3, 'Wet Market', 'Wet Market'),
(4, 'Hygiene', 'Hygiene'),
(5, 'Essentials', 'Essentials'),
(6, 'Cleaning', 'Cleaning'),
(7, 'Fresh Produce', 'Fresh Produce'),
(8, 'Snacks', 'Snacks'),
(9, 'Canned Goods', 'Canned Goods'),
(10, 'Others', 'Others');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `order_tender` float DEFAULT NULL,
  `order_change` float DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `orderitem`
--

CREATE TABLE `orderitem` (
  `orderItem_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `orderItem_qty` int(11) DEFAULT NULL,
  `orderItem_unitPrice` float DEFAULT NULL,
  `orderItem_totalPrice` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_code` int(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` tinyint(1) DEFAULT NULL,
  `product_price` float(255,2) DEFAULT NULL,
  `product_stock` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `deleteStatus` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(50) NOT NULL,
  `supplier_address` varchar(50) NOT NULL,
  `supplier_email` varchar(50) NOT NULL,
  `supplier_contactnumber` varchar(15) NOT NULL,
  `supplier_contactperson` varchar(50) NOT NULL,
  `deleteStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_email`, `supplier_contactnumber`, `supplier_contactperson`, `deleteStatus`) VALUES
(1, 'Ace Synthesis, LLC', 'Mandaue City', 'sales@acesynthesis.com	', '978 726 7885', 'Mr. General Santos', 0),
(2, 'Puregold Gatuslao', 'Gatuslao St., Barangay 17 (Pob.) Bacolod', 'puregoldgatuslao@gmail.com', '234-7658', 'Mr. John Doe', 0),
(3, 'Robinsons Cebu Talisay', 'Talisay South Central Square Lawaan 111, Cebu', 'robinsonstalisay@yahoo.com', '302-8493', 'Mr. Robby', 0),
(4, 'Robinsons Tacloban City Samar', 'Robinsons Place Marasbaras, Leyte', 'robinsonstacloban@yahoo.com', '342-7441', 'Ms. Ronnie Calungsod', 0),
(5, 'S&R Cebu', 'North Reclamation Area Mandaue City', 'sandr@gmail.com', '301-3114', 'Miss S&R', 0),
(6, 'Theo and Philo Chocolate Factory Inc.', '36 S. Veloso Street, Brgy. Salapan', 'theo_philo@yahoo.com.ph', '137-2329', 'Theo Philo', 0),
(7, 'Consumer Plus Corporation', '5 Ledesma Court St. Visayas Avenue', 'consumer24@yahoo.com', '182-2382', 'Uncle Sam Alum', 0),
(8, 'EHE FARMS', 'PUROK 3, CROSSING RUBBER, TUPI', 'ehefarm_13@gmail.com', '271-5682', 'Farmers Brothers', 0),
(9, '7RF DELIFOODS Enterprise', '283 Unit E 15th Ave. Level Residences 15th Avenue', 'delifoods_2016@yahoo.com', '371-4622', 'Gourmet Smith', 0),
(10, 'Australian Fine Foods', 'C Plaza Friendship Highway cor Volga Street Anuna', 'finefoods2016@hotmail.au', '728-4527', 'John Smith', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_firstname` varchar(255) DEFAULT NULL,
  `user_lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_contactnumber` varchar(15) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `deleteStatus` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_firstname`, `user_lastname`, `username`, `password`, `user_email`, `user_contactnumber`, `user_address`, `branch_id`, `isAdmin`, `deleteStatus`) VALUES
(1, 'cebu', 'branch', 'cebu', 'cebu', 'cebu@gmail.com', '09123454357', 'Mandaue City, Cebu', 1, 1, 0),
(2, 'leyte', 'branch', 'leyte', 'leyte', 'leyte@gmail.com', '09233456789', 'Tacloban City', 2, 1, 0),
(3, 'John', 'Doe', 'johndoe', '1234', 'johndoe@gmail.com', '09173847593', 'Talamban, Cebu City', 1, 0, 0),
(4, 'Christine', 'Calungsod', 'christine', '1234', 'christine@gmail.com', '09273544539', 'Guadalupe, Cebu City', 1, 0, 0),
(5, 'John Mari', 'Flores', 'john', '1234', 'john@yahoo.com', '09156448233', 'Mabolo, Cebu City', 1, 0, 0),
(6, 'Joe', 'Baxter', 'joe', '1234', 'joe@yahoo.com', '09178850934', 'Tacloban City', 2, 0, 0),
(7, 'Rebecca', 'Smith', 'rebecca', '1234', 'rebecca@gmail.com', '09152200988', 'Palo, Leyte', 2, 0, 0),
(8, 'Brian', 'Santos', 'brian', '1234', 'brian@yahoo.com.ph', '09173345560', 'Maasin, Leyte', 2, 0, 0),
(9, 'Allan', 'Tan', 'allan', '1234', 'allan@gmail.com', '09278554019', 'Talamban, Cebu City', 1, 0, 0),
(10, 'Lucy', 'Tan', 'lucy', '1234', 'lucy@yahoo.com', '09157882091', 'Canduman, Cebu', 1, 0, 0),
(11, 'Gemma', 'Marion', 'gemma', '1234', 'gemma12@yahoo.com', '09156645091', 'Albuera, Leyte', 2, 0, 0),
(12, 'Michelle', 'Wheeler', 'michelle', '1234', 'michelle_15@gmail.com', '09150192871', 'Tacloban', 2, 0, 0),
(13, 'Austine', 'Mahone', 'austine', '1234', 'austine@gmail.com', '09267083611', 'Canduman, Maasin, Leyte', 2, 0, 0),
(14, 'Luke', 'Casas', 'luke', '1234', 'luke_casas@gmail.com', '09158830019', 'A.S Fortuna Street, Mandaue City', 1, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `order_fk` (`user_id`);

--
-- Indexes for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD PRIMARY KEY (`orderItem_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_fk1` (`branch_id`),
  ADD KEY `product_fk2` (`category_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_fk` (`branch_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `branch_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orderitem`
--
ALTER TABLE `orderitem`
  MODIFY `orderItem_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  ADD CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_fk1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `product_fk2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
