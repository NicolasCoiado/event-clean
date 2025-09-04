CREATE TYPE event_type AS ENUM (
    'CULTURAL',
    'SPORTS',
    'RELIGIOUS',
    'CORPORATE',
    'ACADEMIC',
    'SOCIAL',
    'POLITICAL',
    'GASTRONOMIC',
    'TRADE_SHOW'
);

CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    identifier VARCHAR(15) NOT NULL UNIQUE,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    capacity INT,
    type event_type
);

CREATE TABLE venues (
    id BIGSERIAL PRIMARY KEY,
    establishment_name VARCHAR(255),
    street VARCHAR(255) NOT NULL,
    number VARCHAR(10),
    neighborhood VARCHAR(100),
    zipCode VARCHAR(9),
    event_id BIGINT UNIQUE,
    FOREIGN KEY (event_id) REFERENCES events(id)
);