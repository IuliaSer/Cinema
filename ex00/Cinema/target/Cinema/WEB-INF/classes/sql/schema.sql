DROP TABLE IF EXISTS halls CASCADE;

CREATE TABLE halls(
                      serial_num SERIAL PRIMARY KEY,
                      amount_of_seats INT
);

-- CREATE TABLE auth (
--     user_id SERIAL references users(id),
--     date varchar(30) NOT NULL,
--     ip varchar(30) NOT NULL
-- );