/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.17 : Database - zyb_netaware
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `zyb_netaware`;

/*Table structure for table `sta_area` */

CREATE TABLE `sta_area` (
  `area_id` varchar(11) NOT NULL COMMENT '小区编码',
  `area_name` varchar(200) DEFAULT NULL COMMENT '小区名称',
  `reserved1` varchar(20) DEFAULT NULL COMMENT '预留1',
  `reserved2` varchar(20) DEFAULT NULL COMMENT '预留1',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小区信息表';

/*Table structure for table `sta_broken_record` */

CREATE TABLE `sta_broken_record` (
  `broken_num` varchar(11) NOT NULL COMMENT '故障流水号',
  `sta_id` varchar(11) DEFAULT NULL COMMENT '基站编码',
  `isrecovery` varchar(5) DEFAULT NULL COMMENT '是否恢复',
  `broken_type` varchar(200) DEFAULT NULL COMMENT '故障类型',
  `broken_time` date DEFAULT NULL COMMENT '故障时间',
  `recover_time` date DEFAULT NULL COMMENT '恢复时间',
  `broken_reason` varchar(1000) DEFAULT NULL COMMENT '故障原因',
  `broken_address` varchar(200) DEFAULT NULL COMMENT '故障位置',
  `area_id` varchar(11) DEFAULT NULL COMMENT '小区编码',
  `reserved1` varchar(20) DEFAULT NULL COMMENT '预留1',
  `reserved2` varchar(20) DEFAULT NULL COMMENT '预留1',
  PRIMARY KEY (`broken_num`),
  KEY `pk_area_id_b` (`area_id`),
  CONSTRAINT `pk_area_id_b` FOREIGN KEY (`area_id`) REFERENCES `sta_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='断站信息表';

/*Table structure for table `sta_complaint_record` */

CREATE TABLE `sta_complaint_record` (
  `complaint_num` varchar(11) DEFAULT NULL COMMENT '工单流水号',
  `down_type` varchar(200) DEFAULT NULL COMMENT '故障类型',
  `down_appear` varchar(200) DEFAULT NULL COMMENT '故障现象',
  `mobile_num` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `complaint_address` varchar(200) DEFAULT NULL COMMENT '投诉地址',
  `create_time` date DEFAULT NULL COMMENT '登记时间',
  `net_type` varchar(10) DEFAULT NULL COMMENT '网络类型',
  `is_recovery` int(11) DEFAULT NULL COMMENT '恢复与否（0,1）',
  `lng` varchar(20) DEFAULT NULL COMMENT '经度',
  `lac` varchar(20) DEFAULT NULL COMMENT '纬度',
  `big_x` varchar(20) DEFAULT NULL COMMENT 'x坐标',
  `big_y` varchar(20) DEFAULT NULL COMMENT 'y坐标',
  `user_emotion` int(11) DEFAULT NULL COMMENT '用户情绪',
  `area_id` varchar(11) DEFAULT NULL COMMENT '小区编码',
  `reserved1` varchar(20) DEFAULT NULL COMMENT '预留1',
  `reserved2` varchar(20) DEFAULT NULL COMMENT '预留2',
  KEY `pk_area_id_a` (`area_id`),
  CONSTRAINT `pk_area_id_a` FOREIGN KEY (`area_id`) REFERENCES `sta_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='投诉登记表';

/*Table structure for table `tb_user` */

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(40) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
