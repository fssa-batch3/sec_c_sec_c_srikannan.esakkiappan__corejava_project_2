USE srikannan_esakkiappan_corejava_project;

CREATE TABLE IF NOT EXISTS parkingplace (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    placeownername VARCHAR(15) NOT NULL,
    address VARCHAR(35) NOT NULL,
    locality VARCHAR(15) NOT NULL,
    mapurl VARCHAR(150) NOT NULL ,
    placephotourl VARCHAR(150) NOT NULL,
    proofdocurl VARCHAR(150) NOT NULL,
    lattitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL	
);

Select * from parkingplace;