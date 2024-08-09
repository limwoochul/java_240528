package shopping.service;

import java.io.IOException;
import java.io.InputStream;

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
		String resource = "servlet_self/config/mybatis-config.xml";
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

}
