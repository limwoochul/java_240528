package kr.kh.spring3.controller;

import javax.servlet.http.HttpSession;

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
			message = new MessageDTO("/guest/signup" , "아이디 또는 이메일이 중복되었습니다.");
		}
		model.addAttribute("message", message);
		return "/main/message";
	}
	
	@GetMapping("/guest/login")
	public String guestlogin(Model model) {
		log.info("/guest/login:get");
		return "/member/login";
	}
	@PostMapping("/guest/login")
	public String guestLoginPost(Model model, MemberVO member, HttpSession session) {
		log.info("/guest/login:post");
		MessageDTO message;
		MemberVO user = memberService.login(member);
		if(user != null) {
			message = new MessageDTO("/", "로그인에 성공했습니다.");
			session.removeAttribute("id");
		} else {
			message = new MessageDTO("/guest/login", "로그인에 실패했습니다.");
			session.setAttribute("id", member.getMe_id());
		}
		model.addAttribute("user", user);
		model.addAttribute("message", message);
		return "/main/message";
	}
	
	@GetMapping("/member/logout")
	public String memberLogout(Model model, HttpSession session) {
		log.info("/member/logout:get");
		session.removeAttribute("user");
		
		MessageDTO message = new MessageDTO("/", "로그아웃 되었습니다.");
		
		model.addAttribute("message", message);
		return "/main/message";
	}
	

}
