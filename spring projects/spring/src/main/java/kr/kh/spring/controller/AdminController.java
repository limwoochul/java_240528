package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/community")
	public String community(Model model) {
		List<CommunityVO> list = postService.getCommunityList();
		model.addAttribute("list", list);
		return "/admin/community";
	}
	
	@PostMapping("/community/insert")
	public String communityInsert(Model model, String name) {
		
		
		if(postService.insertCommunity(name)) {
			model.addAttribute("msg", "커뮤니티를 등록했습니다.");
		} else {
			model.addAttribute("msg", "커뮤니티를 등록하지 못했습니다.");
		}
		
		model.addAttribute("url", "/admin/community");
		return "/main/message";
	}
	
	@RequestMapping("/community/delete")
	public String communityDelete(Model model, int co_num) {
		
		
		if(postService.deleteCommunity(co_num)) {
			model.addAttribute("msg", "커뮤니티를 삭제했습니다.");
		} else {
			model.addAttribute("msg", "커뮤니티를 삭제하지 못했습니다.");
		}
		
		model.addAttribute("url", "/admin/community");
		return "/main/message";
	}
	
	@RequestMapping("/community/update")
	public String communityUpdate(Model model, CommunityVO community) {
		
		
		if(postService.updateCommunity(community)) {
			model.addAttribute("msg", "커뮤니티를 수정했습니다.");
		} else {
			model.addAttribute("msg", "커뮤니티를 수정하지 못했습니다.");
		}
		
		model.addAttribute("url", "/admin/community");
		return "/main/message";
	}
}
