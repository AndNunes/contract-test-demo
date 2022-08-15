# Aplicação Provider

## Subindo Banco de dados Local com Docker

Siga o passo a passo:

1) Conectar ao MYSQL: `docker exec -it mysql-user bash -l`
2) Entrar com senha: digite: `mysql -u user -p` e entre com a senha: `pass`
3) Entre na base de dados: `use contract`

Rode o comando abaixo:

```
drop table if exists user;

create table user
(
    id int AUTO_INCREMENT,
    name varchar(250) not null,
    profession varchar(250) not null,
    email varchar(250) not null,
    age int not null,
    primary key (id)
);
```