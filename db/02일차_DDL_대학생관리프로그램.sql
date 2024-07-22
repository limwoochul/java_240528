# DB 삭제(university)
DROP DATABASE IF EXISTS university;
# DB 생성(university)
CREATE DATABASE IF NOT EXISTS university;

USE university;

# student 테이블 삭제
DROP TABLE IF EXISTS student;
# student 테이블 추가
# 학번, 이름(30자), 전공(15자), 학년
CREATE TABLE IF NOT EXISTS student (
	st_num CHAR(10) PRIMARY KEY,
	st_name VARCHAR(30) NOT NULL,
	st_major VARCHAR(15) NOT NULL,
	st_grade INT NOT NULL DEFAULT 1
);

# professor 테이블 삭제
DROP TABLE IF EXISTS professor;
# professor 테이블 추가
# 교번, 이름(30자), 전공(15자), 교수실(100)
CREATE TABLE IF NOT EXISTS professor (
	pr_num CHAR(10) PRIMARY KEY,
	pr_name VARCHAR(30) NOT NULL,
	pr_major VARCHAR(15) NOT NULL,
	pr_room VARCHAR(100)
);

# lecture 테이블 삭제
DROP TABLE IF EXISTS lecture;
# lecture 테이블 추가
# 강의번호(PK), 강의명(30자), 강의실(100자), 강의시간(시간표, 최대 50자),
# 학점, 시수, 전공여부(전공선택, 전공필수, 교양선택, 교양필수), 교수번호(FK)
CREATE TABLE IF NOT EXISTS lecture(
	le_num INT PRIMARY KEY AUTO_INCREMENT,
	le_title VARCHAR(30) NOT NULL,
	le_major CHAR(5) NOT NULL,
	le_room VARCHAR(100),
	le_schedule VARCHAR(50),
	le_point INT,
	le_time INT,
	le_pr_num CHAR(10),
	FOREIGN KEY(le_pr_num) REFERENCES professor(pr_num)
);
# course(수강) 테이블 삭제
DROP TABLE IF EXISTS course;
# course 테이블 추가
# 수강번호(PK), 중간, 기말, 과제, 학점, 출석, 학번(FK), 강의 번호(FK)
CREATE TABLE IF NOT EXISTS course(
	co_num INT PRIMARY KEY AUTO_INCREMENT,
	co_mid INT DEFAULT 0,
	co_final INT DEFAULT 0,
	co_homework INT DEFAULT 0,
	co_total VARCHAR(2) DEFAULT 'F',
	co_attendance INT DEFAULT 0,
	co_st_num CHAR(10),
	co_le_num INT,
	FOREIGN KEY(co_st_num) REFERENCES student(st_num),
	FOREIGN KEY(co_le_num) REFERENCES lecture(le_num)
);
# contact(연락처) 테이블 삭제
DROP TABLE IF EXISTS contact;
# contact 테이블 추가
# 연락처 번호(PK), 주소(100자), 상세주소(100자), 전화번호(최대 13자), 학번
CREATE TABLE IF NOT EXISTS contact(
	ct_num INT PRIMARY KEY AUTO_INCREMENT,
	ct_addr VARCHAR(100) NOT NULL,
	ct_detail VARCHAR(100),
	ct_phone VARCHAR(13) NOT NULL,
    ct_st_num CHAR(10),
    FOREIGN KEY(ct_st_num) REFERENCES student(st_num)
);

