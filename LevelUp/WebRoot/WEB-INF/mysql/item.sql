/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : whm

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-05-19 01:07:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `playerid` int(11) DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `ATK` int(11) unsigned zerofill DEFAULT NULL,
  `DEF` int(11) unsigned zerofill DEFAULT NULL,
  `SPD` int(11) unsigned zerofill DEFAULT NULL,
  `EXP` int(11) unsigned zerofill DEFAULT NULL,
  `HIT` double unsigned zerofill DEFAULT NULL,
  `EVD` double unsigned zerofill DEFAULT NULL,
  `CRT` double unsigned zerofill DEFAULT NULL,
  `HP` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('83', '8', '23', 'EXPPotion', '2', null, null, null, '00000000035', null, null, null, null);
INSERT INTO `item` VALUES ('84', '8', '23', 'Arms', '2', '00000000014', null, null, null, null, null, null, null);
INSERT INTO `item` VALUES ('85', '8', '23', 'Shoes', '2', null, null, '00000000014', null, null, null, null, null);
