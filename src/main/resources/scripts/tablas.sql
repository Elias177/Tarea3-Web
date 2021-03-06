CREATE TABLE IF NOT EXISTS USUARIO (
  ID            BIGINT PRIMARY KEY,
  USERNAME      VARCHAR2(30),
  NOMBRE        VARCHAR2(30),
  PASSWORD      VARCHAR2(30),
  ADMINISTRATOR BOOLEAN,
  AUTOR         BOOLEAN,
  COOKIES       VARCHAR2(255),
  ACTIVO        BOOLEAN
);

CREATE TABLE IF NOT EXISTS ETIQUETA (
  ID       BIGINT PRIMARY KEY,
  ETIQUETA VARCHAR2(200),
  ACTIVO   BOOLEAN
);

CREATE TABLE IF NOT EXISTS ARTICULO (
  ID       BIGINT PRIMARY KEY,
  TITULO   VARCHAR2(70),
  CUERPO   VARCHAR2(900000),
  ID_AUTOR BIGINT REFERENCES USUARIO (ID) ON UPDATE CASCADE,
  FECHA    DATE,
  ACTIVO   BOOLEAN
);

CREATE TABLE IF NOT EXISTS COMENTARIO (
  ID          BIGINT PRIMARY KEY,
  COMENTARIO  VARCHAR2(1000),
  ID_AUTOR    BIGINT REFERENCES USUARIO (ID) ON UPDATE CASCADE,
  ID_ARTICULO BIGINT REFERENCES ARTICULO (ID) ON UPDATE CASCADE,
  ACTIVO      BOOLEAN
);
CREATE TABLE IF NOT EXISTS ARTICULO_COMENTARIOS (
  ID_ARTICULO   BIGINT REFERENCES ARTICULO (ID) ON UPDATE CASCADE,
  ID_COMENTARIO BIGINT REFERENCES COMENTARIO (ID) ON UPDATE CASCADE,
  ACTIVO        BOOLEAN
);

CREATE TABLE IF NOT EXISTS ARTICULO_ETIQUETAS (
  ID_ARTICULO BIGINT REFERENCES ARTICULO (ID) ON UPDATE CASCADE,
  ID_ETIQUETA BIGINT REFERENCES ETIQUETA (ID) ON UPDATE CASCADE,
  ACTIVO      BOOLEAN
);

