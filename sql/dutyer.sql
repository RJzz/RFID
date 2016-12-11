/*
Navicat MySQL Data Transfer

Source Server         : RJzz
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rfid

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-11 18:09:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dutyer
-- ----------------------------
DROP TABLE IF EXISTS `dutyer`;
CREATE TABLE `dutyer` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `dName` char(10) NOT NULL,
  `dEmail` varchar(20) DEFAULT NULL,
  `dPhone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dName` (`dName`),
  CONSTRAINT `dName` FOREIGN KEY (`dName`) REFERENCES `rfid` (`rDname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dutyer
-- ----------------------------
INSERT INTO `dutyer` VALUES ('11', '小明', '11111', '111111');
INSERT INTO `dutyer` VALUES ('13', '小红', '', '13908089999');
