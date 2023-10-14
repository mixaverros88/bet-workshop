CREATE TABLE BET (
    id int NOT NULL AUTO_INCREMENT primary key,
	team varchar(200) not null,
	opponent varchar(200) not null,
	league varchar(200) not null,
	bettingCompany varchar(200) not null,
	userName varchar(200) not null,
	betPoint varchar(200) not null,
	attribution double not null,
	betAmount double default 0 not null,
	dateTime DATETIME DEFAULT CURRENT_TIMESTAMP,
	result varchar(200) not null,
	revenue double not null
);

CREATE TABLE MOCK (
    id int NOT NULL AUTO_INCREMENT primary key,
	betInfo varchar(200) not null,
	bettingCompany varchar(200) not null,
	userName varchar(200) not null,
	attribution double not null,
	betAmount double default 0 not null,
	dateTime DATETIME DEFAULT CURRENT_TIMESTAMP,
	result varchar(200) not null,
	revenue double not null
);

CREATE TABLE SEASON_TEAMS (
    id int NOT NULL AUTO_INCREMENT primary key,
	team varchar(200) not null,
	season varchar(200) not null
);
