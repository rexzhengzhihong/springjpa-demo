/*
 Navicat Premium Data Transfer

 Source Server         : con
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : demo1

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 14/05/2021 17:18:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_demo_purchaserequisition
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo_purchaserequisition`;
CREATE TABLE `tb_demo_purchaserequisition`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人',
  `application_date` datetime(0) NOT NULL COMMENT '申请日期',
  `status` int(255) NOT NULL COMMENT '采购状态 1：申请新建 2：申请提交 3： 审核通过 4： 审核不通过',
  `approval` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指定的审批人',
  `create_date` datetime(0) NOT NULL COMMENT '创建日期',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `modify_date` datetime(0) NOT NULL COMMENT '修改日期',
  `modifier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采购申请基本信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
