package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.Pagination.Criteria;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	CommunityVO selectCommunity(@Param("co_num")String num);

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

}
