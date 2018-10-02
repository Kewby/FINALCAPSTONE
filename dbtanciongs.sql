-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 17, 2018 at 10:20 AM
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
-- Database: `dbtanciongs`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `description`) VALUES
(1, 'Beverages', 'Beverages'),
(2, 'Dry Goods', 'Dry Goods'),
(3, 'Condiments', 'Condiments'),
(4, 'Toiletries', 'Toiletries'),
(5, 'Canned Goods', 'Canned Goods'),
(6, 'Snacks', 'Snacks');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `delivery_id` int(11) NOT NULL,
  `delivery_datetime` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `delivery_unitprice` float(255,2) DEFAULT NULL,
  `delivery_numberofunits` int(11) DEFAULT NULL,
  `delivery_unitofmeasure` varchar(255) DEFAULT NULL,
  `delivery_totalcostamount` float(255,2) AS (delivery_unitprice * delivery_numberofunits) VIRTUAL,
  `supplier_id` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`delivery_id`, `delivery_datetime`, `product_id`, `delivery_unitprice`, `delivery_numberofunits`, `delivery_unitofmeasure`, `supplier_id`, `branch_id`, `employee_id`, `deleteStatus`) VALUES
(4, '2018-08-09 11:28:52', 1, 50.00, 50, 'mL', 2, 1, 1, 0),
(5, '2018-08-09 12:23:34', 2, 10.00, 10, 'mL', 1, 1, 1, 0),
(6, '2018-08-10 12:27:16', 2, 12.00, 12, 'mL', 1, 2, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `employee_firstname` varchar(255) DEFAULT NULL,
  `employee_lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_contactnumber` varchar(15) DEFAULT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `isAdmin` tinyint(4) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_firstname`, `employee_lastname`, `username`, `password`, `employee_email`, `employee_contactnumber`, `employee_address`, `branch_id`, `isAdmin`, `deleteStatus`) VALUES
(1, 'Cebu', 'Cebu', 'cebu', 'cebu', 'cebu@gmail.com', '09177222222', 'Mabolo, Cebu City', 1, 1, 0),
(2, 'Leyte', 'Leyte', 'leyte', 'leyte', 'leyte@gmail.com', '09122214444', 'Tacloban City', 2, 1, 0),
(3, 'John', 'Flo', 'john', 'john', 'johnmari@gmail.com', '09122211121', 'Mabolo, Cebu City', 2, 0, 0),
(5, 'Allysha', 'Ledesma', 'Allysha', 'Ledesma', 'allysha@gmail.com', '09112345678', 'Test address', 1, 0, 0),
(8, 'Kirby', 'Cataluna', 'kirby', 'cataluna', 'kirbpao@gmail.com', '09228270645', 'cebu', 1, 0, 0),
(12, 'Genale', 'Tagalog', 'genale', '1234', 'genale@gmail.com', '09123456789', 'Address here', 2, 0, 0),
(13, 'Bos', 'Coffee', 'bos', '1234', 'bos@gmail.com', '09123456789', 'it park', 1, 0, 0),
(14, 'qwerty', 'uiop', 'qwerty', '1234', 'qwery@gmail.com', '1234567899', 'qwerty', 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_code` bigint(20) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` tinyint(1) DEFAULT NULL,
  `standard_cost` float(255,2) DEFAULT NULL,
  `markup_cost` varchar(5) NOT NULL,
  `list_price` float(255,2) AS (standard_cost + markup_cost) VIRTUAL,
  `branch_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `product_type`, `standard_cost`, `markup_cost`, `branch_id`, `category_id`, `deleteStatus`) VALUES
(1, 4800049720121, '1000mL NATURES SPRING DRINKING WATER', 1, 16.00, '4.00', 1, 1, 0),
(2, 4801981164851, '200ML MINUTE MAID', 0, 20.00, '5.00', 1, 1, 0),
(3, 28400017503, '184.2g LAYS SALT AND VINEGAR', 0, 116.00, '19.00', 1, 6, 0),
(4, 4807770270291, '60g PANCIT CANTON CHILIMANSI', 0, 8.00, '3.00', 1, 2, 0),
(5, 4807770271229, '60g PANCIT CANTON EXTRA HOT', 0, 8.00, '3.00', 1, 2, 0),
(6, 4807770272554, '60g PANCIT CANTON SWEET & SPICY', 0, 8.00, '3.00', 1, 2, 0),
(7, 4807770270055, '60g PANCIT CANTON ORIGINAL', 0, 8.00, '3.00', 1, 2, 0),
(8, 4807770270123, '60g PANCIT CANTON CALAMANSI', 1, 8.00, '3.00', 1, 2, 0),
(9, 4807770272097, '50g LUCKY ME SPICY LABUYO BEEF', 0, 8.00, '1', 1, 2, 0),
(10, 4807770270017, '50g LUCKY ME BEEF NA BEEF', 0, 8.00, '1', 1, 2, 0),
(11, 4807770270024, '50g LUCKY ME CHICKEN', 0, 8.00, '1', 1, 2, 0),
(12, 4807770272394, '65g LUCKY ME SPECIAL LOMI', 0, 8.00, '1', 1, 2, 0),
(13, 4800110026497, '55g HO-MI INSTANT MAMI NOODLES', 0, 8.00, '1', 1, 2, 0),
(14, 8801073113428, '140g SAMYANG 2X SPICY HOT CHICKEN', 0, 80.00, '0', 1, 2, 0),
(15, 8801073113688, '135g SAMYANG MALA', 0, 80.00, '0', 1, 2, 0),
(16, 4807770273612, '40g LUCKY ME GO CUP SPICY BULALO', 0, 12.00, '5.00', 1, 2, 0),
(17, 4807770271175, '40g LUCKY ME GO CUP BULALO', 0, 12.00, '5.00', 1, 2, 0),
(18, 4807770272943, '40g LUCKY ME GO CUP SEAFOOD', 0, 12.00, '5.00', 1, 2, 0),
(19, 4807770271519, '40g LUCKY ME GO CUP CHICKEN SOTANGHON', 0, 12.00, '5.00', 1, 2, 0),
(20, 4800024577740, '900g DEL MONTE SPAG PASTA', 0, 82.00, '11.00', 1, 2, 0),
(21, 4800024556103, '400g DEL MONTE SPAG PASTA', 0, 44.00, '11.00', 1, 2, 0),
(22, 4800024556110, '400g DEL MONTE SALAD MACARONI', 0, 47.50, '12.00', 1, 2, 0),
(23, 4806506152801, '300 SHEETS CESS TISSUE', 0, 12.00, '3.00', 1, 4, 0),
(24, 4806506152221, '440 SHEETS HELLO 2PLY BATHROOM TISSUE', 0, 15.30, '4.70', 1, 4, 0),
(25, 4902430278119, '380G TIDE ULTRA ORIG SCENT\r\n', 0, 15.00, '2.25', 1, 4, 0),
(26, 8998866802666, '150G WINGS TOTAL CARE\r\n', 0, 10.15, '3.60', 1, 4, 0),
(27, 4800888183804, '61G SURF WITH FABCON ROSE FRESH', 0, 6.25, '1.75', 1, 4, 0),
(28, 4806502350096, '10G SANICARE COTTON ROLLS\r\n', 0, 8.30, '1.70', 1, 4, 0),
(29, 8850006494905, '12ML PALMOLIVE NATURALS 2+1 SHAMPOO AND CONDITIONER COCO MILK & MILK PROTEIN\r\n', 0, 6.00, '2.00', 1, 4, 0),
(30, 4902430698085, '12ML PANTENE SHAMPOO\r\n', 0, 6.00, '1', 1, 4, 0),
(31, 8850006536063, '15ML GARD ANTI DANDRUFF SHAMPOO WITH CONDITIONER', 0, 7.00, '2', 1, 4, 0),
(32, 4902430698078, '16ML REJOICE FRAGRANT RICH SHAMPOO\r\n', 0, 7.00, '2.00', 1, 4, 0),
(33, 4800888139283, '11ML CREAMSILK HAIRFALL DEFENSE', 0, 7.00, '2.75', 1, 4, 0),
(34, 4800888169709, '13ML SUNSILK STRONG AND LONG\r\n', 0, 6.00, '1', 1, 4, 0),
(35, 4902430333597, '12ML HEAD&SHOULDERS ANTI DANDRUFF SHAMPOO COOL MENTHOL\r\n', 0, 8.15, '0.85', 1, 4, 0),
(36, 8850006493014, '15ML PALMOLIVE NATURALS SHAMPOO AND CONDITIONER COCO MILK & MILK PROTEIN\r\n', 0, 5.25, '2.75', 1, 4, 0),
(37, 4800888169716, '13ML SUNSILK SMOOTH AND MANAGEABLE SHAMPOO\r\n', 0, 5.00, '2.00', 1, 4, 0),
(38, 4902430634014, '10ML PANTENE 3MINUTE MIRACLE CONDITIONER\r\n', 0, 6.00, '3.00', 1, 4, 0),
(39, 8850006494912, '12ML PALMOLIVE NATURALS 2+1 SHAMPOO AND CONDITIONER ALOE VERA & FRUIT VITAMINS\r\n', 0, 5.00, '2.00', 1, 4, 0),
(40, 2250001322603, '15ML PALMOLIVE NATURALS SHAMPOO AND CONDITIONER ALOE VERA & FRUIT VITAMINS\r\n', 0, 5.00, '2.00', 1, 4, 0),
(41, 4800888139306, '12ML CREAMSILK STAND OUT STRAIGHT\r\n', 0, 8.00, '1.75', 1, 4, 0),
(42, 4800888154415, '10ML DOVE NOURISHING OIL CARE CONDITIONER\r\n', 0, 8.00, '1.00', 1, 4, 0),
(43, 4902430495073, '90G SAFEGUARD PURE WHITE\r\n', 0, 15.00, '3.00', 1, 4, 0),
(44, 4902430522809, '12ML HEAD AND SHOULDERS MEN COOL BLAST SHAMPOO\r\n', 0, 8.00, '1', 1, 4, 0),
(45, 4800067055762, '72 TIPS BABY FLO COTTON BUDS\r\n', 0, 14.37, '2.13', 1, 4, 0),
(46, 4902430951357, '60G SAFEGUARD FLORAL PINK WITH ALOE VERA\r\n', 0, 8.00, '4.00', 1, 4, 0),
(47, 4800119214093, '60G SKINWHITE WHITENING SOAP CLASSIC\r\n', 0, 8.00, '2.00', 1, 4, 0),
(48, 4902430935999, '135G SAFEGUARD CLASSIC BEIGE\r\n', 0, 22.00, '3.00', 1, 4, 0),
(49, 4902430495042, '90G SAFEGUARD CLASSIC BEIGE\r\n', 0, 15.00, '3.25', 1, 4, 0),
(50, 4806507832481, '65G SILKA PAPAYA WHITENING SOAP\r\n', 0, 13.00, '3.25', 1, 4, 0),
(51, 4902430934800, '135G SAFEGUARD PURE WHITE\r\n', 0, 27.18, '5.82', 1, 4, 0),
(52, 4806502352076, '200 SHEETS TISYU TO GO\r\n', 0, 15.00, '3.00', 1, 4, 0),
(53, 2200001724679, '10PCS CLASSIC ROYALE GARBAGE BAG ROLL\r\n', 0, 9.00, '', 1, 4, 0),
(54, 4902430344876, '27ML DOWNY ANTI-BAC\r\n', 0, 9.00, '', 1, 4, 0),
(55, 4902430401845, '27ML DOWNY SUNRISE FRESH\r\n', 0, 9.00, '', 1, 4, 0),
(56, 4902430759250, '74G TIDE DOWNY PERFUMES FANTASY\r\n', 0, 9.00, '', 1, 4, 0),
(57, 4902430583169, '70G ARIEL SUNRISE FRESH\r\n', 0, 9.00, '', 1, 4, 0),
(58, 8850006325230, '22G TWINPACK COLGATE COOLING CRYSTALS\r\n', 0, 9.00, '', 1, 4, 0),
(59, 8850006342039, '24G COLGATE SENSITIVE FRESH MINT\r\n', 0, 9.00, '', 1, 4, 0),
(60, 8850006325216, '24G COLGATE MAXIMUM CAVITY PROTECTION\r\n', 0, 9.00, '', 1, 4, 0),
(61, 4902430729925, '20ML DOWNY PARFUM COLLECTION MYSTIQUE\r\n', 0, 9.00, '', 1, 4, 0),
(62, 4902430729901, '20ML DOWNY PARFUM COLLECTION PASSION\r\n', 0, 9.00, '', 1, 4, 0),
(63, 4902430453295, '25ML DOWNY GARDEN BLOOM\r\n', 0, 9.00, '', 1, 4, 0),
(64, 4800888136732, '40G SURF OXY BUBBLES BAR\r\n', 0, 9.00, '', 1, 4, 0),
(65, 4806504753512, '30G UNCLE JOHN\'S TOOTHPICK\r\n', 0, 9.00, '', 1, 4, 0),
(66, 4909010432916, '250 PIECES GLOW DELUXE\r\n', 0, 9.00, '', 1, 4, 0),
(67, 4800888189806, '57G SURF WITH FABCON CHERRY BLOSSOM\r\n', 0, 9.00, '', 1, 4, 0),
(68, 4902430389556, '40ML JOY ANTI-BAC DISHWASHING\r\n', 0, 9.00, '', 1, 4, 0),
(69, 4902430389570, '20ML JOY LEMON DISHWASHING\r\n', 0, 9.00, '', 1, 4, 0),
(70, 4902430434393, '20ML JOY CALAMANSI DISHWASHING\r\n', 0, 9.00, '', 1, 4, 0),
(71, 4902430389563, '45ML JOY LEMON DISHWASHING\r\n', 0, 9.00, '', 1, 4, 0),
(72, 4902430389532, '35ML JOY CALANSI DISHWASHING\r\n', 0, 9.00, '', 1, 4, 0),
(73, 4800011133515, '95G EVERCLEAN LAUNDRY BAR\r\n', 0, 9.00, '', 1, 4, 0),
(74, 4902430178228, '95G PERLA HYPOALLERGENIC\r\n', 0, 9.00, '', 1, 4, 0),
(75, 4800011133607, '95G EVERCLEAN WHITE LAUNDRY BAR\r\n', 0, 9.00, '', 1, 4, 0),
(76, 4809014485362, '84 PIECES BABY WIPES UNICARE\r\n', 0, 9.00, '', 1, 4, 0),
(77, 4902430026420, '8PADS WHISPER SUPERCLEAN AND DRY\r\n', 0, 9.00, '', 1, 4, 0),
(78, 4902430335065, '16PADS WHISPER COTTONY SOFT\r\n', 0, 9.00, '', 1, 4, 0),
(79, 4902430293419, '1 PAD WHISPER COTTONY SOFT\r\n', 0, 9.00, '', 1, 4, 0),
(80, 4800049720114, '500ML NATURES SPRING DRINIKING WATER\r\n', 0, 9.00, '', 1, 1, 0),
(81, 4801981107971, '500ML WILKINS PURE \r\n', 0, 9.00, '', 1, 1, 0),
(82, 4801981118588, '300ML SPRITE BOTTLE\r\n', 0, 9.00, '', 1, 1, 0),
(83, 4801981025619, '355ML SPARKLE LEMON BOTTLE\r\n', 0, 9.00, '', 1, 1, 0),
(84, 4801981110001, '330ML COCA COLA CAN\r\n', 0, 9.00, '', 1, 1, 0),
(85, 4801981118502, '300ML COCA COLA BOTTLE\r\n', 0, 9.00, '', 1, 1, 0),
(86, 731126105040, '40G NAGARAYA HOT AND SPICY CRACKER NUTS', 0, 9.00, '', 1, 6, 0),
(87, 4800194177085, '90G OISHI PRAWN CRACKERS\r\n', 0, 9.00, '', 1, 6, 0),
(88, 4809011681378, '100G BOY BAWANG CORNICK GARLIC FLAVOR\r\n', 0, 9.00, '', 1, 6, 0),
(89, 4806511013562, '100G SUPER BAWANG CORN SNACK\r\n', 0, 9.00, '', 1, 6, 0),
(90, 4807770121692, '10 PIECES VOICE CAFÉ MOCHA\r\n', 0, 9.00, '', 1, 6, 0),
(91, 4807770121296, '10 PIECES VOICE OVERLOAD CHOCO COATED\r\n', 0, 9.00, '', 1, 6, 0),
(92, 4806511012916, '70 GRAMS WL CORNBITS\r\n', 0, 9.00, '', 1, 6, 0),
(93, 8411778164306, '454G ZANUY TORTILLA CHIPS\r\n', 0, 9.00, '', 1, 6, 0),
(94, 4800194179881, '90G OISHI CRACKLINGS PLAIN SALTED\r\n', 0, 9.00, '', 1, 6, 0),
(95, 4806014000366, '565G JOLLY LYCHEES\r\n', 0, 9.00, '', 1, 5, 0),
(96, 4800024020642, '227G DEL MONTE PINEAPPLE CHUNKS\r\n', 0, 9.00, '', 1, 5, 0),
(97, 4806014001424, '198G JOLLY MUSHROOMS\r\n', 0, 9.00, '', 1, 5, 0),
(98, 4800088146012, '150G AUSTRALIAN CARNE NORTE\r\n', 0, 9.00, '', 1, 5, 0),
(99, 4806508624009, '155G SEÑORITA BRAND COOKED DRY PEAS\r\n', 0, 9.00, '', 1, 5, 0),
(100, 4800088135269, '150G WINNER BEEF LOAF\r\n', 0, 9.00, '', 1, 5, 0),
(101, 748485100401, '155G CENTURY TUNA FLAKES AND OIL\r\n', 0, 9.00, '', 1, 5, 0),
(102, 4800024562258, '227G DEL MONTE PINEAPPLE TIDBITS\r\n', 0, 9.00, '', 1, 5, 0),
(103, 4800088270373, '150G VIRGINIA CORNED BEEF\r\n', 0, 9.00, '', 1, 5, 0),
(104, 4806508627215, '155G SEÑORITA SARDINES GREEN\r\n', 0, 9.00, '', 1, 5, 0),
(105, 4800088135023, '150G WINNER MEAT LOAF\r\n', 0, 9.00, '', 1, 5, 0),
(106, 4800088196000, '155G VINTA SARDINES\r\n', 0, 9.00, '', 1, 5, 0),
(107, 4806508621039, '155G SEÑORITA SARDINES RED\r\n', 0, 9.00, '', 1, 5, 0),
(108, 4800088115162, '165G VIRGINIA PORK AND BEANS\r\n', 0, 9.00, '', 1, 5, 0),
(109, 4800024555489, '115G DEL MONTE TOMATO SAUCE\r\n', 0, 9.00, '', 1, 3, 0),
(110, 4800024556929, '250G DEL MONTE TOMATO SAUCE ORIGINAL\r\n', 0, 9.00, '', 1, 3, 0),
(111, 4800024575395, '90G DEL MONTE TOMATO SAUCE FILIPINO STYLE\r\n', 0, 9.00, '', 1, 3, 0),
(112, 4800024555496, '200G DEL MONTE TOMATO SAUCE ORIGINAL\r\n', 0, 9.00, '', 1, 3, 0),
(113, 4800344004940, '200ML SILVER SWAN SUKANG PUTI\r\n', 0, 9.00, '', 1, 3, 0),
(114, 4801668602027, '200ML DATUPUTI VINEGAR\r\n', 0, 9.00, '', 1, 3, 0),
(115, 4806501810201, '200ML CAMEL SOY SAUCE\r\n', 0, 9.00, '', 1, 3, 0),
(116, 4800344001949, '200ML SILVER SWAN SOY SAUCE\r\n', 0, 9.00, '', 1, 3, 0),
(117, 4801668602034, '200ML DATUPUTI SOY SAUCE\r\n', 0, 9.00, '', 1, 3, 0),
(118, 4901515129988, '100ML KIKOMAN NATURAL BREWED SOY SAUCE\r\n', 0, 9.00, '', 1, 3, 0),
(119, 1234567890, 'TestProduct', 0, 1.00, '', 1, 6, 1),
(120, 1234567890, 'test', 0, 123.00, '12.0', 1, 1, 0),
(121, 12345, 'zonrox', 0, 25.00, '25.0', 1, 1, 0),
(123, 12345678, 'test', 1, 123.00, '123.0', 1, 4, 0),
(124, 1234567, 'asasa', 1, 12.00, '1.0', 1, 1, 0),
(125, 1234567, '123456', 1, 12.00, '12.0', 1, 1, 0),
(126, 98765, 'asdfgh', 1, 55.00, '55.0', 1, 1, 0),
(127, 987654321, 'asdgjhl', 1, 50.00, '50.0', 1, 4, 0),
(128, 1234567890, 'swertyui', 1, 12.00, '12.0', 1, 1, 0),
(129, 12345678909876, 'asdfghjkjmhngb', 1, 12.00, '21.0', 1, 1, 0),
(130, 1234567897654, 'sdfghgfdsa', 1, 12.00, '12.0', 1, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` int(11) NOT NULL,
  `sales_datetime` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `changefund` float(255,2) DEFAULT NULL,
  `total_sales` float(255,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `sales_datetime`, `employee_id`, `changefund`, `total_sales`) VALUES
(5, NULL, NULL, 5000.00, NULL),
(11, '2018-07-31 14:31:55', NULL, 12345.00, NULL),
(12, '2018-07-31 14:35:25', NULL, 67890.00, NULL),
(13, '2018-07-31 14:53:02', NULL, 12345678.00, NULL),
(14, '2018-07-31 14:59:45', NULL, 1234567936.00, NULL),
(15, '2018-07-31 15:00:45', NULL, 5500.00, NULL),
(22, '2018-08-18 07:47:05', 5, 1000.00, NULL),
(23, '2018-08-18 07:50:55', 5, NULL, 727.00),
(24, '2018-08-18 07:53:42', 12, NULL, 205.50),
(25, '2018-08-18 07:56:38', 1, NULL, 0.00),
(26, '2018-08-18 07:58:25', 5, NULL, 727.00),
(27, '2018-08-18 07:58:50', 5, NULL, 736.00),
(32, '2018-08-20 19:16:05', 12, 1000.00, NULL),
(40, '2018-08-21 12:19:14', 1, 1000.00, NULL),
(41, '2018-08-21 12:20:23', 1, NULL, 63.00),
(42, '2018-08-21 12:47:01', 1, NULL, 72.00),
(43, '2018-08-30 13:19:36', 5, 1000.00, NULL),
(44, '2018-09-03 09:52:33', 5, 1000.00, NULL),
(45, '2018-09-03 09:55:43', 5, NULL, 111.00);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `stock_onhand` int(11) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `supplier_address` varchar(255) DEFAULT NULL,
  `supplier_email` varchar(255) DEFAULT NULL,
  `supplier_contactnumber` varchar(255) DEFAULT NULL,
  `supplier_contactperson` varchar(255) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_email`, `supplier_contactnumber`, `supplier_contactperson`, `deleteStatus`) VALUES
(1, 'NATURES SPRING', 'Cebu City', 'drinkingwater@gmail.com', '09188827333', 'Mr. Waters', 0),
(2, 'VIRGINIA', 'Mabolo, Cebu City', 'virginia@gmail.com', '345-0987', 'Mr. Jhumar', 0),
(3, 'GRANNIX', 'Cebu City', 'grannix@gmail.com', '345-1023', 'Angela Lim', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_datetime` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `transaction_grandtotal` float(255,2) DEFAULT NULL,
  `transaction_tender` float(255,2) DEFAULT NULL,
  `transaction_change` float(255,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `transaction_datetime`, `employee_id`, `transaction_grandtotal`, `transaction_tender`, `transaction_change`) VALUES
(4, '2018-08-18 07:50:22', 5, 727.00, 1000.00, 273.00),
(5, '2018-08-18 07:52:17', 12, 128.00, 150.00, 22.00),
(6, '2018-08-18 07:53:03', 12, 77.50, 100.00, 22.50),
(7, '2018-08-18 07:58:43', 5, 9.00, 20.00, 11.00),
(9, '2018-08-20 19:17:31', 12, 72.00, 100.00, 28.00),
(10, '2018-08-20 19:19:44', 12, 18.00, 50.00, 32.00),
(18, '2018-08-21 12:19:48', 1, 18.00, 20.00, 2.00),
(19, '2018-08-21 12:20:08', 1, 45.00, 100.00, 55.00),
(20, '2018-08-21 12:46:47', 1, 9.00, 20.00, 11.00),
(21, '2018-09-03 09:55:21', 5, 111.00, 500.00, 389.00);

-- --------------------------------------------------------

--
-- Table structure for table `transactionitem`
--

CREATE TABLE `transactionitem` (
  `transactionItem_id` int(11) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `transactionItem_qty` int(11) DEFAULT NULL,
  `transactionItem_unitprice` float(255,2) DEFAULT NULL,
  `transactionItem_subtotal` float(255,2) AS (transactionItem_qty * transactionItem_unitprice) VIRTUAL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionitem`
--

INSERT INTO `transactionitem` (`transactionItem_id`, `transaction_id`, `product_id`, `transactionItem_qty`, `transactionItem_unitprice`) VALUES
(8, 4, 11, 1, 9.00),
(9, 4, 14, 2, 80.00),
(10, 4, 20, 6, 93.00),
(11, 5, 25, 1, 9.00),
(12, 5, 22, 2, 59.50),
(13, 6, 22, 1, 59.50),
(14, 6, 27, 2, 9.00),
(15, 7, 27, 1, 9.00),
(18, 9, 32, 1, 9.00),
(19, 9, 34, 2, 9.00),
(20, 9, 36, 5, 9.00),
(21, 10, 81, 2, 9.00),
(32, 18, 85, 2, 9.00),
(33, 19, 107, 5, 9.00),
(34, 20, 107, 1, 9.00),
(35, 21, 1, 5, 20.00),
(36, 21, 7, 1, 11.00);

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
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`delivery_id`),
  ADD KEY `delivery_fk1` (`product_id`),
  ADD KEY `delivery_fk2` (`supplier_id`),
  ADD KEY `delivery_fk3` (`branch_id`),
  ADD KEY `delivery_fk4` (`employee_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `employee_fk1` (`branch_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_fk1` (`branch_id`),
  ADD KEY `product_fk2` (`category_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`),
  ADD KEY `sales_fk1` (`employee_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_id`),
  ADD KEY `stock_fk1` (`product_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `transaction_fk1` (`employee_id`);

--
-- Indexes for table `transactionitem`
--
ALTER TABLE `transactionitem`
  ADD PRIMARY KEY (`transactionItem_id`),
  ADD KEY `transactionItem_fk1` (`transaction_id`),
  ADD KEY `transactionItem_fk2` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `delivery_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `sales_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `transactionitem`
--
ALTER TABLE `transactionitem`
  MODIFY `transactionItem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_fk1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `delivery_fk2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  ADD CONSTRAINT `delivery_fk3` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `delivery_fk4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_fk1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_fk1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `product_fk2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_fk1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_fk1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_fk1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `transactionitem`
--
ALTER TABLE `transactionitem`
  ADD CONSTRAINT `transactionItem_fk1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  ADD CONSTRAINT `transactionItem_fk2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
