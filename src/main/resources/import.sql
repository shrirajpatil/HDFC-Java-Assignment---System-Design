INSERT INTO users (user_id, name, email, password_hash, created_at) VALUES
(1, 'Alice', 'alice@example.com', '$2a$10$7QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8', NOW()),
(2, 'Bob', 'bob@example.com', '$2a$10$7QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8', NOW());

INSERT INTO movies (movie_id, title, language, genre, duration) VALUES
(1, 'Inception', 'English', 'Sci-Fi', 148),
(2, '3 Idiots', 'Hindi', 'Comedy', 170);

INSERT INTO theaters (theater_id, name, city) VALUES
(1, 'PVR', 'Mumbai'),
(2, 'INOX', 'Delhi');

INSERT INTO shows (show_id, movie_id, theater_id, show_time, screen_no) VALUES
(1, 1, 1, '2025-11-05 18:00:00', 1),
(2, 2, 2, '2025-11-05 20:00:00', 2);

INSERT INTO seats (seat_id, show_id, seat_number, status) VALUES
(1, 1, 'A1', 'AVAILABLE'),
(2, 1, 'A2', 'AVAILABLE'),
(3, 2, 'B1', 'AVAILABLE'),
(4, 2, 'B2', 'AVAILABLE');

