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


CREATE TABLE AVALIACAO(
	id SERIAL PRIMARY KEY,
	nota float,
	horario VARCHAR(5),
	local VARCHAR,
	aprovacao boolean,
	gerente_codigo int,
	avaliador_codigo int,
	candidato_email VARCHAR,
	codvaga int,
	FOREIGN KEY (gerente_codigo) REFERENCES Gerente(codigo),
	FOREIGN KEY (avaliador_codigo) REFERENCES Avaliador(codigo),
	FOREIGN KEY (candidato_email) REFERENCES Candidato(email)
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

INSERT INTO AVALIACAO(nota,horario,local,aprovacao,gerente_codigo,
avaliador_codigo,candidato_email,codvaga)
 VALUES (9,'10:30','sousa',false,'1111','1111','flavio@gmail.com',1);


