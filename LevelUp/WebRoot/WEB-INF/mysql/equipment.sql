/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : whm

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-05-19 01:06:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equipment`
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `playerid` int(11) DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `ATK` int(11) unsigned zerofill DEFAULT NULL,
  `DEF` int(11) unsigned zerofill DEFAULT NULL,
  `SPD` int(11) unsigned zerofill DEFAULT NULL,
  `HIT` double unsigned zerofill DEFAULT NULL,
  `EVD` double unsigned zerofill DEFAULT NULL,
  `CRT` double unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('35', '8', '23', 'Arms', '1', '00000000010', null, null, null, null, null);
INSERT INTO `equipment` VALUES ('36', '8', '23', 'Armor', '1', null, '00000000005', null, null, null, null);
INSERT INTO `equipment` VALUES ('37', '8', '23', 'Accessories', '1', null, null, null, '0000000000000000000000', '0000000000000000000.02', '0000000000000000000000');
INSERT INTO `equipment` VALUES ('38', '8', '23', 'Shoes', '1', null, null, '00000000010', null, null, null);
INSERT INTO `equipment` VALUES ('43', '9', '25', 'Arms', '1', '00000000010', null, null, null, null, null);
INSERT INTO `equipment` VALUES ('44', '9', '25', 'Armor', '1', null, '00000000005', null, null, null, null);
INSERT INTO `equipment` VALUES ('45', '9', '25', 'Accessories', '1', null, null, null, '0000000000000000000.02', '0000000000000000000.01', '0000000000000000000.01');
INSERT INTO `equipment` VALUES ('46', '9', '25', 'Shoes', '1', null, null, '00000000010', null, null, null);
