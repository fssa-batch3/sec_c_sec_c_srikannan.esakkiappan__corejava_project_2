USE srikannan_esakkiappan_corejava_project;

CREATE TABLE IF NOT EXISTS userdetails (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(15) NOT NULL,
    email VARCHAR(50)  NOT NULL UNIQUE,
    address VARCHAR(120) NOT NULL,
    phonenumber VARCHAR(15) NOT NULL,
    password VARCHAR(150) NOT NULL,
    mapurl VARCHAR(150)  NOT NULL UNIQUE,
    placephotourl VARCHAR(150) NOT NULL,
    lattitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
); 

SELECT * FROM userdetails;


CREATE TABLE IF NOT EXISTS Tenantdetails (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(15) NOT NULL,
    email VARCHAR(50)  NOT NULL UNIQUE,
    address VARCHAR(120) NOT NULL,
    phonenumber VARCHAR(15) NOT NULL,
    password VARCHAR(150) NOT NULL,
    bikephotourl VARCHAR(150) NOT NULL
);

SELECT * FROM Tenantdetails;

CREATE TABLE ParkingPlaceBooking (
    bookingId INT AUTO_INCREMENT PRIMARY KEY,
    leaserId INT NOT NULL,
    tenantName VARCHAR(15) NOT NULL,
    tenantPhone VARCHAR(15) NOT NULL,
    tenantEmail VARCHAR(255) NOT NULL,
    startingPeriod DATETIME NOT NULL,
    endingPeriod DATETIME NOT NULL,
    amount DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL,
    tenantBikeImg VARCHAR(150) NOT NULL
);

SELECT * FROM ParkingPlaceBooking;


