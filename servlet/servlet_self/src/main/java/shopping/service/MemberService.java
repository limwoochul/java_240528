package shopping.service;

import shopping.model.dto.LoginDTO;
import shopping.model.vo.MemberVO;

public interface MemberService {
	
	boolean signup(LoginDTO member);

	MemberVO login(LoginDTO member);

}
