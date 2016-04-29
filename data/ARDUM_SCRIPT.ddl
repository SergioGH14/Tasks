-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2016-04-29 16:50:30 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE ACTIVIDAD
  (
    id_actividad       INTEGER NOT NULL ,
    id_asignatura      INTEGER NOT NULL ,
    titulo             CHAR (150) ,
    descripcion        CHAR (500) ,
    fecha_finalizacion DATE ,
    finalizada         CHAR (1) ,
    tiempo_estimado    SMALLINT ,
    porcentaje         DOUBLE,
    prioridad_u        INTEGER ,
    prioridad_t        INTEGER
  ) ;
ALTER TABLE ACTIVIDAD ADD CONSTRAINT ACTIVIDAD_PK PRIMARY KEY ( id_actividad ) ;


CREATE TABLE ASIGNATURA
  (
    id_asignatura   INTEGER NOT NULL ,
    id_cuatrimestre INTEGER NOT NULL ,
    titulo          CHAR (75) ,
    creditos        DOUBLE,
    dificultad      INTEGER ,
    anual           CHAR (1)
  ) ;
ALTER TABLE ASIGNATURA ADD CONSTRAINT ASIGNATURA_PK PRIMARY KEY ( id_asignatura ) ;


CREATE TABLE CLASE
  (
    id_clase     INTEGER NOT NULL ,
    id_actividad INTEGER NOT NULL ,
    puntuable    CHAR (1)
  ) ;
ALTER TABLE CLASE ADD CONSTRAINT CLASE_PK PRIMARY KEY ( id_clase ) ;


CREATE TABLE CUATRIMESTRE
  (
    id_cuatrimestre INTEGER NOT NULL ,
    id_curso        INTEGER NOT NULL ,
    cuatrimestre    SMALLINT
  ) ;
ALTER TABLE CUATRIMESTRE ADD CONSTRAINT CUATRIMESTRE_PK PRIMARY KEY ( id_cuatrimestre ) ;


CREATE TABLE CURSO
  (
    id_curso INTEGER NOT NULL ,
    id_grado INTEGER NOT NULL ,
    anyo     DATE ,
    creditos DOUBLE
  ) ;
ALTER TABLE CURSO ADD CONSTRAINT CURSO_PK PRIMARY KEY ( id_curso ) ;


CREATE TABLE EXAMEN
  (
    id_examen            INTEGER NOT NULL ,
    id_actividad         INTEGER NOT NULL ,
    id_examen_poliformat INTEGER ,
    id_examen_practicas  INTEGER ,
    id_examen_clase      INTEGER ,
    ultimo               CHAR (1) ,
    recuperable          CHAR (1)
  ) ;
ALTER TABLE EXAMEN ADD CONSTRAINT EXAMEN_PK PRIMARY KEY ( id_examen ) ;


CREATE TABLE EXAMEN_CLASE
  (
    id_examen_clase INTEGER NOT NULL ,
    id_examen       INTEGER NOT NULL ,
    grupal          CHAR (1) ,
    apuntes         CHAR (1)
  ) ;
ALTER TABLE EXAMEN_CLASE ADD CONSTRAINT EXAMEN_CLASE_PK PRIMARY KEY ( id_examen_clase ) ;


CREATE TABLE EXAMEN_POLIFORMAT
  (
    id_examen_poliformat INTEGER NOT NULL ,
    id_examen            INTEGER NOT NULL ,
    reintentable         CHAR (1)
  ) ;
ALTER TABLE EXAMEN_POLIFORMAT ADD CONSTRAINT EXAMEN_POLLIFORMAT_PK PRIMARY KEY ( id_examen_poliformat ) ;


CREATE TABLE EXAMEN_PRACTICAS
  (
    id_examen_practicas INTEGER NOT NULL ,
    id_examen           INTEGER NOT NULL ,
    apuntes             CHAR (1)
  ) ;
ALTER TABLE EXAMEN_PRACTICAS ADD CONSTRAINT EXAMEN_PRACTICAS_PK PRIMARY KEY ( id_examen_practicas ) ;


CREATE TABLE GRADO
  (
    id_grado       INTEGER NOT NULL ,
    id_universidad INTEGER NOT NULL ,
    titulacion     CHAR (75) ,
    anyo_inicio    DATE
  ) ;
ALTER TABLE GRADO ADD CONSTRAINT GRADO_PK PRIMARY KEY ( id_grado ) ;


CREATE TABLE NOTIFICACION
  (
    id_notificacion INTEGER NOT NULL ,
    id_actividad    INTEGER NOT NULL ,
    descripcion     VARCHAR (500) ,
    fecha_notificar DATE ,
    prioridad       INTEGER
  ) ;
ALTER TABLE NOTIFICACION ADD CONSTRAINT NOTIFICACION_PK PRIMARY KEY ( id_notificacion ) ;


CREATE TABLE PRACTICAS
  (
    id_practicas INTEGER NOT NULL ,
    id_actividad INTEGER NOT NULL ,
    grupal       CHAR (1) ,
    recuperable  CHAR (1)
  ) ;
ALTER TABLE PRACTICAS ADD CONSTRAINT PRACTICAS_PK PRIMARY KEY ( id_practicas ) ;


CREATE TABLE UNIVERSIDAD
  (
    id_universidad INTEGER NOT NULL ,
    nombre         CHAR (100) ,
    logo           CHAR (50) ,
    direccion      CHAR (60)
  ) ;
ALTER TABLE UNIVERSIDAD ADD CONSTRAINT UNIVERSIDAD_PK PRIMARY KEY ( id_universidad ) ;


CREATE TABLE USUARIO
  (
    id_usuario       INTEGER NOT NULL ,
    id_universidad   INTEGER,
    nombre           CHAR (30) ,
    apellidos        CHAR (60) ,
    avatar           CHAR (50) ,
    fecha_nacimiento DATE ,
    email            CHAR (100)
  ) ;
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY ( id_usuario ) ;


ALTER TABLE ACTIVIDAD ADD CONSTRAINT ACTIVIDAD_ASIGNATURA_FK FOREIGN KEY ( id_asignatura ) REFERENCES ASIGNATURA ( id_asignatura ) ON
DELETE CASCADE ;

ALTER TABLE ASIGNATURA ADD CONSTRAINT ASIGNATURA_CUATRIMESTRE_FK FOREIGN KEY ( id_cuatrimestre ) REFERENCES CUATRIMESTRE ( id_cuatrimestre ) ;

ALTER TABLE CLASE ADD CONSTRAINT CLASE_ACTIVIDAD_FK FOREIGN KEY ( id_actividad ) REFERENCES ACTIVIDAD ( id_actividad ) ;

ALTER TABLE CUATRIMESTRE ADD CONSTRAINT CUATRIMESTRE_CURSO_FK FOREIGN KEY ( id_curso ) REFERENCES CURSO ( id_curso ) ;

ALTER TABLE CURSO ADD CONSTRAINT CURSO_GRADO_FK FOREIGN KEY ( id_grado ) REFERENCES GRADO ( id_grado ) ;

ALTER TABLE EXAMEN ADD CONSTRAINT EXAMEN_ACTIVIDAD_FK FOREIGN KEY ( id_actividad ) REFERENCES ACTIVIDAD ( id_actividad ) ON
DELETE CASCADE ;

ALTER TABLE EXAMEN_CLASE ADD CONSTRAINT EXAMEN_CLASE_EXAMEN_FK FOREIGN KEY ( id_examen ) REFERENCES EXAMEN ( id_examen ) ;

ALTER TABLE EXAMEN ADD CONSTRAINT EXAMEN_EXAMEN_CLASE_FK FOREIGN KEY ( id_examen_clase ) REFERENCES EXAMEN_CLASE ( id_examen_clase ) ;

ALTER TABLE EXAMEN ADD CONSTRAINT EXAMEN_EXAMEN_POLIFORMAT_FK FOREIGN KEY ( id_examen_poliformat ) REFERENCES EXAMEN_POLIFORMAT ( id_examen_poliformat ) ;

ALTER TABLE EXAMEN ADD CONSTRAINT EXAMEN_EXAMEN_PRACTICAS_FK FOREIGN KEY ( id_examen_practicas ) REFERENCES EXAMEN_PRACTICAS ( id_examen_practicas ) ;

ALTER TABLE EXAMEN_POLIFORMAT ADD CONSTRAINT EXAMEN_POLLIFORMAT_EXAMEN_FK FOREIGN KEY ( id_examen ) REFERENCES EXAMEN ( id_examen ) ;

ALTER TABLE EXAMEN_PRACTICAS ADD CONSTRAINT EXAMEN_PRACTICAS_EXAMEN_FK FOREIGN KEY ( id_examen ) REFERENCES EXAMEN ( id_examen ) ;

ALTER TABLE GRADO ADD CONSTRAINT GRADO_UNIVERSIDAD_FK FOREIGN KEY ( id_universidad ) REFERENCES UNIVERSIDAD ( id_universidad ) ;

ALTER TABLE NOTIFICACION ADD CONSTRAINT NOTIFICACION_ACTIVIDAD_FK FOREIGN KEY ( id_actividad ) REFERENCES ACTIVIDAD ( id_actividad ) ;

ALTER TABLE PRACTICAS ADD CONSTRAINT PRACTICAS_ACTIVIDAD_FK FOREIGN KEY ( id_actividad ) REFERENCES ACTIVIDAD ( id_actividad ) ;

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_UNIVERSIDAD_FK FOREIGN KEY ( id_universidad ) REFERENCES UNIVERSIDAD ( id_universidad ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler:
--
-- CREATE TABLE                            14
-- CREATE INDEX                             0
-- ALTER TABLE                             30
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
--
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
--
-- REDACTION POLICY                         0
--
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
--
-- ERRORS                                   0
-- WARNINGS                                 0
