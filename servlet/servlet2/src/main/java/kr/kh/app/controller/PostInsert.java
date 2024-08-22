package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/insert")
public class PostInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String co_num = request.getParameter("co_num");
		request.setAttribute("co_num", co_num);
		request.getRequestDispatcher("/WEB-INF/views/post/insert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String co_num = request.getParameter("po_co_num");
		String title = request.getParameter("po_title");
		String content = request.getParameter("po_content");
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		
		PostVO post = new PostVO(title, content, user.getMe_id(), co_num);
		
		boolean res = postService.insertPost(post); 
		
		if(res) {
			request.setAttribute("msg",	"게시글 등록하였습니다.");
			request.setAttribute("url", "/post/list?co_num=" + co_num);
		} else {
			request.setAttribute("msg",	"게시글 등록에 실패하였습니다.");
			request.setAttribute("url", "/post/list?co_num=" + co_num);
		}

		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}


}
