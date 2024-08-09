package shopping.dao;

import org.apache.ibatis.annotations.Param;

import shopping.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("id")String id);

}
