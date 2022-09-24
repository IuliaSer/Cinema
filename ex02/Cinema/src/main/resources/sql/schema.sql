DROP TABLE IF EXISTS halls CASCADE;

CREATE TABLE halls(
                      serial_num SERIAL PRIMARY KEY,
                      amount_of_seats INT not null
);

DROP TABLE IF EXISTS movies CASCADE;

CREATE TABLE movies(
                      id SERIAL PRIMARY KEY,
                      title varchar(30) not null,
                      year INT not null,
                      age_restriction INT not null ,
                      description text,
                      image_url text
);

DROP TABLE IF EXISTS sessions CASCADE;

CREATE TABLE sessions(
                       id SERIAL PRIMARY KEY,
                       movie_id Int REFERENCES movies(id),
                       hall_id Int REFERENCES halls(serial_num),
                       time timestamp without time zone,
                       price Int not null
);

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
                         id BIGSERIAL PRIMARY KEY,
                         login varchar(20) unique
);

DROP TABLE IF EXISTS messages CASCADE;

CREATE TABLE messages(
                         id SERIAL PRIMARY KEY,
                         message text,
                         movie_id Int REFERENCES movies(id),
                         user_id bigserial REFERENCES users(id)

);