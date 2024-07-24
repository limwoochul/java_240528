# 데드풀과 울버린 영화의 CGV강남에서 7/27에 상영하는 상영시간표를 조회하는 쿼리
SELECT 
    sd_date 상영날짜, mo_title 영화제목, sd_time 상영시간, sc_name 상영관, th_name 영화관
FROM
    schedule
        JOIN
    screen ON sd_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
		JOIN
	movie on sd_mo_num = mo_num
WHERE
	sd_date = '2024-07-27' and th_name = 'CGV강남' and mo_title = '데드풀과 울버린';

# 서브 쿼리를 이용
SELECT 
    *
FROM
    SCHEDULE
        JOIN
    SCREEN ON SD_SC_NUM = SC_NUM
        JOIN
    (SELECT * FROM THEATER WHERE TH_NAME = 'CGV강남') TH
		ON SC_TH_NUM = TH_NUM
        JOIN
	(SELECT * FROM MOVIE WHERE MO_TITLE = '데드풀과 울버린') MO
		ON SD_MO_NUM = MO_NUM
WHERE
	SD_DATE = '2024-07-27';

# CGV강남 1관에 등록된 좌석을 조회하는 쿼리
SELECT 
    SE_NAME 좌석명
FROM
    SEAT
		JOIN
	SCREEN ON SE_SC_NUM = SC_NUM
        JOIN
    THEATER ON SC_TH_NUM = TH_NUM
WHERE 
	TH_NAME = 'CGV강남' and SC_NAME = '1관';
# abc회원이 예약한 예매 내역을 조회하는 쿼리(영화 제목, 극장이름, 상영관이름, 시간, 좌석번호)
SELECT 
    MO_TITLE 영화,SD_DATE 일시, TH_NAME 극장, SC_NAME 상영관, SD_TIME 시간, SE_NAME 좌석
FROM
    TICKETING
    JOIN TICKETING_LIST ON TL_TI_NUM = TI_NUM
    JOIN SEAT ON SE_NUM = TL_SE_NUM
    JOIN SCHEDULE ON SD_NUM = TI_SD_NUM
    JOIN SCREEN ON SD_SC_NUM = SC_NUM
    JOIN THEATER ON TH_NUM = SC_TH_NUM
    JOIN MOVIE ON MO_NUM = SD_MO_NUM
WHERE
    TI_ME_ID = 'abc123';
 

# 데드풀과 울버린 CGV강남점 1관 7/27 10:00에 예약된 좌석을 조회하는 쿼리
# 1번 스케줄에 예약된 좌석을 조회하는 쿼리
SELECT 
    SE_NAME '예약된 좌석번호'
FROM
    (SELECT * FROM TICKETING WHERE TI_SD_NUM = 1) TT
    JOIN
		TICKETING_LIST ON TL_TI_NUM = TI_NUM
	JOIN
		SEAT ON TL_SE_NUM = SE_NUM;

# CGV강남점 1관의 좌석을 조회하는 쿼리
# 1번 상영관에 좌석들을 조회하는 쿼리
SELECT * FROM SEAT WHERE SE_SC_NUM = 1;


# 데드풀과 울버린 CGV강남점 1관 7/27 10:00에 예약가능한 좌석을 조회하는 쿼리
# 1번 스케줄에 예약 가능한 1번 상영관 좌석을 조회하는 쿼리
# 1번 스케줄에 예약된 좌석 + 1번 상영관 좌석
SELECT 
    *
FROM
    SEAT
WHERE
    SE_SC_NUM = 1
        AND SE_NAME NOT IN (SELECT 
            SE_NAME
        FROM
            (SELECT 
                *
            FROM
                TICKETING
            WHERE
                TI_SD_NUM = 1) TT
                JOIN
            TICKETING_LIST ON TL_TI_NUM = TI_NUM
                JOIN
            SEAT ON TL_SE_NUM = SE_NUM);

# 1번 스케줄에서 예약 가능한 좌석들의 수를 조회
SELECT 
    COUNT(SE_NAME) `예약 가능학 좌석 수`
FROM
    SEAT
WHERE
    SE_SC_NUM = 1
        AND SE_NAME NOT IN (SELECT 
            SE_NAME
        FROM
            (SELECT 
                *
            FROM
                TICKETING
            WHERE
                TI_SD_NUM = 1) TT
                JOIN
            TICKETING_LIST ON TL_TI_NUM = TI_NUM
                JOIN
            SEAT ON TL_SE_NUM = SE_NUM);
            
# 장르별 등록된 영화 개수를 조회하는 쿼리
SELECT 
    GE_NAME, COUNT(MG_NUM)
FROM
    MOVIE_GENRE
RIGHT JOIN
		GENRE ON GE_NAME = MG_GE_NAME
GROUP BY GE_NAME;

# 개봉한 영화를 조회하는 쿼리
SELECT * FROM MOVIE WHERE MO_DATE <= NOW();

# 오늘부터 한달 사이에 개봉한 영화를 조회하는 쿼리
SELECT 
    *
FROM
    MOVIE
WHERE
    MO_DATE BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) AND NOW();
