CREATE TABLE CLIENTS (
    CLIENT_ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(50) UNIQUE NOT NULL,
    CPF VARCHAR2(20) UNIQUE NOT NULL,
    ADDRESS VARCHAR2(100) NOT NULL,
    TOTAL_LOANS NUMBER DEFAULT 0
);

CREATE TABLE TELEPHONES (
    TELEPHONE_ID NUMBER PRIMARY KEY,
    CLIENT_ID NUMBER,
    PHONE_NUMBER VARCHAR2(40) UNIQUE NOT NULL,
    PHONE_TYPE VARCHAR2(3) NOT NULL,
    CONSTRAINT FK_TELEPHONE_CLIENT FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(CLIENT_ID)
);

CREATE TABLE LOANS (
    LOAN_ID NUMBER PRIMARY KEY,
    CLIENT_ID NUMBER,
    LOAN_DATE DATE,
    DUE_DATE DATE,
    RETURN_DATE DATE,
    LOAN_STATUS VARCHAR2(20) DEFAULT 'OPEN',
    FINE_AMOUNT NUMBER DEFAULT 0,
    CREATED_AT DATE DEFAULT SYSDATE,
    UPDATED_AT DATE,
    CONSTRAINT FK_LOANS_CLIENT FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(CLIENT_ID)
);

CREATE TABLE FINES (
    FINE_ID NUMBER PRIMARY KEY,
    LOAN_ID NUMBER NOT NULL,
    FINE_AMOUNT NUMBER NOT NULL,
    FINE_DATE DATE DEFAULT SYSDATE,
    FINE_STATUS VARCHAR2(20) DEFAULT 'PENDING',
    CONSTRAINT FK_FINE_LOANS FOREIGN KEY (LOAN_ID) REFERENCES LOANS(LOAN_ID)
);

CREATE TABLE AUTHORS (
    AUTHOR_ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    NATIONALITY VARCHAR2(50) NOT NULL,
    BIRTH_DATE DATE NOT NULL,
    DEATH_DATE DATE
);

CREATE TABLE BOOKS (
    BOOK_ID NUMBER PRIMARY KEY,
    AUTHOR_ID NUMBER,
    TITLE VARCHAR2(100) NOT NULL,
    YEAR_PUBLISHED NUMBER(4),
    GENRE VARCHAR2(50) NOT NULL,
    COPIES_AVAILABLE NUMBER DEFAULT 0,
    TOTAL_COPIES NUMBER DEFAULT 0,
    LANGUAGE VARCHAR2(30) NOT NULL,
    CONSTRAINT FK_BOOKS_AUTHOR FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(AUTHOR_ID)
);

CREATE TABLE LOAN_BOOKS (
    LOAN_BOOK_ID NUMBER PRIMARY KEY,
    LOAN_ID NUMBER NOT NULL,
    BOOK_ID NUMBER NOT NULL,
    QUANTITY NUMBER DEFAULT 1,
    CONSTRAINT FK_LB_LOAN FOREIGN KEY (LOAN_ID) REFERENCES LOANS(LOAN_ID),
    CONSTRAINT FK_LB_BOOKS FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID)
);

CREATE TABLE PUBLISHERS (
    PUBLISHER_ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(50) UNIQUE NOT NULL,
    DATE_FOUNDATION DATE,
    COUNTRY VARCHAR2(50) NOT NULL,
    WEBSITE VARCHAR2(100) UNIQUE NOT NULL
);

CREATE TABLE BOOK_PUBLISHERS (
    BOOK_PUBLISHER_ID NUMBER PRIMARY KEY,
    BOOK_ID NUMBER,
    PUBLISHER_ID NUMBER,
    CONSTRAINT FK_BP_BOOK FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
    CONSTRAINT FK_BP_PUBLISHER FOREIGN KEY (PUBLISHER_ID) REFERENCES PUBLISHERS(PUBLISHER_ID)
);

-- SEQUENCE FOR FINES (FINE_ID)
CREATE SEQUENCE FINE_SEQ
START WITH 1
INCREMENT BY 1;