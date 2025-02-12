CREATE TABLE item (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      supplier VARCHAR(255),
                      size FLOAT,
                      price FLOAT,
                      aisle INTEGER,
                      rack INTEGER,
                      shelf INTEGER
);

CREATE TABLE zone (
                      id SERIAL PRIMARY KEY,
                      wave_id INTEGER,
                      name VARCHAR(255),
                      type VARCHAR(255),
                      item_id INTEGER REFERENCES item(id),
                      item_count INTEGER
);