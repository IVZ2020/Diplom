create table roles
(
	role varchar not null,
	id serial not null
		constraint roles_pk
			primary key
);

alter table roles owner to postgres;

create unique index roles_id_uindex
	on roles (id);

create unique index roles_role_uindex
	on roles (role);

