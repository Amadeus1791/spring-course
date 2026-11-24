-- One line per note, written by TransferNote in its own transaction.
CREATE TABLE note (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(100) NOT NULL
);
