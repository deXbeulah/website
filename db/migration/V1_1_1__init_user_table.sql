CREATE TABLE `user` (
  `id`                    int(11) NOT NULL AUTO_INCREMENT                     COMMENT '用户id,自增长',
  `name`                  char(40) DEFAULT NULL                               COMMENT '用户名',
  `password`              char(50) DEFAULT NULL                               COMMENT '密码',
 CONSTRAINT PRIMARY KEY (`id`)
) COMMENT '用户表';

INSERT INTO `user` VALUES (1,'chenkaihua','chenkaihua');
INSERT INTO `user` VALUES   (2,'test_user','test');
INSERT INTO `user` VALUES (3,'陈开华','mypassword');
INSERT INTO `user` VALUES (6,'myname','mypass');
INSERT INTO `user` VALUES (7,'chenhua','chss');


CREATE TABLE `website`.`blog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `blog_name` VARCHAR(100) NULL,
  `author_name` VARCHAR(45) NULL,
  `blog_file` VARCHAR(100) NULL,
  `create_time` DATE NULL,
  `disable` TINYINT NULL,
  PRIMARY KEY (`id`))
COMMENT = '博客表';

CREATE TABLE `website`.`classify` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `classify_name` VARCHAR(45) NULL,
  `group_id` INT NULL,
  PRIMARY KEY (`id`))
COMMENT = '分类表';
CREATE TABLE `website`.`blog_classify` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `blog_id` INT NULL,
  `classify_id` INT NULL,
  PRIMARY KEY (`id`))
COMMENT = '博客分类对应表';

