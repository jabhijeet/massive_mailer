CREATE TABLE IF NOT EXISTS events (
    id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    title        VARCHAR(50),
    description VARCHAR(200),
    location    VARCHAR(255) NOT NULL DEFAULT ''
);