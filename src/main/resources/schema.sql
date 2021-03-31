DROP TABLE IF EXISTS products;
DROP  TABLE IF EXISTS public.authority;
DROP  TABLE IF EXISTS public.users;

CREATE TABLE public.products(
    id SERIAL ,
    description varchar(50),
    price double precision,
    title varchar(50),
    owner   varchar(50),
    PRIMARY KEY (id));

CREATE TABLE public.users(
    id        SERIAL,
    email     varchar(50),
    password  varchar(100),
    username  varchar(50),
    authority varchar(50),
    PRIMARY KEY (id));

CREATE TABLE public.authority(
    id SERIAL,
    name varchar(50),
    user_id bigint,
    PRIMARY KEY (id),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
             REFERENCES users(id));