insert into bd_grupo16_oo2.user (user.enabled ,user.password, user.username) values (true, "$2a$10$rUZDrIFWyM/Ua2AJXFQV2OZYdb.xQJLL5fh39YPxqmfBQufJm/JqW","usuario1");
insert into bd_grupo16_oo2.user (user.enabled ,user.password, user.username) values (true, "$2a$10$rUZDrIFWyM/Ua2AJXFQV2OZYdb.xQJLL5fh39YPxqmfBQufJm/JqW","usuario2");

insert into bd_grupo16_oo2.user_role (user_role.role, user_role.user_id) values ("ROLE_1", 1) ;
insert into bd_grupo16_oo2.user_role (user_role.role, user_role.user_id) values ("ROLE_2", 2) ;

insert into bd_grupo16_oo2.zona (zona.nombre) values ("Edificio Jose Hernandez") ;
insert into bd_grupo16_oo2.zona (zona.nombre) values ("Edificio Juana Manso") ;
insert into bd_grupo16_oo2.zona (zona.nombre) values ("Edificio Arturo Jauterche") ;
insert into bd_grupo16_oo2.zona (zona.nombre) values ("Edificio Manuel Ugarte") ; 

