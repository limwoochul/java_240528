package shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopping.model.vo.CategoryVO;
import shopping.model.vo.ProductVO;
import shopping.pagination.Criteria;

public interface ProductDAO {

	List<CategoryVO> selectCategoryList();

	CategoryVO selectCategory(@Param("cg_num")int cgNum);

	List<ProductVO> selectProductList(@Param("cri")Criteria cri);

	int selectProductTotalCount(@Param("cri")Criteria cri);

}
