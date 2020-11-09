create table adminfields
(
	id serial not null
		constraint fields_pk
			primary key,
	fieldlink varchar,
	fieldrus varchar
);

alter table adminfields owner to postgres;

create unique index fields_id_uindex
	on adminfields (id);

