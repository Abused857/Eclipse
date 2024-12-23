-- Select database
use user_incentro;

-- Create db_files
CREATE TABLE IF NOT EXISTS db_modules (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NULL,
    `order` INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP NULL
) ENGINE=InnoDB;


-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_modules AUTO_INCREMENT = 1;

-- Insert data in db_languages table
INSERT INTO db_modules (name, `order`)
VALUES
	("Control Panel", 100);