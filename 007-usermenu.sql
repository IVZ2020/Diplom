create table usermenu
(
	id serial not null
		constraint usermenu_pk
			primary key,
	menulink varchar,
	menurus varchar
);

alter table usermenu owner to postgres;

create unique index usermenu_id_uindex
	on usermenu (id);

