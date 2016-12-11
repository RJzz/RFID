/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-11 18:08:09
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
  `rPosition` char(20) DEFAULT NULL,
  `rKname` char(10) NOT NULL,
  `rDname` char(10) NOT NULL,
  `rDate` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rId` (`rId`),
  KEY `rDname` (`rDname`),
  KEY `rKname` (`rKname`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rfid
-- ----------------------------
INSERT INTO `rfid` VALUES ('89', '0001', '电脑', '0001', '电子设备', '实验室4-5', '小明', '小明', '2016-12-13');
INSERT INTO `rfid` VALUES ('94', '112', '手机', '200', '实验室4-5', '电子设备', '小红', '小红', '2016-12-11');
