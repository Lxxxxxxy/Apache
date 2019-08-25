package Service.impl;

import Dao.ProductBigCategoryDao;
import Service.ProductBigCategoryService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/12 10:13
 */
@Service
public class ProductBigCategoryServiceImpl implements ProductBigCategoryService {

    @Autowired
    private ProductBigCategoryDao productBigCategoryDao;

    @Override
    public String getBigCategory() {
        List<ProductBigCategoryDao> bigCategory = productBigCategoryDao.getBigCategory();
        String bigCategoryJson = JSONArray.fromObject(bigCategory).toString();
        return bigCategoryJson;
    }
}
