-- Select database
use user_incentro;

-- Create db_companies
CREATE TABLE IF NOT EXISTS db_companies (
	id bigint auto_increment primary key,
	name varchar(50) default null,
	short_description text default null,
	description longtext default null,
	url varchar(255) default null,
	email varchar(255) default null,
	contact_person varchar(50) default null,
	date_start datetime default null,
	date_end datetime default null,
	image_id bigint default null,
	social_login_google boolean default 0,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP NULL,
	foreign key (image_id) references db_files(id)
   
) ENGINE=InnoDB;

-- Add company_id into db_files after type_id
ALTER TABLE db_files
    ADD COLUMN company_id BIGINT NULL AFTER type_id,
    ADD CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES db_companies(id) ON DELETE SET NULL;



-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_companies AUTO_INCREMENT = 1;


