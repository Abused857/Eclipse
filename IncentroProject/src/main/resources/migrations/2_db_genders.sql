-- Select database
use user_incentro;

-- Create db_genders table
CREATE TABLE IF NOT EXISTS db_genders (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
	deleted_at TIMESTAMP NULL
)ENGINE=InnoDB;

-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_genders AUTO_INCREMENT = 1;

-- Insert data in db_genders table
INSERT INTO db_genders (id)
VALUES
	(1),
	(2);