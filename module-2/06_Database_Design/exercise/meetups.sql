DROP TABLE IF EXISTS group_event;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS interest_group;


CREATE TABLE member (
	member_id serial primary key,
	first_name varchar(64) not null,
	last_name varchar(64) not null,
	email varchar(128) not null,
	phone_number varchar(60),
	date_of_birth varchar(10) not null,
	reminder_email boolean DEFAULT false
);

CREATE TABLE interest_group (
	group_id serial primary key,
	group_name varchar(64)
);

CREATE TABLE event (
	event_id serial primary key,
	event_name varchar(128) not null,
	description varchar(300) not null,
	start_date date DEFAULT CURRENT_DATE not null,
	start_time time DEFAULT CURRENT_TIME not null,
	duration int not null,
	group_running_event varchar (64) not null
);

CREATE TABLE group_event (
	group_id bigint not null
	event_id bigint not null
);

CREATE TABLE member_event (
	group_id bigint not null
	member_id bigint not null
);

