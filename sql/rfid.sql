/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-04 09:54:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rfid
-- ----------------------------
DROP TABLE IF EXISTS `rfid`;
CREATE TABLE `rfid` (
  `rTag` char(12) NOT NULL,
  `rName` varchar(10) NOT NULL,
  `rId` char(12) NOT NULL,
  `rType` char(10) NOT NULL,
  `rPosition` char(20) NOT NULL,
  `rKId` char(20) NOT NULL,
  `rDId` char(20) NOT NULL,
  `rDate` date NOT NULL,
  PRIMARY KEY (`rTag`),
  UNIQUE KEY `rId` (`rId`),
  KEY `rKId` (`rKId`),
  KEY `rDId` (`rDId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rfid
-- ----------------------------
