DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS waste_entries;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS partners;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS leaderboard;

INSERT INTO users (full_name, email, password_hash, role, school_name) VALUES
('EcoSphere Admin', 'admin@ecosphere.ai', '$2a$10$X3nAKBX0/iE8vD5Nw7wD5uG7uY0E0lR0m4mRFXe2c4vT4p8t7K0a', 'ADMIN', 'GIIS Whitefield');

INSERT INTO waste_entries (item_type, category, weight, condition, serial_number, qr_id, collection_date, student_name, class_name, collection_point, status) VALUES
('Laptop Motherboard', 'Electronics', 2.5, 'Good', 'SER-1001', 'EW-1001', '2026-10-01', 'Aarav Singh', '10A', 'STEM Lab', 'Received'),
('Battery Pack', 'Power', 1.2, 'Moderate', 'SER-1002', 'EW-1002', '2026-10-05', 'Meera Nair', '9B', 'Science Block', 'Sorted'),
('Motor', 'Mechanics', 0.8, 'Good', 'SER-1003', 'EW-1003', '2026-10-09', 'Kabir Shah', '11C', 'Innovation Hub', 'Repurposed');

INSERT INTO projects (title, description, category, materials_used, recovered_components, mentor, status) VALUES
('RC Car Prototype', 'A compact re-engineered vehicle using recovered motors and battery packs.', 'Mobility', 'Recovered motor, battery, chassis', 'Motor, battery', 'Mr. Kumar', 'Prototype'),
('Solar Bank', 'A sustainable portable charging setup built from recovered electronic parts.', 'Sustainability', 'Battery, circuit board', 'Battery, motherboard', 'Ms. Sharma', 'Approved');

INSERT INTO partners (name, type, focus_area, sector) VALUES
('Lenovo', 'Corporate Partner', 'Circular technology and recovery analytics', 'Technology'),
('Dell', 'Corporate Partner', 'Hardware, software and AI literacy', 'Technology'),
('Honda', 'Corporate Partner', 'Mobility systems and RC challenges', 'Mobility');

INSERT INTO events (name, type, attendance, hours, impact, date) VALUES
('E-Waste Collection Drive', 'Workshop', 120, 4, 'Recovered 160 kg', '2026-10-14'),
('STEM Maker Lab', 'Workshop', 80, 3, 'Built 7 prototypes', '2026-10-18');

INSERT INTO leaderboard (student_name, class_name, points, badge) VALUES
('Aarav Singh', '10A', 840, 'Eco Warrior'),
('Meera Nair', '9B', 790, 'Sustainability Ambassador'),
('Kabir Shah', '11C', 905, 'Innovation Leader');
