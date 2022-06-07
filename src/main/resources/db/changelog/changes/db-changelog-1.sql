CREATE TABLE IF NOT EXISTS edifice.building (
	id int8 NOT NULL,
	create_user int8 NULL,
	creation_timestamp timestamp NULL,
	update_timestamp timestamp NULL,
	update_user int8 NULL,
	block_no varchar(255) NOT NULL,
	city varchar(255) NOT NULL,
	district varchar(255) NOT NULL,
	floors int4 NOT NULL,
	street varchar(255) NOT NULL,
	street_no varchar(255) NOT NULL,
	CONSTRAINT building_pkey PRIMARY KEY (id),
	CONSTRAINT uk_hf0jd2vbp1ftyx4pr8wop95yo UNIQUE (block_no),
	CONSTRAINT ukdj96b87s9ol3soijhx1bnr9bx UNIQUE (city, district, block_no)
);