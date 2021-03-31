INSERT INTO products(id, description, price, title, owner) VALUES (1001, 'For writing', 12.99, 'Pencil', 'user');
INSERT INTO products(id, description, price, title, owner) VALUES (1002, 'For reading', 120.99, 'Lamp', 'user');
INSERT INTO products(id, description, price, title, owner) VALUES (1003, 'Sport CAR 460 HP', 12000.99, 'Car', 'user');
INSERT INTO products(id, description, price, title, owner) VALUES (1005, 'For swimming', 1299.99, 'Glasses', 'user');
INSERT INTO products(id, description, price, title, owner) VALUES (1006, 'To click on the desktop', 1299.99, 'Mouse', 'user');
INSERT INTO products(id, description, price, title, owner) VALUES (1007, 'Typing text', 1299.99, 'Keyboard', 'user');
INSERT INTO products(id, description, price, title, owner) VALUES (1008, 'Coffee/Tea', 1299.99, 'Cup', 'admin');
INSERT INTO products(id, description, price, title, owner) VALUES (1009, 'Discover new places', 1299.99, 'Map', 'admin');
INSERT INTO products(id, description, price, title, owner) VALUES (1010, 'Make notes', 1299.99, 'Paper', 'admin');



INSERT INTO users(id, email, password, username, authority) VALUES (1001, 'user@gmail.com', 'user', 'user', 'read');
INSERT INTO users(id, email, password, username, authority) VALUES (1002, 'admin@gmail.com', 'admin', 'admin', 'write');

INSERT INTO authority(id, name, user_id) VALUES (1001, 'read', 1002);
INSERT INTO authority(id, name, user_id) VALUES (1002, 'write', 1001);
