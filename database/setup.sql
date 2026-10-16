-- Run this in pgAdmin Query Tool or psql.
CREATE DATABASE userdb;

-- Connect to userdb, then run:
CREATE TABLE IF NOT EXISTS users (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100),
    password VARCHAR(255) NOT NULL
);

-- Demo-only placeholder. For real accounts, store a password hash (e.g. BCrypt), never plaintext.
INSERT INTO users (username, email, password)
VALUES ('prasanna', 'prasanna@example.com', 'DEMO_HASH_PLACEHOLDER')
ON CONFLICT (username) DO NOTHING;
