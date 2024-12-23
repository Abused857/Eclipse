-- Select database
use user_incentro;

-- Create db_settings
create table if not exists db_settings(
	id bigint auto_increment primary key,
	company_id bigint default null,
	name varchar(50) default null,
	value varchar(50) default null,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP NULL,
    foreign key (company_id) references db_companies(id)
)ENGINE = innoDB;

-- Set initial AUTO_INCREMENT value at 1
ALTER TABLE db_settings AUTO_INCREMENT = 1;

-- Insert data in db_languages table
INSERT INTO db_settings (name, value)
VALUES
    ("maximum_failed_access", 5),
    ("token_validate", 30),
    ("recover_token_validate", 60),
    ("time_bloqued_password", 60),
    ("language_default_id", 2),
    ("currency_default_id", null),
    ("email_host_default", 'change this'),
    ("email_username_default", 'change this'),
    ("email_from_default", 'change this'),
    ("email_system_copy", ''),
    ("email_driver_default", 'smtp'),
    ("email_port_default", 25),
    ("email_encryption_default", ''),
    ("name_client", 'change this'),
    ("base_path_protocol", 'http://'),
    ("base_path_system", 'beehub.loc'),
    ("base_path_www", ''),
    ("send_slack_error", 0),
    ("slack_webhook_default", ''),
    ("slack_channel_error", '');
    
    