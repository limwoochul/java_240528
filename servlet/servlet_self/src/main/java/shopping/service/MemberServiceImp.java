package shopping.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shopping.dao.MemberDAO;
import shopping.model.dto.LoginDTO;
import shopping.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "shopping/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public MemberVO login(LoginDTO member) {
		if(member==null) {
			return null;
		}
		
		MemberVO user = new MemberVO();
		try {
			user = memberDao.selectMember(member.getId());			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		if(user == null) {
			return null;
		}
		
		if(member.getPw().equals(user.getMe_pw())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean signup(LoginDTO member) {
		if(member == null) {
			return false;
		}
		//아이디 중복 검사해서 있으면 false를 리턴
		if(memberDao.selectMember(member.getId()) != null) {
			return false;
		}
		
		//유효성 검사 실패 시 false를 리턴
		if(!checkValidate(member)) {
			return false;
		}
		
		//
		try {
			//이메일이 중복되면 추가할 수 없어서(유니크 설정)
			return memberDao.insertMember(member);
		} catch(Exception e) {
			return false;
		}
	}
	
	private boolean checkValidate(LoginDTO member) {
		if( member == null || 
			member.getId() == null || 
			member.getPw() == null || 
			member.getName() == null ||
			member.getAddress() == null ||
			member.getPhone() == null ||
			member.getAnswer() == null) {
			return false;
		}
		//아이디 유효성 검사. 영어, 숫자 6~13
		String idRegex = "^\\w{6,13}$";
		if(!Pattern.matches(idRegex, member.getId())) {
			return false;
		}
		//비번 유효성 검사. 영어, 숫자, !@#$ 6~15
		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
		if(!Pattern.matches(pwRegex, member.getPw())) {
			return false;
		}
		//이메일 유효성 검사.
		String phoneRegex = "^01(?:0|1|[6-9])-\\d{3,4}-\\d{4}$";
		if(!Pattern.matches(phoneRegex, member.getPhone())) {
			return false;
		}
		return true;
	}

}
