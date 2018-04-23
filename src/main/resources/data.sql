insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img.png', 'Hobbits')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img2.png', 'Control Intenso')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img3.png', 'Mc Friends')
insert into equipos (id_equipo, logo, nombre) values (nextval('seq_equipo'), 'club-img4.png', 'Rollbacks')

insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Juan Perez', 'juan.perez@banorte.com',8,true, 1)
insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Jose Mendez','juan.perez@banorte.com',10,true, 2)
insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Luis Garcia','juan.perez@banorte.com',9,false, 1)
insert into jugadores (id_jugador,nombre, correo, numero,  es_capitan,id_equipo) values (nextval('seq_jugador'), 'Anselmo Martinez','juan.perez@banorte.com',7,false, 2)

insert into usuarios(id_usuario, correo, clave) values (nextval('seq_usuario'), 'roger.davila.reyna@banorte.com', '1232341234')
insert into roles(id_rol, descripcion) values (nextval('seq_rol'), 'Administrador')
insert into usuarios_roles (id_usuario, id_rol) values (1,1)

insert into partidos (id_partido, fecha, hora, lugar, id_equipo_local, id_equipo_visita) values (nextval('seq_partido'),'2012-09-17','19:00','Cancha 1', 1,2)
insert into resultados (id_resultado, marcador, set, triunfo, id_equipo, id_partido) values (nextval('seq_resultado'),25, 1, true, 1, 1)
