package org.example.di.service;

import org.example.di.dao.Dao;
import org.example.di.dao.MemberDao;
import org.example.di.domain.Member;
import org.example.di.domain.RegisterRequest;
import org.example.di.exception.AlreadyExistingMemberException;

import java.util.Date;

public class MemberRegisterService2 {

	private Dao memberDao; // MemberDao -> Dao로 바꿨다 / 느슨한 결합으로 바뀜 -> dao가 바뀐다고 해서 서비스를 변경할 필요가 없게 된다.

	// 이렇게 세터를 넣고 xml 파일에서 property태그를 정의한다.
	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}
