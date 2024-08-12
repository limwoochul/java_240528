package shopping.dao;

import java.util.List;

import shopping.model.vo.CategoryVO;

public interface ProductDAO {

	List<CategoryVO> selectCategoryList();

}
