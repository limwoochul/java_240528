use university;
# 컴퓨터공학 고길동 학생이 수강 신청한 강의의 개수를 조회하는 쿼리
SELECT 
    ST_NAME, ST_MAJOR, COUNT(*)
FROM
    COURSE
        JOIN
    STUDENT ON ST_NUM = CO_ST_NUM
WHERE
    ST_NAME = '고길동' AND ST_MAJOR = '컴퓨터공학';
    
# 신입생을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NUM LIKE '2024%' AND ST_GRADE = 1;

# 각 전공별 학생수를 조회하는 쿼리
SELECT ST_MAJOR '전공', COUNT(ST_MAJOR) '학생수' FROM STUDENT GROUP BY ST_MAJOR;

#컴퓨터공학 고길동 학생이 수강 신청한 학점을 조회하는 커리
SELECT 
    ST_NAME '이름', ST_MAJOR '전공', SUM(LE_POINT) '학점'
FROM
    COURSE
        JOIN
    STUDENT ON ST_NUM = CO_ST_NUM
        JOIN
    LECTURE ON LE_NUM = CO_LE_NUM
WHERE
    ST_NAME = '고길동' AND ST_MAJOR = '컴퓨터공학';
    
# 강의별 수강 신청한 학생수를 조회하는 쿼리
SELECT 
    LE_TITLE ' 강의명', COUNT(CO_ST_NUM) '학생수'
FROM
    LECTURE
        JOIN
    COURSE ON CO_LE_NUM = LE_NUM
GROUP BY
	LE_TITLE;

# 학생이 있는 학과 이름을 조회하는 쿼리
SELECT DISTINCT ST_MAJOR FROM STUDENT;
SELECT ST_MAJOR FROM STUDENT GROUP BY ST_MAJOR;

# 홍길동 학생이 수강하는 강의 목록을 조회하는 쿼리
SELECT DISTINCT
    ST_NAME '학생이름', LE_TITLE '과목명'
FROM
    COURSE
        JOIN
    STUDENT ON ST_NUM = CO_ST_NUM
		JOIN
	LECTURE ON LE_NUM = CO_LE_NUM
WHERE
	ST_NAME = '홍길동';
    
# 김교수가 강의하는 강의명을 조회하는 쿼리
SELECT DISTINCT
    PR_NAME '교수이름', LE_TITLE '강의명'
FROM
    LECTURE
        JOIN
    PROFESSOR ON PR_NUM = LE_PR_NUM
WHERE
    PR_NAME = '김교수';