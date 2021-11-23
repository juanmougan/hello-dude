CREATE USER test WITH PASSWORD 'password' CREATEDB;

CREATE
DATABASE hello_dude_db
    WITH
    OWNER = username
TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
