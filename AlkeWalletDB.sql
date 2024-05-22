DROP DATABASE AlkeWalletDB;
CREATE DATABASE AlkeWalletDB;

USE AlkeWalletDB;

CREATE TABLE Users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL
);

INSERT INTO Users(user, password) VALUES
('Admin', '1234'),
('Jorge', '1234'),
('UsuarioBasico', 'UsuarioBasico2024')


CREATE TABLE Account (
    accountNumber INT PRIMARY KEY,
    accountHolder VARCHAR(255) NOT NULL,
    accountBalance DOUBLE NOT NULL
);

CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    accountNumber INT,
    FOREIGN KEY (accountNumber) REFERENCES Account(accountNumber) 
);



SELECT * FROM Account;
SELECT * FROM Account WHERE accountNumber = 68748;


INSERT INTO Account (accountNumber, accountHolder, accountBalance) VALUES (1300, "pedrito",1530);
INSERT INTO Customer (name, accountNumber) VALUES ("pedrito",1300);
SELECT * FROM Customer;

SELECT * FROM Users WHERE user='Jorge' AND password ='1234'



