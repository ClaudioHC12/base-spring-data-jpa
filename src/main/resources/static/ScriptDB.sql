DROP DATABASE IF EXISTS shop_center;
CREATE DATABASE shop_center;

DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente(
	id_cliente SERIAL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	email VARCHAR(40) NOT NULL,
	ciudad VARCHAR(40) NULL,
	colonia VARCHAR(40) NULL,
	calle VARCHAR(40) NULL,
	numero VARCHAR(40) NULL
);
select * from cliente;

DROP TABLE IF EXISTS gerente;
CREATE TABLE gerente(
	id_gerente SERIAL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30) NOT NULL
);
select * from gerente;

DROP TABLE IF EXISTS local;
CREATE TABLE local(
	id_local SERIAL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	piso VARCHAR(30) NOT NULL,
	id_gerente INTEGER UNIQUE NOT NULL REFERENCES gerente(id_gerente)
);
select * from local;

DROP TABLE IF EXISTS orden;
CREATE TABLE orden(
	id_orden SERIAL PRIMARY KEY,
	descripcion VARCHAR(30) NOT NULL,
	precio DECIMAL(10,2) NOT NULL,
	id_local INTEGER NOT NULL REFERENCES local(id_local)
);
select * from orden;

select * from local;

select * from cliente;

DROP TABLE IF EXISTS local_cliente;
CREATE TABLE local_cliente(
	id_local INTEGER NOT NULL REFERENCES local(id_local),
	id_cliente INTEGER NOT NULL REFERENCES cliente(id_cliente),
	PRIMARY KEY(id_local, id_cliente)
);
INSERT INTO local_cliente(id_local, id_cliente) VALUES(1, 1);

INSERT INTO gerente(nombre, apellido) VALUES('gerente q', 'q')

SELECT * FROM local_cliente;

TRUNCATE TABLE cliente RESTART IDENTITY;