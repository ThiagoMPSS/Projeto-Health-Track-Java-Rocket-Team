SELECT * FROM t_usuario
WHERE cd_usuario = '169606b0';

SELECT * FROM t_peso
WHERE t_usuario_cd_usuario = '169606b0' ORDER BY dt_pesagem DESC;

SELECT * FROM t_peso
WHERE cd_pesagem = 707936;

SELECT * FROM t_pressao_art
WHERE t_usuario_cd_usuario = '169606b0'
ORDER BY dt_medicao DESC;

SELECT * FROM t_pressao_art
WHERE cd_medicao = 400;

SELECT * FROM t_usuario_ati_fis
WHERE t_usuario_cd_usuario = '169606b0'
ORDER BY dt_atividade DESC;

SELECT * FROM t_usuario_ati_fis
WHERE cd_usuario_atv_fis = 9081;

SELECT * FROM t_alim_cons
WHERE t_usuario_cd_usuario = '169606b0'
ORDER BY dt_adicao DESC;

SELECT * FROM t_alim_cons
WHERE cd_refeicao = 0 AND t_usuario_cd_usuario = '169606b0';

select cd_usuario, nm_usuario,
    (select nr_peso from t_peso where t_usuario_cd_usuario = cd_usuario order by dt_pesagem desc fetch first 1 rows only),
    (select nr_press from t_pressao_art where t_usuario_cd_usuario = cd_usuario order by dt_medicao desc fetch first 1 rows only)
    from t_usuario where cd_usuario = '169606b0';