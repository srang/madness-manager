ALTER TABLE users CHANGE name first_name VARCHAR(255);
ALTER TABLE users ADD COLUMN last_name VARCHAR(255) AFTER first_name;
