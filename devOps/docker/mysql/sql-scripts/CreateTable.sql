CREATE TABLE BET (
    id int NOT NULL AUTO_INCREMENT primary key,
	amount double default 0 not null,
	homeTeam varchar(100) not null,
	awayTeam varchar(100) not null,
	selection varchar(100) not null
);
