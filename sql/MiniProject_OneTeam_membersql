DROP INDEX ONE.PK_member;

/* member */
DROP TABLE ONE.member 
	CASCADE CONSTRAINTS;

/* member */
CREATE TABLE ONE.member (
	memberNo INTEGER NOT NULL, /* memberNo */
	memberName VARCHAR2(50), /* memberName */
	memberAddres VARCHAR2(255), /* memberAddres */
	memberPhone VARCHAR2(30), /* memberPhone */
	memberId INTEGER, /* memberId */
	memberPwd VARCHAR2(50), /* memberPwd */
	memberGrade INTEGER /* memberGrade */
);

COMMENT ON TABLE ONE.member IS 'member';

COMMENT ON COLUMN ONE.member.memberNo IS 'memberNo';

COMMENT ON COLUMN ONE.member.memberName IS 'memberName';

COMMENT ON COLUMN ONE.member.memberAddres IS 'memberAddres';

COMMENT ON COLUMN ONE.member.memberPhone IS 'memberPhone';

COMMENT ON COLUMN ONE.member.memberId IS 'memberId';

COMMENT ON COLUMN ONE.member.memberPwd IS 'memberPwd';

COMMENT ON COLUMN ONE.member.memberGrade IS 'memberGrade';

CREATE UNIQUE INDEX ONE.PK_member
	ON ONE.member (
		memberNo ASC
	);

ALTER TABLE ONE.member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			memberNo
		);