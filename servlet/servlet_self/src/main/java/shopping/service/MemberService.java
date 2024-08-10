package shopping.service;

import shopping.model.dto.LoginDTO;
import shopping.model.vo.MemberVO;

public interface MemberService {

	MemberVO login(LoginDTO member);

}
