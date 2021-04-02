/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : text

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 02/04/2021 18:32:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for weather_facility
-- ----------------------------
DROP TABLE IF EXISTS `weather_facility`;
CREATE TABLE `weather_facility`  (
  `facility_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备主键',
  `facility_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备位置',
  `facility_uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备唯一表示',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`facility_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather_facility
-- ----------------------------
INSERT INTO `weather_facility` VALUES ('1375708034910715906', '郑州大学', '1562378945237714', '2021-03-27 15:15:30', '2021-03-27 15:15:30');
INSERT INTO `weather_facility` VALUES ('1375708206965260289', '河南大学', '1562378945237713', '2021-03-27 15:16:11', '2021-03-27 15:16:11');
INSERT INTO `weather_facility` VALUES ('1376352470329982978', '河南工业大学', '1562378945237712', '2021-03-29 09:56:15', '2021-03-29 09:56:15');

-- ----------------------------
-- Table structure for weather_feedback
-- ----------------------------
DROP TABLE IF EXISTS `weather_feedback`;
CREATE TABLE `weather_feedback`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `feedback` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户反馈',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather_feedback
-- ----------------------------
INSERT INTO `weather_feedback` VALUES ('1375698494358081537', '1371743970845048834', '这是一条反馈', '2021-03-27 14:37:35', '2021-03-27 14:37:35');
INSERT INTO `weather_feedback` VALUES ('1377918435270410242', '1371743970845048834', '上的高富帅的郭德纲\n\n点点滴滴得到', '2021-04-02 17:38:50', '2021-04-02 17:38:50');

-- ----------------------------
-- Table structure for weather_site
-- ----------------------------
DROP TABLE IF EXISTS `weather_site`;
CREATE TABLE `weather_site`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '天气预报管理地址',
  `lat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lng` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除 1删 0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather_site
-- ----------------------------
INSERT INTO `weather_site` VALUES ('1372081414387826689', '1371743970845048834', '二七广场', '34.75186', '113.666451', '2021-03-17 15:04:36', '2021-03-17 15:04:36', 0);
INSERT INTO `weather_site` VALUES ('1372094781877940226', '1371743970845048834', '中原福塔', '34.723295', '113.728679', '2021-03-17 15:57:43', '2021-03-17 15:57:43', 0);
INSERT INTO `weather_site` VALUES ('1377256997690314754', '1371743970845048834', '郑州市人民政府', '34.746303', '113.625351', '2021-03-31 21:50:31', '2021-03-31 21:50:31', 0);

-- ----------------------------
-- Table structure for weather_user
-- ----------------------------
DROP TABLE IF EXISTS `weather_user`;
CREATE TABLE `weather_user`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户别称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `account_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather_user
-- ----------------------------
INSERT INTO `weather_user` VALUES ('1', '小明', '123456789@163.com', '123456789', '123456789', '2019-01-01 12:27:40', '2019-01-01 12:27:40', 0);
INSERT INTO `weather_user` VALUES ('1368894208865296386', 'key1', 'toy111111@163.com', '1111111111', 'toy111111', '2021-03-08 19:59:47', '2021-03-08 19:59:47', 0);
INSERT INTO `weather_user` VALUES ('1371743970845048834', '卡卡', '18437312484@163.com', '18437312484', 'yue0123.0', '2021-03-16 16:43:43', '2021-03-16 16:43:43', 0);
INSERT INTO `weather_user` VALUES ('1376523826354982913', NULL, NULL, '13937301483', 'yue0123.0', '2021-03-29 21:17:09', '2021-03-29 21:17:09', 0);
INSERT INTO `weather_user` VALUES ('1376542379527413762', NULL, NULL, '15823658942', '123456', '2021-03-29 22:30:53', '2021-03-29 22:30:53', 0);
INSERT INTO `weather_user` VALUES ('2', '小红', '123456789@163.com', '123456789', '123456789', '2019-01-01 12:27:40', '2019-01-01 12:27:40', 0);
INSERT INTO `weather_user` VALUES ('3', 'toy', 'toy111111@163.com', '1111111111', 'toy111111', '2021-03-08 19:49:47', '2021-03-08 19:49:47', 0);
INSERT INTO `weather_user` VALUES ('4', 'toy1', 'toy111111@163.com', '1111111111', 'toy111111', '2021-03-08 19:53:02', '2021-03-08 19:53:02', 0);

-- ----------------------------
-- Table structure for weather_user_facility
-- ----------------------------
DROP TABLE IF EXISTS `weather_user_facility`;
CREATE TABLE `weather_user_facility`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `facility_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备id',
  `collect` int NOT NULL DEFAULT 0 COMMENT '是否收藏 1收  0否',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除 1删  0否',
  PRIMARY KEY (`id`, `facility_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather_user_facility
-- ----------------------------
INSERT INTO `weather_user_facility` VALUES ('0', '1376352470329982978', 0, 0);
INSERT INTO `weather_user_facility` VALUES ('1368894208865296386', '1376352470329982978', 1, 0);
INSERT INTO `weather_user_facility` VALUES ('1371743970845048834', '1375708034910715906', 1, 0);
INSERT INTO `weather_user_facility` VALUES ('1371743970845048834', '1375708206965260289', 1, 0);
INSERT INTO `weather_user_facility` VALUES ('1371743970845048834', '1376352470329982978', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
