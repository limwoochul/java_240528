package shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.model.dto.LoginDTO;
import shopping.model.vo.MemberVO;
import shopping.service.MemberService;
import shopping.service.MemberServiceImp;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDTO member = new LoginDTO(id, pw, "", "", "", 0, "");
		
		MemberVO user = memberService.login(member);
		
		if(user == null) {
			request.setAttribute("msg", "로그인 실패!");
			request.setAttribute("url", "/login");
		} else {
			request.setAttribute("msg", "로그인 성공!");
			request.setAttribute("url", "/");
			request.getSession().setAttribute("user", user);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
