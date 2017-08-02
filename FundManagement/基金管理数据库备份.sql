-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 fund 的数据库结构
CREATE DATABASE IF NOT EXISTS `fund` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fund`;

-- 导出  表 fund.fund 结构
CREATE TABLE IF NOT EXISTS `fund` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT '0' COMMENT '基金名称',
  `platform` varchar(50) DEFAULT '0' COMMENT '基金平台',
  `ballpark` varchar(50) DEFAULT '0' COMMENT '基金规模 大 中 小',
  `grade` int(11) DEFAULT '0' COMMENT '五星评分',
  `bgrade` int(11) DEFAULT '0' COMMENT 'b评分',
  `manager` varchar(50) NOT NULL DEFAULT '0' COMMENT '基金经理',
  `mgrade` int(11) NOT NULL DEFAULT '0' COMMENT '经理评分',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=100008 DEFAULT CHARSET=utf8 COMMENT='基金表';

-- 正在导出表  fund.fund 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `fund` DISABLE KEYS */;
REPLACE INTO `fund` (`fid`, `name`, `platform`, `ballpark`, `grade`, `bgrade`, `manager`, `mgrade`) VALUES
	(100000, '网易基金', '网易基金', '大', 5, 4, '张三', 5),
	(100001, '人寿基金', '人寿基金', '中', 4, 3, '张建', 4),
	(100006, '天使基金', '天使基金平台', '大', 5, 4, '余豪', 5),
	(100007, '阿里巴巴', '阿里巴巴基金平台', '大', 5, 4, '马云', 5);
/*!40000 ALTER TABLE `fund` ENABLE KEYS */;

-- 导出  表 fund.invest 结构
CREATE TABLE IF NOT EXISTS `invest` (
  `iid` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易的id',
  `uid` int(11) NOT NULL COMMENT '用户的id',
  `fid` int(11) NOT NULL COMMENT '基金的id',
  `mode` varchar(50) NOT NULL COMMENT '模式',
  `firstdate` date NOT NULL COMMENT '首日投资日期',
  `today` date NOT NULL COMMENT '今天的日期',
  `getincome` float NOT NULL COMMENT '以实现收益',
  `thisincome` float NOT NULL COMMENT '本轮收益',
  `count` int(11) NOT NULL COMMENT '轮次',
  `amount` float NOT NULL COMMENT '账目总资产',
  `proalo` float NOT NULL COMMENT '持仓盈亏',
  `rifa` float NOT NULL COMMENT '涨幅',
  `invest` float NOT NULL DEFAULT '5000' COMMENT '投资份额',
  `firstyearprofit` float NOT NULL COMMENT '首日年化',
  `bsale` int(11) NOT NULL DEFAULT '1' COMMENT '1表示正在投资该基金',
  PRIMARY KEY (`iid`),
  KEY `uikey` (`uid`),
  KEY `FK__fund` (`fid`),
  KEY `Index 4` (`iid`),
  CONSTRAINT `FK__fund` FOREIGN KEY (`fid`) REFERENCES `fund` (`fid`),
  CONSTRAINT `uikey` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='信息记录表';

-- 正在导出表  fund.invest 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `invest` DISABLE KEYS */;
REPLACE INTO `invest` (`iid`, `uid`, `fid`, `mode`, `firstdate`, `today`, `getincome`, `thisincome`, `count`, `amount`, `proalo`, `rifa`, `invest`, `firstyearprofit`, `bsale`) VALUES
	(1, 10000, 100000, '日投', '2017-07-21', '2017-07-23', 12, 25, 1, 12569, 145, 25, 3654, 0.05, 1),
	(2, 10000, 100000, '日投', '2017-07-28', '2017-07-29', 12, 25, 1, 65, 458, 236, 5000, 0.26, 1),
	(3, 10000, 100001, '周投', '2017-07-29', '2017-07-30', 12, 25, 1, 35, 45, 212, 5000, 0.36, 0),
	(4, 10001, 100000, '日投', '2017-07-26', '2017-07-30', 12, 25, 1, 35, 45, 212, 5000, 0.36, 1),
	(8, 10000, 100000, '日投', '3917-08-21', '2017-07-31', 2000, 475, 2, 30000, 2500, 0.0025, 5000, 5.8721, 1),
	(9, 10000, 100001, '周投', '2017-07-29', '2017-07-31', 2500, 475, 2, 300000, 3000, -0.0012, 1000, 0.5788, 0),
	(11, 10000, 100006, '日投', '2017-07-31', '2017-07-31', 0, 0, 1, 1000, 0, 0, 1000, 0, 1),
	(12, 10000, 100000, '日投', '2017-08-02', '2017-08-02', 0, 0, 1, 1000, 0, 0, 1000, 0, 1),
	(13, 10000, 100006, '日投', '2017-07-31', '2017-08-02', 2000, 950, 2, 360000, 3000, 0.00001, 5000, 0.9657, 1),
	(14, 10000, 100000, '日投', '2017-08-21', '2017-08-03', 2000, 950, 2, 360000, 3000, 0.00001, 500, 0.9657, 1);
/*!40000 ALTER TABLE `invest` ENABLE KEYS */;

-- 导出  表 fund.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户名id',
  `password` varchar(50) DEFAULT '0' COMMENT '用户的密码',
  `account` float DEFAULT '0' COMMENT '用户的账户资金',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='用户名';

-- 正在导出表  fund.user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`uid`, `password`, `account`) VALUES
	(10000, 'root', 0),
	(10001, 'root', 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
