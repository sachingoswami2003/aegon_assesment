INSERT INTO customers (CUSTOMER_Id, FIRST_NAME, LAST_NAME, MEMBERSHIP_STATUS) VALUES (3, 'Sachin ', 'Goswami' , true)
INSERT INTO customers (CUSTOMER_Id, FIRST_NAME, LAST_NAME, MEMBERSHIP_STATUS) VALUES (4, 'Sam ', 'Brit' , true)
INSERT INTO customers (CUSTOMER_Id, FIRST_NAME, LAST_NAME, MEMBERSHIP_STATUS) VALUES (5, 'Mark ', 'Goswami' , true)
INSERT INTO customers (CUSTOMER_Id, FIRST_NAME, LAST_NAME, MEMBERSHIP_STATUS) VALUES (6, 'Alex ', 'Brown' , true)
INSERT INTO ROOM (ROOM_ID ,ROOM_PRICE ,ROOM_TYPE,BREAK_FAST_PRICE  ) values(121,200,'DELUX',5)
INSERT INTO ROOM (ROOM_ID ,ROOM_PRICE ,ROOM_TYPE,BREAK_FAST_PRICE  ) values(122,100,'SIMPLE',5)
INSERT INTO ROOM (ROOM_ID ,ROOM_PRICE ,ROOM_TYPE,BREAK_FAST_PRICE  ) values(123,200,'DELUX',5)
INSERT INTO ROOM (ROOM_ID ,ROOM_PRICE ,ROOM_TYPE,BREAK_FAST_PRICE  ) values(124,200,'DELUX',5)
INSERT INTO ROOM (ROOM_ID ,ROOM_PRICE ,ROOM_TYPE,BREAK_FAST_PRICE  ) values(125,100,'SIMPLE',5)
INSERT INTO OCCUPIED_ROOMS(OCCUPIED_ID ,BOOKING_ID,NUMBER_OF_ROOM ,ROOM_ID ,CUSTOMER_ID,ROOM_TYPE,CHECK_IN_DATE,CHECK_OUT_DATE ) VALUES (4,3,1,122,3,'Simple',{ts '2017-07-10 18:47:52.69'},{ts '2017-07-10 18:47:52.69'})
INSERT INTO OCCUPIED_ROOMS(OCCUPIED_ID ,BOOKING_ID,NUMBER_OF_ROOM ,ROOM_ID ,CUSTOMER_ID,ROOM_TYPE,CHECK_IN_DATE,CHECK_OUT_DATE ) VALUES (5,4,1,123,4,'Delux',{ts '2017-07-11 18:47:52.69'},{ts '2017-07-13 18:47:52.69'})
INSERT INTO OCCUPIED_ROOMS(OCCUPIED_ID ,BOOKING_ID,NUMBER_OF_ROOM ,ROOM_ID ,CUSTOMER_ID,ROOM_TYPE,CHECK_IN_DATE,CHECK_OUT_DATE ) VALUES (6,5,1,124,5,'Delux',{ts '2017-07-14 18:47:52.69'},{ts '2017-07-17 18:47:52.69'})
INSERT INTO OCCUPIED_ROOMS(OCCUPIED_ID ,BOOKING_ID,NUMBER_OF_ROOM ,ROOM_ID ,CUSTOMER_ID,ROOM_TYPE,CHECK_IN_DATE,CHECK_OUT_DATE ) VALUES (7,6,1,121,6,'Delux',{ts '2017-07-11 18:47:52.69'},{ts '2017-07-17 18:47:52.69'})




