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
) ENGINE=InnoDB AUTO_INCREMENT=100004 DEFAULT CHARSET=utf8 COMMENT='基金表';

-- 正在导出表  fund.fund 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `fund` DISABLE KEYS */;
REPLACE INTO `fund` (`fid`, `name`, `platform`, `ballpark`, `grade`, `bgrade`, `manager`, `mgrade`) VALUES
	(100000, 'yuhao', '天使基金', '大', 5, 4, '余豪', 5);
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
  PRIMARY KEY (`iid`),
  KEY `uikey` (`uid`),
  KEY `FK__fund` (`fid`),
  CONSTRAINT `FK__fund` FOREIGN KEY (`fid`) REFERENCES `fund` (`fid`),
  CONSTRAINT `uikey` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息记录表';

-- 正在导出表  fund.invest 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `invest` DISABLE KEYS */;
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
	(10000, '1', 2),
	(10001, '2', 3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
