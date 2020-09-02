-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Sep 02, 2020 at 09:20 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie`
--

-- --------------------------------------------------------

--
-- Table structure for table `cast`
--

CREATE TABLE `cast` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cast`
--

INSERT INTO `cast` (`id`, `name`, `description`, `image`) VALUES
(1, 'Russell Brand', 'Russell Brand', NULL),
(2, 'Steve Carell', 'Steve Carell', NULL),
(3, 'Jason Segel', 'Jason Segel', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `image`) VALUES
(1, 'Hài hước', NULL),
(2, 'Hành động', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `filmid` int(11) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE `director` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `director`
--

INSERT INTO `director` (`id`, `name`, `description`, `image`) VALUES
(1, 'Chris Renaud', 'Chris Renaud', NULL),
(2, 'Shawn Levy', 'Shawn Levy', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `categoryid` int(11) DEFAULT NULL,
  `directorid` int(11) DEFAULT NULL,
  `thumbnail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `create_at` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id`, `name`, `description`, `categoryid`, `directorid`, `thumbnail`, `duration`, `url`, `view`, `update_at`, `create_at`) VALUES
(1, 'Despicable Me', 'Phim về Gru-một tên tội phạm khét tiếng và đám tay chân robot tí hon chuyên đi đánh cắp những biểu tượng nổi tiếng của thế giới. Thế nhưng tiếng xấu của Gru bị suy giảm bởi Vector - tên trộm trẻ tuổi đã đánh cắp kim tự tháp Ai Cập. Bởi vậy để lấy lại danh tiếng của mình, Gru đã nghĩ đến một kế hoạch có một không hai: đánh cắp mặt trăng.', 1, 1, 'img6.jpg', 95, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 0, '2020-09-03 00:00:00', '2020-09-03 00:00:00'),
(2, 'Night At The Museum: Secret Of The Tomb', 'Anh chàng gác đêm Michael một lần nữa sẽ theo viện bảo tàng đến xứ sở hoa anh đào để công tác. Không quên mang theo những người bạn tí hon của mình, và đặc biệt là tấm bài vị thần kì quý giả của vua Ai Cập. Cùng những nhân vật sống dậy từ bảo tàng, Micheal bắt đầu một chuyến phiêu lưu đầy hài hước.', 2, 2, 'img2.jpg', 100, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 0, '2020-09-02 00:00:00', '2020-09-02 00:00:00'),
(3, 'Aquaman', 'Một người nửa nhân loại nửa Atlantis bước chân vào hành trình xác định xem mình có phải là vị vua xứng đáng của thế giới Atlantis.', 2, 2, 'img7.jpg', 120, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 1, '2020-09-01 00:00:00', '2020-09-01 00:00:00'),
(4, 'Constantine: City Of Demons', 'Một sai lầm tệ hại đã khiến con gái bạn thân của thợ săn quỷ Constatine bị hôn mê. Hai người bước vào hành trình đầy hiểm nguy để giành lại linh hồn cô bé.', 2, 2, 'img5.jpg', 90, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 5, '2020-09-03 00:00:00', '2020-09-03 00:00:00'),
(5, 'John Wick Chapter 3: Parabellum', 'Sau khi sát hại một thành viên của tổ chức sát thủ quốc tế, mạng của John Wick được treo giá 14 triệu USD, và một đạo quân săn tiền thưởng liền bám riết lấy anh.', 2, 1, 'img1.jpg', 110, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 100, '2020-09-03 00:00:00', '2020-09-03 00:00:00'),
(6, 'Gemini Man', 'Một sát thủ về hưu bị buộc phải chạy trốn và nhận ra anh phải đối đầu với địch thủ ghê gớm nhất - bản sao trẻ trung hơn của mình.', 2, 2, 'img2.jpg', 95, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 200, '2020-09-01 00:00:00', '2020-09-01 00:00:00'),
(7, 'Angel Has Fallen', 'Một nhân viên Mật vụ bị kết tội oan chạy đua với thời gian để cứu Tổng thống và đất nước khỏi hiểm họa trong lúc trốn tránh chính cơ quan của mình và FBI.', 2, 1, 'img3.jpg', 95, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 150, '2020-09-02 00:00:00', '2020-09-02 00:00:00'),
(8, 'Tomb Raider', 'Khi tìm kiếm manh mối về vụ mất tích của người cha là nhà thám hiểm, cô gái Lara thông minh và can đảm bước vào hành trình tìm kiếm lăng mộ mất tích mà cha cô đang bỏ dở.', 2, 1, 'img8.jpg', 100, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 20, '2020-08-28 00:00:00', '2020-08-29 00:00:00'),
(9, 'A Score To Settle', 'Bị chẩn đoán mắc bệnh hiểm nghèo, một cựu tội phạm cố gắng hàn gắn với con trai trong lúc lên kế hoạch trả thù băng đảng cũ.', 2, 1, 'img9.jpg', 110, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 120, '2020-09-03 00:00:00', '2020-09-03 00:00:00'),
(10, 'Fast & Furious: Hobbs & Shaw', 'Khi một kẻ vô chính phủ được cải tạo gien chiếm được một vũ khí sinh học nguy hiểm có thể làm thay đổi cả thế giới, một nhân viên hành pháp phải hợp lực cùng một kẻ ngoài vòng pháp luật để đánh bại hắn.', 2, 2, 'img10.jpg', 100, 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4', 120, '2020-09-03 00:00:00', '2020-09-03 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `film_cast`
--

CREATE TABLE `film_cast` (
  `filmid` int(11) NOT NULL,
  `castid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `film_cast`
--

INSERT INTO `film_cast` (`filmid`, `castid`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 1),
(3, 1),
(3, 2),
(4, 3),
(5, 1),
(5, 2),
(6, 1),
(6, 2),
(7, 3),
(7, 2),
(8, 1),
(9, 1),
(9, 3),
(10, 2),
(10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'vip');

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `id` int(11) NOT NULL,
  `expire` int(11) DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`id`, `expire`, `token`, `userid`) VALUES
(1, 30, '7f55d78e-821a-4f40-a799-398cd5bab59e1599065299154', 1),
(2, 30, '09d9ac45-0e02-4c1a-b841-fd798c383e9d1599065303234', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `token`, `username`) VALUES
(1, '$2a$10$sz0pB4exZ9Oud1qWYSD3H.KBv7bRbXixh36XVnJ22n9QZJELR3Pl2', NULL, 'admin'),
(2, '$2a$10$jKM9Uqr0qtdUVArCqnu3VOL7VrXj26X90I65MvGuqHnpcI0z.xVkm', NULL, 'anhth');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`userid`, `roleid`) VALUES
(1, 1),
(1, 2),
(2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cast`
--
ALTER TABLE `cast`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3a33y60k2p0bku2t3wd2qwbj6` (`filmid`);

--
-- Indexes for table `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7pg89sracs1oddsekoldk7jag` (`categoryid`),
  ADD KEY `FKjy9a9ec8iviw4h3foalol4j7v` (`directorid`);

--
-- Indexes for table `film_cast`
--
ALTER TABLE `film_cast`
  ADD KEY `FKqdgqifeixyha2cv404twrc3oo` (`castid`),
  ADD KEY `FKgqodjvjxyle7etc5301eh4x7i` (`filmid`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKofgnyja0tjti5am5xwv36boek` (`userid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKbo5ik0bthje7hum554xb17ry6` (`roleid`),
  ADD KEY `FKd0xwi6psywvnj59btfns0alnm` (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cast`
--
ALTER TABLE `cast`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `director`
--
ALTER TABLE `director`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `token`
--
ALTER TABLE `token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK3a33y60k2p0bku2t3wd2qwbj6` FOREIGN KEY (`filmid`) REFERENCES `film` (`id`);

--
-- Constraints for table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK7pg89sracs1oddsekoldk7jag` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKjy9a9ec8iviw4h3foalol4j7v` FOREIGN KEY (`directorid`) REFERENCES `director` (`id`);

--
-- Constraints for table `film_cast`
--
ALTER TABLE `film_cast`
  ADD CONSTRAINT `FKgqodjvjxyle7etc5301eh4x7i` FOREIGN KEY (`filmid`) REFERENCES `film` (`id`),
  ADD CONSTRAINT `FKqdgqifeixyha2cv404twrc3oo` FOREIGN KEY (`castid`) REFERENCES `cast` (`id`);

--
-- Constraints for table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `FKofgnyja0tjti5am5xwv36boek` FOREIGN KEY (`userid`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKd0xwi6psywvnj59btfns0alnm` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKbo5ik0bthje7hum554xb17ry6` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
