package kr.kh.app.service;

import java.util.List;

import kr.kh.app.Pagination.Criteria;
import kr.kh.app.Pagination.PageMaker;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(String num);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

	PostVO getPost(String po_num);

	void updatePostView(String po_num);

	boolean insertPost(PostVO post);

	boolean updatePost(PostVO post, MemberVO user);

	int deletePost(String po_num, MemberVO user);

}
