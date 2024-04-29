CREATE TABLE IF NOT EXISTS lab_users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    active INT,
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_type (
    user_type_id SERIAL PRIMARY KEY,
    user_type_description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS lab_roles (
    role_id SERIAL PRIMARY KEY,
    role_description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_roles (
    id SERIAL PRIMARY KEY,
    user_id INT,
    role_id INT
);
truncate table lab_users;
truncate table user_type;
truncate table lab_roles;
truncate table user_roles;
INSERT INTO lab_users (name, active, password)
VALUES 
    ('ABC', 1, 'password123'),
    ('XYZ', 0, 'pass321');

INSERT INTO user_type (user_type_description)
VALUES 
    ('Admin'),
    ('Patient');

INSERT INTO lab_roles (role_description)
VALUES 
    ('Edit'),
    ('view');

INSERT INTO user_roles (user_id, role_id)
VALUES 
    (1, 1),
    (1, 2),
    (2, 2);