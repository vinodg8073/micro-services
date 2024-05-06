CREATE TABLE IF NOT EXISTS lab_users (
    user_id  SERIAL PRIMARY KEY,
    name VARCHAR(255),
    active INT,
    password VARCHAR(255),
    user_type_id INT
);

CREATE TABLE IF NOT EXISTS user_type (
    user_type_id SERIAL PRIMARY KEY,
    user_type_description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS lab_roles (
    role_id  SERIAL PRIMARY KEY,
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_roles (
    id  SERIAL PRIMARY KEY,
    user_id INT,
    role_id INT
);

-- truncate table lab_users;
-- truncate table user_type;
-- truncate table lab_roles;
-- truncate table user_roles;

-- INSERT INTO lab_users (user_id, name, active, password)
-- VALUES 
--     (1,'ABC', 1, 'password123'),
--     (2, 'XYZ', 0, 'pass321')
--     ON CONFLICT (user_id) do update  SET
--      name = EXCLUDED.name,
--     active = EXCLUDED.active,
--     password = EXCLUDED.password;

-- INSERT INTO user_type (user_type_id, user_type_description)
-- VALUES 
--     (1,'Admin'),
--     (2,'Patient')
-- ON CONFLICT (user_type_id) DO UPDATE 
-- SET 
--     user_type_description = EXCLUDED.user_type_description;


-- INSERT INTO lab_roles (role_id,role)
-- VALUES 
--     (1,'Edit'),
--     (2,'view')
-- ON CONFLICT (role_id) DO UPDATE 
-- SET 
--     role = EXCLUDED.role;
   
-- INSERT INTO user_roles (id ,user_id, role_id)
-- VALUES 
--     (1,1, 1),
--     (2,1, 2),
--     (3,2, 2)
--     on conflict (id) do update set 
--     user_id = EXCLUDED.user_id,
--     role_id  = EXCLUDED.role_id;