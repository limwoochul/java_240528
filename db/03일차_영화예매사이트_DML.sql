# 사용자가 아이디 abc123, 비번 abc123으로 회원 가입을 진행했을 때 사용하는 쿼리
# 권한은 관리자인 경우 'ADMIN', 사용자인 경우 'USER'
insert into member(me_id, me_pw, me_authority) value('abc123', 'abc123', 'user');

# 관리자가 아이디 admin1, 비번 admin1로 회원 가입을 진행했을 때 사용하는 쿼리
insert into member values('admin1', 'admin1', 'admin');

# 영화 정보를 추가하는 작업을 해보세요.(데드풀과 울버린)
# 1. 영화 정보를 추가 : 제목, 내용, 시간, 연령대, 개봉일
insert into movie values(null, '데드풀과 울버린', 
"히어로 생활에서 은퇴한 후, 평범한 중고차 딜러로 살아가던 ‘데드풀’이 예상치 못한 거대한 위기를 맞아 모든 면에서 상극인 ‘울버린’을 찾아가게 되며 펼쳐지는 도파민 폭발 액션 블록버스터", 
127, '청소년관람불가', '2024-07-24');
# 2. 국가를 등록. 한국, 미국, 영국, 일본, 중국
insert into country values ('한국'), ('미국'), ('영국'), ('일본'), ('중국');
# 3. 영화 참여 국가를 추가 : 데드풀과 울버린 영화의 참여 국가
insert into movie_country values (null, '미국', 1);
# 4. 장르를 추가. 액션, 코미디, 멜로, 공포, 스릴러
insert into genre values ('액션'), ('코미디'), ('멜로'), ('공포'), ('스릴러');
# 5. 영화 장르를 추가 : 데드풀과 울버린의 장르
insert into movie_genre values (null, '액션', 1), (null, '코미디', 1);
# 6. 영화인을 등록 : 데드풀과 울버린에 나오는 모든 영화인
insert into person values 
	(null, '숀 레비', '1968-07-23', '', '캐나다'),
    (null, '라이언 레이놀즈', '1976-10-23', "<엑스맨 탄생: 울버린> 등의 액션 블록버스터와 호러, 로맨틱 무비 등 다양한 장르의 작품들을 아우르며 실력과 인기를 동시에 쌓아가고 있는 라이언 레이놀즈. 배우 스칼렛 요한슨과의 결혼을 통해 전세계적으로 이목을 집중시킨 주인공이기도 하다. 2004년 영화 <블레이드 트리니티>의 3인조 중 하나로 국내에도 ‘액션 몸짱 배우’로 알려지기 시작한 라이언 레이놀즈는 <저스트 프렌드>, <프로포즈>와 같은 로맨틱 코미디 작품들을 통해 세간의 주목을 받으며 ‘로맨틱 가이’로 떠올랐다. 그는 2011년 스칼렛요한슨과 이혼한 후 <가쉽걸>의 주인공 '블레이크 라이블리'와 2012년에 결혼을 하였다. 이후 <알.아이.피.디>에서 주연과 제작을 맡으며 2014년에는 <데드풀>, <퀸 오브 더 나이트>, <더 보이스> 등 많은 영화들에서 주연을 맡아 개봉을 앞두고 있다.", '캐나다'),
    (null, '휴 잭맨', '1968-10-12', '호주 출신 배우인 휴 잭맨은 TV연속극 [이웃들]에 출연하면서 연기자로 데뷔식을 치렀다. 원래 그는 연예계와 상관없는 라디오 저널리즘을 공부했다. 하지만 연극 무대에서 주역을 맡으면서 그의 인생목표도 수정하게 된다. 바로 연기자가 그의 목표가 된 것이다. 그 후 아카데미 스쿨에서 연기공부를 시작했으며 졸업하고 춝연한 [콜렐리]란 드라마에서 노래실력까지 발휘하게 된다.
또한 SF 액션물[엑스 맨]의 강한 카리스마 ‘울버린’으로 일약 스타덤에 올랐다. [반헬싱][엑스맨2][스워드 피쉬][썸원 라이크 유]등 대다수 작품의 출연했으며, 2008 피플지에서 ‘올해 가장 섹시한 남자’에 1위로 선정되기도 했다. 2011 [리얼스틸]로 돌아온 휴 잭맨은 다시금 전세계 관객들을 자로잡을 예정이다.', '오스트레일리아'),
	(null, '엠마 코린', '1995-12-13', '', ''),
    (null, '모레나 바카린', '1979-06-02', '', '브라질'),
    (null, '롭 딜레이니', '1977-01-19', '', '미국'),
    (null, '레슬리 우감스', '1943-05-25', '', ''),
    (null, '카란 소니', '1985-01-08', '', '인도'),
    (null, '매튜 맥퍼딘', '1974-10-17', '', '영국');
# 7. 캐릭터를 등록 : 데드풀과 울버린에 나오는 영화인의 역할을 등록. 사진은 NULL로
insert into `character` values 
	(null, '감독', null, 1),
    (null, '배우', null, 2),
    (null, '배우', null, 3),
	(null, '배우', null, 4),
    (null, '배우', null, 5),
    (null, '배우', null, 6),
    (null, '배우', null, 7),
    (null, '배우', null, 8),
    (null, '배우', null, 9);
# 8. 캐스팅을 등록 : 데드풀과 울버린에 나오는 캐릭터들의 캐스팅 이름을 등록. 감독은 감독으로
insert into casting values
	(null, '감독', 1, 1),
    (null, '데드풀', 2, 1),
    (null, '울버린', 3, 1),
	(null, '카산드라 노바', 4, 1),
    (null, '바네사 칼라일', 5, 1),
    (null, '피터', 6, 1),
    (null, '블라인드 앨', 7, 1),
    (null, '도핀더', 8, 1),
    (null, '패러독스', 9, 1);
    
# CGV 강남을 등록. 상영관 : 3, 좌석 : 30
# 1관 : A1~A3, B1~B3, C1~C4
# 2관 : A1~A4, B1~B4, C1~C2
# 3관 : A1~A2, B1~B2, C1~C2, D1~D2, E1~E2
insert into theater values
	(null, 'CGV강남', 3, 30, '서울특별시 강남구 강남대로 438', '서울');
insert into screen values
	(null, '1관', 10, 1), (null, '2관', 10, 1), (null, '3관', 10, 1);
insert into seat values
	(null, 'A1', 1), (null, 'A2', 1), (null, 'A3', 1),
	(null, 'B1', 1), (null, 'B2', 1), (null, 'B3', 1),
	(null, 'C1', 1), (null, 'C2', 1), (null, 'C3', 1), (null, 'C4', 1),
    (null, 'A1', 2), (null, 'A2', 2), (null, 'A3', 2), (null, 'A4', 2),
	(null, 'B1', 2), (null, 'B2', 2), (null, 'B3', 2), (null, 'B4', 2),
	(null, 'C1', 2), (null, 'C2', 2),
    (null, 'A1', 3), (null, 'A2', 3), (null, 'B1', 3), (null, 'B2', 3),
    (null, 'C1', 3), (null, 'C2', 3), (null, 'D1', 3), (null, 'D2', 3),
    (null, 'E1', 3), (null, 'E2', 3);

# CGV영등포를 등록. 상영관 : 4, 좌석 : 44
# 1관 : A1~A3, B1~B3, C1~C4
# 2관 : A1~A4, B1~B4, C1~C2
# 3관 : A1~A3, B1~B3, C1~C3, D1~D3
# 4관 : A1~A6, B1~B6
insert into theater values(null, '영등포CGV', 4, 44, '서울특별시 영등포구 영중로 15', '서울');
insert into screen values(null, '1관', 10, 2), (null, '2관', 10, 2), (null, '3관', 12, 2), (null, '4관', 12, 2);
insert into seat values(null, 'A1', 4), (null, 'A2', 4), (null, 'A3', 4),
	(null, 'B1', 4), (null, 'B2', 4), (null, 'B3', 4),
	(null, 'C1', 4), (null, 'C2', 4), (null, 'C3', 4), (null, 'C4', 4),
    (null, 'A1', 5), (null, 'A2', 5), (null, 'A3', 5), (null, 'A4', 5),
	(null, 'B1', 5), (null, 'B2', 5), (null, 'B3', 5), (null, 'B4', 5),
	(null, 'C1', 5), (null, 'C2', 5),
    (null, 'A1', 6), (null, 'A2', 6), (null, 'A3', 6),
    (null, 'B1', 6), (null, 'B2', 6), (null, 'B3', 6),
    (null, 'C1', 6), (null, 'C2', 6), (null, 'C3', 6),
    (null, 'D1', 6), (null, 'D2', 6), (null, 'D3', 6),
    (null, 'A1', 7), (null, 'A2', 7), (null, 'A3', 7), (null, 'A4', 7), (null, 'A5', 7), (null, 'A6', 7),
    (null, 'B1', 7), (null, 'B2', 7), (null, 'B3', 7), (null, 'B4', 7), (null, 'B5', 7), (null, 'B6', 7);
    
# 데드풀과 울버린 영화 상영시간을 등록
# CGV강남 - 7/27
# 1관 - 10:00(조조), 12:35, 15:10, 17:45, 20:20
# 2관 - 10:30(조조), 15:00, 20:00, 23:00
# 3관 - 09:00(조조), 11:35, 14:10, 16:45, 19:20
insert into schedule values
	(null, '10:00', '2024-07-27', 1, 1, 1),
	(null, '12:35', '2024-07-27', 0, 1, 1),
    (null, '15:10', '2024-07-27', 0, 1, 1),
    (null, '17:45', '2024-07-27', 0, 1, 1),
    (null, '20:20', '2024-07-27', 0, 1, 1),
	(null, '10:30', '2024-07-27', 1, 1, 2),
	(null, '15:00', '2024-07-27', 0, 1, 2),
    (null, '20:00', '2024-07-27', 0, 1, 2),
    (null, '23:00', '2024-07-27', 0, 1, 2),
	(null, '09:00', '2024-07-27', 1, 1, 3),
	(null, '11:35', '2024-07-27', 0, 1, 3),
    (null, '14:10', '2024-07-27', 0, 1, 3),
    (null, '16:45', '2024-07-27', 0, 1, 3),
    (null, '19:20', '2024-07-27', 0, 1, 3);

# CGV영등포 - 7/27
# 1관 - 08:00(조조), 10:40, 16:00, 18:40
# 2관 - 09:40(조조), 15:00, 23:00
# 3관 - 08:40(조조), 17:00
# 4관 - 16:00
insert into schedule values
	(null, '08:00', '2024-07-27', 1, 1, 4),
    (null, '10:40', '2024-07-27', 0, 1, 4),
    (null, '16:00', '2024-07-27', 0, 1, 4),
    (null, '18:40', '2024-07-27', 0, 1, 4),
	(null, '09:40', '2024-07-27', 1, 1, 5),
    (null, '15:00', '2024-07-27', 0, 1, 5),
    (null, '23:00', '2024-07-27', 0, 1, 5),
	(null, '08:40', '2024-07-27', 1, 1, 6),
    (null, '17:00', '2024-07-27', 0, 1, 6),
	(null, '16:00', '2024-07-27', 0, 1, 7);

# 성인 : 14000원, 청소년 : 10000원, 조조 성인 : 12000원, 조조 청소년 : 8000원
insert into price values 
	(null, '성인', 14000),
    (null, '청소년', 10000),
    (null, '조조 성인', 12000),
    (null, '조조 청소년', 8000);

# abc123회원이 CGV강남 1관 10:00에 상영하는 데드풀과 울버린 성인 2장을 예매하는 쿼리
# 좌석은 A1, A2
insert into ticketing values(null, 2, 0, 24000, 'abc123', 1);
insert into ticketing_list values(null, 1, 1), (null, 1, 2);