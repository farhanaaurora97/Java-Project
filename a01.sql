-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2019 at 05:15 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a01`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cusId` varchar(20) NOT NULL,
  `customerName` varchar(30) NOT NULL,
  `address` varchar(40) NOT NULL,
  `phoneNumber` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cusId`, `customerName`, `address`, `phoneNumber`) VALUES
('c0001', 'cus1', 'house#2,rd-3,lakeview', 1618),
('c0002', 'cus2', 'house#4,rd-3,jacksontower', 1616),
('c00025', 'qwert', 'Sylhet', 102301),
('c0003', 'cus3', 'house-434,blck-D', 1515),
('c0004', 'cus4', 'house-32,dhaka', 1646),
('c00058', 're', 'dhaka', 2569),
('c00078', 'ffgd', 'dhaka', 123697),
('c00096', 'jkoi', 'chittagong', 7896);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(20) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('', '', '', 0.00),
('e00001', 'emp1', 'manager', 300000.00),
('e00002', 'Employee2', 'salesman', 220000.00),
('e00003', 'emp3', 'salesman', 10000.00),
('e00006', 'e6', 'cashier', 10000.00),
('e013', 'Employee13', 'manager', 5345.00),
('e056', 'aftahi', 'manager', 500.00),
('e08', 'Emp08', 'cashier', 12000.00),
('e11', 'mp11', 'cashier', 10000.00),
('e12', 'E12', 'assdd', 1234.00),
('e15', 'Emp015', 'manager', 1234.00),
('e16', 'asdgg', 'cashier', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('c0001', '3030', 2),
('c0002', '4040', 2),
('c00025', '789789', 2),
('c0003', '5050', 2),
('c00058', '16325941', 2),
('c00078', 'null', 2),
('c00096', '456456', 2),
('e00001', '1234', 0),
('e00002', '17404044', 1),
('e00003', '13695425', 1),
('e00006', '10415479', 1),
('e013', '14487762', 0),
('e056', '12041605', 0),
('e08', '12121238', 1),
('e11', '10956941', 1),
('e12', '17588323', 1),
('e15', '15501192', 0),
('e16', '18587052', 1),
('p006', 'null', 0);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productId` varchar(20) NOT NULL,
  `productName` varchar(30) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productName`, `price`, `quantity`) VALUES
('p001', 'rice', 70.00, 5),
('p002', 'oil', 110.00, 6),
('p003', 'dal', 110.00, 7),
('p004', 'soap', 50.00, 8),
('p006', 'meat', 50.00, 1);

-- --------------------------------------------------------

--
-- Table structure for table `purchaseinfo`
--

CREATE TABLE `purchaseinfo` (
  `purchaseId` varchar(20) NOT NULL,
  `cusId` varchar(30) NOT NULL,
  `productId` varchar(20) NOT NULL,
  `productName` varchar(20) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseinfo`
--

INSERT INTO `purchaseinfo` (`purchaseId`, `cusId`, `productId`, `productName`, `price`, `quantity`) VALUES
('001', 'c0001', 'p001', 'rice', 70.00, 5),
('002', 'c0002', 'p002', 'oil', 110.00, 4),
('003', 'c0003', 'p003', 'dal', 110.00, 3),
('004', 'c0004', 'p004', 'soap', 50.00, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cusId`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD PRIMARY KEY (`purchaseId`),
  ADD KEY `cusId` (`cusId`),
  ADD KEY `productId` (`productId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD CONSTRAINT `purchaseinfo_ibfk_1` FOREIGN KEY (`cusId`) REFERENCES `customer` (`cusId`),
  ADD CONSTRAINT `purchaseinfo_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
