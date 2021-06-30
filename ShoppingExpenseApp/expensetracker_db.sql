DROP DATABASE expensetrackerdb;
DROP USER expensetracker;
CREATE USER expensetracker WITH password 'password';
CREATE DATABASE expensetrackerdb with template=template0 owner=expensetracker;
\CONNECT expensetrackerdb;

ALTER DEFAULT PRIVILEGES GRANT ALL ON tables TO expensetracker;
ALTER DEFAULT PRIVILEGES GRANT ALL ON sequences TO expensetracker;

CREATE TABLE et_users(
    user_id INTEGER PRIMARY KEY NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    password text NOT NULL
);

CREATE TABLE et_categories(
    catergory_id INTEGER PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    title VARCHAR(20) NOT NULL,
    description VARCHAR(50) NOT NULL
);

ALTER TABLE et_categories ADD CONSTRAINT cat_users_fk
FOREIGN KEY (user_id) REFERENCES et_users(user_id);

CREATE TABLE et_transactions(
    transaction_id INTEGER PRIMARY KEY NOT NULL,
    catergory_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    amount NUMERIC(10, 2) NOT NULL,
    note VARCHAR(50) NOT NULL,
    transaction_date BIGINT NOT NULL
);

ALTER TABLE et_transactions ADD CONSTRAINT trans_cat_fk
FOREIGN KEY(catergory_id) REFERENCES et_categories(catergory_id);
ALTER TABLE et_transactions ADD CONSTRAINT trans_users_fk
FOREIGN KEY(user_id) REFERENCES et_users(user_id);

CREATE sequenece et_users INCREMENT 1 START 1;
CREATE sequenece et_categories INCREMENT 1 START 1;
CREATE sequenece et_transactions INCREMENT 1 START 1000;
