package kr.kh.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.dto.MessageDTO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
    @Autowired
    MemberService memberService;
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("/ : 메인페이지입니다.");
		model.addAttribute("title", "메인");
		return "/main/home";
	}
	@GetMapping("/guest/signup")
	public String guestSignup() {
		log.info("/guest/signup:get");
		return "/member/signup";
	}
	@PostMapping("/guest/signup")
	public String guestSignupPost(Model model, MemberVO member) {
		log.info("/guest/signup:post");
		MessageDTO message;
		if(memberService.signup(member)) {
			message = new MessageDTO("/" , "회원 가입에 성공했습니다.");
		} else {
			message = new MessageDTO("/guest/signup" , "아이디 또는 이메일이 중복되었습니다..");
		}
		model.addAttribute("message", message);
		return "/main/message";
	}
	
	
}
