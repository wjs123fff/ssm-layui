/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3307
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3307
 Source Schema         : personnel

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 29/06/2020 16:47:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept_inf
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
INSERT INTO `dept_inf` VALUES (1, '技术部', '技术部');
INSERT INTO `dept_inf` VALUES (2, '运营部1', '运营部1');
INSERT INTO `dept_inf` VALUES (3, '财务部', '财务部');
INSERT INTO `dept_inf` VALUES (4, '总公办', '总公办');
INSERT INTO `dept_inf` VALUES (5, '市场部', '市场部');
INSERT INTO `dept_inf` VALUES (6, '教学部', '教学部');
INSERT INTO `dept_inf` VALUES (8, '舍管部', '管理宿舍');

-- ----------------------------
-- Table structure for document_inf
-- ----------------------------
DROP TABLE IF EXISTS `document_inf`;
CREATE TABLE `document_inf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filename` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of document_inf
-- ----------------------------
INSERT INTO `document_inf` VALUES (4, 'm', '阿祥 - Dependent（枪声版）.flac', 'e', '2020六月22', NULL);
INSERT INTO `document_inf` VALUES (7, 'k', 'Aloan - Beat Of The Black Heart.mp3', 'o', '2020六月27', NULL);
INSERT INTO `document_inf` VALUES (9, 'k', 'Aloan - Beat Of The Black Heart.mp3', 'u', '2020六月27', NULL);
INSERT INTO `document_inf` VALUES (10, 'pp', '阿祥 - Dependent（枪声版）.flac', 'uu', '2020六月27', NULL);
INSERT INTO `document_inf` VALUES (13, 'my ', 'Chen X He - 爱的魔力转圈圈（Cover：芭比）.mp3', 'my', '2020六月27', NULL);

-- ----------------------------
-- Table structure for employee_inf
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `job_id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq_num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `party` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `race` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `speciality` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hobby` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE,
  CONSTRAINT `employee_inf_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept_inf` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employee_inf_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `job_inf` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_inf
-- ----------------------------
INSERT INTO `employee_inf` VALUES (4, 5, 1, '1', '1', '1', NULL, NULL, '1', NULL, '1', '1', NULL, NULL, NULL, '1', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (5, 1, 1, '2', '2', '2', NULL, NULL, '2', NULL, '2', '2', NULL, NULL, NULL, '2', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (6, 1, 1, '3', '3', '3', NULL, NULL, '3', NULL, '3', '3', NULL, NULL, NULL, '3', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (7, 1, 1, '4', '4', '4', NULL, NULL, '4', NULL, '4', '4', NULL, NULL, NULL, '4', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (8, 1, 1, '5', '5', '5', NULL, NULL, '5', NULL, '5', '5', NULL, NULL, NULL, '5', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (9, 1, 1, '6', '6', '6', NULL, NULL, '6', NULL, '6', '6', NULL, NULL, NULL, '6', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (10, 1, 1, '7', '7', '7', NULL, NULL, '7', NULL, '7', '7', NULL, NULL, NULL, '7', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (11, 1, 1, '8', '8', '8', NULL, NULL, '8', NULL, '8', '8', NULL, NULL, NULL, '8', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (12, 1, 1, '9', '9', '9', NULL, NULL, '9', NULL, '9', '9', NULL, NULL, NULL, '9', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (13, 1, 1, '10', '10', '10', NULL, NULL, '10', NULL, '10', '10', NULL, NULL, NULL, '10', NULL, NULL, NULL, '2020六月28');
INSERT INTO `employee_inf` VALUES (14, 1, 1, 'd', '3', '3', NULL, NULL, '3', NULL, '3', '3', NULL, NULL, NULL, '3', NULL, NULL, NULL, '2020六月29');

-- ----------------------------
-- Table structure for job_inf
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf`  (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
INSERT INTO `job_inf` VALUES (1, '1', '1');
INSERT INTO `job_inf` VALUES (9, '2', '2');
INSERT INTO `job_inf` VALUES (10, '3', '3');
INSERT INTO `job_inf` VALUES (11, '4', '4');
INSERT INTO `job_inf` VALUES (12, '5', '5');
INSERT INTO `job_inf` VALUES (13, '6', '6');
INSERT INTO `job_inf` VALUES (14, '13', '15');

-- ----------------------------
-- Table structure for notice_inf
-- ----------------------------
DROP TABLE IF EXISTS `notice_inf`;
CREATE TABLE `notice_inf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_date` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice_inf
-- ----------------------------
INSERT INTO `notice_inf` VALUES (1, '今天齐事', '今天终于把bug解决了,哇哈哈哈哈', NULL, NULL);
INSERT INTO `notice_inf` VALUES (2, '放假啦', '六一快乐哈', '2017-06-01 23:00:48', '3');
INSERT INTO `notice_inf` VALUES (14, 'f', 'f', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (15, 'g', 'g', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (16, 'bb', 'b', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (17, 'hh', 'hh', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (18, 'nn', 'nn', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (19, 'kk', 'kk', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (20, 'iii', 'ii', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (21, 'kkk', 'kkkk', '2020六月28', NULL);
INSERT INTO `notice_inf` VALUES (22, 'o', 'o', '2020六月28', NULL);

-- ----------------------------
-- Table structure for quit_inf
-- ----------------------------
DROP TABLE IF EXISTS `quit_inf`;
CREATE TABLE `quit_inf`  (
  `quit_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `job_id` int(11) NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq_num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`quit_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  CONSTRAINT `quit_inf_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job_inf` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `quit_inf_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept_inf` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `quit_inf_ibfk_3` FOREIGN KEY (`type_id`) REFERENCES `type_inf` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of quit_inf
-- ----------------------------
INSERT INTO `quit_inf` VALUES (14, 8, 1, 4, '1', '1', '1', NULL, '1', NULL, '11', '1', '1', NULL, '2020六月28');
INSERT INTO `quit_inf` VALUES (15, 1, 1, 1, '2', '2', '2', NULL, '2', NULL, '2', '2', '2', NULL, '2020六月28');
INSERT INTO `quit_inf` VALUES (16, 1, 1, 1, '3', '3', '3', NULL, '3', NULL, '3', '3', '3', NULL, '2020六月28');
INSERT INTO `quit_inf` VALUES (17, 1, 1, 1, '4', '4', '4', NULL, '4', NULL, '4', '4', '4', NULL, '2020六月28');
INSERT INTO `quit_inf` VALUES (18, 1, 1, 1, '5', '5', '5', NULL, '5', NULL, '5', '5', '5', NULL, '2020六月28');
INSERT INTO `quit_inf` VALUES (19, 1, 1, 1, '6', '6', '6', NULL, '6', NULL, '6', '6', '6', NULL, '2020六月28');
INSERT INTO `quit_inf` VALUES (20, 1, 1, 1, '22', '22', '22', NULL, '22', NULL, '22', '22', '22', NULL, '2020六月29');

-- ----------------------------
-- Table structure for salary_inf
-- ----------------------------
DROP TABLE IF EXISTS `salary_inf`;
CREATE TABLE `salary_inf`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `job_id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE,
  CONSTRAINT `salary_inf_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept_inf` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salary_inf_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `job_inf` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary_inf
-- ----------------------------
INSERT INTO `salary_inf` VALUES (1, 1, 1, '3', '3', '2020-06', NULL, NULL);
INSERT INTO `salary_inf` VALUES (2, 1, 1, '2', '2', '2020-04', '7', '2');
INSERT INTO `salary_inf` VALUES (3, 1, 1, '3', '3', '2020-10', NULL, '3');
INSERT INTO `salary_inf` VALUES (4, 1, 1, '4', '4', '2020-02', NULL, '4');
INSERT INTO `salary_inf` VALUES (5, 1, 1, '5', '55', '2020-02', NULL, '5');
INSERT INTO `salary_inf` VALUES (6, 1, 1, '6', '6', '2020-07', '6', '6');
INSERT INTO `salary_inf` VALUES (7, 1, 1, 'g', 'g', '2020-02', 'g', 'g');
INSERT INTO `salary_inf` VALUES (8, 1, 1, 'n', 'n', '2020-03', 'n', 'n');
INSERT INTO `salary_inf` VALUES (9, 1, 1, 'm', 'm', '2020-02', 'm', 'm');
INSERT INTO `salary_inf` VALUES (10, 1, 1, 'j', 'j', '2020-07', 'j', 'j');

-- ----------------------------
-- Table structure for type_inf
-- ----------------------------
DROP TABLE IF EXISTS `type_inf`;
CREATE TABLE `type_inf`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type_inf
-- ----------------------------
INSERT INTO `type_inf` VALUES (1, '主动辞退', '0');
INSERT INTO `type_inf` VALUES (2, '辞退', '0');
INSERT INTO `type_inf` VALUES (3, '退休', '0');
INSERT INTO `type_inf` VALUES (4, '开除', '0');
INSERT INTO `type_inf` VALUES (5, '试用期未过', '0');

-- ----------------------------
-- Table structure for user_inf
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES (1, 'admin', '123456', 2, '超级管理员');
INSERT INTO `user_inf` VALUES (19, '2', '2', NULL, '2');
INSERT INTO `user_inf` VALUES (20, '3', '3', NULL, '3');
INSERT INTO `user_inf` VALUES (21, '4', '4', NULL, '4');
INSERT INTO `user_inf` VALUES (22, '5', '5', NULL, '5');
INSERT INTO `user_inf` VALUES (23, '6', '6', NULL, '6');

SET FOREIGN_KEY_CHECKS = 1;
