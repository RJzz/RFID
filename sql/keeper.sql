/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-08 19:37:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for keeper
-- ----------------------------
DROP TABLE IF EXISTS `keeper`;
CREATE TABLE `keeper` (
  `id` smallint(6) NOT NULL,
  `kName` char(10) NOT NULL,
  `kEmail` varchar(20) NOT NULL,
  `kPhone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`kName`),
  KEY `kName` (`kName`),
  CONSTRAINT `kName` FOREIGN KEY (`kName`) REFERENCES `rfid` (`rKname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keeper
-- ----------------------------
