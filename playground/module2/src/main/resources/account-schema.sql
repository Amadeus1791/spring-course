-- A bank account in the playground. A closed account takes no more money.
CREATE TABLE account (
    id      INT PRIMARY KEY,
    owner   VARCHAR(20) NOT NULL,
    balance INT NOT NULL,
    closed  BOOLEAN NOT NULL
);
