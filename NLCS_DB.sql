-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 11, 2022 lúc 07:31 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `minhluu2608`
--
CREATE DATABASE IF NOT EXISTS `minhluu2608` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `minhluu2608`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `case`
--

CREATE TABLE `case` (
  `ID_LK` int(11) NOT NULL,
  `HangSX` varchar(20) NOT NULL,
  `Kieu_case` varchar(11) NOT NULL,
  `Mau` varchar(20) NOT NULL,
  `Kieu_mainboard` varchar(40) NOT NULL,
  `Chat_lieu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `case`
--

INSERT INTO `case` (`ID_LK`, `HangSX`, `Kieu_case`, `Mau`, `Kieu_mainboard`, `Chat_lieu`) VALUES
(22, 'Cooler Master', 'Mini Tower', 'Đen', 'Mini-ITX, Micro-ATX', 'Thép'),
(23, 'Cooler Master', 'Mid Tower', 'Đen', 'Micro-ATX, ATX', 'Thép'),
(24, 'Golden Field', 'Full Tower', 'Đen', 'Micro-ATX, ATX, Extended-ATX, ITX', 'Thép'),
(25, 'Cooler Master', 'Mid Tower', 'Trắng', 'Mini-ITX, Micro-ATX, ATX', 'Thép'),
(26, 'Jetek', 'Mid Tower', 'Trắng', 'ATX ', 'Thép'),
(122, 'Cooler Master', 'Mini Tower', 'Đen', 'Mini-ITX, Micro-ATX', 'Thép'),
(123, 'Cooler Master', 'Mid Tower', 'Đen', 'Micro-ATX, ATX', 'Thép'),
(124, 'Golden Field', 'Full Tower', 'Đen', 'Micro-ATX, ATX, Extended-ATX, ITX', 'Thép');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cpu`
--

CREATE TABLE `cpu` (
  `ID_LK` int(11) NOT NULL,
  `HangSX` varchar(30) NOT NULL,
  `Series` int(11) NOT NULL,
  `Core` int(11) NOT NULL,
  `Xung` varchar(20) NOT NULL,
  `Socket` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cpu`
--

INSERT INTO `cpu` (`ID_LK`, `HangSX`, `Series`, `Core`, `Xung`, `Socket`) VALUES
(4, 'Intel', 8, 4, '3.6GHz', '1151-v2'),
(1, 'Intel', 7, 2, '3.9GHz', '1151'),
(2, 'Intel', 7, 4, '3.4GHz - 3.8GHz', '1151'),
(5, 'AMD', 1, 6, '3.2GHz - 3.6GHz', 'AM4'),
(3, 'Intel', 10, 4, '3.6GHz - 4.30GHz', '1200'),
(101, 'Intel', 7, 2, '3.9GHz', '1151'),
(102, 'Intel', 7, 4, '3.4GHz - 3.8GHz', '1151'),
(105, 'AMD', 1, 6, '3.2GHz - 3.6GHz', 'AM4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `disk`
--

CREATE TABLE `disk` (
  `ID_LK` int(11) NOT NULL,
  `HangSX` varchar(10) NOT NULL,
  `Chuan_ket_noi` varchar(10) NOT NULL,
  `Kich_thuoc` varchar(10) NOT NULL,
  `Dung_luong` varchar(10) NOT NULL,
  `Loai` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `disk`
--

INSERT INTO `disk` (`ID_LK`, `HangSX`, `Chuan_ket_noi`, `Kich_thuoc`, `Dung_luong`, `Loai`) VALUES
(12, 'WD', 'SATA 3', '3.5\"', '1TB', 'HDD'),
(18, 'SEAGATE', 'SATA 3', '3.5\"', '3TB', 'HDD'),
(19, 'TRANSCEND', 'SATA 3', '2.5\"', '120GB', 'SSD'),
(20, 'TRANSCEND', 'SATA 3', '2.5\"', '240GB', 'SSD'),
(21, 'WD', 'M.2 SATA', 'M.2 2280', '120GB', 'SSD'),
(112, 'WD', 'SATA 3', '3.5\"', '1TB', 'HDD'),
(118, 'SEAGATE', 'SATA 3', '3.5\"', '3TB', 'HDD'),
(119, 'TRANSCEND', 'SATA 3', '2.5\"', '120GB', 'SSD'),
(120, 'TRANSCEND', 'SATA 3', '2.5\"', '240GB', 'SSD');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gpu`
--

CREATE TABLE `gpu` (
  `ID_LK` int(11) NOT NULL,
  `HangSX` varchar(20) NOT NULL,
  `Chip_do_hoa` varchar(30) NOT NULL,
  `VMemory` int(11) NOT NULL,
  `The_he_bo_nho` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `gpu`
--

INSERT INTO `gpu` (`ID_LK`, `HangSX`, `Chip_do_hoa`, `VMemory`, `The_he_bo_nho`) VALUES
(13, 'MSI', 'NVIDIA GeForce GTX 1060', 6, 'GDDR5'),
(14, 'MSI', 'NVIDIA GeForce GTX 1050', 2, 'GDDR5'),
(15, 'GIGABYTE', 'AMD Radeon RX Vega 56', 8, 'HBM2'),
(16, 'GIGABYTE', 'GeForce GTX 1650', 4, 'GDDR6'),
(17, 'GIGABYTE', 'GeForce RTX 2060', 6, 'GDDR6'),
(113, 'MSI', 'NVIDIA GeForce GTX 1060', 6, 'GDDR5'),
(114, 'MSI', 'NVIDIA GeForce GTX 1050', 2, 'GDDR5'),
(115, 'GIGABYTE', 'AMD Radeon RX Vega 56', 8, 'HBM2'),
(116, 'GIGABYTE', 'GeForce GTX 1650', 4, 'GDDR6'),
(117, 'GIGABYTE', 'GeForce RTX 2060', 6, 'GDDR6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `linhkien`
--

CREATE TABLE `linhkien` (
  `ID_LK` int(11) NOT NULL,
  `Ten_LK` varchar(200) NOT NULL,
  `Loai_LK` varchar(50) NOT NULL,
  `Gia_LK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `linhkien`
--

INSERT INTO `linhkien` (`ID_LK`, `Ten_LK`, `Loai_LK`, `Gia_LK`) VALUES
(1, 'CPU Intel Core I3-7100 (3.9GHz)', 'CPU', 3350000),
(2, 'CPU Intel Core I5-7500 (3.4GHz - 3.8GHz)', 'CPU', 5970000),
(3, 'CPU INTEL i3-10100 (4C/8T, 3.60 GHz - 4.30 GHz, 6MB) - 1200', 'CPU', 4190000),
(4, 'CPU Intel Core I3-8100 (3.6GHz)', 'CPU', 3290000),
(5, 'CPU AMD Ryzen R5 1600 (3.2GHz - 3.6GHz)', 'CPU', 4990000),
(6, 'Mainboard ASUS ROG STRIX B350-F GAMING', 'Mainboard', 3290000),
(7, 'RAM desktop KINGMAX (1x4GB) DDR4 2400MHz', 'RAM', 650000),
(8, 'RAM desktop KINGMAX Zeus Dragon (1x16GB) DDR4 3000MHz', 'RAM', 2350000),
(9, 'RAM desktop KINGMAX (1x8GB) DDR4 2400MHz', 'RAM', 1250000),
(10, 'RAM desktop KINGMAX Zeus Dragon Heatsink (1 x 32GB) DDR4 3200MHz ', 'RAM', 4790000),
(11, 'RAM desktop AVEXIR Core (1x4GB) DDR4 2400MHz', 'RAM', 1269000),
(12, 'Ổ cứng HDD Western Digital Blue 1TB 3.5\" SATA 3 - WD10EZEX', 'disk', 930000),
(13, 'Card màn hình MSI GeForce GTX 1060 6GB GDDR5 Gaming X (GTX-1060-GAMING-X-6G)', 'GPU', 8300000),
(14, 'Card màn hình MSI GeForce GTX 1050 2GB GDDR5 OCV1 (GTX-1050-2GT-OCV1)', 'GPU', 2890000),
(15, 'Card màn hình GIGABYTE Radeon RX Vega 56 8GB HBM2 Gaming OC', 'GPU', 12950000),
(16, 'Card màn hình GIGABYTE GeForce GTX 1650 D6 OC 4G (rev. 1.0) 4GB GDDR6', 'GPU', 6390000),
(17, 'Card màn hình GIGABYTE GeForce RTX 2060 D6 6G 6GB GDDR6', 'GPU', 12990000),
(18, 'Ổ cứng HDD Seagate Barracuda 3TB 3.5\" SATA 3 - ST3000DM007', 'disk', 2350000),
(19, 'Ổ cứng SSD Transcend 220S 120GB 2.5\" SATA 3', 'disk', 650000),
(20, 'Ổ cứng SSD Transcend 220S 240GB 2.5\" SATA 3', 'disk', 1090000),
(21, 'Ổ cứng SSD Western Digital Green 120GB M.2 2280 SATA 3 - WDS120G2G0B', 'disk', 790000),
(22, 'Case máy tính Cooler Master RC 343', 'Case', 830000),
(23, 'Case máy tính Cooler Master RC K380', 'Case', 999000),
(24, 'Case Golden Field Z21 (3 fans LED Rainbow)', 'Case', 1150000),
(25, 'Case máy tính Cooler Master MasterBox 5 White', 'Case', 1660000),
(26, 'Case máy tính Jetek G9311W - Mid Tower (Trắng)', 'Case', 670000),
(101, 'CPU Intel Core I3-7100 (3.9GHz) COPY 1', 'CPU', 2550000),
(102, 'CPU Intel Core I5-7500 (3.4GHz - 3.8GHz) COPY 1', 'CPU', 5070000),
(105, 'CPU AMD Ryzen R5 1600 (3.2GHz - 3.6GHz) COPY 1', 'CPU', 4090000),
(106, 'Mainboard ASUS ROG STRIX B350-F GAMING COPY 1', 'Mainboard', 3090000),
(107, 'RAM desktop KINGMAX (1x4GB) DDR4 2400MHz COPY 1', 'RAM', 750000),
(108, 'RAM desktop KINGMAX Zeus Dragon (1x16GB) DDR4 3000MHz COPY 1', 'RAM', 2550000),
(109, 'RAM desktop KINGMAX (1x8GB) DDR4 2400MHz COPY 1', 'RAM', 1350000),
(110, 'RAM desktop KINGMAX Zeus Dragon Heatsink (1 x 32GB) DDR4 3200MHz COPY 1', 'RAM', 5090000),
(112, 'Ổ cứng HDD Western Digital Blue 1TB 3.5\" SATA 3 - WD10EZEX COPY 1', 'disk', 1030000),
(113, 'Card màn hình MSI GeForce GTX 1060 6GB GDDR5 Gaming X (GTX-1060-GAMING-X-6G) COPY 1', 'GPU', 7800000),
(114, 'Card màn hình MSI GeForce GTX 1050 2GB GDDR5 OCV1 (GTX-1050-2GT-OCV1) COPY 1', 'GPU', 2690000),
(115, 'Card màn hình GIGABYTE Radeon RX Vega 56 8GB HBM2 Gaming OC COPY 1', 'GPU', 11950000),
(116, 'Card màn hình GIGABYTE GeForce GTX 1650 D6 OC 4G (rev. 1.0) 4GB GDDR6 COPY 1', 'GPU', 6990000),
(117, 'Card màn hình GIGABYTE GeForce RTX 2060 D6 6G 6GB GDDR6 COPY 1', 'GPU', 15990000),
(118, 'Ổ cứng HDD Seagate Barracuda 3TB 3.5\" SATA 3 - ST3000DM007 COPY 1', 'disk', 2050000),
(119, 'Ổ cứng SSD Transcend 220S 120GB 2.5\" SATA 3 COPY 1', 'disk', 690000),
(120, 'Ổ cứng SSD Transcend 220S 240GB 2.5\" SATA 3 COPY 1', 'disk', 1190000),
(122, 'Case máy tính Cooler Master RC 343 COPY 1', 'Case', 850000),
(123, 'Case máy tính Cooler Master RC K380 COPY 1', 'Case', 959000),
(124, 'Case Golden Field Z21 (3 fans LED Rainbow) COPY 1', 'Case', 1350000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mainboard`
--

CREATE TABLE `mainboard` (
  `ID_LK` int(11) NOT NULL,
  `HangSX` varchar(20) NOT NULL,
  `Socket` varchar(10) NOT NULL,
  `Chipset` varchar(10) NOT NULL,
  `Chuan_kich_thuoc` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `mainboard`
--

INSERT INTO `mainboard` (`ID_LK`, `HangSX`, `Socket`, `Chipset`, `Chuan_kich_thuoc`) VALUES
(6, 'ASUS', 'AM4', 'B350', 'ATX'),
(106, 'ASUS', 'AM4', 'B350', 'ATX');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ram`
--

CREATE TABLE `ram` (
  `ID_LK` int(11) NOT NULL,
  `HangSX` varchar(11) NOT NULL,
  `DDR` varchar(10) NOT NULL,
  `Dung_luong` int(11) NOT NULL,
  `Bus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ram`
--

INSERT INTO `ram` (`ID_LK`, `HangSX`, `DDR`, `Dung_luong`, `Bus`) VALUES
(7, 'KINGMAX', '4', 4, 2400),
(8, 'KINGMAX', '4', 16, 3000),
(9, 'KINGMAX', '4', 8, 2400),
(10, 'KINGMAX', '4', 32, 3200),
(11, 'AVEXIR', '4', 4, 2400),
(107, 'KINGMAX', '4', 4, 2400),
(108, 'KINGMAX', '4', 16, 3000),
(109, 'KINGMAX', '4', 8, 2400),
(110, 'KINGMAX', '4', 32, 3200);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `case`
--
ALTER TABLE `case`
  ADD KEY `ID_LK` (`ID_LK`);

--
-- Chỉ mục cho bảng `cpu`
--
ALTER TABLE `cpu`
  ADD KEY `ID_LK` (`ID_LK`);

--
-- Chỉ mục cho bảng `disk`
--
ALTER TABLE `disk`
  ADD KEY `ID_LK` (`ID_LK`);

--
-- Chỉ mục cho bảng `gpu`
--
ALTER TABLE `gpu`
  ADD KEY `ID_LK` (`ID_LK`);

--
-- Chỉ mục cho bảng `linhkien`
--
ALTER TABLE `linhkien`
  ADD PRIMARY KEY (`ID_LK`);

--
-- Chỉ mục cho bảng `mainboard`
--
ALTER TABLE `mainboard`
  ADD KEY `ID_LK` (`ID_LK`);

--
-- Chỉ mục cho bảng `ram`
--
ALTER TABLE `ram`
  ADD KEY `ID_LK` (`ID_LK`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `case`
--
ALTER TABLE `case`
  ADD CONSTRAINT `case_ibfk_1` FOREIGN KEY (`ID_LK`) REFERENCES `linhkien` (`ID_LK`);

--
-- Các ràng buộc cho bảng `cpu`
--
ALTER TABLE `cpu`
  ADD CONSTRAINT `cpu_ibfk_1` FOREIGN KEY (`ID_LK`) REFERENCES `linhkien` (`ID_LK`);

--
-- Các ràng buộc cho bảng `disk`
--
ALTER TABLE `disk`
  ADD CONSTRAINT `disk_ibfk_1` FOREIGN KEY (`ID_LK`) REFERENCES `linhkien` (`ID_LK`);

--
-- Các ràng buộc cho bảng `gpu`
--
ALTER TABLE `gpu`
  ADD CONSTRAINT `gpu_ibfk_1` FOREIGN KEY (`ID_LK`) REFERENCES `linhkien` (`ID_LK`);

--
-- Các ràng buộc cho bảng `mainboard`
--
ALTER TABLE `mainboard`
  ADD CONSTRAINT `mainboard_ibfk_1` FOREIGN KEY (`ID_LK`) REFERENCES `linhkien` (`ID_LK`);

--
-- Các ràng buộc cho bảng `ram`
--
ALTER TABLE `ram`
  ADD CONSTRAINT `ram_ibfk_1` FOREIGN KEY (`ID_LK`) REFERENCES `linhkien` (`ID_LK`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
