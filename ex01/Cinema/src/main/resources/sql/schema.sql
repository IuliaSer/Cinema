DROP TABLE IF EXISTS halls CASCADE;

CREATE TABLE halls(
                      serialNum SERIAL PRIMARY KEY,
                      amountOfSeats INT not null
);

DROP TABLE IF EXISTS movies CASCADE;

CREATE TABLE movies(
                      id SERIAL PRIMARY KEY,
                      title varchar(30) not null,
                      year INT not null,
                      ageRestriction INT not null ,
                      description text,
                      imageUrl text
);

DROP TABLE IF EXISTS sessions CASCADE;

CREATE TABLE sessions(
                       id SERIAL PRIMARY KEY,
                       movieId Int REFERENCES movies(id),
                       hallId Int REFERENCES halls(serialNum),
                       time timestamp without time zone,
                       price Int not null
);