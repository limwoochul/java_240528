package shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.model.dto.LoginDTO;
import shopping.service.MemberService;
import shopping.service.MemberServiceImp;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String questionStr = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		try {
			int question = Integer.parseInt(questionStr);
			LoginDTO member = new LoginDTO(id, pw, name, address, phone, question, answer);
			if(memberService.signup(member)) {
				request.setAttribute("msg", "회원 가입에 성공했습니다.");
				request.setAttribute("url", "/");
			} else {
				throw new RuntimeException();
			}

		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "회원 가입에 실패했습니다.");
			request.setAttribute("url", "/signup");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
