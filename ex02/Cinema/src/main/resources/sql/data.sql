INSERT INTO halls(serialNum, amountOfSeats) VALUES (default, 50);
INSERT INTO halls(serialNum, amountOfSeats) VALUES (default, 40);
INSERT INTO movies(id, title, year, ageRestriction, description) VALUES (default, 'Aliens', 2022, 16, 'Our planet was attacked by aliences');
INSERT INTO movies(id, title, year, ageRestriction, description) VALUES (default, 'Matrix', 2022, 16, 'Blue or red pill?');
INSERT INTO sessions(id, movieId, hallId, time, price) VALUES (default, 1, 1, DATE '2022-12-09', 400);