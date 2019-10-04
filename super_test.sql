-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:8887
-- Generation Time: Oct 04, 2019 at 04:52 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `super_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `id` int(11) NOT NULL,
  `character_level` int(11) NOT NULL,
  `character_name` varchar(255) NOT NULL,
  `character_race` varchar(255) NOT NULL,
  `class_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `characters`
--

INSERT INTO `characters` (`id`, `character_level`, `character_name`, `character_race`, `class_id`, `user_id`) VALUES
(1, 99999999, 'I\'m not hacking', 'Secret', 1, 1),
(2, 0, 'not a noob 78', 'Orc', 2, 2),
(3, 1, 'daman', 'human', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `character_classes`
--

CREATE TABLE `character_classes` (
  `id` int(11) NOT NULL,
  `class_description` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `character_classes`
--

INSERT INTO `character_classes` (`id`, `class_description`, `class_name`) VALUES
(1, 'Here all them cheating **** will gather', 'H4xx0r'),
(2, 'noob gather here', 'noobs'),
(3, 'masters be gone!', 'Elite');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_email`, `user_name`, `user_password`) VALUES
(1, 'some email', 'test', 'some test'),
(2, 'leffes mail', 'Leffe', 'leffemanen'),
(3, 'cheataway@cheater.com', 'IHack', 'notahacker');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2jv4ly095rr7uabfs90f9lt00` (`class_id`),
  ADD KEY `FK1pdgldxg62dv3qdexxv2q1box` (`user_id`);

--
-- Indexes for table `character_classes`
--
ALTER TABLE `character_classes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_j09k2v8lxofv2vecxu2hde9so` (`user_email`),
  ADD UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `character_classes`
--
ALTER TABLE `character_classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
