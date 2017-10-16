/*
Navicat MySQL Data Transfer

Source Server         : qewrq
Source Server Version : 50709
Source Host           : 10.63.220.3:3306
Source Database       : visual

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-12-01 16:07:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for dual
-- ----------------------------
DROP TABLE IF EXISTS `dual`;
CREATE TABLE `dual` (
  `1` varchar(255) DEFAULT NULL,
  `info_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `work` varchar(255) DEFAULT NULL,
  `feel` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for workinfo
-- ----------------------------
DROP TABLE IF EXISTS `workinfo`;
CREATE TABLE `workinfo` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `work` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `feel` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `date` varchar(255) NOT NULL,
  `team` varchar(255) DEFAULT NULL,
  `userid` varchar(255) NOT NULL,
  PRIMARY KEY (`info_id`,`date`,`userid`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1384 DEFAULT CHARSET=latin1;
