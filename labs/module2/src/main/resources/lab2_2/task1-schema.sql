-- Lab 2.2, task 1
CREATE TABLE card (
    number VARCHAR(16) PRIMARY KEY,
    holder VARCHAR(50) NOT NULL,
    daily_limit INT NOT NULL
);
