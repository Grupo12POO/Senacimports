create database loja;
use loja;

create table cliente(
id_cliente varchar(50),
nome varchar(200),
cep varchar(50),
cpf varchar(50));

create table senac_imports(
id_item varchar(50),
produto varchar(50),
quantidade int(250),
preço varchar(5));

drop table senac_imports;
delete from cliente where id_cliente=19;

INSERT INTO cliente (id_cliente, nome, cep, cpf) VALUES(19, 23213, 87297, 63263891);
INSERT INTO senac_imports (id_item, produto, quantidade, preço) VALUES(?,?,?,?);
select*from cliente;
select*from senac_imports;
