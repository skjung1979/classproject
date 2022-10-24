DROP INDEX ONE.PK_hall;

/* hall */
DROP TABLE ONE.hall 
	CASCADE CONSTRAINTS;

/* hall */
CREATE TABLE hall (
	hallNo INTEGER NOT NULL, /* hallNo */
	hallResvYN VARCHAR2(50), /* hallResvYN */
	hallTime INTEGER /* hallTime */
);

COMMENT ON TABLE ONE.hall IS 'hall';

COMMENT ON COLUMN ONE.hall.hallNo IS 'hallNo';

COMMENT ON COLUMN ONE.hall.hallResvYN IS 'hallResvYN';

COMMENT ON COLUMN ONE.hall.hallTime IS 'hallTime';

CREATE UNIQUE INDEX ONE.PK_hall
	ON ONE.hall (
		hallNo ASC
	);

ALTER TABLE ONE.hall
	ADD
		CONSTRAINT PK_hall
		PRIMARY KEY (
			hallNo
		);