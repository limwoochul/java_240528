package kr.kh.spring3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.pagination.PostCriteria;
import kr.kh.spring3.service.PostService;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/post")
@Log4j
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/list/{co_num}")
	public String list(Model model, @PathVariable("co_num")int co_num, PostCriteria cri) {
		log.info("/post/list/"+co_num+":get");
		
		cri.setCo_num(co_num);
		cri.setPerPageNum(3);
		
		List<CommunityVO> communities = postService.getCommunityList();
		List<PostVO> list = postService.getPostList(cri);
		
		PageMaker pm = postService.getPageMaker(cri);
		
		model.addAttribute("communities", communities);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
	
	@GetMapping("/detail/{po_num}")
	public String detail(Model model, @PathVariable("po_num")int po_num) {
		log.info("/post/detail/"+po_num+":get");
		
		postService.updatePostView(po_num);
		
		PostVO post = postService.getPost(po_num);
		
		model.addAttribute("post", post);
		
		return "/post/detail";
	}
	
}
