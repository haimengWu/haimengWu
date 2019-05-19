/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : whm

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-05-19 01:07:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `player`
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `userid` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `maxHP` int(11) DEFAULT NULL,
  `currentHP` int(11) DEFAULT NULL,
  `maxEXP` int(11) DEFAULT NULL,
  `currentEXP` int(11) DEFAULT NULL,
  `ATK` int(11) DEFAULT NULL,
  `DEF` int(11) DEFAULT NULL,
  `SPD` int(11) DEFAULT NULL,
  `HIT` double DEFAULT NULL,
  `EVD` double DEFAULT NULL,
  `CRT` double DEFAULT NULL,
  `isVIP` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('8', '23', 'whm', 'Assassin', '3', '280', '208', '160', '105', '69', '9', '146', '1', '0.25', '0.37', '0000000000');
INSERT INTO `player` VALUES ('9', '25', '23232', 'Fighter', '1', '350', '350', '40', '0', '25', '10', '100', '1', '0.1', '0.05', '0000000000');
