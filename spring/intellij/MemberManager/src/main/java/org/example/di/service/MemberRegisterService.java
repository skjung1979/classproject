package org.example.di.service;

import java.util.Date;

import org.example.di.dao.Dao;
import org.example.di.dao.MemberDao;
import org.example.di.domain.Member;
import org.example.di.domain.RegisterRequest;
import org.example.di.exception.AlreadyExistingMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisterService {

	@Autowired()
	//@Qualifier("member") // member를 사용하겠다.
	private final Dao dao; // MemberDao -> Dao로 바꿨다 / 느슨한 결합으로 바뀜 -> dao가 바뀐다고 해서 서비스를 변경할 필요가 없게 된다.


	public MemberRegisterService(Dao dao){
		this.dao = dao;
	}



	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
