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

@WebServlet("/post/update")
public class PostUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String po_num = request.getParameter("po_num");
		PostVO post = postService.getPost(po_num);
		request.setAttribute("post", post);
		request.getRequestDispatcher("/WEB-INF/views/post/update.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String po_num = request.getParameter("po_num");
		String title = request.getParameter("po_title");
		String content = request.getParameter("po_content");
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		
		PostVO post = new PostVO(po_num, title, content);
		
		boolean res = postService.updatePost(post, user);
		
		if(res) {
			request.setAttribute("msg",	"게시글 수정하였습니다.");
			request.setAttribute("url", "/post/detail?po_num=" + po_num);
		} else {
			request.setAttribute("msg",	"게시글 수정에 실패하였습니다.");
			request.setAttribute("url", "/post/detail?po_num=" + po_num);
		}

		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
		
		
	}

}
