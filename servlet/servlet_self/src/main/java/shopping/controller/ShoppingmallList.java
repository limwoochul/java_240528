package shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.model.vo.CategoryVO;
import shopping.model.vo.ProductVO;
import shopping.pagination.Criteria;
import shopping.pagination.PageMaker;
import shopping.pagination.ProductCriteria;
import shopping.service.ProductService;
import shopping.service.ProductServiceImp;

@WebServlet("/shoppingmall/list")
public class ShoppingmallList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cgNum = 0;
		
		try {
			cgNum = Integer.parseInt(request.getParameter("cg_num"));
			String pageStr = request.getParameter("page");
			int page = 1;
			if(pageStr != null && pageStr.length() != 0) {
				page = Integer.parseInt(pageStr);
			}
			String search = request.getParameter("search");
			
			CategoryVO category = productService.getCategory(cgNum);
			if(category == null) {
				throw new Exception();
			}
			Criteria cri = new ProductCriteria(page, 3, search, cgNum);
			PageMaker pm = productService.getPageMaker(cri, 2);
			
			List<ProductVO> list = productService.getProductList(cri);
			
			request.setAttribute("cg", category);
			request.setAttribute("list", list);
			request.setAttribute("pm", pm);
			request.getRequestDispatcher("/WEB-INF/views/shoppingmall/list.jsp").forward(request, response);			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 카테고리입니다.");
			request.setAttribute("url", "/shopping");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		
		
	}


}
