package shopping.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCriteria extends Criteria {

	private int cg_num;
	
	public ProductCriteria(int page, int perPageNum, String search, int cg_num) {
		super(page, perPageNum, search);
		this.cg_num = cg_num;
	}
}
