CREATE TABLE IF NOT EXISTS edifice.parking_place (
	id int8 NOT NULL,
	create_user int8 NULL,
	creation_timestamp timestamp NULL,
	update_timestamp timestamp NULL,
	update_user int8 NULL,
	area float4 NULL,
	parking_place_no varchar(255) NULL,
	building_id int8 NULL,
	CONSTRAINT parking_place_pkey PRIMARY KEY (id)
);

ALTER TABLE edifice.parking_place ADD CONSTRAINT fkemnckmk1s389eilb0u55fegs6 FOREIGN KEY (building_id) REFERENCES edifice.building(id);