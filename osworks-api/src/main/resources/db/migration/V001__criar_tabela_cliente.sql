CREATE SEQUENCE seq_cliente START 1;
create table cliente(
    id bigint not null default nextval('seq_cliente'),
	nome varchar(60) not null,
	email varchar(255) not null,
	telefone varchar(20) not null,
	primary key (id)
);
