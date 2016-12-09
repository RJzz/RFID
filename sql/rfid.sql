/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-08 19:37:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rfid
-- ----------------------------
DROP TABLE IF EXISTS `rfid`;
CREATE TABLE `rfid` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `rTag` char(12) NOT NULL,
  `rName` varchar(10) NOT NULL,
  `rId` char(12) NOT NULL,
  `rType` char(10) DEFAULT NULL,
  `rPosition` char(20) NOT NULL,
  `rKname` char(10) NOT NULL,
  `rDname` char(10) NOT NULL,
  `rDate` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rId` (`rId`),
  KEY `rDname` (`rDname`),
  KEY `rKname` (`rKname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rfid
-- ----------------------------
INSERT INTO `rfid` VALUES ('4', '1', '2', '3', '4', '4', '5', '5', '2016-12-04');
