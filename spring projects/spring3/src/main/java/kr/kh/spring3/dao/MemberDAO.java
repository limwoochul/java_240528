package kr.kh.spring3.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring3.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(MemberVO member);

	MemberVO selectMember(@Param("me_id")String me_id);

}
