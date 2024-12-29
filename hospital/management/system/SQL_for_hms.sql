CREATE DATABASE hospital_management_system;
USE hospital_management_system;

CREATE TABLE login(
	ID varchar(20),
    PW varchar(20)
);

SELECT * FROM login;

INSERT INTO login VALUES ("simran","1234");

INSERT INTO login (ID, PW)
VALUES
('john_doe', 'securePassword123'),
('jane_smith', 'password456'),
('michael_brown', 'P@ssw0rd!'),
('emma_watson', 'Emma2024#'),
('robert_davis', 'R0b3rt!Pass'),
('sophia_lee', 'SophiaSecure12'),
('william_taylor', 'WillTay@321'),
('olivia_jones', 'LivPass#987'),
('james_clark', 'JamesC!2024'),
('ava_white', 'Ava_White1234'),
('elijah_moore', 'EliP@ssword456'),
('mia_anderson', 'Mia2023&Secure'),
('lucas_thomas', 'Lucas!456Pass'),
('isabella_hall', 'IsaH@ll#2023'),
('noah_harris', 'Noah2024!Password');

INSERT INTO login (ID, PW) VALUES ('user1','1234567');

CREATE TABLE patientInfo(
	ID varchar(20),
    IdNum varchar(20),
    patientName varchar(20),
    gender varchar(20),
    patientDisease varchar(20),
    roomNumber varchar(20),
    Time varchar(100),
    deposite varchar(20)
);

SELECT * FROM patientInfo;

INSERT INTO patientInfo (ID, IdNum, patientName, gender, patientDisease, roomNumber, Time, deposite) 
VALUES 
    ('Driving Licence', 'DL1234567', 'John Doe', 'Male', 'Flu', '101', 'Fri Dec 20 10:30:00 CST 2024', '500'),
    ('Passport Number', 'P1234567', 'Jane Smith', 'Female', 'Cold', '102', 'Sat Dec 21 11:00:00 CST 2024', '300'),
    ('Voter ID', 'V1234567', 'Alice Brown', 'Female', 'Fever', '103', 'Sat Dec 21 11:30:00 CST 2024', '400'),
    ('Driving Licence', 'DL2345678', 'Robert White', 'Male', 'Asthma', '104', 'Sun Dec 22 12:00:00 CST 2024', '600'),
    ('Passport Number', 'P2345678', 'Michael Green', 'Male', 'Allergy', '105', 'Sun Dec 22 12:30:00 CST 2024', '350');
CREATE TABLE room(
	roomNum varchar(20),
    availabilty varchar(20),
    price varchar(20),
    roomType varchar(100)
);

SELECT * FROM room;

insert into Room values("100","Available","500","G Bed 1");
insert into Room values("101","Available","500","G Bed 2");
insert into Room values("102","Available","500","G Bed 3");
insert into Room values("103","Available","500","G Bed 4");
insert into Room values("200","Available","1500","Private Room");
insert into Room values("201","Available","1500","Private Room");
insert into Room values("202","Available","1500","Private Room");
insert into Room values("203","Available","1500","Private Room");
insert into Room values("300","Available","3500","ICU Bed 1");
insert into Room values("301","Available","3500","ICU Bed 2");
insert into Room values("302","Available","3500","ICU Bed 3");
insert into Room values("303","Available","3500","ICU Bed 4");
insert into Room values("304","Available","3500","ICU Bed 5");
insert into Room values("305","Available","3500","ICU Bed 6");


CREATE TABLE department(
	Department varchar(100),
    PhoneNo varchar(20)
);

SELECT * FROM department;

INSERT INTO department (Department, PhoneNo)
VALUES
    ('Surgical Department', '123-456-7890'),
    ('Nursing Department', '987-654-3210'),
    ('Operation Theatre Complex (OT)', '456-789-1234'),
    ('Paramedical Department', '789-123-4567'),
    ('Technical Department', '111-222-3333');
    
CREATE TABLE employeeInfo(
	Name varchar(50), 
    Age varchar(20),
    PhoneNo varchar(20),
    Salary varchar(20),
    Email varchar(100),
    Driver_Licence varchar(20)
);

SELECT * FROM employeeInfo;

INSERT INTO employeeInfo (Name, Age, PhoneNo, Salary, Email, Driver_Licence)
VALUES
    ('Olivia Johnson', '30', '555-1111', '72000', 'olivia.johnson@example.com', 'D33445566'),
    ('Liam Martinez', '28', '555-2222', '60000', 'liam.martinez@example.com', 'D77665544'),
    ('Sophia Anderson', '37', '555-3333', '75000', 'sophia.anderson@example.com', 'D22334455'),
    ('James Thomas', '50', '555-4444', '90000', 'james.thomas@example.com', 'D44556677'),
    ('Ava Moore', '42', '555-5555', '82000', 'ava.moore@example.com', 'D66778899'),
    ('Ethan Taylor', '27', '555-6666', '58000', 'ethan.taylor@example.com', 'D88990011'),
    ('Charlotte Hernandez', '36', '555-7777', '77000', 'charlotte.hernandez@example.com', 'D11223300'),
    ('Lucas White', '32', '555-8888', '68000', 'lucas.white@example.com', 'D33441122'),
    ('Amelia King', '48', '555-9999', '87000', 'amelia.king@example.com', 'D55667733'),
    ('Mason Scott', '31', '555-0000', '69000', 'mason.scott@example.com', 'D77889911'),
    ('Isabella Martinez', '39', '555-1235', '80000', 'isabella.martinez@example.com', 'D99887755'),
    ('Elijah Lee', '41', '555-6789', '84000', 'elijah.lee@example.com', 'D44553322'),
    ('Mia Walker', '34', '555-4321', '73000', 'mia.walker@example.com', 'D22334466'),
    ('Benjamin Hall', '46', '555-5432', '89000', 'benjamin.hall@example.com', 'D66778844'),
    ('Harper Young', '29', '555-6543', '62000', 'harper.young@example.com', 'D11221133');

CREATE TABLE ambulance(
	driverName varchar(20),
    driverGender varchar(20),
    ambName varchar(20),
    available varchar(20),
    location varchar(20)
);

SELECT * FROM ambulance;

INSERT INTO ambulance (driverName, driverGender, ambName, available, location) VALUES
('Alex Carter', 'Male', 'Ambulance X', 'Available', 'Central Park'),
('Sophia Martinez', 'Female', 'Ambulance Y', 'Available', 'East Side'),
('Liam Wilson', 'Male', 'Ambulance Z', 'Available', 'West End'),
('Isabella Lopez', 'Female', 'Ambulance Q', 'Available', 'North Hill'),
('Ethan Taylor', 'Male', 'Ambulance W', 'Available', 'South Gate');
