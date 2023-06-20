DROP TABLE IF EXISTS member_group;
DROP TABLE IF EXISTS group_event;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS event;


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
	duration int CHECK (duration > 30) not null,
	group_running_event varchar (64) not null
	
	
);

CREATE TABLE group_event (
	group_id bigint not null,
	event_id bigint not null,
	
	CONSTRAINT pk_group_event PRIMARY KEY (group_id,event_id),
	
	CONSTRAINT fk_interest_group
	FOREIGN KEY (group_id)
	REFERENCES interest_group (group_id),
	
	CONSTRAINT fk_event
	FOREIGN KEY (event_id)
	REFERENCES event (event_id)
);

CREATE TABLE member_group (
	group_id bigint not null,
	member_id bigint not null,
	
	CONSTRAINT pk_member_group PRIMARY KEY (group_id,member_id),
	
	CONSTRAINT fk_member
	FOREIGN KEY (member_id)
	REFERENCES member (member_id),
	
	CONSTRAINT fk_group
	FOREIGN KEY (group_id)
	REFERENCES interest_group (group_id)
);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Thad','Osburn','123Sesame@Street.com','01-01-1999',true);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Doc','Dwarf','docdwarf@forest.com','01-02-1999',false);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Sleepy','Dwarf','sleepydwarf@forest.com','01-03-1999',true);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Dopey','Dwarf','dopeydwarf@forest.com','01-04-1999',true);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Grumpy','Dwarf','grumpydwarf@forest.com','01-05-1999',false);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Happy','Dwarf','happydwarf@forest.com','01-06-1999',true);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Bashful','Dwarf','bashfuldwarf@forest.com','01-07-1999',true);
INSERT INTO member (first_name,last_name,email,date_of_birth,reminder_email) 
VALUES ('Sneezy','Dwarf','sneezydwarf@forest.com','01-08-1999',false);


INSERT INTO interest_group (group_name)
VALUES ('Weeny Hut Jr');
INSERT INTO interest_group (group_name)
VALUES ('Weeny Hut General');
INSERT INTO interest_group (group_name)
VALUES ('Weeny Hut Tech Elevator');

INSERT INTO event (event_name, description, start_date, start_time, duration, group_running_event)
VALUES('Summoning The Great Lord, Cthulu', 'We Shall Summon The Great One', '06-28-2023', NOW(), 60, 'Weeny Hut Tech Elevator');
INSERT INTO event (event_name, description, start_date, start_time, duration, group_running_event)
VALUES('Drink Til Ya Drop','We Are Gonna Drink Till We Drop. Forget The Pain','06-20-2023', NOW(),100,'Weeny Hut Tech Elevator');
INSERT INTO event (event_name, description, start_date, start_time, duration, group_running_event)
VALUES('Torture Parker Fun Time!','We are gonna torture Parker by strapping him to a chair and forcing him to watch 1000 hours of Teeth','06-30-2023',NOW(),1000,'Weeny Hut Tech Elevator');
INSERT INTO event (event_name, description, start_date, start_time, duration, group_running_event)
VALUES('Nap Time','Enjoy Nap Time','06-20-2023',NOW(),35,'Weeny Hut Jr');

INSERT INTO member_group(member_id,group_id)
VALUES ((SELECT member_id FROM member WHERE first_name = 'Thad'),(SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Tech Elevator'));
INSERT INTO member_group(member_id,group_id)
VALUES ((SELECT member_id FROM member WHERE first_name = 'Grumpy'),(SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Tech Elevator'));
INSERT INTO member_group(member_id,group_id)
VALUES ((SELECT member_id FROM member WHERE first_name = 'Doc'),(SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Jr'));
INSERT INTO member_group(member_id,group_id)
VALUES ((SELECT member_id FROM member WHERE first_name = 'Sleepy'),(SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut General'));
INSERT INTO member_group(member_id,group_id)
VALUES ((SELECT member_id FROM member WHERE first_name = 'Happy'),(SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Jr'));
INSERT INTO member_group(member_id,group_id)
VALUES ((SELECT member_id FROM member WHERE first_name = 'Sneezy'),(SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut General'));

INSERT INTO group_event (group_id,event_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Tech Elevator'),(SELECT event_id FROM event WHERE event_name = 'Torture Parker Fun Time!'));
INSERT INTO group_event (group_id,event_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Tech Elevator'),(SELECT event_id FROM event WHERE event_name = 'Summoning The Great Lord, Cthulu'));
INSERT INTO group_event (group_id,event_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut Jr'),(SELECT event_id FROM event WHERE event_name = 'Drink Til Ya Drop'));
INSERT INTO group_event (group_id,event_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Weeny Hut General'),(SELECT event_id FROM event WHERE event_name = 'Nap Time'));


SELECT * FROM member
