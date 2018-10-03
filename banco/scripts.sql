CREATE TABLE CANDIDATO(
	nome VARCHAR,
	email VARCHAR PRIMARY KEY,
	senha VARCHAR,	
	curriculo VARCHAR
);

CREATE TABLE AVALIADOR(
	nome VARCHAR,
	codigo int PRIMARY KEY
);

CREATE TABLE GERENTE(
	nome VARCHAR,
	codigo int PRIMARY KEY
);


INSERT INTO CANDIDATO (nome,email,senha,curriculo) 
VALUES ('Flavio','flavio@gmail.com','1234','curriculo1');

INSERT INTO CANDIDATO (nome,email,senha,curriculo) 
VALUES ('Julierme','julierme@gmail.com','1234','curriculo2');

INSERT INTO CANDIDATO (nome,email,senha,curriculo) 
VALUES ('Aguirre','aguirre@gmail.com','1234','curriculo3');


INSERT INTO GERENTE(nome,codigo)
VALUES ('Gerente1','1111');

INSERT INTO AVALIADOR(nome,codigo)
VALUES ('Avaliador1','1111');




