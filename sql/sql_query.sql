USE parkin_java;

CREATE TABLE IF NOT EXISTS userdetails (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(15) NOT NULL,
    email VARCHAR(50)  NOT NULL UNIQUE,
    address VARCHAR(120) NOT NULL,
    phonenumber VARCHAR(15) NOT NULL,
    password VARCHAR(15) NOT NULL,
    mapurl VARCHAR(150)  NOT NULL UNIQUE,
    placephotourl VARCHAR(150) NOT NULL
); 

SELECT * FROM userdetails;