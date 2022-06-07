CREATE TABLE IF NOT EXISTS edifice.entrance (
	id int8 NOT NULL,
	create_user int8 NULL,
	creation_timestamp timestamp NULL,
	update_timestamp timestamp NULL,
	update_user int8 NULL,
	entrance_no varchar(255) NOT NULL,
	building_id int8 NULL,
	CONSTRAINT entrance_pkey PRIMARY KEY (id)
);

ALTER TABLE edifice.entrance ADD CONSTRAINT fkmh9bo2cy9ygk4383y6gdy5ocd FOREIGN KEY (building_id) REFERENCES edifice.building(id);