# Aplicação PRovider

## Subindo Banco de dados Local com Docker

Siga o passo a passo:

1) Conectar ao MYSQL: docker exec -it mysql-user bash -l
2) Entrar com senha: digite: mysql -u user -p e entre com a senha: pass
3) Entre na base de dados: use contract

Rode o comando abaixo:

```
drop table if exists user;

create table user
(
    name varchar(250) not null,
    cpf varchar(11) not null,
    profession varchar(250) not null,
    primary key (cpf)
);
```