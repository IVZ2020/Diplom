create table mainmenuwithauth
(
	id serial not null
		constraint mainmenuwithauth_pk
			primary key,
	menulink varchar,
	menurus varchar
);

alter table mainmenuwithauth owner to postgres;

create unique index mainmenuwithauth_id_uindex
	on mainmenuwithauth (id);

