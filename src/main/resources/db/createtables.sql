SET MODE PostgresSQL;

--create two tables for heroes and squads. NB; always use plural

create TABLE IF NOT EXISTS heroes(
id int PRIMARY KEY auto-increment,
heroName VARCHAR,
heroPower VARCHAR,
heroWeakness VARCHAR,
heroGender VARCHAR,
squadId INTEGER,
heroAge INTEGER,
);
