package shopping.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shopping.dao.ProductDAO;
import shopping.model.vo.CategoryVO;
import shopping.model.vo.ProductVO;
import shopping.pagination.Criteria;
import shopping.pagination.PageMaker;

public class ProductServiceImp implements ProductService {

	private ProductDAO productDao;
	
	public ProductServiceImp() {
		String resource = "shopping/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			productDao = session.getMapper(ProductDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryVO> getCategoryList() {
		return productDao.selectCategoryList();
	}

	@Override
	public CategoryVO getCategory(int cgNum) {
		return productDao.selectCategory(cgNum);
	}

	@Override
	public List<ProductVO> getProductList(Criteria cri) {
		if(cri == null) {
			throw new RuntimeException();
		}
		return productDao.selectProductList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		if(cri == null) {
			throw new RuntimeException();
		}
		int totalCount = productDao.selectProductTotalCount(cri);
		return new PageMaker(totalCount, displayPageNum, cri);
	}
}
