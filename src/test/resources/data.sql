DROP TABLE IF EXISTS ACCOUNT;

CREATE TABLE ACCOUNT (
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         AMOUNT_OF_MONEY INT NOT NULL
);


insert into ACCOUNT (AMOUNT_OF_MONEY) values (1234);
insert into ACCOUNT (AMOUNT_OF_MONEY) values (2345);
insert into ACCOUNT (AMOUNT_OF_MONEY) values (3456);
insert into ACCOUNT (AMOUNT_OF_MONEY) values (4567);
