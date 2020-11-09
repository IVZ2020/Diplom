create table mainmenu
(
	id serial not null,
	menulink varchar,
	menurus varchar
);

alter table mainmenu owner to postgres;

create unique index menuitems_id_uindex
	on mainmenu (id);

