create table film
(
    id         serial    not null
        constraint film_pk
            primary key,
    title      text      not null,
    start_date timestamp not null,
    end_date   timestamp not null
);

alter table film
    owner to postgres;

create unique index film_id_uindex
    on film (id);

create table hall
(
    id          serial not null
        constraint hall_pk
            primary key,
    description text
);

alter table hall
    owner to postgres;

create table session
(
    id      serial  not null
        constraint session_pk
            primary key,
    film_id integer not null
        constraint session_film_id_fk
            references film,
    hall_id integer not null
        constraint session_hall_id_fk
            references hall
);

alter table session
    owner to postgres;

create unique index session_id_uindex
    on session (id);

create unique index hall_id_uindex
    on hall (id);

create table employee_position
(
    id          serial not null
        constraint employee_type_pk
            primary key,
    description text   not null
);

alter table employee_position
    owner to postgres;

create table employee
(
    id          serial  not null
        constraint employee_pk
            primary key,
    name        text    not null,
    salary      integer not null,
    hall_id     integer
        constraint employee_hall_id_fk
            references hall,
    position_id integer not null
        constraint employee_employee_position_id_fk
            references employee_position
);

alter table employee
    owner to postgres;

create unique index employee_id_uindex
    on employee (id);

create unique index employee_type_id_uindex
    on employee_position (id);

