package shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.model.vo.CategoryVO;
import shopping.service.ProductService;
import shopping.service.ProductServiceImp;

@WebServlet("/shoppingmall/searchproductall")
public class SearchProductAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CategoryVO> list = productService.getCategoryList();
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/shoppingmall/searchproductall.jsp").forward(request, response);
	}


}
