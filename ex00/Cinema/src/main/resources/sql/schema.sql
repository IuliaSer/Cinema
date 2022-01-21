DROP TABLE IF EXISTS halls CASCADE;

CREATE TABLE halls(
                      serialNum SERIAL PRIMARY KEY,
                      amountOfSeats INT
);

CREATE TABLE movies(
                      id SERIAL PRIMARY KEY,
                      title varchar(30),
                      year INT,
                      ageRestriction INT,
                      description text
);