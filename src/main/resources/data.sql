CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    school_name VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (full_name, email, password_hash, role, school_name) VALUES
('EcoSphere Admin', 'admin@ecosphere.ai', '$2a$10$X3nAKBX0/iE8vD5Nw7wD5uG7uY0E0lR0m4mRFXe2c4vT4p8t7K0a', 'ADMIN', 'GIIS Whitefield')
ON CONFLICT (email) DO NOTHING;
