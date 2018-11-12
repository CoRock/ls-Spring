package com.corock.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.corock.spring01.model.dao.MemberDAO;
import com.corock.spring01.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	// cf. MemberDAO memberDao = new MemberDAOImpl();
	
	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		return memberDao.checkPw(userid, passwd);
	}

}
