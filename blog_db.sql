/*
Navicat MySQL Data Transfer

Source Server         : mysql-1
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : blog_db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-15 15:27:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `author`
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('11', '黄大海', '123', 'hdh@sina.com', '广州市北京路46号', '13912091212');
INSERT INTO `author` VALUES ('12', '张兆辉', '321', 'zzh@sina.com', '深圳市深南大道11号', '13312092412');
INSERT INTO `author` VALUES ('13', '牛志飞', '123', 'nzf@sina.com', '武汉市台北路11号', '13212348909');
INSERT INTO `author` VALUES ('14', '巴拿马', '123', 'nzf@sina.com', '武汉市黄兴路11号', '13212348712');

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_author` (`author_id`),
  CONSTRAINT `fk_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '甲午战争', '中国割让台湾步入深渊', '2016-04-22', '政论', '12');
INSERT INTO `blog` VALUES ('9', '朝鲜核试验', '王毅表示我们对美国有可能在韩部署“萨德”反导系统的动向表示严重关切', '2016-03-19', '政论', '11');
INSERT INTO `blog` VALUES ('10', '物价温和', '2016年2月CPI为2.3%', '2016-03-13', '财经', '12');
INSERT INTO `blog` VALUES ('11', '反恐战争迫在眉睫', '伊斯兰国极端恐怖组织在阿拉伯地区大力扩充地盘', '2016-02-03', '政论', '11');
INSERT INTO `blog` VALUES ('12', '武汉马拉松比赛', '武汉马拉松比赛于2016年4月10日开跑', '2016-03-16', '体育', '11');
INSERT INTO `blog` VALUES ('14', '甲午战争', '中国割让台湾步入深渊', '2016-09-11', '政论', null);

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `postDate` date DEFAULT NULL,
  `blog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_blog` (`blog_id`),
  CONSTRAINT `fk_blog` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '伊斯兰教的教义是反对极端思想的', '2016-03-08', '11');
INSERT INTO `comment` VALUES ('2', '极端恐怖主义违背伊斯兰基本教义', '2016-03-10', '11');
INSERT INTO `comment` VALUES ('3', '汉马与武网一起大大提升武汉的国际地位', '2016-03-23', '12');
INSERT INTO `comment` VALUES ('4', '武汉马拉松比赛分为10公里、半程和全程', '2016-03-28', '12');
INSERT INTO `comment` VALUES ('10', '台湾也没有禁摩托，交通环境也', '2016-04-02', '11');
INSERT INTO `comment` VALUES ('11', '管理当局不能一禁了之', '2016-04-02', '11');

-- ----------------------------
-- Procedure structure for `procGetNumOfComments`
-- ----------------------------
DROP PROCEDURE IF EXISTS `procGetNumOfComments`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `procGetNumOfComments`(
	in _title varchar(50), -- 指定的博文标题
	out numOfComments int -- 针对标题指定的博文所发表评论的数量
)
    READS SQL DATA
begin 
		select count(*) into numOfComments from comment where blog_id=
		(select id from blog where title=_title);
end
;;
DELIMITER ;
