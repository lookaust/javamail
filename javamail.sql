/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50131
Source Host           : localhost:3306
Source Database       : javamail

Target Server Type    : MYSQL
Target Server Version : 50131
File Encoding         : 65001

Date: 2017-07-05 23:23:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `state` int(11) DEFAULT '0',
  `code` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
