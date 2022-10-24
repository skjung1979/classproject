DROP INDEX ONE.PK_reservation;

/* reservation */
DROP TABLE ONE.reservation 
	CASCADE CONSTRAINTS;

/* reservation */
CREATE TABLE ONE.reservation (
	reservNo INTEGER NOT NULL, /* reservNo */
	memberNo INTEGER, /* memberNo */
	hallNo INTEGER, /* hallNo */
	reservDate DATE, /* reservDate */
	reservTime DATE /* reservTime */
);

COMMENT ON TABLE ONE.reservation IS 'reservation';

COMMENT ON COLUMN ONE.reservation.reservNo IS 'reservNo';

COMMENT ON COLUMN ONE.reservation.memberNo IS 'memberNo';

COMMENT ON COLUMN ONE.reservation.hallNo IS 'hallNo';

COMMENT ON COLUMN ONE.reservation.reservDate IS 'reservDate';

COMMENT ON COLUMN ONE.reservation.reservTime IS 'reservTime';

CREATE UNIQUE INDEX ONE.PK_reservation
	ON ONE.reservation (
		reservNo ASC
	);

ALTER TABLE ONE.reservation
	ADD
		CONSTRAINT PK_reservation
		PRIMARY KEY (
			reservNo
		);

ALTER TABLE ONE.reservation
	ADD
		CONSTRAINT FK_member_TO_reservation
		FOREIGN KEY (
			memberNo
		)
		REFERENCES ONE.member (
			memberNo
		);

ALTER TABLE ONE.reservation
	ADD
		CONSTRAINT FK_hall_TO_reservation
		FOREIGN KEY (
			hallNo
		)
		REFERENCES ONE.hall (
			hallNo
		);