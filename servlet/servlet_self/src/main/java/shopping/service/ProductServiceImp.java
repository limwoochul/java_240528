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
}
