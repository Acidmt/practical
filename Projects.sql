/*
SQLyog Ultimate v10.00 Beta1
MySQL - 8.0.25 : Database - blogs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `blogs`;

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `register_id` int NOT NULL AUTO_INCREMENT,
  `register_username` varchar(10) NOT NULL,
  `register_password` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `register` */

insert  into `register`(`register_id`,`register_username`,`register_password`,`email`) values (1,'syb','123','13234343@121.com'),(2,'adm','123','123@qq.com'),(3,'sys','666','666@666');

/*Table structure for table `register_blogmessage` */

DROP TABLE IF EXISTS `register_blogmessage`;

CREATE TABLE `register_blogmessage` (
  `blog_ids` int NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(50) NOT NULL,
  `blog_message` varchar(100) NOT NULL,
  `blog_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`blog_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `register_blogmessage` */

insert  into `register_blogmessage`(`blog_ids`,`blog_title`,`blog_message`,`blog_data`) values (14,'英语语法','一本英语语法大全','2022-10-07 18:17:57'),(16,'正则表达','正则表达正则表达正则表达正则表达','2022-10-07 18:24:56'),(17,'秘籍','秘籍秘籍','2022-10-07 18:40:33'),(18,'你好','你好你好你好你好你好你好你好你好你好你好你好你好你好','2022-10-07 18:44:19'),(20,'你好','1212121','2022-10-07 19:07:45'),(22,'javaweb','导数','2022-10-22 16:40:44'),(29,'正则表达','正则表达正则表达正则表达正则表达正则表达正则表达正则表达','2022-10-23 20:02:47');

/*Table structure for table `register_blogpath` */

DROP TABLE IF EXISTS `register_blogpath`;

CREATE TABLE `register_blogpath` (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `blogPath_id` int NOT NULL,
  `blogPath_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `blog_md5` varchar(100) NOT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `register_blogpath` */

insert  into `register_blogpath`(`blog_id`,`blogPath_id`,`blogPath_path`,`blog_md5`) values (14,1,'/syb/8b5f005d-7dba-4030-9ae1-102cf87fac3b.html','8e2fa9b0090b0e02c1462fd8f63a0d36'),(16,1,'/syb/66764944-5c45-46ee-a33b-8fbe55d62b5e.html','7f6af10585bd2e3ab122cc90d3d4a513'),(17,1,'/syb/7ac59f72-05fd-4764-bdf9-cadd8b446599.html','a42f7adf19ffb0db0fb327df3516d34b'),(18,1,'/syb/ef4e1e2d-fc43-4940-8b40-5017d8a8a8f4.html','5f981641b1cc1835e3691398c1b97225'),(20,1,'/syb/8b96a98d-2ba8-47c5-aee3-23d1f00c9e26.html','a35d760e5724584afd706497b9af06be'),(22,1,'/syb/bba5e4db-4287-463b-ac49-bfa7354608a4.html','c57c25844e1655da1ec1f7d8a030c92e'),(29,2,'/adm/ef234946-3651-4a29-965e-989496508423.html','7f6af10585bd2e3ab122cc90d3d4a513');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
