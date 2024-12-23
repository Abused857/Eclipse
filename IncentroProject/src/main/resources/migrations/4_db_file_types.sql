-- Select database
use user_incentro;

-- Create db_file_types
CREATE TABLE IF NOT EXISTS db_file_types(
	id bigint auto_increment primary key,
	name varchar(50) null,
	extensions text null,
	max_size bigint null,
	created_at timestamp default current_timestamp not null,
	updated_at timestamp default current_timestamp on update current_timestamp not null,
	deleted_at timestamp null
	
)ENGINE=InnoDB;

-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_file_types AUTO_INCREMENT = 1;


-- Insert data in db_languages table
INSERT INTO db_file_types (name, extensions, max_size)
VALUES
    ("image", "|jpg||jpeg||gif||png|", 10240),
    ("pdf", "|pdf|", 20480),
    ("video", "|mp4|", 102400),
    ("word", "|doc||docx|", 20480),
    ("excel", "|xls||xlsx|", 20480);
    
