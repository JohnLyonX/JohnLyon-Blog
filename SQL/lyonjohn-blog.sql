/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : lyonjohn-blog

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 14/12/2023 15:19:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `pin` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of posts
-- ----------------------------
BEGIN;
INSERT INTO `posts` (`id`, `url`, `name`, `date`, `introduction`, `pin`) VALUES (1, 'http://154.12.19.8:8080/img/1.GIF', 'About Lyon John', 'December 8, 2023', 'This is an article about me. If you are interested in me, you can learn something about me here.', 1);
INSERT INTO `posts` (`id`, `url`, `name`, `date`, `introduction`, `pin`) VALUES (3, 'http://154.12.19.8:8080/img/2.GIF', 'Lyon John\'s Blog', 'December 9 2023', 'About my blog introduction,\nHere you will learn a few things about my blog', 0);
COMMIT;

-- ----------------------------
-- Table structure for posts_page
-- ----------------------------
DROP TABLE IF EXISTS `posts_page`;
CREATE TABLE `posts_page` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of posts_page
-- ----------------------------
BEGIN;
INSERT INTO `posts_page` (`id`, `url`, `name`, `title`, `date`, `content`) VALUES (1, 'http://154.12.19.8:8080/img/1.GIF', 'About Lyon John', 'Who is Lyon John', 'December 8, 2023', 'Hi my name is Lyon John, emmm... I\'m   full stack developer, I like programming and photography very much. My dream is to have a Vlog channel. My wish is to allow people to enjoy the fun of technology. In the end, work hard to make the world a better place');
INSERT INTO `posts_page` (`id`, `url`, `name`, `title`, `date`, `content`) VALUES (2, 'http://154.12.19.8:8080/img/2.GIF', 'Lyon John\'s Blog', 'My blog is online today!', 'December 9 2023', 'In fact, this is not my first blog site. My first blog site was last November. All I can say is it\'s terrible. No backend is used. I only used the Vue front-end framework to complete it, with only static pages, and the page design was also terrible, but luckily I have a new blog. This is my new blog. This blog site took less than a day to complete. It\'s not completely perfect, but it\'s pretty good compared to the year before. Great progress, hello, my new blog!');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
