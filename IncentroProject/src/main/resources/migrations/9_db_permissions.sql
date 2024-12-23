-- Select database
use user_incentro;

-- Create db_files
CREATE TABLE IF NOT EXISTS db_permissions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    module_id bigint default null,
    name VARCHAR(50) default NULL,
    description varchar(255) default null,
    `order` INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP NULL,
    foreign key (module_id) references db_modules(id)
) ENGINE=InnoDB;


-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_permissions AUTO_INCREMENT = 1;

-- Insert data in db_languages table
INSERT INTO db_permissions (id, module_id, name, `order`)
VALUES
	(1,1, 'Developer', 100),
	(2,1, 'Access to Control Panel', 100);