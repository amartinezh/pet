DROP DATABASE arquitectura;

CREATE DATABASE arquitectura
  WITH OWNER = postgres
       
       TABLESPACE = pg_default
      
       CONNECTION LIMIT = -1;

\c arquitectura;


CREATE SCHEMA arquitectura
  AUTHORIZATION postgres;
  
CREATE SCHEMA gestion
  AUTHORIZATION postgres;
-- -------------------------------------------------------------------------------

CREATE TABLE gestion.region
(
  region_id character varying(6) NOT NULL,
  descripcion character varying(128),
  CONSTRAINT region_pk PRIMARY KEY (region_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.region
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.company
(
  comp_id character varying(6) NOT NULL,
  region_id character varying(6),
  comp_desc character varying(255),
  CONSTRAINT comp_id_pk PRIMARY KEY (comp_id),
  CONSTRAINT region_fk FOREIGN KEY (region_id)
      REFERENCES gestion.region (region_id)  
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.company
  OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.currency
(
  currency_id integer NOT NULL,
  currency_desc character varying(255) ,
  CONSTRAINT currency_id_pk PRIMARY KEY (currency_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.currency
  OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.nivel_organico
(
  nivel_organico_id serial NOT NULL,
  descripcion character varying(128),
  area_estrategica character varying(32),
  CONSTRAINT nivel_organico_pk PRIMARY KEY (nivel_organico_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.nivel_organico
  OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.type_users
(
  id serial NOT NULL,
  descripcion character varying(30),
  CONSTRAINT tip_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.type_users
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.users
(
  id character varying(255) COLLATE pg_catalog."es_CO.utf8" NOT NULL,
  pass character varying(255) COLLATE pg_catalog."es_CO.utf8",
  type_id integer,
  comp_comp_id character varying(6),
  curr_currency_id integer,
  nivel_organico_id integer,
  CONSTRAINT users_id_pk PRIMARY KEY (id),
  CONSTRAINT users_comp_id FOREIGN KEY (comp_comp_id)
      REFERENCES gestion.company (comp_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_curr_fk FOREIGN KEY (curr_currency_id)
      REFERENCES gestion.currency (currency_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_tip_fk FOREIGN KEY (type_id)
      REFERENCES gestion.type_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT nivel_organico_fk FOREIGN KEY (nivel_organico_id)
      REFERENCES gestion.nivel_organico (nivel_organico_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.users
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

INSERT INTO gestion.region(region_id, descripcion) VALUES ('COL','COLOMBIA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('VEN','VENEZUELA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('PAN','PANAMA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('TRI','TRINIDAD');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('GUA','GUATEMALA');

INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('01', 'COL', 'CIA A');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('02', 'VEN', 'CIA B');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('03', 'PAN', 'CIA C');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('04', 'TRI', 'CIA D');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('05', 'GUA', 'CIA E');

INSERT INTO gestion.currency(currency_id, currency_desc) VALUES ('0', 'USD');
INSERT INTO gestion.currency(currency_id, currency_desc) VALUES ('1', 'LOCAL');

INSERT INTO gestion.type_users(id, descripcion) VALUES ('1', 'gestionistrador');
INSERT INTO gestion.type_users(id, descripcion)VALUES ('2', 'Usuario');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('1', 'c4ca4238a0b923820dcc509a6f75849b','1' , '01', '1');

INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Saleman', 'Operational');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Supervisor', 'Operational');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('District Manager', 'Tactical');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Middle Manager', 'Tactical');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Area Manager', 'Estrategic');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('General Manager', 'Estrategic');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Regional V.P.', 'Estrategic');
