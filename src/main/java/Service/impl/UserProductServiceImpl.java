package Service.impl;

import Dao.UserProductDao;
import Entity.Product;
import Entity.Shop;
import Service.UserProductService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author lxxxxxxy
 * @time 2019/4/9 15:04
 */
@Service
public class UserProductServiceImpl implements UserProductService {

    @Autowired
    private UserProductDao userProductDao;

    @Override
    public String getProductList(String userId) {
        if (userId == null) {
            return null;
        }
        List<Product> productList = userProductDao.getProductList(userId);
        JSONArray json = JSONArray.fromObject(productList);
        String productListJson = json.toString();
        return productListJson;
    }

    @Override
    public void putProduct(Product product) {
        if (product == null) {
            throw new RuntimeException("添加商品失败！");
        }
        userProductDao.putProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        if (productId == null) {
            throw new RuntimeException("删除商品失败！");
        }
        userProductDao.deleteProduct(productId);
    }

    @Override
    public String getIndexCarouselProduct() {
        Integer countProduct = userProductDao.getCountProduct();
        int[] a = new int[]{-1,-1,-1,-1,-1};
        Random random = new Random();
        int count = 0;
        while(count < a.length){
            boolean flag = true;
            int r = random.nextInt(countProduct);
            for(int i=0;i<a.length;i++){
                if(r == a[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                a[count] = r;
                count++;
            }
        }
        Entity.Random random1 = new Entity.Random();
        random1.setA1(a[1]);
        random1.setA2(a[2]);
        random1.setA3(a[3]);
        random1.setA4(a[4]);
        random1.setA5(a[0]);
        List<Product> productByPriority = userProductDao.getIndexCarouselProduct(random1);
        JSONArray json = JSONArray.fromObject(productByPriority);
        String productListJson = json.toString();
        return productListJson;
    }

    @Override
    public String getIndexProduct() {
        Integer countProduct = userProductDao.getCountProduct();
        int[] a = new int[]{-1,-1,-1,-1,-1,-1,-1};
        Random random = new Random();
        int count = 0;
        while(count < a.length){
            boolean flag = true;
            int r = random.nextInt(countProduct);
            for(int i=0;i<a.length;i++){
                if(r == a[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                a[count] = r;
                count++;
            }
        }
        Entity.Random random1 = new Entity.Random();
        random1.setA7(a[0]);
        random1.setA1(a[1]);
        random1.setA2(a[2]);
        random1.setA3(a[3]);
        random1.setA4(a[4]);
        random1.setA5(a[5]);
        random1.setA6(a[6]);
        List<Product> productByPriority = userProductDao.getIndexProduct(random1);
        JSONArray json = JSONArray.fromObject(productByPriority);
        String productListJson = json.toString();
        return productListJson;
    }

    @Override
    public String getProductById(String productId) {
        if (productId == null) {
            throw new RuntimeException("获取商品失败！");
        }
        Product productById = userProductDao.getProductById(productId);
        JSONObject jsonObject = JSONObject.fromObject(productById);
        String productByIdJson = jsonObject.toString();
        return productByIdJson;
    }

    @Override
    public String getProductListByCategory(Integer productCategoryId) {
        if (productCategoryId == null) {
            throw new RuntimeException("获取商品列表失败！");
        }
        List<Product> productListByCategory = userProductDao.getProductListByCategory(productCategoryId);
        JSONArray json = JSONArray.fromObject(productListByCategory);
        String productListJson = json.toString();
        return productListJson;
    }

    @Override
    public String getProductListBySearch(String productName) {
        if (productName == null) {
            throw new RuntimeException("获取商品列表失败！");
        }
        List<Product> productListBySearch = userProductDao.getProductListBySearch(productName);
        JSONArray json = JSONArray.fromObject(productListBySearch);
        String productListJson = json.toString();
        return productListJson;
    }

    @Override
    public String getShopNameByProductUserId(String shopUserId) {
        if (shopUserId == null) {
            throw new RuntimeException("获取店铺信息失败！");
        }
        Shop shopNameByProductUserId = userProductDao.getShopNameByProductUserId(shopUserId);
        JSONObject jsonObject = JSONObject.fromObject(shopNameByProductUserId);
        String ShopJson = jsonObject.toString();
        return ShopJson;
    }

    @Override
    public void updateRemaining(Product product) {
        if (product == null) {
            throw new RuntimeException("提交订单失败！");
        }
        userProductDao.updateRemaining(product);
    }
}
