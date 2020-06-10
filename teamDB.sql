CREATE DATABASE IF NOT EXISTS teams;

USE teams;

DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
		id int(10) not null auto_increment,
		name varchar(50) not null,
		primary key(id)
);

CREATE TABLE members(
		id int(10) not null auto_increment,
		first_name varchar(25) not null,
		last_name varchar(25) not null,
		team_id int(10) not null,
		primary key (id),
		foreign key(team_id) references teams(id)
);