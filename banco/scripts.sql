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
	classificacao boolean,
	gerente_codigo int,
	avaliador_codigo int,
	candidato_email VARCHAR,
	codvaga int,
	FOREIGN KEY (gerente_codigo) REFERENCES Gerente(codigo),
	FOREIGN KEY (avaliador_codigo) REFERENCES Avaliador(codigo),
	FOREIGN KEY (candidato_email) REFERENCES Candidato(email)
);

INSERT INTO CANDIDATO (nome,email,senha) 
VALUES ('Flavio','flavio@gmail.com','flavio');

INSERT INTO CANDIDATO (nome,email,senha) 
VALUES ('Julierme','julierme@gmail.com','1234');

INSERT INTO CANDIDATO (nome,email,senha) 
VALUES ('Aguirre','aguirre@gmail.com','1234');

INSERT INTO GERENTE(nome,codigo)
VALUES ('job','1111');

INSERT INTO AVALIADOR(nome,codigo)
VALUES ('ari','1111');

