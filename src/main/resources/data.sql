use cds_naverpay_db;

INSERT INTO `user` (name, total_saving)
VALUES ('남희주', 11500),
       ('원하연', 2000);

INSERT INTO brand (name, logo_img_url, discount_content, discount_type, place, distance)
VALUES ('CU', 'https://user-images.githubusercontent.com/80024278/285090785-d642f07f-21f1-4cac-935c-89cd3d05e38e.png', '네플멤 회원은 CU 최대', 'TEN_PERCENT', '건대점', 100),
       ('파리바게트', 'https://user-images.githubusercontent.com/80024278/285090803-98cefa59-19ff-4e85-951c-beaf951b5ede.png', '네이버페이 회원은 매일', 'DOUBLE_BENEFIT', '건대점', 200),
       ('신라호텔', 'https://user-images.githubusercontent.com/80024278/285090804-c1c9b9b2-7dc1-466d-a385-dc0bf18feef3.png', '30만원 이상 결제 시', 'DOUBLE_BENEFIT', '건대점', 300),
       ('신세계면세점', 'https://user-images.githubusercontent.com/80024278/285090806-6cee1cf8-afad-4480-8a57-8a893743198e.png', '30만원 이상 결제 시', 'MAX', '신논현점', 300),
       ('GS25', 'https://user-images.githubusercontent.com/80024278/285090810-419d8a5f-1bc7-4ef1-a222-f8e4dd77c08b.png', '30만원 이상 결제 시', 'MAX', '신논현점', 300),
       ('도미노피자', 'https://user-images.githubusercontent.com/80024278/285090788-69dd5cb7-90e2-4117-a1d2-c140e72c93b8.png', 'QR결제시 최대 2천원 할인', 'MAX', '건대점', 300),
       ('ZARA', 'https://user-images.githubusercontent.com/80024278/285090778-770450d4-93a4-44ba-a771-f89612c2fd80.png', '30만원 이상 결제 시', 'MAX', null, 150),
       ('SPAO', 'https://user-images.githubusercontent.com/80024278/285090775-fec9e889-18aa-42a1-8fd8-9c7911edc6c2.png', '30만원 이상 결제 시', 'TEN_THOUSAND_WON', null, 300),
       ('H&M', 'https://user-images.githubusercontent.com/80024278/285090780-301c3843-9979-456c-911f-966bef664a15.png', '30만원 이상 결제 시', 'DOUBLE_BENEFIT', null, 100),
       ('무신사', 'https://user-images.githubusercontent.com/80024278/285090771-18f17fc8-a168-4d31-8865-1844d4593bc1.png', '네이버페이 회원은 매일', 'MAX', null, 200),
       ('탑텐', 'https://user-images.githubusercontent.com/80024278/285090783-200dc60c-adc2-4642-83cd-4ea07034c037.png', '30만원 이상 결제 시', 'MAX', null, 260),
       ('서브웨이', 'https://user-images.githubusercontent.com/80024278/285090794-5c6952e0-1b73-468a-8419-8eefa5718d87.png', '30만원 이상 결제 시', 'TEN_PERCENT', null, 180),
       ('빽다방', 'https://user-images.githubusercontent.com/80024278/285090798-ada08b7b-6832-4a07-bdfc-6f8ad8dee790.png', '네이버페이 회원은 매일', 'TEN_PERCENT', null, 170),
       ('샐러디', 'https://user-images.githubusercontent.com/80024278/285090787-a69458ac-a660-4853-ae0c-81592f52dbb3.png', 'QR결제시 최대 2천원 할인', 'MAX', null, 10),
       ('KREAM', 'https://user-images.githubusercontent.com/80024278/285090781-fdfbf93a-251c-422d-8b9f-63b9ea1f9295.png', '네이버페이 회원은 매일', 'DOUBLE_BENEFIT', null, 150),
       ('뚜레쥬르', 'https://user-images.githubusercontent.com/80024278/285090790-514b483b-1034-4d81-886a-dac9121b7283.png', 'QR결제시 최대 2천원 할인', 'MAX', null, 180),
       ('투썸플레이스', 'https://user-images.githubusercontent.com/80024278/285090801-29cbc8f2-54da-4e61-bef6-5dd329ec5031.png', 'QR결제시 최대 2천원 할인', 'MAX', null, 270);


INSERT INTO brand_like (brand_id, user_id)
VALUES (1,1),
       (2,1);

INSERT INTO point (saving, point_type, user_id, brand_id, created_at, updated_at)
VALUES (1260, 'BASIC', 1, 1, now(), now()),
       (2920, 'MEMBERSHIP', 1, 2, now(), now()),
       (2300, 'REVIEW', 1, 4, now(), now()),
       (100, 'PAYMENT_METHOD', 1, 5, now(), now()),
       (240, 'MEMBERSHIP', 1, 2, now(), now()),
       (230, 'REVIEW', 1, 4, now(), now()),
       (500, 'PAYMENT_METHOD', 1, 5, now(), now()),
       (20, 'MEMBERSHIP', 1, 2, now(), now()),
       (110, 'REVIEW', 1, 4, now(), now()),
       (5020, 'PAYMENT_METHOD', 1, 5, now(), now()),
       (2920, 'MEMBERSHIP', 1, 2, now(), now()),
       (2300, 'REVIEW', 1, 4, now(), now()),
       (5020, 'PAYMENT_METHOD', 2, 8, now(), now()),
       (2300, 'REVIEW', 2, 4, now(), now()),
       (100, 'PAYMENT_METHOD', 2, 7, now(), now()),
       (240, 'MEMBERSHIP', 2, 2, now(), now()),
       (240, 'BASIC', 2, 2, now(), now()),
       (100, 'PAYMENT_METHOD', 2, 5, now(), now()),
       (240, 'MEMBERSHIP', 2, 2, now(), now()),
       (240, 'BASIC', 2, 2, now(), now()),
       (100, 'PAYMENT_METHOD', 2, 5, now(), now()),
       (240, 'MEMBERSHIP', 2, 2, now(), now()),
       (240, 'BASIC', 2, 4, now(), now());


INSERT INTO payment (amount, user_id, brand_id, created_at, updated_at)
VALUES (25000, 1, 1, now(), now()),
       (10000, 2, 1, now(), now()),
       (3000, 1, 3, now(), now()),
       (2400, 1, 5, now(), now());

INSERT INTO point(saving, point_type, created_at, updated_at)
VALUES (1260, 'BASIC', now(), now()),
       (2920, 'MEMBERSHIP', now(), now()),
       (2300, 'REVIEW', now(), now()),
       (5020, 'PAYMENT_METHOD', now(), now())  #원형 카테고리 표



