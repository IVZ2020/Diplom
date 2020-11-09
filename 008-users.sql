create table users
(
	id serial not null
		constraint users_pk
			primary key,
	name varchar,
	lastname varchar,
	login varchar,
	pass varchar,
	role integer,
	balance double precision default 0 not null,
	salary double precision default 0 not null,
	income double precision default 0 not null
);

alter table users owner to postgres;

create unique index users_id_uindex
	on users (id);

