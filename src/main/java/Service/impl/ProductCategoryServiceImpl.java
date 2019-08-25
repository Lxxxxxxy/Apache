package Service.impl;

import Dao.ProductCategoryDao;
import Entity.ProductCategory;
import Service.ProductCategoryService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/10 19:33
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public String getProductCategory() {
        List<ProductCategory> productCategory = productCategoryDao.getProductCategory();
        JSONArray json = JSONArray.fromObject(productCategory);
        String productCategoryJson = json.toString();
        return productCategoryJson;
    }

    @Override
    public void deleteProductCategory(Integer productCategoryId) {
        if (productCategoryId == null) {
            throw new RuntimeException("删除商品分类失败！");
        }
        productCategoryDao.deleteProductCategory(productCategoryId);
    }

    @Override
    public void insertCategory(ProductCategory productCategory) {
        if (productCategory == null) {
            throw new RuntimeException("添加商品分类失败！");
        }
        productCategoryDao.insertCategory(productCategory);
    }
}
