BEGIN TRANSACTION;

DROP TABLE IF EXISTS offer, account, bartertown_user, offer_status;
DROP SEQUENCE IF EXISTS seq_user_id, seq_account_id, seq_offer_id;

CREATE TABLE offer_status (
	offer_status_id serial primary key,
	offer_status_desc varchar(10) NOT NULL
);

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE bartertown_user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(20),
	CONSTRAINT PK_bartertown_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE SEQUENCE seq_account_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;

CREATE TABLE account (
	account_id int NOT NULL DEFAULT nextval('seq_account_id'),
	user_id int NOT NULL,
	barter_credits int DEFAULT 0,
	CONSTRAINT PK_account PRIMARY KEY (account_id),
	CONSTRAINT FK_account_bartertown_user FOREIGN KEY (user_id) REFERENCES bartertown_user (user_id)
);

CREATE SEQUENCE seq_offer_id
  INCREMENT BY 1
  START WITH 3001
  NO MAXVALUE;

CREATE TABLE offer (
	offer_id int NOT NULL DEFAULT nextval('seq_offer_id'),
	offer_status_id int NOT NULL,
	account_from int NOT NULL,
	account_to int NOT NULL,
	item varchar(255) NOT NULL,
	CONSTRAINT PK_offer PRIMARY KEY (offer_id),
	CONSTRAINT FK_offer_account_from FOREIGN KEY (account_from) REFERENCES account (account_id),
	CONSTRAINT FK_offer_account_to FOREIGN KEY (account_to) REFERENCES account (account_id),
	CONSTRAINT FK_offer_status FOREIGN KEY (offer_status_id) REFERENCES offer_status (offer_status_id),
	CONSTRAINT CK_offer_not_same_account CHECK (account_from <> account_to)
);

INSERT INTO offer_status (offer_status_desc) VALUES ('Pending'); -- 1
INSERT INTO offer_status (offer_status_desc) VALUES ('Accepted'); -- 2
INSERT INTO offer_status (offer_status_desc) VALUES ('Rejected'); -- 3

-- User ids start at 1001
INSERT INTO bartertown_user (username,password_hash,role) VALUES ('user1','user1','ROLE_USER'); -- 1001
INSERT INTO bartertown_user (username,password_hash,role) VALUES ('user2','user2','ROLE_USER'); -- 1002
INSERT INTO bartertown_user (username,password_hash,role) VALUES ('user3','user3','ROLE_USER'); -- 1003

-- Account ids start at 2001
INSERT INTO account (user_id, barter_credits) VALUES (1001, 10); -- 2001
INSERT INTO account (user_id, barter_credits) VALUES (1002, 10); -- 2002
INSERT INTO account (user_id, barter_credits) VALUES (1003, 0);  -- 2003 (cannot receive an item until they send one)

-- Offer ids start at 3001
INSERT INTO offer (offer_status_id, account_from, account_to, item)
VALUES (2, 2001, 2002, 'TEST_ITEM_1'); -- 3001
INSERT INTO offer (offer_status_id, account_from, account_to, item)
VALUES (2, 2002, 2001, 'TEST_ITEM_2'); -- 3002

COMMIT TRANSACTION;
