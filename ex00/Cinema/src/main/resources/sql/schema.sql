DROP TABLE IF EXISTS halls CASCADE;

CREATE TABLE halls(
                      serialNum SERIAL PRIMARY KEY,
                      amountOfSeats INT
);

DROP TABLE IF EXISTS movies CASCADE;

CREATE TABLE movies(
                      id SERIAL PRIMARY KEY,
                      title varchar(30),
                      year INT,
                      ageRestriction INT,
                      description text,
                      poster text
);

DROP TABLE IF EXISTS sessions CASCADE;

CREATE TABLE sessions(
                       id SERIAL PRIMARY KEY,
                       movieId Int REFERENCES movies(id),
                       hallId Int REFERENCES halls(serialNum),
                       time timestamp without time zone,
                       price varchar(30)
);