CREATE TABLE IF NOT EXISTS edifice.apartment (
	id int8 NOT NULL,
	create_user int8 NULL,
	creation_timestamp timestamp NULL,
	update_timestamp timestamp NULL,
	update_user int8 NULL,
	apartment_no varchar(255) NOT NULL,
	common_area float4 NOT NULL,
	floor varchar(255) NOT NULL,
	full_area float4 NOT NULL,
	entrance_id int8 NULL,
	CONSTRAINT apartment_pkey PRIMARY KEY (id)
);

ALTER TABLE edifice.apartment ADD CONSTRAINT fk86837tl6xqkhjpqfm3av5r459 FOREIGN KEY (entrance_id) REFERENCES edifice.entrance(id)