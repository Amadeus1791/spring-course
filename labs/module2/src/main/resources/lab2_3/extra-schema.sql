-- Lab 2.3, extra task
CREATE TABLE card (
    number VARCHAR(16) PRIMARY KEY,
    daily_limit INT NOT NULL
);
INSERT INTO card (number, daily_limit) VALUES ('4242', 5000);
