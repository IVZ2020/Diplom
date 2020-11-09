create table adminmenu
(
	id serial not null
		constraint adminmenu_pk
			primary key,
	menulink varchar,
	menurus varchar
);

alter table adminmenu owner to postgres;

create unique index adminmenu_id_uindex
	on adminmenu (id);

