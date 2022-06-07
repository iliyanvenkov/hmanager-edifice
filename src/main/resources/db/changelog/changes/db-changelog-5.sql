CREATE TABLE IF NOT EXISTS edifice.householder (
	id int8 NOT NULL,
	create_user int8 NULL,
	creation_timestamp timestamp NULL,
	update_timestamp timestamp NULL,
	update_user int8 NULL,
	address varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	full_name varchar(255) NOT NULL,
	phone varchar(255) NOT NULL,
	type_owner varchar(255) NOT NULL,
	building_id int8 NULL,
	CONSTRAINT owner_pkey PRIMARY KEY (id)
);

ALTER TABLE edifice.householder ADD CONSTRAINT fkacdq539thtgs6mw9fepkknnvc FOREIGN KEY (building_id) REFERENCES edifice.building(id);