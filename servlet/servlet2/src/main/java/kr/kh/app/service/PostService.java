package kr.kh.app.service;

import java.util.List;

import kr.kh.app.Pagination.Criteria;
import kr.kh.app.Pagination.PageMaker;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(String num);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

}
