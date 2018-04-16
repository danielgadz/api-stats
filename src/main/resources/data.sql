insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), '/TMP/LOGO.PNG', 'MI PRIMER EQUIPO')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), '/TMP/LOGO2.PNG', 'MI SEGUNDO EQUIPO')

insert into jugadores (id_jugador,nombre, edad, peso, numero, estatura, es_capitan,id_equipo) values (nextval('seq_jugador'), 'Juan Perez', 23, 70,8,1.70,true, 1)
insert into jugadores (id_jugador,nombre, edad, peso, numero, estatura, es_capitan,id_equipo) values (nextval('seq_jugador'), 'Jose Mendez', 28, 73,10,1.75,true, 2)
insert into jugadores (id_jugador,nombre, edad, peso, numero, estatura, es_capitan,id_equipo) values (nextval('seq_jugador'), 'Luis Garcia', 26, 75,9,1.73,false, 1)
insert into jugadores (id_jugador,nombre, edad, peso, numero, estatura, es_capitan,id_equipo) values (nextval('seq_jugador'), 'Anselmo Martinez', 27, 74,7,1.80,false, 2)
