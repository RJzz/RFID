/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-04 09:53:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `rDId` char(20) NOT NULL,
  `dName` char(10) NOT NULL,
  `dEmail` char(20) NOT NULL,
  `dPone` char(15) NOT NULL,
  PRIMARY KEY (`rDId`),
  CONSTRAINT `rDId` FOREIGN KEY (`rDId`) REFERENCES `rfid` (`rDId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------
