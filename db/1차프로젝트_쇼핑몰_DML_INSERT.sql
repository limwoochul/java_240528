INSERT INTO CATEGORY(CG_NAME) VALUES('과일'),('채소'),('고기'),('생선');

INSERT INTO PRODUCT(PR_NAME, PR_PRICE, PR_INVENTORY, PR_CG_NUM) VALUES
('사과', 2000, 100, 1), ('키위', 3000, 150, 1), ('파인애플', 10000, 80, 1),
('메론', 9000, 120, 1), ('토마토', 4000, 200, 1), ('바나나', 5000, 175, 1);

INSERT INTO PRODUCT(PR_NAME, PR_PRICE, PR_INVENTORY, PR_CG_NUM) VALUES
('콩나물', 1000, 300, 2), ('양파', 3000, 170, 2), ('당근', 4000, 110, 2),
('고추', 1000, 90, 2), ('시금치', 3500, 120, 2), ('숙주나물', 1500, 220, 2);

INSERT INTO PRODUCT(PR_NAME, PR_PRICE, PR_INVENTORY, PR_CG_NUM) VALUES
('삼겹살1근', 12000, 30, 3), ('목살1근', 10500, 50, 3), ('항정살1근', 15000, 20, 3),
('티본스테이크400g', 30000, 15, 3), ('한우등심100g', 10000, 100, 3);

INSERT INTO PRODUCT(PR_NAME, PR_PRICE, PR_INVENTORY, PR_CG_NUM) VALUES
('삼치', 10000, 50, 4), ('병어', 3000, 80, 4), ('임연수', 6500, 75, 4),
('꽁치', 1000, 120, 4), ('갈치', 9000, 60, 4);

INSERT INTO QUESTION(QU_CONTENT) VALUES ('가장 존경하는 사람은?'), ('가장 좋아하는 노래는?'), ('가장 좋아하는 음식은?');

INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_ADDRESS, ME_ANSWER, ME_QU_NUM)
VALUES('abc123', 'abc123', '홍길동', '010-1234-5678', '서울시 강남구', '김밥', 3);
INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_ADDRESS, ME_ANSWER, ME_QU_NUM)
VALUES('qwe123', 'qwe123', '둘리', '010-2222-3333', '경기도 의정부시', '아버지', 1);
INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_ADDRESS, ME_ANSWER, ME_QU_NUM)
VALUES('def123', 'def123', '고길동', '010-8888-7654', '강원도 춘천시', '라면', 3);
INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_ADDRESS, ME_AUTHORITY, ME_ANSWER, ME_QU_NUM)
VALUES('admin123', 'admin123', '관리자', '000-0000-0000', '서울시 용산구', 'ADMIN', '없음', 2);