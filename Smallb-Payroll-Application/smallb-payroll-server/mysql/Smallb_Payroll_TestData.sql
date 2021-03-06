INSERT INTO Account (Name, Email, Account_Sub, Pay_Period) VALUES
    ("test_account", "nsw.amicosnypizza@gmail.com", "ada144e7-5084-49e4-a7e5-701f762ecacf", 'WEEKLY'),
    ("test_account_2", "nsw.advocare@gmail.com", "bcdea241-27b3-4efd-a8c6-cd797c0f8a68", 'BIWEEKLY');

INSERT INTO Employee VALUES
    (1, "1-E-0001", "TestA", "EmployeeA", NULL, 'HOURLY'),
    (2, "2-E-0001", "2TestA", "2EmployeeA", NULL, 'HOURLY'),
    (1, "1-E-0002", "TestB", "EmployeeB", NULL, 'HOURLY'),
    (1, "1-E-0003", "TestC", "EmployeeC", NULL, 'SALARY');

INSERT INTO Hourly_Employee VALUES
    (1, "1-E-0001", 7.25),
    (2, "2-E-0001", 9.50),
    (1, "1-E-0002", 12);

INSERT INTO Salary_Employee VALUES
    (1, "1-E-0003", 525.25);

INSERT INTO Pay_Period VALUES
    (1, "1-P-0001", '2021-11-28', '2021-12-04'),
    (2, "2-P-0001", '2021-11-29', '2021-12-12'),
    (1, "1-P-0002", '2021-12-05', '2021-12-11'),
    (1, "1-P-0003", '2021-12-12', '2021-12-18'),
    (2, "2-P-0002", '2021-12-13', '2021-12-26');

INSERT INTO Timecard VALUES
    (1, "1-E-0001", "1-P-0001", 40, 0, NULL, NULL),
    (1, "1-E-0002", "1-P-0001", 30, 0, NULL, NULL),
    (1, "1-E-0003", "1-P-0001", NULL, NULL, 0, 0),
    (2, "2-E-0001", "2-P-0001", 80, 10, NULL, NULL),
    (1, "1-E-0001", "1-P-0002", 40, 5, NULL, NULL),
    (1, "1-E-0002", "1-P-0002", 25, 0, NULL, NULL),
    (1, "1-E-0003", "1-P-0002", NULL, NULL, 0, 112.52),
    (1, "1-E-0001", "1-P-0003", 40, 10, NULL, NULL),
    (1, "1-E-0002", "1-P-0003", 20, 0, NULL, NULL),
    (1, "1-E-0003", "1-P-0003", NULL, NULL, 750, 0),
    (2, "2-E-0001", "2-P-0002", 80, 20, NULL, NULL);
