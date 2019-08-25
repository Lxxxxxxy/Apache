package Dao;

import Entity.ProductCategory;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/10 19:31
 */
public interface ProductCategoryDao {
    List<ProductCategory> getProductCategory();
    void deleteProductCategory(Integer productCategoryId);
    void insertCategory(ProductCategory productCategory);
}
