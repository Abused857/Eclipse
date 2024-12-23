-- Select database
use user_incentro;

-- Create db_files
CREATE TABLE IF NOT EXISTS db_files (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NULL,
    size DECIMAL(20, 5) NULL,
    mimetype VARCHAR(50) NULL,
    url TEXT NULL,
    type_id bigint null,
    private BOOLEAN DEFAULT 0,
    gallery BOOLEAN DEFAULT 1,
    date DATETIME NULL,
    `order` INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP NULL,
    FOREIGN KEY (type_id) REFERENCES db_file_types(id) -- Link db_file_types
) ENGINE=InnoDB;


-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_files AUTO_INCREMENT = 1;

