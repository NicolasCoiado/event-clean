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

CREATE TABLE venues (
    id BIGSERIAL PRIMARY KEY,
    establishment_name VARCHAR(255),
    street VARCHAR(255) NOT NULL,
    number VARCHAR(10) ,
    neighborhood VARCHAR(100),
    zipCode VARCHAR(9)
);

CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    identifier VARCHAR(10) NOT NULL UNIQUE,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    venue_id BIGINT UNIQUE,
    capacity INT,
    type event_type,
    FOREIGN KEY (venue_id) REFERENCES venues(id)
);
