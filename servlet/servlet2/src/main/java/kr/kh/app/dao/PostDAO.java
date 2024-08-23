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

	PostVO selectPost(@Param("po_num")String po_num);

	void updatePostView(@Param("po_num")String po_num);

	boolean insertPost(@Param("po")PostVO post);

	boolean updatePost(@Param("po")PostVO post);

	boolean deletePost(@Param("po_num")String po_num);

}
