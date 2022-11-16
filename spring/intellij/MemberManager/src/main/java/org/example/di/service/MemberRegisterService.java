package org.example.di.service;

import java.util.Date;

import org.example.di.dao.MemberDao;
import org.example.di.domain.Member;
import org.example.di.domain.RegisterRequest;
import org.example.di.exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	
	private MemberDao memberDao;

	// 이 구조가 의존성을 낮추는 구조이다!
	public MemberRegisterService(MemberDao memberDao) {
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
