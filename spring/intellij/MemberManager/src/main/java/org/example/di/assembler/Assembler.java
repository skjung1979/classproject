package org.example.di.assembler;


// 어셈블러가 하는 역할이 역행제어이다.

import org.example.di.dao.Dao;
import org.example.di.dao.DaoImpl;
import org.example.di.dao.MemberDao;
import org.example.di.service.ChangePasswordService;
import org.example.di.service.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao; // MemberDao -> Dao로 바꿨다 -> 다시 MemberDao
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao(); //new MemberDao(); <- 조립기에서는 필요하다면 이 부분만 바꿔주면 된다. -> 다시 MemberDao
		// 이렇게 어셈블러가 객체를 만들어(new)서 아래 처러 만든 객체를 매개변수에 넣어도 사용자가 호출하면 주입해 주는 것이다.
		regSvc = new MemberRegisterService(null);
		pwdSvc = new ChangePasswordService();
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}

}
