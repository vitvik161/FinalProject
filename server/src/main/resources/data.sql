DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          pin INT NOT NULL
);

CREATE TABLE ACCOUNT (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         balance int DEFAULT 0,
                         custid  INT NOT NULL,
                         foreign key (custid) references CUSTOMER(id)
);

INSERT INTO CUSTOMER (id,pin) VALUES
(101,111),
(102,222),
(103,333);

INSERT INTO ACCOUNT (balance,custid) VALUES
(123,101),
(456,102),
(789,103);
