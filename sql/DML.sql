INSERT INTO T_USUARIO (cd_usuario,cd_login,cd_senha,nm_usuario,dt_nascimento,nr_cpf,ds_sexo) VALUES ('169606b0','mspurett0', 'RRkgc0JrzPXc', 'Madelena Spurett','31/01/1986',51131086007, 'Female'); 
 
UPDATE T_USUARIO SET cd_login = 'rwoollard1', cd_senha = 'Gnv2wL',nm_usuario = 'Rafaell le Woollard',ds_sexo = 'NDEF' WHERE cd_usuario = '169606b0'; 
 
INSERT INTO T_PESO (cd_pesagem, t_usuario_cd_usuario, nr_peso, dt_pesagem) VALUES (707936, '169606b0', 72, to_date('05/10/2021', 'DD/MM/YYYY')); 
 
UPDATE T_PESO SET nr_peso = 74 WHERE cd_pesagem = 707936;  
 
INSERT INTO T_PRESSAO_ART (cd_medicao, t_usuario_cd_usuario, nr_press, dt_medicao) VALUES (400, '169606b0', 12, to_date('05/09/20', 'DD/MM/YYYY')); 
 
UPDATE T_PRESSAO_ART SET nr_press = 14 WHERE cd_medicao = 400;     

/**/
insert into t_tipo_ati_fis values (5, 'Teste');
insert into t_ati_fis values (0, 5, '2/semana');

INSERT INTO T_USUARIO_ATI_FIS  (cd_usuario_atv_fis, t_usuario_cd_usuario, t_ati_fis_cd_ati_fis, dt_atividade) VALUES (9081, '169606b0', 0, to_date('04/10/2021', 'DD/MM/YYYY')); 
 
UPDATE T_USUARIO_ATI_FIS SET dt_atividade = to_date('05/10/2021') WHERE cd_usuario_atv_fis = 9081;

/**/
 
INSERT INTO T_ALIM_CONS (cd_refeicao, t_usuario_cd_usuario, nm_alimento,dt_adicao,nm_calorias) VALUES (0,'169606b0', 0, '01/10/2021',200); 
 
UPDATE T_ALIM_CONS SET nm_calorias = 400 WHERE cd_refeicao = 0;