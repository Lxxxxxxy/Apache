package Service;

import Entity.ProductCategory;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/10 19:32
 */
public interface ProductCategoryService {
    String getProductCategory();
    void deleteProductCategory(Integer productCategoryId);
    void insertCategory(ProductCategory productCategory);
}
