CREATE DATABASE highschool;
USE highschool;

CREATE TABLE student(
	nif VARCHAR(10) PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	zipCode INT NOT NULL
);

INSERT INTO student(nif, name, surname, zipCode)
VALUES ('1X', 'Bob', 'Esponja', 28000);

INSERT INTO student(nif, name, surname, zipCode)
VALUES ('2X', 'Peppa', 'Pig', 28001);