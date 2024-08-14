package shopping.service;

import java.util.List;

import shopping.model.vo.CategoryVO;
import shopping.model.vo.ProductVO;
import shopping.pagination.Criteria;
import shopping.pagination.PageMaker;

public interface ProductService {

	List<CategoryVO> getCategoryList();

	CategoryVO getCategory(int cgNum);

	List<ProductVO> getProductList(Criteria cri);

	PageMaker getPageMaker(Criteria cri, int displayPageNum);

}
