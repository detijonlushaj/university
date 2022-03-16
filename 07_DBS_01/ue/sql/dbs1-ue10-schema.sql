DROP TABLE schritt;
DROP TABLE rezept;

CREATE TABLE rezept (
  id INTEGER,
  name VARCHAR(50) NOT NULL,

  CONSTRAINT pk_rezept PRIMARY KEY (id)
);

CREATE TABLE schritt (
  id INTEGER,
  nummer INTEGER,
  beschreibung VARCHAR(100) NOT NULL,

  CONSTRAINT pk_rezeptschritt PRIMARY KEY (id, nummer),
  CONSTRAINT fk_rezeptid FOREIGN KEY (id) REFERENCES rezept (id)
);

COMMIT;