/*
 Navicat Premium Data Transfer

 Source Server         : MySQL56
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : vacate

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 08/02/2020 21:48:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `teacher_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `week` int(1) NOT NULL,
  PRIMARY KEY (`id`, `course_id`) USING BTREE,
  INDEX `fk_course_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_course_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '1', 'HTML5', '4001', 1);
INSERT INTO `course` VALUES (2, '2', 'JavaEE', '4002', 2);
INSERT INTO `course` VALUES (3, '3', '高级Android', '4003', 4);
INSERT INTO `course` VALUES (4, '4', '英语', '4004', 3);
INSERT INTO `course` VALUES (5, '5', '计算机接口技术', '4005', 4);
INSERT INTO `course` VALUES (6, '6', '图形图像处理', '4006', 1);
INSERT INTO `course` VALUES (7, '7', '数据结构', '4007', 2);
INSERT INTO `course` VALUES (8, '8', '网络系统配置', '4008', 5);

-- ----------------------------
-- Table structure for edu
-- ----------------------------
DROP TABLE IF EXISTS `edu`;
CREATE TABLE `edu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `edu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`, `edu_id`) USING BTREE,
  INDEX `edu_id`(`edu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu
-- ----------------------------
INSERT INTO `edu` VALUES (1, '3001', '123456');

-- ----------------------------
-- Table structure for edu_vacate
-- ----------------------------
DROP TABLE IF EXISTS `edu_vacate`;
CREATE TABLE `edu_vacate`  (
  `edu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `vacate_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  INDEX `fk_part_edu_id`(`edu_id`) USING BTREE,
  INDEX `fk_part_edu_v`(`vacate_id`) USING BTREE,
  CONSTRAINT `fk_part_edu_id` FOREIGN KEY (`edu_id`) REFERENCES `edu` (`edu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_part_edu_v` FOREIGN KEY (`vacate_id`) REFERENCES `vacate` (`vacate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_vacate
-- ----------------------------
INSERT INTO `edu_vacate` VALUES ('3001', '6b758b5ec7aa434f99311adb17dff2a3', 1);
INSERT INTO `edu_vacate` VALUES ('3001', 'b987c0e9883242298a5c6b73b3e89e88', -1);
INSERT INTO `edu_vacate` VALUES ('3001', '0e83678d825442448c4f7fb5195a0d79', 1);
INSERT INTO `edu_vacate` VALUES ('3001', 'e927f0eea2cc432b8fdc31893d5d798a', -1);
INSERT INTO `edu_vacate` VALUES ('3001', '782d7c5c7039478f94704eeef2e9512d', -1);
INSERT INTO `edu_vacate` VALUES ('3001', '89cf783d7a0b46118d03461f5f5e3112', -1);
INSERT INTO `edu_vacate` VALUES ('3001', '0d0da371d40843afa9e6431cc49ffce7', 1);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `grade_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tutor_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`, `grade_id`) USING BTREE,
  INDEX `grade_id`(`grade_id`) USING BTREE,
  INDEX `fk_tutor_id`(`tutor_id`) USING BTREE,
  CONSTRAINT `fk_tutor_id` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '1', '2001');
INSERT INTO `grade` VALUES (2, '2', '2001');
INSERT INTO `grade` VALUES (3, '3', '2002');
INSERT INTO `grade` VALUES (4, '4', '2002');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grade_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`, `stu_id`) USING BTREE,
  INDEX `fk_grade_id`(`grade_id`) USING BTREE,
  INDEX `stu_id`(`stu_id`) USING BTREE,
  CONSTRAINT `fk_grade_id` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '1001', '张三', '1', '123456', '1,2,3,4,5,6,7,8');
INSERT INTO `student` VALUES (2, '1002', 'Jerry', '4', '123456', '1,2,4,5,7,8');

-- ----------------------------
-- Table structure for student_vacate
-- ----------------------------
DROP TABLE IF EXISTS `student_vacate`;
CREATE TABLE `student_vacate`  (
  `stu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `vacate_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  INDEX `fk_part_stu_id`(`stu_id`) USING BTREE,
  INDEX `fk_part_stu_v`(`vacate_id`) USING BTREE,
  CONSTRAINT `fk_part_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_part_stu_v` FOREIGN KEY (`vacate_id`) REFERENCES `vacate` (`vacate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_vacate
-- ----------------------------
INSERT INTO `student_vacate` VALUES ('1001', '6b758b5ec7aa434f99311adb17dff2a3', 1);
INSERT INTO `student_vacate` VALUES ('1001', 'bc6e03dd6fed4381bc99db3071ad419b', -1);
INSERT INTO `student_vacate` VALUES ('1001', 'b987c0e9883242298a5c6b73b3e89e88', -1);
INSERT INTO `student_vacate` VALUES ('1001', '0e83678d825442448c4f7fb5195a0d79', 1);
INSERT INTO `student_vacate` VALUES ('1001', 'e927f0eea2cc432b8fdc31893d5d798a', -1);
INSERT INTO `student_vacate` VALUES ('1001', '782d7c5c7039478f94704eeef2e9512d', -1);
INSERT INTO `student_vacate` VALUES ('1001', '278db8f49a5944aba7f145ed8bf09ed5', 0);
INSERT INTO `student_vacate` VALUES ('1001', 'a300b8e78ab746bda5dd63927b29c1d4', 0);
INSERT INTO `student_vacate` VALUES ('1001', '59ed5a02fe5046478075232d2320925d', 0);
INSERT INTO `student_vacate` VALUES ('1001', '89cf783d7a0b46118d03461f5f5e3112', -1);
INSERT INTO `student_vacate` VALUES ('1001', 'bfbc43bdf19143bb97499e74282f6050', 0);
INSERT INTO `student_vacate` VALUES ('1001', 'cc1e7d68f0af4c968a64f57d03894ca3', 0);
INSERT INTO `student_vacate` VALUES ('1001', 'eb479eb68bcb4449b838b1cd274addcb', 0);
INSERT INTO `student_vacate` VALUES ('1001', '1856eb47b68c42fc8271cc161b897a18', 0);
INSERT INTO `student_vacate` VALUES ('1001', 'bd7e9a048a314c4a894693d19ea040dd', 0);
INSERT INTO `student_vacate` VALUES ('1001', '455e575388d241f1809d9a2ed154cd42', 0);
INSERT INTO `student_vacate` VALUES ('1001', '38e4f26c69b04b9ab10927ffde2f1369', 0);
INSERT INTO `student_vacate` VALUES ('1001', '0d0da371d40843afa9e6431cc49ffce7', 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`, `teacher_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '4001', '唐红军', '123456');
INSERT INTO `teacher` VALUES (2, '4002', '周梦熊', '123456');
INSERT INTO `teacher` VALUES (3, '4003', '吴昊', '123456');
INSERT INTO `teacher` VALUES (4, '4004', '黄金金', '123456');
INSERT INTO `teacher` VALUES (5, '4005', '孙志海', '123456');
INSERT INTO `teacher` VALUES (6, '4006', '陈立生', '123456');
INSERT INTO `teacher` VALUES (7, '4007', '楼永坚', '123456');
INSERT INTO `teacher` VALUES (8, '4008', '胡昔祥', '123456');

-- ----------------------------
-- Table structure for teacher_vacate
-- ----------------------------
DROP TABLE IF EXISTS `teacher_vacate`;
CREATE TABLE `teacher_vacate`  (
  `teacher_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `vacate_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  INDEX `fk_part_teacher_v`(`vacate_id`) USING BTREE,
  INDEX `fk_part_teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_part_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_part_teacher_v` FOREIGN KEY (`vacate_id`) REFERENCES `vacate` (`vacate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher_vacate
-- ----------------------------
INSERT INTO `teacher_vacate` VALUES ('4003', '6b758b5ec7aa434f99311adb17dff2a3', 0);
INSERT INTO `teacher_vacate` VALUES ('4005', '6b758b5ec7aa434f99311adb17dff2a3', 0);
INSERT INTO `teacher_vacate` VALUES ('4008', '6b758b5ec7aa434f99311adb17dff2a3', 0);
INSERT INTO `teacher_vacate` VALUES ('4003', '0e83678d825442448c4f7fb5195a0d79', 0);
INSERT INTO `teacher_vacate` VALUES ('4005', '0e83678d825442448c4f7fb5195a0d79', 0);
INSERT INTO `teacher_vacate` VALUES ('4008', '0e83678d825442448c4f7fb5195a0d79', 0);
INSERT INTO `teacher_vacate` VALUES ('4001', '0d0da371d40843afa9e6431cc49ffce7', 0);
INSERT INTO `teacher_vacate` VALUES ('4002', '0d0da371d40843afa9e6431cc49ffce7', 0);
INSERT INTO `teacher_vacate` VALUES ('4006', '0d0da371d40843afa9e6431cc49ffce7', 0);
INSERT INTO `teacher_vacate` VALUES ('4007', '0d0da371d40843afa9e6431cc49ffce7', 0);

-- ----------------------------
-- Table structure for tutor
-- ----------------------------
DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tutor_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `edu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`, `tutor_id`) USING BTREE,
  INDEX `tutor_id`(`tutor_id`) USING BTREE,
  INDEX `fk_edu_id`(`edu_id`) USING BTREE,
  CONSTRAINT `fk_edu_id` FOREIGN KEY (`edu_id`) REFERENCES `edu` (`edu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor` VALUES (1, '2001', '顾叶恒', '123456', '3001');
INSERT INTO `tutor` VALUES (2, '2002', '赵雅静', '123456', '3001');
INSERT INTO `tutor` VALUES (11, '2003', '李四', '666666', '3001');
INSERT INTO `tutor` VALUES (12, '2004', '王五', '666666', '3001');

-- ----------------------------
-- Table structure for tutor_vacate
-- ----------------------------
DROP TABLE IF EXISTS `tutor_vacate`;
CREATE TABLE `tutor_vacate`  (
  `tutor_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `vacate_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  INDEX `fk_part_tutor_id`(`tutor_id`) USING BTREE,
  INDEX `fk_part_tutor_v`(`vacate_id`) USING BTREE,
  CONSTRAINT `fk_part_tutor_id` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_part_tutor_v` FOREIGN KEY (`vacate_id`) REFERENCES `vacate` (`vacate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tutor_vacate
-- ----------------------------
INSERT INTO `tutor_vacate` VALUES ('2001', '6b758b5ec7aa434f99311adb17dff2a3', 1);
INSERT INTO `tutor_vacate` VALUES ('2001', 'bc6e03dd6fed4381bc99db3071ad419b', -1);
INSERT INTO `tutor_vacate` VALUES ('2001', 'b987c0e9883242298a5c6b73b3e89e88', 1);
INSERT INTO `tutor_vacate` VALUES ('2001', '0e83678d825442448c4f7fb5195a0d79', 1);
INSERT INTO `tutor_vacate` VALUES ('2001', 'e927f0eea2cc432b8fdc31893d5d798a', 1);
INSERT INTO `tutor_vacate` VALUES ('2001', '782d7c5c7039478f94704eeef2e9512d', 1);
INSERT INTO `tutor_vacate` VALUES ('2001', '278db8f49a5944aba7f145ed8bf09ed5', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', 'a300b8e78ab746bda5dd63927b29c1d4', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', '59ed5a02fe5046478075232d2320925d', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', '89cf783d7a0b46118d03461f5f5e3112', 1);
INSERT INTO `tutor_vacate` VALUES ('2001', 'bfbc43bdf19143bb97499e74282f6050', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', 'cc1e7d68f0af4c968a64f57d03894ca3', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', 'eb479eb68bcb4449b838b1cd274addcb', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', '1856eb47b68c42fc8271cc161b897a18', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', 'bd7e9a048a314c4a894693d19ea040dd', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', '455e575388d241f1809d9a2ed154cd42', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', '38e4f26c69b04b9ab10927ffde2f1369', 0);
INSERT INTO `tutor_vacate` VALUES ('2001', '0d0da371d40843afa9e6431cc49ffce7', 1);

-- ----------------------------
-- Table structure for vacate
-- ----------------------------
DROP TABLE IF EXISTS `vacate`;
CREATE TABLE `vacate`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vacate_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stu_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `term` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `submit_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `start_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `end_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `period` int(3) NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `step` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `vacate_id`) USING BTREE,
  INDEX `fk_stu_id`(`stu_id`) USING BTREE,
  INDEX `vacate_id`(`vacate_id`) USING BTREE,
  CONSTRAINT `fk_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vacate
-- ----------------------------
INSERT INTO `vacate` VALUES (9, '6b758b5ec7aa434f99311adb17dff2a3', '1001', '张三', '2019-2020-1', '1576119048000', '1576080000000', '1576252800000', 2, '病假', '', '高级Android,计算机接口技术,网络系统配置', 3);
INSERT INTO `vacate` VALUES (10, 'bc6e03dd6fed4381bc99db3071ad419b', '1001', '张三', '2019-2020-1', '1576127906000', '1576080000000', '1576166400000', 1, '事假', '', '高级Android,计算机接口技术,网络系统配置', 1);
INSERT INTO `vacate` VALUES (11, 'b987c0e9883242298a5c6b73b3e89e88', '1001', '张三', '2019-2020-1', '1576127916000', '1576166400000', '1576166400000', 0, '病假', '', '网络系统配置', 2);
INSERT INTO `vacate` VALUES (12, '0e83678d825442448c4f7fb5195a0d79', '1001', '张三', '2019-2020-1', '1576127933000', '1576080000000', '1576252800000', 2, '学院学生辅助工作', '', '高级Android,计算机接口技术,网络系统配置', 3);
INSERT INTO `vacate` VALUES (13, 'e927f0eea2cc432b8fdc31893d5d798a', '1001', '张三', '2019-2020-1', '1576127957000', '1576166400000', '1576166400000', 0, '其他', '', '网络系统配置', 2);
INSERT INTO `vacate` VALUES (14, '782d7c5c7039478f94704eeef2e9512d', '1001', '张三', '2019-2020-1', '1576127970000', '1576080000000', '1576166400000', 1, '病假', '', '高级Android,计算机接口技术,网络系统配置', 2);
INSERT INTO `vacate` VALUES (15, '278db8f49a5944aba7f145ed8bf09ed5', '1001', '张三', '2019-2020-1', '1576128040000', '1576080000000', '1576166400000', 1, '学院学生辅助工作', '', '高级Android,计算机接口技术,网络系统配置', 1);
INSERT INTO `vacate` VALUES (17, 'a300b8e78ab746bda5dd63927b29c1d4', '1001', '张三', '2019-2020-1', '1576302446000', '1575907200000', '1576080000000', 2, '事假', '', 'JavaEE,高级Android,英语,计算机接口技术,数据结构', 1);
INSERT INTO `vacate` VALUES (18, '59ed5a02fe5046478075232d2320925d', '1001', '张三', '2019-2020-1', '1576302677000', '1575907200000', '1576080000000', 2, '病假', '', 'JavaEE,高级Android,英语,计算机接口技术,数据结构', 1);
INSERT INTO `vacate` VALUES (19, '89cf783d7a0b46118d03461f5f5e3112', '1001', '张三', '2019-2020-1', '1576304395000', '1575993600000', '1576166400000', 2, '事假', '', '高级Android,英语,计算机接口技术,网络系统配置', 2);
INSERT INTO `vacate` VALUES (20, 'bfbc43bdf19143bb97499e74282f6050', '1001', '张三', '2019-2020-1', '1576304818000', '1575993600000', '1576166400000', 2, '事假', '', '高级Android,英语,计算机接口技术,网络系统配置', 1);
INSERT INTO `vacate` VALUES (21, 'cc1e7d68f0af4c968a64f57d03894ca3', '1001', '张三', '2019-2020-1', '1576304825000', '1575993600000', '1576166400000', 2, '事假', '', '高级Android,英语,计算机接口技术,网络系统配置', 1);
INSERT INTO `vacate` VALUES (22, 'eb479eb68bcb4449b838b1cd274addcb', '1001', '张三', '2019-2020-1', '1576304826000', '1575993600000', '1576166400000', 2, '事假', '', '高级Android,英语,计算机接口技术,网络系统配置', 1);
INSERT INTO `vacate` VALUES (23, '1856eb47b68c42fc8271cc161b897a18', '1001', '张三', '2019-2020-1', '1576304827000', '1575993600000', '1576166400000', 2, '事假', '', '高级Android,英语,计算机接口技术,网络系统配置', 1);
INSERT INTO `vacate` VALUES (24, 'bd7e9a048a314c4a894693d19ea040dd', '1001', '张三', '2019-2020-1', '1576305540000', '1575907200000', '1576080000000', 2, '其他', '123', 'JavaEE,高级Android,英语,计算机接口技术,数据结构', 1);
INSERT INTO `vacate` VALUES (25, '455e575388d241f1809d9a2ed154cd42', '1001', '张三', '2019-2020-1', '1576305584000', '1575907200000', '1576166400000', 3, '事假', '', 'JavaEE,高级Android,英语,计算机接口技术,数据结构,网络系统配置', 1);
INSERT INTO `vacate` VALUES (26, '38e4f26c69b04b9ab10927ffde2f1369', '1001', '张三', '2019-2020-1', '1576484242000', '1576425600000', '1576598400000', 2, '病假', '', 'HTML5,JavaEE,英语,图形图像处理,数据结构', 1);
INSERT INTO `vacate` VALUES (27, '0d0da371d40843afa9e6431cc49ffce7', '1001', '张三', '2019-2020-1', '1576491168000', '1576425600000', '1576512000000', 1, '病假', '', 'HTML5,JavaEE,图形图像处理,数据结构', 3);

SET FOREIGN_KEY_CHECKS = 1;
