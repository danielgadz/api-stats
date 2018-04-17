insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img.png', 'Hobbits')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img2.png', 'Control Intenso')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img3.png', 'Mc Friends')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img4.png', 'Rollbacks')

insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Juan Perez', 'juan.perez@banorte.com',8,true, 1)
insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Jose Mendez','juan.perez@banorte.com',10,true, 2)
insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Luis Garcia','juan.perez@banorte.com',9,false, 1)
insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Anselmo Martinez','juan.perez@banorte.com',7,false, 2)
