INSERT INTO halls(serial_num, amount_of_seats) VALUES (default, 50);
INSERT INTO halls(serial_num, amount_of_seats) VALUES (default, 40);
INSERT INTO movies(id, title, year, age_restriction, description) VALUES (default, 'Aliens', 2022, 16, 'Our planet was attacked by aliences');
INSERT INTO movies(id, title, year, age_restriction, description) VALUES (default, 'Matrix', 2022, 16, 'Blue or red pill?');
INSERT INTO sessions(id, movie_id, hall_id, time, price) VALUES (default, 3, 3, DATE '2022-12-09', 400);
INSERT INTO users(id, login) VALUES (default, 'iulia');
INSERT INTO messages(id, message, movie_id, user_id) VALUES (default, 'hello, how are you?', 3, 1);