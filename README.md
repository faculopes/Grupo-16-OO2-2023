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

-

-

-

-

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

