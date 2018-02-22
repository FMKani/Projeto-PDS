create table Usuario(
	email varchar(60),
    senha varchar(60) NOT NULL,
    
    nome varchar(200) NOT NULL,
    sexo char(1),
    nascimento date,
    
    CONSTRAINT USUARIO_PK PRIMARY KEY(email)  
);

create table Movimentacao(
    cod int,
    usuario varchar(60) references Usuario(email),
	descricao varchar(250),
    valor numeric(10,2) NOT NULL,
    
    data date,
    tipo varchar(50),
    categoria varchar(50),
    
    CONSTRAINT MOVIMENTACAO_PK PRIMARY KEY(cod)
)
