-- Select database
use user_incentro;

-- Create db_gender_translations
CREATE TABLE IF NOT EXISTS db_gender_translations(
	id bigint auto_increment primary key,
	gender_id bigint null,
	language_id bigint null,
	name varchar(50) null,
	created_at timestamp default current_timestamp not null,
	updated_at timestamp default current_timestamp on update current_timestamp not null,
	deleted_at timestamp null,
	foreign key (gender_id) references db_genders(id),
	foreign key (language_id) references db_languages(id)	
	
)ENGINE=InnoDB;

-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_languages AUTO_INCREMENT = 1;


-- Insert data in db_languages table
INSERT INTO db_gender_translations (gender_id, language_id, name)
VALUES
    (1, 1, "Masculino"),
    (1, 2, "Male"),
    (2, 1, "Femenino"),
    (2,2, "Female");
    
