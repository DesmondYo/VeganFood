CREATE DATABASE IF NOT EXISTS veganfoods;

use veganfoods;

DROP TABLE IF EXISTS foods;

CREATE TABLE foods(
		id INT(15) NOT NULL auto_increment,
		name VARCHAR(25) NOT NULL,
		taste VARCHAR(30),
		texture VARCHAR(50),
		PRIMARY KEY(id)
); 
