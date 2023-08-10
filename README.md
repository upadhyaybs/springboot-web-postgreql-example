
### Postgres set up on your local machine

Create below docker-compose.yml file .

```
version: '3.5'

services:
    postgres:
        container_name: postgres_demo 
        image: postgres:latest
        environment:
            POSTGRES_USER: postgres
            POSTGRES_PASSWORD: Welcome1
            PGDATA: /data/postgres
        volumes:
            - postgres-db:/data/postgres
        ports:
            - "5432:5432"

volumes:
    postgres-db:
        driver: local

```

Once Postgres Docker container is started use DBeaver to connect your Postgresql database.

```
https://dbeaver.io/download/
```

Run the below sql script to create table in your postgres database.

```

CREATE TABLE customer."customer" (
id uuid primary key,
first_name varchar NOT NULL,
last_name varchar NOT NULL,
date_of_birth date NOT NULL,
created_by varchar NOT NULL,
created_on timestamptz NULL,
updated_by varchar NULL,
updated_on timestamptz null
);

```