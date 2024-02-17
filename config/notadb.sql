CREATE TABLE apunte (
    id_apunte         INTEGER PRIMARY KEY AUTO_INCREMENT,
    titulo          VARCHAR(255) NOT NULL,
    fecha			DATETIME DEFAULT NOW(),
    id_tema      	INTEGER NOT NULL
)ENGINE=INNODB;

CREATE TABLE notas (
    id_notas   INTEGER PRIMARY KEY AUTO_INCREMENT,
    notas_     TEXT,
    id_apunte 	  INTEGER DEFAULT NULL
)ENGINE=INNODB;

CREATE TABLE tema (
    id_tema   INTEGER PRIMARY KEY AUTO_INCREMENT,
    tema_      VARCHAR(120) NOT NULL
)ENGINE=INNODB;

ALTER TABLE notas
    ADD CONSTRAINT notas_apunte_fk FOREIGN KEY ( id_apunte )
        REFERENCES apunte ( id_apunte );

ALTER TABLE apunte
    ADD CONSTRAINT apunte_tema_fk FOREIGN KEY ( id_tema )
        REFERENCES tema ( id_tema );
commit;