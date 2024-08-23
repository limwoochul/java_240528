DROP DATABASE IF EXISTS UNIVERSITY_MANAGEMENT;

CREATE DATABASE IF NOT EXISTS UNIVERSITY_MANAGEMENT;

USE UNIVERSITY_MANAGEMENT;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(10) primary key	NOT NULL,
	`me_pw`	varchar(255)			NOT NULL DEFAULT 1234,
	`me_authority`	varchar(10)		NOT NULL
);

DROP TABLE IF EXISTS `major`;

CREATE TABLE `major` (
	`ma_num`	int primary key auto_increment	NOT NULL,
	`ma_name`	varchar(30)						NOT NULL
);

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
	`st_num`	int primary key auto_increment	NOT NULL,
	`st_name`	varchar(30)						NOT NULL,
	`st_email`	varchar(50) unique				NOT NULL,
	`st_me_id`	varchar(10) primary key			NOT NULL,
	`st_ma_num`	int								NOT NULL
);

DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
	`pr_num`	int primary key auto_increment	NOT NULL,
	`pr_name`	varchar(30)						NOT NULL,
	`pr_email`	varchar(50) unique				NOT NULL,
	`pr_me_id`	varchar(10)						NOT NULL,
	`pr_ma_num`	int								NOT NULL
);

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
	`ad_num`	int primary key auto_increment	NOT NULL,
	`ad_name`	varchar(30)						NOT NULL,
	`ad_email`	varchar(50) unique				NOT NULL,
	`ad_me_id`	varchar(10)						NOT NULL
);

DROP TABLE IF EXISTS `lecture`;

CREATE TABLE `lecture` (
	`le_num`	int primary key auto_increment	NOT NULL,
	`le_name`	varchar(30)						NOT NULL,
	`le_room`	varchar(50)						NOT NULL,
	`le_time`	varchar(30)						NOT NULL,
	`le_point`	int								NOT NULL,
	`le_pr_num`	int								NOT NULL
);

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
	`co_num`	int primary key auto_increment	NOT NULL,
	`co_grade`	varchar(5)						NOT NULL,
	`co_st_num`	int								NOT NULL,
	`co_le_num`	int								NOT NULL
);

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
	`no_num`	int primary key auto_increment	NOT NULL,
	`no_title`	varchar(100)					NOT NULL,
	`no_content`	longtext					NOT NULL,
	`no_date`	datetime						NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`no_view`	int								NOT NULL DEFAULT 0,
	`no_ad_num`	int								NOT NULL
);

ALTER TABLE `student` ADD CONSTRAINT `FK_member_TO_student_1` FOREIGN KEY (
	`st_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `student` ADD CONSTRAINT `FK_major_TO_student_1` FOREIGN KEY (
	`st_ma_num`
)
REFERENCES `major` (
	`ma_num`
);

ALTER TABLE `professor` ADD CONSTRAINT `FK_member_TO_professor_1` FOREIGN KEY (
	`pr_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `professor` ADD CONSTRAINT `FK_major_TO_professor_1` FOREIGN KEY (
	`pr_ma_num`
)
REFERENCES `major` (
	`ma_num`
);

ALTER TABLE `admin` ADD CONSTRAINT `FK_member_TO_admin_1` FOREIGN KEY (
	`ad_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `lecture` ADD CONSTRAINT `FK_professor_TO_lecture_1` FOREIGN KEY (
	`le_pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_student_TO_course_1` FOREIGN KEY (
	`co_st_num`
)
REFERENCES `student` (
	`st_num`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_lecture_TO_course_1` FOREIGN KEY (
	`co_le_num`
)
REFERENCES `lecture` (
	`le_num`
);

ALTER TABLE `notice` ADD CONSTRAINT `FK_admin_TO_notice_1` FOREIGN KEY (
	`no_ad_num`
)
REFERENCES `admin` (
	`ad_num`
);
