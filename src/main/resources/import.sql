INSERT INTO clientes (nombre, apellidos, correo, identificacion) VALUES ('jhon', 'Meza','jhon@gmail.com', '123456789' );
INSERT INTO clientes (nombre, apellidos, correo, identificacion) VALUES ('juan', 'castro','juan@gmail.com', '424245354' );
INSERT INTO clientes (nombre, apellidos, correo, identificacion) VALUES ('pedro', 'peres','pedro@gmail.com', '41752857' );
INSERT INTO clientes (nombre, apellidos, correo, identificacion) VALUES ('luis', 'ramos','luis@gmail.com', '78625218' );
INSERT INTO clientes (nombre, apellidos, correo, identificacion) VALUES ('sergio', 'gonzales','sergio@gmail.com', '78278556' );


INSERT INTO aerolineas (nombre) VALUES ('latam');
INSERT INTO aerolineas (nombre) VALUES ('CanaryFly');
INSERT INTO aerolineas (nombre) VALUES ('Avianca');
INSERT INTO aerolineas (nombre) VALUES ('ATSA');


INSERT INTO aeropuerto (nombre, iata, ubicacion) VALUES ('jorge chavez', 'lim','peru' );
INSERT INTO aeropuerto (nombre, iata, ubicacion) VALUES ('Adolfo Suárez', 'mad','espania' );
INSERT INTO aeropuerto (nombre, iata, ubicacion) VALUES ('Internacional de la Ciudad de México', 'mex','mexico' );
INSERT INTO aeropuerto (nombre, iata, ubicacion) VALUES ('	Comandante Espora', 'bhi','argentina' );


INSERT INTO vuelos (numero_vuelo, fecha_llegada, fecha_salida,id_aerolinea,aeropuerto_origen,aeropuerto_destino) VALUES ('AV1234', '2022-01-01 12:00:00','2022-01-01 12:00:00', 2, 1, 2 );
INSERT INTO vuelos (numero_vuelo, fecha_llegada, fecha_salida,id_aerolinea,aeropuerto_origen,aeropuerto_destino) VALUES ('TR4567', '2022-01-01 12:00:00','2022-01-01 12:00:00', 2, 3, 4  );
INSERT INTO vuelos (numero_vuelo, fecha_llegada, fecha_salida,id_aerolinea,aeropuerto_origen,aeropuerto_destino) VALUES ('QP1594', '2022-01-01 12:00:00','2022-01-01 12:00:00', 3, 1, 2 );