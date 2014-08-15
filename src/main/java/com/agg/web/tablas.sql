create table salon(
id_salon integer primary key auto_increment,
edificio    varchar(1),
nivel       integer,
numero      integer
);

create table docente(
id_mdocente integer primary key auto_increment,
nombre_docente varchar (50)
);

create table materia(
id_materia integer primary key auto_increment,
id_salon   integer, 
id_mdocente integer,
nombre_materia   varchar(30),
hora_inicio  date,
hora_termino date,
constraint foreign key (id_salon) references salon (id_salon),
constraint foreign key (id_mdocente) references docente (id_mdocente)
);       

