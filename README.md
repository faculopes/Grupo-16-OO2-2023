# Grupo-16-OO2-2023
TP cuatrimestral Objetos 2.
Trabajo terminado en la Rama "Main".
----------------------------------------------------------
DATOS USUARIO PARA INGRESAR A LA WEB:

Usuario: usuario1  Contraseña: contra Rol: Administrador.

Usuario: usuario2 Contraseña: contra Rol: Auditor.

--------------------------------------------------------

PARA INSERCION DE DATOS NECESARIOS EN BD:

La primera vez que se corre el proyecto, en application.properties configurar spring.jpa.hibernate.ddl-auto en create.
Luego configurar con update para que no borren los registros ingresados.
Los insert necesarios ya estan en el import.sql

--------------------------------------------------------
En caso de querer replicar los eventos tal como se muestra en los videos se deben ejecutar las siguientes Query's.

Dispositivo Temperatura:

-INSERT INTO `bd_grupo16_oo2`.`medicion_temperatura` (`fecha_hora`, `procesado`, `temperatura`, `dispositivo_temperatura_id`) VALUES ('2023-06-20 15:44:19', false, 90, 1);

-INSERT INTO `bd_grupo16_oo2`.`medicion_temperatura` (`fecha_hora`, `procesado`, `temperatura`, `dispositivo_temperatura_id`) VALUES ('2023-06-20 15:44:19', false, 30, 1);

-INSERT INTO `bd_grupo16_oo2`.`medicion_temperatura` (`fecha_hora`, `procesado`, `temperatura`, `dispositivo_temperatura_id`) VALUES ('2023-06-20 15:44:19', false, 180, 1);

-INSERT INTO `bd_grupo16_oo2`.`medicion_temperatura` (`fecha_hora`, `procesado`, `temperatura`, `dispositivo_temperatura_id`) VALUES ('2023-06-20 15:44:19', false, 60, 1);

Dispositivo Luces Automaticas:

-- SE APAGAN LAS LUCES (no hay personas, hay luz natural, luces prendidas)

insert into bd_grupo16_oo2.medicion_luces_automaticas (medicion_luces_automaticas.fecha_hora, medicion_luces_automaticas.hay_personas,
medicion_luces_automaticas.hay_luz_natural, medicion_luces_automaticas.luces_prendidas, medicion_luces_automaticas.procesado,medicion_luces_automaticas.dispositivo_luces_automaticas_id) values
('2023-06-20 16:06:05', false, true, true,false, 1);

-- SE PRENDIERON LAS LUCES (hay personas, no hay luz natural, las luces estan apagadas)

insert into bd_grupo16_oo2.medicion_luces_automaticas (medicion_luces_automaticas.fecha_hora, medicion_luces_automaticas.hay_personas,
medicion_luces_automaticas.hay_luz_natural, medicion_luces_automaticas.luces_prendidas, medicion_luces_automaticas.procesado,medicion_luces_automaticas.dispositivo_luces_automaticas_id) values
('2023-06-20 17:06:05', true, false, false,false, 1);

-- NO CREA EVENTO (no hay presonas, hay luz natural, luces apagadas)
insert into bd_grupo16_oo2.medicion_luces_automaticas (medicion_luces_automaticas.fecha_hora, medicion_luces_automaticas.hay_personas,
medicion_luces_automaticas.hay_luz_natural, medicion_luces_automaticas.luces_prendidas, medicion_luces_automaticas.procesado,medicion_luces_automaticas.dispositivo_luces_automaticas_id) values
('2023-06-20 08:30:00', false, true, false,false, 3);

Dispositivo Cortina:

- INSERT INTO `bd_grupo16_oo2`.`medicion_cortina` (`fecha_hora`, `hora`, `procesado`, `dispositivo_cortina_id`) VALUES ('2023-06-22 09:01:00', '09:01:00', false, 1);

- INSERT INTO `bd_grupo16_oo2`.`medicion_cortina` (`fecha_hora`, `hora`,`procesado`, `dispositivo_cortina_id`) VALUES ('2023-06-22 23:01:00', '23:01:00', false, 1);

-

-

Dispositivo Alumbrado:

-

-

-

-

-------------------------------------------------

