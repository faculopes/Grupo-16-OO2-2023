insert into bd_grupo16_oo2.user (user.enabled ,user.password, user.username) values (true, "$2a$10$rUZDrIFWyM/Ua2AJXFQV2OZYdb.xQJLL5fh39YPxqmfBQufJm/JqW","usuario1");
insert into bd_grupo16_oo2.user (user.enabled ,user.password, user.username) values (true, "$2a$10$rUZDrIFWyM/Ua2AJXFQV2OZYdb.xQJLL5fh39YPxqmfBQufJm/JqW","usuario2");

insert into bd_grupo16_oo2.user_role (user_role.role, user_role.user_id) values ("ROLE_1", 1) ;
insert into bd_grupo16_oo2.user_role (user_role.role, user_role.user_id) values ("ROLE_2", 2) ;

