CREATE TABLE IF NOT EXISTS  scooter (
  id serial,
  habilitado VARCHAR(45) NOT NULL,
  unidad # VARCHAR(45) NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS  usuarios (
  id serial,
  CI VARCHAR(45) NOT NULL,
  # de usuario  VARCHAR(45) NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS  apli (
    id serial,
    # de scooter VARCHAR(45) NOT NULL,
    distancia VARCHAR(45) NULL,
    PRIMARY KEY (id)

    );









