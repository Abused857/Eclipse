-- Select database
use user_incentro;

-- Create db_languages table
CREATE TABLE IF NOT EXISTS db_languages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    abbreviation VARCHAR(10) NULL,
    flag VARCHAR(50) NULL,
    `order` INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP NULL
)ENGINE=InnoDB;

-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_languages AUTO_INCREMENT = 1;


-- Insert data in db_languages table
INSERT INTO db_languages (name, abbreviation, flag, `order`)
VALUES
    ('spanish', 'ES', 'spanish.gif', 100),
    ('english', 'EN', 'english.gif', 99);
    
  