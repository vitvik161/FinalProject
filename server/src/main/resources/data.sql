DROP TABLE IF EXISTS CARD;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS CUST;

CREATE TABLE CUST (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          name VARCHAR(250) NOT NULL
);

CREATE TABLE ACCOUNT (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         custid  INT NOT NULL,
                         balance int DEFAULT 0,
                         foreign key (custid) references CUST(id)
);

CREATE TABLE CARD (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         accid  INT NOT NULL,
                         pan VARCHAR(22) NOT NULL,
                         pin INT DEFAULT 0,
                         foreign key (accid) references ACCOUNT(id)
);

INSERT INTO CUST (id,name) VALUES
(101,'Ivan'),
(102,'Petr'),
(103,'Mariya');


INSERT INTO ACCOUNT (id,balance,custid) VALUES
(1,123,101),
(2,456,102),
(3,789,103);

INSERT INTO CARD (accid,pan,pin) VALUES
(1,'1111222233334444',1111),
(2,'0000222255559999',2222),
(2,'8888222255559999',6666),
(3,'3333111155557777',3333);

