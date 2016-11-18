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
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016-11-16 13:50:55                          */
/*==============================================================*/


drop table if exists blog;

drop table if exists plan;

drop table if exists task;

drop table if exists task_complete;

drop table if exists user;

/*==============================================================*/
/* Table: blog                                                  */
/*==============================================================*/
create table blog
(
   id                   int not null,
   title                varchar(50),
   create_type          timestamp,
   dir                  varchar(250),
   content              blob,
   author               varchar(50),
   read_number          int,
   primary key (id)
);

alter table blog comment '博客';

/*==============================================================*/
/* Table: plan                                                  */
/*==============================================================*/
create table plan
(
   id                   int not null,
   title                varchar(50),
   user_id              varchar(100),
   start_time           date,
   end_time             date,
   create_time          date,
   group_id             int,
   goal                 varchar(50),
   remind_type          varchar(50),
   primary key (id)
);

alter table plan comment '计划表';

/*==============================================================*/
/* Table: task                                                  */
/*==============================================================*/
create table task
(
   id                   int not null,
   task_name            varchar(50),
   frequency            varchar(50),
   primary key (id)
);

alter table task comment '任务';

/*==============================================================*/
/* Table: task_complete                                         */
/*==============================================================*/
create table task_complete
(
   id                   int not null,
   task_id              int,
   state                tinyint,
   expire_time          timestamp,
   primary key (id)
);

alter table task_complete comment '完成情况';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null,
   user_name            varchar(50),
   phone_number      varchar(50),
   email                varchar(50),
   password             varchar(50),
   user_type            numeric,
   create_time          date,
   update_time          date,
   primary key (id)
);

alter table user comment '用户';



