DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;

CREATE TABLE person (
	person_id serial primary key,
	fullname varchar(128) not null,
	added_date date DEFAULT CURRENT_DATE
);

CREATE TABLE address (
	address_id serial primary key,
	line_one varchar(255) not null,
	line_two varchar(255),
	city varchar(36) not null,
	district varchar(60) not null,
	postal_code varchar(24),
	country_code char(3)	
);

CREATE TABLE person_address (
	person_id bigint not null,
	address_id bigint not null,
	type varchar(16) not null,
	type_description varchar(255),
	
	CONSTRAINT pk_person_address PRIMARY KEY (person_id, address_id),
	CONSTRAINT fk_person_person_address FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_address_person_address FOREIGN KEY (address_id) REFERENCES address(address_id),
	
	CONSTRAINT ck_address_type CHECK (type IN ('Home', 'Billing', 'Other')),
	CONSTRAINT ck_address_type_description CHECK ( (type = 'Other' AND type_description IS NOT NULL) 
												 OR (type != 'Other' AND type_description IS NULL) ) 
);

