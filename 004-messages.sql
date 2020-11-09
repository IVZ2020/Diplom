create table messages
(
	id serial not null
		constraint messages_pk
			primary key,
	messagerus varchar,
	messageeng varchar
);

alter table messages owner to postgres;

create unique index messages_id_uindex
	on messages (id);

