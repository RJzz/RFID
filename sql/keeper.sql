/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-04 09:54:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for keeper
-- ----------------------------
DROP TABLE IF EXISTS `keeper`;
CREATE TABLE `keeper` (
  `kKId` char(20) DEFAULT NULL,
  `kName` char(10) NOT NULL,
  `KEmail` char(20) NOT NULL,
  `kPone` char(15) NOT NULL,
  KEY `kKId` (`kKId`),
  CONSTRAINT `kKId` FOREIGN KEY (`kKId`) REFERENCES `rfid` (`rKId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keeper
-- ----------------------------
