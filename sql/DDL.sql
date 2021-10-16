CREATE TABLE t_alim_cons (
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    cd_refeicao          NUMBER(4) NOT NULL,
    nm_alimento          NUMBER(5) NOT NULL,
    dt_adicao            DATE NOT NULL,
    nm_calorias          NUMBER(4) NOT NULL
);

ALTER TABLE t_alim_cons ADD CONSTRAINT t_alim_cons_pk PRIMARY KEY ( t_usuario_cd_usuario,
                                                                    cd_refeicao );

CREATE TABLE t_altura (
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    nr_altura            NUMBER(3, 2) NOT NULL,
    dt_medicao           DATE NOT NULL
);

ALTER TABLE t_altura ADD CONSTRAINT t_altura_pk PRIMARY KEY ( t_usuario_cd_usuario );

CREATE TABLE t_ati_fis (
    cd_ati_fis                     NVARCHAR2(30) NOT NULL,
    t_tipo_ati_fis_cd_tipo_ati     NVARCHAR2(1) NOT NULL,
    ds_frequencia_atividade_fisica NVARCHAR2(30) NOT NULL
);

ALTER TABLE t_ati_fis ADD CONSTRAINT t_ati_fis_pk PRIMARY KEY ( cd_ati_fis );

CREATE TABLE t_bairro (
    cd_bairro          NVARCHAR2(30) NOT NULL,
    t_cidade_cd_cidade NVARCHAR2(30) NOT NULL,
    nm_bairro          VARCHAR2(30) NOT NULL
);

ALTER TABLE t_bairro ADD CONSTRAINT t_bairro_pk PRIMARY KEY ( cd_bairro );

CREATE TABLE t_cidade (
    cd_cidade          NVARCHAR2(30) NOT NULL,
    t_estado_cd_estado NVARCHAR2(30) NOT NULL,
    nm_cidade          VARCHAR2(30) NOT NULL
);

ALTER TABLE t_cidade ADD CONSTRAINT t_cidade_pk PRIMARY KEY ( cd_cidade );

CREATE TABLE t_email (
    cd_email                   NVARCHAR2(30) NOT NULL,
    t_tipo_email_cd_tipo_email NVARCHAR2(30) NOT NULL,
    ds_email                   NVARCHAR2(30) NOT NULL
);

ALTER TABLE t_email ADD CONSTRAINT t_email_pk PRIMARY KEY ( cd_email );

CREATE TABLE t_end (
    nr_cep                     NUMBER(8) NOT NULL,
    t_bairro_cd_bairro         NVARCHAR2(30) NOT NULL,
    t_tipo_logra_cd_tipo_logra NVARCHAR2(30) NOT NULL,
    ds_logradouro              VARCHAR2(30) NOT NULL
);

ALTER TABLE t_end ADD CONSTRAINT t_end_pk PRIMARY KEY ( nr_cep );

CREATE TABLE t_estado (
    cd_estado NVARCHAR2(30) NOT NULL,
    nm_estado VARCHAR2(30) NOT NULL
);

ALTER TABLE t_estado ADD CONSTRAINT t_estado_pk PRIMARY KEY ( cd_estado );

CREATE TABLE t_fone (
    nr_fone_completo             NUMBER(15) NOT NULL,
    t_tipo_fone_cd_tipo_telefone NVARCHAR2(30) NOT NULL,
    nr_ddi                       NUMBER(2) NOT NULL,
    nr_ddd                       NUMBER(3) NOT NULL,
    nr_telefone                  NUMBER(10) NOT NULL
);

ALTER TABLE t_fone ADD CONSTRAINT t_fone_pk PRIMARY KEY ( nr_fone_completo );

CREATE TABLE t_peso (
    cd_pesagem           NUMBER NOT NULL,
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    nr_peso              NUMBER(3) NOT NULL,
    dt_pesagem           DATE NOT NULL
);

ALTER TABLE t_peso ADD CONSTRAINT t_peso_pk PRIMARY KEY ( cd_pesagem );

CREATE TABLE t_premium (
    cd_premium           NVARCHAR2(30) NOT NULL,
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    cd_pagamento         NVARCHAR2(30) NOT NULL,
    dt_pagamento         DATE NOT NULL,
    dt_contratacao       DATE NOT NULL,
    dt_vencimento        DATE NOT NULL
);

CREATE UNIQUE INDEX t_premium__idx ON
    t_premium (
        t_usuario_cd_usuario
    ASC );

ALTER TABLE t_premium ADD CONSTRAINT t_premium_pk PRIMARY KEY ( cd_premium );

CREATE TABLE t_pressao_art (
    cd_medicao           NUMBER(4) NOT NULL,
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    nr_press             NUMBER(4, 2) NOT NULL,
    dt_medicao           DATE NOT NULL
);

ALTER TABLE t_pressao_art ADD CONSTRAINT t_pressao_art_pk PRIMARY KEY ( cd_medicao );

CREATE TABLE t_tipo_ati_fis (
    cd_tipo_ati       NVARCHAR2(5) NOT NULL,
    ds_tipo_atividade NVARCHAR2(50) NOT NULL
);

ALTER TABLE t_tipo_ati_fis ADD CONSTRAINT t_tipo_ati_fis_pk PRIMARY KEY ( cd_tipo_ati );

CREATE TABLE t_tipo_email (
    cd_tipo_email NVARCHAR2(30) NOT NULL,
    ds_tipo_email NVARCHAR2(30) NOT NULL
);

ALTER TABLE t_tipo_email ADD CONSTRAINT t_tipo_email_pk PRIMARY KEY ( cd_tipo_email );

CREATE TABLE t_tipo_fone (
    cd_tipo_telefone NVARCHAR2(30) NOT NULL,
    ds_tipo_telefone NVARCHAR2(30) NOT NULL
);

ALTER TABLE t_tipo_fone ADD CONSTRAINT t_tipo_fone_pk PRIMARY KEY ( cd_tipo_telefone );

CREATE TABLE t_tipo_logra (
    cd_tipo_logra NVARCHAR2(30) NOT NULL,
    ds_tipo_logra NVARCHAR2(30) NOT NULL
);

ALTER TABLE t_tipo_logra ADD CONSTRAINT t_tipo_logra_pk PRIMARY KEY ( cd_tipo_logra );

CREATE TABLE t_usuario (
    cd_usuario    VARCHAR2(30) NOT NULL,
    cd_login      NVARCHAR2(30) NOT NULL,
    cd_senha      NVARCHAR2(30) NOT NULL,
    nm_usuario    VARCHAR2(30) NOT NULL,
    dt_nascimento DATE NOT NULL,
    nr_cpf        NUMBER(11) NOT NULL,
    ds_sexo       VARCHAR2(6) NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY ( cd_usuario );

CREATE TABLE t_usuario_ati_fis (
    cd_usuario_atv_fis   NUMBER(4) NOT NULL,
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    t_ati_fis_cd_ati_fis NVARCHAR2(30) NOT NULL,
    dt_atividade         DATE NOT NULL
);

ALTER TABLE t_usuario_ati_fis ADD CONSTRAINT t_usuario_ati_fis_pk PRIMARY KEY ( cd_usuario_atv_fis );

CREATE TABLE t_usuario_email (
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    t_email_cd_email     NVARCHAR2(30) NOT NULL
);

ALTER TABLE t_usuario_email ADD CONSTRAINT t_usuario_email_pk PRIMARY KEY ( t_usuario_cd_usuario,
                                                                            t_email_cd_email );

CREATE TABLE t_usuario_end (
    t_usuario_cd_usuario VARCHAR2(30) NOT NULL,
    t_end_nr_cep         NUMBER(8) NOT NULL,
    nr_end               NUMBER(5) NOT NULL,
    ds_complemento       NVARCHAR2(30)
);

ALTER TABLE t_usuario_end ADD CONSTRAINT t_usuario_end_pk PRIMARY KEY ( t_usuario_cd_usuario,
                                                                        t_end_nr_cep );

CREATE TABLE t_usuario_fone (
    t_usuario_cd_usuario    VARCHAR2(30) NOT NULL,
    t_fone_nr_fone_completo NUMBER(15) NOT NULL,
    nr_ramal                NUMBER(4)
);

ALTER TABLE t_usuario_fone ADD CONSTRAINT t_usuario_fone_pk PRIMARY KEY ( t_usuario_cd_usuario,
                                                                          t_fone_nr_fone_completo );

ALTER TABLE t_alim_cons
    ADD CONSTRAINT t_alim_cons_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_altura
    ADD CONSTRAINT t_altura_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_ati_fis
    ADD CONSTRAINT t_ati_fis_t_tipo_ati_fis_fk FOREIGN KEY ( t_tipo_ati_fis_cd_tipo_ati )
        REFERENCES t_tipo_ati_fis ( cd_tipo_ati );

ALTER TABLE t_bairro
    ADD CONSTRAINT t_bairro_t_cidade_fk FOREIGN KEY ( t_cidade_cd_cidade )
        REFERENCES t_cidade ( cd_cidade );

ALTER TABLE t_cidade
    ADD CONSTRAINT t_cidade_t_estado_fk FOREIGN KEY ( t_estado_cd_estado )
        REFERENCES t_estado ( cd_estado );

ALTER TABLE t_email
    ADD CONSTRAINT t_email_t_tipo_email_fk FOREIGN KEY ( t_tipo_email_cd_tipo_email )
        REFERENCES t_tipo_email ( cd_tipo_email );

ALTER TABLE t_end
    ADD CONSTRAINT t_end_t_bairro_fk FOREIGN KEY ( t_bairro_cd_bairro )
        REFERENCES t_bairro ( cd_bairro );

ALTER TABLE t_end
    ADD CONSTRAINT t_end_t_tipo_logra_fk FOREIGN KEY ( t_tipo_logra_cd_tipo_logra )
        REFERENCES t_tipo_logra ( cd_tipo_logra );

ALTER TABLE t_fone
    ADD CONSTRAINT t_fone_t_tipo_fone_fk FOREIGN KEY ( t_tipo_fone_cd_tipo_telefone )
        REFERENCES t_tipo_fone ( cd_tipo_telefone );

ALTER TABLE t_peso
    ADD CONSTRAINT t_peso_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_premium
    ADD CONSTRAINT t_premium_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_pressao_art
    ADD CONSTRAINT t_pressao_art_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_usuario_ati_fis
    ADD CONSTRAINT t_usuario_ati_fis_t_ati_fis_fk FOREIGN KEY ( t_ati_fis_cd_ati_fis )
        REFERENCES t_ati_fis ( cd_ati_fis );

ALTER TABLE t_usuario_ati_fis
    ADD CONSTRAINT t_usuario_ati_fis_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_usuario_email
    ADD CONSTRAINT t_usuario_email_t_email_fk FOREIGN KEY ( t_email_cd_email )
        REFERENCES t_email ( cd_email );

ALTER TABLE t_usuario_email
    ADD CONSTRAINT t_usuario_email_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_usuario_end
    ADD CONSTRAINT t_usuario_end_t_end_fk FOREIGN KEY ( t_end_nr_cep )
        REFERENCES t_end ( nr_cep );

ALTER TABLE t_usuario_end
    ADD CONSTRAINT t_usuario_end_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_usuario_fone
    ADD CONSTRAINT t_usuario_fone_t_fone_fk FOREIGN KEY ( t_fone_nr_fone_completo )
        REFERENCES t_fone ( nr_fone_completo );

ALTER TABLE t_usuario_fone
    ADD CONSTRAINT t_usuario_fone_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );
