DROP SCHEMA IF EXISTS Smallb_Payroll;

CREATE SCHEMA Smallb_Payroll;

USE Smallb_Payroll;

CREATE TABLE Account
    (Account_Id int NOT NULL AUTO_INCREMENT,
    Name varchar(64) CHARACTER SET utf8 NOT NULL,
    Email varchar(128) CHARACTER SET utf8 NOT NULL,
    Account_Sub varchar(64) CHARACTER SET utf8 NOT NULL UNIQUE,
    Pay_Period enum('WEEKLY','BIWEEKLY') NOT NULL,
    PRIMARY KEY (Account_Id));

CREATE TABLE Employee
    (Account_Id int NOT NULL,
    Emp_Id varchar(32) NOT NULL UNIQUE,
    First_Name varchar(32) CHARACTER SET utf8 NOT NULL,
    Last_Name varchar(32) CHARACTER SET utf8 NOT NULL,
    Phone_Num varchar(32) CHARACTER SET utf8,
    Emp_Type enum('HOURLY','SALARY') NOT NULL,
    PRIMARY KEY (Account_Id, Emp_Id),
    FOREIGN KEY (Account_Id) REFERENCES Account(Account_Id)
		ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Hourly_Employee
    (Account_Id int NOT NULL,
    Emp_Id varchar(32) NOT NULL,
    Rate decimal(5,2) NOT NULL,
    PRIMARY KEY (Account_Id, Emp_Id),
    FOREIGN KEY (Account_Id) REFERENCES Account(Account_Id)
	        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Emp_Id) REFERENCES Employee(Emp_Id)
		ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Salary_Employee
    (Account_Id int NOT NULL,
    Emp_Id varchar(32) NOT NULL,
    Period_Rate decimal(7,2) NOT NULL,
    PRIMARY KEY (Account_Id, Emp_Id),
    FOREIGN KEY (Account_Id) REFERENCES Account(Account_Id)
	        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Emp_Id) REFERENCES Employee(Emp_Id)
		ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Pay_Period
    (Account_Id int NOT NULL,
    Period_Id varchar(32) NOT NULL UNIQUE,
    Start_Date date NOT NULL,
    End_Date date NOT NULL,
    PRIMARY KEY (Account_Id, Period_Id),
    FOREIGN KEY (Account_Id) REFERENCES Account(Account_Id)
	        ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Timecard
    (Account_Id int NOT NULL,
    Emp_Id varchar(32) NOT NULL,
    Period_Id varchar(32) NOT NULL,
    Regular_Hours decimal(5,2),
    Overtime_Hours decimal(5,2),
    Bonus_Pay decimal(7,2),
    Other_Pay decimal(7,2),
    PRIMARY KEY (Account_Id, Emp_Id, Period_Id),
    FOREIGN KEY (Account_Id) REFERENCES Account(Account_Id)
	        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Emp_Id) REFERENCES Employee(Emp_Id)
		ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Period_Id) REFERENCES Pay_Period(Period_Id)
		ON DELETE CASCADE ON UPDATE CASCADE);
