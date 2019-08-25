package Controller;

import Dao.UserInfoDao;
import Entity.*;
import Service.impl.*;
import Util.ImageUtil;
import Util.PathUtil;
import com.sun.mail.util.MailSSLSocketFactory;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.PasswordAuthentication;
import java.security.GeneralSecurityException;
import java.util.*;

/**
 * @author lxxxxxxy
 * @time 2019/4/1 08:44
 */
@Controller
@RequestMapping("/user")
@Transactional
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoServiceimpl;

    @Autowired
    private UserCheckServiceImpl userCheckServiceimpl;

    @Autowired
    private UserAddressServiceImpl userAddressServiceimpl;

    @Autowired
    private UserShopServiceImpl userShopServiceimpl;

    @Autowired
    private UserProductServiceImpl userProductServiceimpl;

    @Autowired
    private ProductCategoryServiceImpl productCategoryServiceimpl;

    @Autowired
    private ProductBigCategoryServiceImpl productBigCategoryServiceimpl;

    @Autowired
    private UserOrderServiceImpl UserOrderServiceImpl;

    @Autowired
    private OrderProductServiceImpl orderProductServiceimpl;

    @Autowired
    private CommentProductServiceImpl commentProductServiceimpl;

    @RequestMapping(value = "/getIndexCarouselProduct")
    @ResponseBody
    public Map<String, Object> getIndexCarouselProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String carouselProductList = userProductServiceimpl.getIndexCarouselProduct();
        if (carouselProductList == null) {
            modelMap.put("success", false);
            modelMap.put("carouselProductInfo", "获取失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("carouselProductInfo", carouselProductList);
        return modelMap;
    }

    @RequestMapping(value = "/editPassword")
    @ResponseBody
    public Map<String, Object> editPassword(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userId = request.getParameter("userId");
        String password = request.getParameter("newpassword");
        if (userId == null) {
            modelMap.put("success", false);
            modelMap.put("editInfo", "修改密码失败！");
            return modelMap;
        }
        UserCheck userCheck = new UserCheck();
        userCheck.setUserPassword(password);
        userCheck.setUserId(userId);
        userCheckServiceimpl.updatePassword(userCheck);
        modelMap.put("success", true);
        modelMap.put("editInfo", "修改密码成功，请重新登录！");
        return modelMap;
    }

    @RequestMapping(value = "/getComment")
    @ResponseBody
    public Map<String, Object> getComment(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String productId = request.getParameter("productId");
        if (productId == null) {
            modelMap.put("success", false);
            modelMap.put("commentInfo", "获取评论失败！");
            return modelMap;
        }
        String commentJson = commentProductServiceimpl.getCommentById(productId);
        modelMap.put("success", true);
        modelMap.put("commentInfo", commentJson);
        return modelMap;
    }

    @RequestMapping(value = "/commentOrder")
    @ResponseBody
    public Map<String, Object> commentOrder(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String orderId = request.getParameter("orderId");
        String commentDetailContent = null;
        try {
            commentDetailContent = new String(request.getParameter("commentDetail").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String userId = commentProductServiceimpl.getUserId(orderId);
        if (orderId == null || commentDetailContent == null) {
            modelMap.put("success", false);
            modelMap.put("conmmentInfo", "评价订单失败！");
            return modelMap;
        }
        Comment comment1 = new Comment();
        comment1.setCommentUserId(userId);
        comment1.setCommentDetail(commentDetailContent);
        commentProductServiceimpl.insertComment(comment1);
        Integer productId = commentProductServiceimpl.getProductId(orderId);
        CommentProduct commentProduct = new CommentProduct();
        commentProduct.setCommentId(comment1.getCommentId());
        commentProduct.setProductId(productId);
        commentProductServiceimpl.insertCommentProduct(commentProduct);
        commentProductServiceimpl.updateOrderComment(orderId);
        modelMap.put("success", true);
        modelMap.put("conmmentInfo", "评价订单成功！");
        return modelMap;
    }

    @RequestMapping(value = "/confirmOrder")
    @ResponseBody
    public Map<String, Object> confirmOrder(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String orderId = request.getParameter("orderId");
        if (orderId == null) {
            modelMap.put("success", false);
            modelMap.put("confirmInfo", "确认收货失败！");
            return modelMap;
        }
        UserOrderServiceImpl.confirmOrder(orderId);
        modelMap.put("success", true);
        modelMap.put("confirmInfo", "确认收货成功！");
        return modelMap;
    }

    @RequestMapping(value = "/addLogistics")
    @ResponseBody
    public Map<String, Object> addLogistics(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String orderId = request.getParameter("orderId");
        String orderLogistics = request.getParameter("orderLogistics");
        if (orderId == null || orderLogistics == null) {
            modelMap.put("success", false);
            modelMap.put("addInfo", "添加物流信息失败！");
            return modelMap;
        }
        UserOrder userOrder = new UserOrder();
        userOrder.setOrderId(orderId);
        userOrder.setOrderLogistics(orderLogistics);
        UserOrderServiceImpl.addLogistics(userOrder);
        modelMap.put("success", true);
        modelMap.put("addInfo", "添加物流信息成功！");
        return modelMap;
    }

    @RequestMapping(value = "/getOrders")
    @ResponseBody
    public Map<String, Object> getOrders(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userId = request.getParameter("userId");
        if (userId == null) {
            modelMap.put("success", false);
            modelMap.put("orderInfo", "获取订单失败！");
            return modelMap;
        }
        String orders = orderProductServiceimpl.getOrders(userId);
        if (orders == null) {
            modelMap.put("success", false);
            modelMap.put("orderInfo", "获取订单失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("orderInfo", orders);
        return modelMap;
    }

    @RequestMapping(value = "/defaultMyAddress")
    @ResponseBody
    public Map<String, Object> defaultMyAddress(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String myAddressId = request.getParameter("myAddressId");
        String userId = request.getParameter("userId");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserDefaultAddress(Integer.parseInt(myAddressId));
        if (myAddressId == null || userId == null) {
            modelMap.put("success", false);
            modelMap.put("defaultInfo", "设置默认地址失败！");
            return modelMap;
        }
        userInfoServiceimpl.updateDefaultAddress(userInfo);
        modelMap.put("success", true);
        modelMap.put("defaultInfo", "设置默认地址成功！");
        return modelMap;
    }

    @RequestMapping(value = "/addOrder")
    @ResponseBody
    public Map<String, Object> addOrder(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String productId = request.getParameter("productId");
        String buyCount = request.getParameter("buyCount");
        String orderJson = request.getParameter("order");
        orderJson = orderJson.replace("userUUID", "orderUserId");
        JSONObject jsonObject = JSONObject.fromObject(orderJson);
        UserOrder order = (UserOrder) JSONObject.toBean(jsonObject, UserOrder.class);
        if (order == null) {
            modelMap.put("success", false);
            modelMap.put("orderInfo", "订单提交失败！");
            return modelMap;
        }
        String productById = userProductServiceimpl.getProductById(productId);
        JSONObject jsonObject1 = JSONObject.fromObject(productById);
        Product product = (Product) JSONObject.toBean(jsonObject1, Product.class);
        if (product.getProductRemaining() < Integer.parseInt(buyCount)) {
            modelMap.put("success", false);
            modelMap.put("orderInfo", "库存不足！");
            return modelMap;
        } else {
            product.setProductRemaining(Integer.parseInt(buyCount));
            userProductServiceimpl.updateRemaining(product);
        }
        order.setOrderPaymentAmount(product.getProductNowprice() * Integer.parseInt(buyCount));
        UserOrderServiceImpl.insertOrder(order);
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrderId(order.getOrderId());
        orderProduct.setProductId(Integer.parseInt(productId));
        orderProductServiceimpl.insertOrderProduct(orderProduct);
        modelMap.put("success", true);
        modelMap.put("orderInfo", "订单提交成功！");
        return modelMap;
    }

    @RequestMapping(value = "/activation")
    @ResponseBody
    public Map<String, Object> activation(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userUUID = request.getParameter("userUUID");
        if (userUUID == null) {
            modelMap.put("success", false);
            modelMap.put("activeInfo", "激活失败！");
            return modelMap;
        }
        userInfoServiceimpl.activationById(userUUID);
        modelMap.put("success", true);
        modelMap.put("activeInfo", "激活成功！");
        return modelMap;
    }

    @RequestMapping(value = "/buyProduct")
    @ResponseBody
    public Map<String, Object> buyProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userUUID = request.getParameter("userUUID");
        String productId = request.getParameter("productId");
        String userDefaultAddress = request.getParameter("userDefaultAddress");
        String buyCount = request.getParameter("buyCount");
        if (buyCount == null || userDefaultAddress == null || productId == null || userUUID == null) {
            modelMap.put("success", false);
            modelMap.put("buyInfo", "创建订单失败！");
            return modelMap;
        }
        String productInfo = userProductServiceimpl.getProductById(productId);
        UserAddress userAddress = new UserAddress();
        userAddress.setUserAddressUserId(userUUID);
        userAddress.setUserAddressId(userDefaultAddress);
        String userAddressInfo = userAddressServiceimpl.getUserAddressById(userAddress);
        String shopInfo = userShopServiceimpl.getShop(userUUID);
        modelMap.put("success", true);
        modelMap.put("productInfo", productInfo);
        modelMap.put("shopInfo", shopInfo);
        modelMap.put("userAddressInfo", userAddressInfo);
        modelMap.put("buyCount", buyCount);
        return modelMap;
    }

    @RequestMapping(value = "/searchProduct")
    @ResponseBody
    public Map<String, Object> searchProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String search = null;
        try {
            search = new String(request.getParameter("searchContent").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (search == null) {
            modelMap.put("success", false);
            modelMap.put("searchInfo", "获取商品列表失败！");
            return modelMap;
        }
        String productListJson = userProductServiceimpl.getProductListBySearch(search);
        modelMap.put("success", true);
        modelMap.put("searchInfo", productListJson);
        return modelMap;
    }

    @RequestMapping(value = "/getProductListByCategory")
    @ResponseBody
    public Map<String, Object> getProductListByCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String productCategoryId = request.getParameter("productCategoryId");
        if (productCategoryId == null) {
            modelMap.put("success", false);
            modelMap.put("productListInfo", "获取商品列表失败！");
            return modelMap;
        }
        String productListJson = userProductServiceimpl.getProductListByCategory(Integer.parseInt(productCategoryId));
        modelMap.put("success", true);
        modelMap.put("productListInfo", productListJson);
        return modelMap;
    }

    @RequestMapping(value = "/addCategory")
    @ResponseBody
    public Map<String, Object> addCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String categoryJson = request.getParameter("category");
        JSONObject jsonObject = JSONObject.fromObject(categoryJson);
        ProductCategory productCategory = (ProductCategory) JSONObject.toBean(jsonObject, ProductCategory.class);
        if (productCategory == null) {
            modelMap.put("success", false);
            modelMap.put("addInfo", "添加分类失败！");
            return modelMap;
        }
        productCategoryServiceimpl.insertCategory(productCategory);
        modelMap.put("success", true);
        modelMap.put("addInfo", "添加分类成功！");
        return modelMap;
    }

    @RequestMapping(value = "/getBigCategory")
    @ResponseBody
    public Map<String, Object> getBigCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String bigCategory = productBigCategoryServiceimpl.getBigCategory();
        if (bigCategory == null) {
            modelMap.put("success", false);
            modelMap.put("bigCategoryInfo", "获取分类失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("bigCategoryInfo", bigCategory);
        return modelMap;
    }

    @RequestMapping(value = "/productInfo")
    @ResponseBody
    public Map<String, Object> productInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String productId = request.getParameter("productId");
        String productById = userProductServiceimpl.getProductById(productId);
        if (productById == null) {
            modelMap.put("success", false);
            modelMap.put("productInfo", "获取商品失败！");
            return modelMap;
        }
        JSONObject jsonObject = JSONObject.fromObject(productById);
        Product product = (Product) JSONObject.toBean(jsonObject, Product.class);
        String shopName = userProductServiceimpl.getShopNameByProductUserId(product.getProductUserId());
        modelMap.put("success", true);
        modelMap.put("productInfo", productById);
        modelMap.put("shopName", shopName);
        return modelMap;
    }

    @RequestMapping(value = "/getIndexProduct")
    @ResponseBody
    public Map<String, Object> getProductByPriority(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String productList = userProductServiceimpl.getIndexProduct();
        if (productList == null) {
            modelMap.put("success", false);
            modelMap.put("productIndexInfo", "获取失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("productIndexInfo", productList);
        return modelMap;
    }

    @RequestMapping(value = "/addMyAddress")
    @ResponseBody
    public Map<String, Object> addAddress(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userAddressJson = request.getParameter("userAddress");
        userAddressJson = userAddressJson.replace("userUUID", "userAddressUserId");
        JSONObject jsonObject = JSONObject.fromObject(userAddressJson);
        UserAddress userAddress = (UserAddress) JSONObject.toBean(jsonObject, UserAddress.class);
        if (userAddress == null) {
            modelMap.put("success", false);
            modelMap.put("addInfo", "添加地址失败！");
            return modelMap;
        }
        userAddressServiceimpl.insertAddress(userAddress);
        modelMap.put("success", true);
        modelMap.put("addInfo", "添加地址成功！");
        return modelMap;
    }

    @RequestMapping(value = "/deleteCategory")
    @ResponseBody
    public Map<String, Object> deleteCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String categoryId = request.getParameter("categoryId");
        if (categoryId == null) {
            modelMap.put("success", false);
            modelMap.put("deleteInfo", "删除失败！");
            return modelMap;
        }
        productCategoryServiceimpl.deleteProductCategory(Integer.parseInt(categoryId));
        modelMap.put("success", true);
        modelMap.put("deleteInfo", "删除成功！");
        return modelMap;
    }

    @RequestMapping(value = "/getProductCategory")
    @ResponseBody
    public Map<String, Object> getProductCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String productCategory = productCategoryServiceimpl.getProductCategory();
        if (productCategory == null) {
            modelMap.put("success", false);
            modelMap.put("productCategoryInfo", "获取失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("productCategoryInfo", productCategory);
        return modelMap;
    }

    @RequestMapping(value = "/deleteProduct")
    @ResponseBody
    public Map<String, Object> deleteProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取商品id
        String productId = request.getParameter("productId");
        if (productId == null) {
            modelMap.put("success", false);
            modelMap.put("deleteInfo", "删除失败！");
            return modelMap;
        }
        userProductServiceimpl.deleteProduct(productId);
        modelMap.put("success", true);
        modelMap.put("deleteInfo", "删除成功！");
        return modelMap;
    }

    @RequestMapping(value = "/putProduct")
    @ResponseBody
    public Map<String, Object> putProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            //获取商品信息
            String productJson = request.getParameter("product");
            productJson = productJson.replace("userUUID", "productUserId");
            //json->product
            JSONObject jsonObject = JSONObject.fromObject(productJson);
            Product product = (Product) JSONObject.toBean(jsonObject, Product.class);
            if (product == null) {
                modelMap.put("success", false);
                modelMap.put("putProductInfo", "添加商品失败！");
                return modelMap;
            }
            //图片获取
            CommonsMultipartFile productImg = null;
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (commonsMultipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
                productImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("thumbnail");
            } else {
                modelMap.put("success", false);
                modelMap.put("errormessage", "商品图片不能为空！");
                return modelMap;
            }
            //保存商品图片
            addProductImg(product, productImg);
            userProductServiceimpl.putProduct(product);
            modelMap.put("success", true);
            modelMap.put("putProductInfo", "添加商品成功！");
            return modelMap;
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("putProductInfo", "添加商品失败！");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return modelMap;
        }
    }

    @RequestMapping(value = "/managerProductList")
    @ResponseBody
    public Map<String, Object> getProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取用户userUUID
        String userUUID = request.getParameter("userUUID");
        userUUID = userUUID.replace("userUUID", "productUserId");
        //json->product
        JSONObject jsonObject = JSONObject.fromObject(userUUID);
        Product product = (Product) JSONObject.toBean(jsonObject, Product.class);
        if (product == null) {
            modelMap.put("success", false);
            modelMap.put("productInfo", "获取失败！");
            return modelMap;
        }
        String productList = userProductServiceimpl.getProductList(product.getProductUserId());
        modelMap.put("success", true);
        modelMap.put("productInfo", productList);
        return modelMap;
    }

    @RequestMapping(value = "/deleteShop")
    @ResponseBody
    public Map<String, Object> deleteShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取店铺id和用户id
        String shopId = request.getParameter("shopId");
        String userId = request.getParameter("userId");
        if (shopId == null) {
            modelMap.put("success", false);
            modelMap.put("deleteInfo", "删除失败！");
            return modelMap;
        }
        //删除店铺
        userShopServiceimpl.deleteShop(Integer.parseInt(shopId),userId);
        //修改用户中的user_apply_shop
        userInfoServiceimpl.updateUserByApplyShop(userId);
        modelMap.put("success", true);
        modelMap.put("deleteInfo", "删除成功！");
        return modelMap;
    }

    @RequestMapping(value = "/getAllShop")
    @ResponseBody
    public Map<String, Object> getAllShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String shop = userShopServiceimpl.getAllShop();
        if (shop == null) {
            modelMap.put("success", false);
            modelMap.put("info", "获取失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("info", shop);
        return modelMap;
    }

    @RequestMapping(value = "/editManagerShop")
    @ResponseBody
    public ModelAndView editManagerShop(HttpServletRequest request) throws IOException, TemplateException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ModelAndView modelAndView = new ModelAndView();
        //获取用户id
        String userId = request.getParameter("userId");
        String shop = userShopServiceimpl.getShop(userId);
        if (shop == null) {
            modelMap.put("success", false);
            modelMap.put("deleteInfo", "获取店铺信息失败！");
            modelAndView.addObject("map", modelMap);
            return modelAndView;
        }
        modelMap.put("success", true);
        modelMap.put("editInfo", shop);

        //生成freemarker模板
        String realPath = request.getSession().getServletContext().getRealPath("");
        String apache = realPath.substring(0, realPath.indexOf("Apache"));
        String dir = apache + "Apache/src/main/webapp/WEB-INF/ftl/user";
        Configuration conf = new Configuration(Configuration.getVersion());
        conf.setDefaultEncoding("UTF-8");
        //加载模板文件(模板的路径)
        conf.setDirectoryForTemplateLoading(new File(dir));
        conf.setTemplateUpdateDelayMilliseconds(0);
        // 加载模板
        Template template = conf.getTemplate("/editManagerShop.ftl");
        // 定义数据

        Map root = new HashMap();
        root.put("shopInfo", shop);
        // 定义输出
        File file = new File(dir + "/editManagerShop/" + userId);
        file.mkdirs();
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir + "/editManagerShop/" + userId + "/editManagerShop.html"), "UTF-8"));
        template.process(root, out);
        out.flush();
        out.close();
        File file1 = new File("");
        try {
            file1 = new File(dir + "/editMyAddress/" + userId + "/editMyAddress.html");
        } catch (Exception e) {
        } finally {

        }
        //返回模型与视图
        modelAndView.addObject("map", modelMap);
        modelAndView.setViewName("/user/editManagerShop/" + userId + "/editManagerShop");

        return modelAndView;
    }

    @RequestMapping(value = "/deleteMyAddress")
    @ResponseBody
    public Map<String, Object> deleteAddress(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取地址id
        String myAddressId = request.getParameter("myAddressId");
        String userId = request.getParameter("userId");
        UserAddress userAddress = new UserAddress();
        userAddress.setUserAddressId(myAddressId);
        userAddress.setUserAddressUserId(userId);
        if (userAddress == null) {
            modelMap.put("success", false);
            modelMap.put("deleteInfo", "删除失败！");
            return modelMap;
        }
        //删除地址
        userAddressServiceimpl.deleteUserAddress(userAddress);
        modelMap.put("success", true);
        modelMap.put("deleteInfo", "删除成功！");
        return modelMap;
    }


    @RequestMapping(value = "/editAddress")
    @ResponseBody
    public Map<String, Object> editAddress(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取用户地址信息
        String userAddressByJson = request.getParameter("userAddress");
        String myAddressId = request.getParameter("myAddressId");
        String userId = request.getParameter("userId");
        //json->userAddress
        JSONObject jsonObject = JSONObject.fromObject(userAddressByJson);
        UserAddress userAddress = (UserAddress) JSONObject.toBean(jsonObject, UserAddress.class);
        userAddress.setUserAddressId(myAddressId);
        userAddress.setUserAddressUserId(userId);
        if (userAddress == null) {
            modelMap.put("success", false);
            modelMap.put("editInfo", "修改失败！");
            return modelMap;
        }
        userAddressServiceimpl.updateUserAddress(userAddress);
        modelMap.put("success", true);
        modelMap.put("editInfo", "修改成功！");
        return modelMap;
    }


    @RequestMapping(value = "/editMyAddress")
    @ResponseBody
    public ModelAndView editMyAddress(HttpServletRequest request) throws IOException, TemplateException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ModelAndView modelAndView = new ModelAndView();
        //获取地址id
        String myAddressId = request.getParameter("myAddressId");
        //获取用户id
        String userId = request.getParameter("userId");
        UserAddress userAddress = new UserAddress();
        userAddress.setUserAddressId(myAddressId);
        userAddress.setUserAddressUserId(userId);
        //获取地址信息
        String userAddressJson = userAddressServiceimpl.getUserAddressById(userAddress);

        if (userAddressJson == null) {
            modelMap.put("success", false);
            modelMap.put("myAddressInfo", "获取失败！");
            modelAndView.addObject("map", modelMap);
            return modelAndView;
        }
//        modelMap.put("success", true);
//        modelMap.put("myAddressInfo", userAddressJson);

        //生成freemarker模板
        String realPath = request.getSession().getServletContext().getRealPath("");
        String apache = realPath.substring(0, realPath.indexOf("Apache"));
        String dir = apache + "Apache/WEB-INF/ftl/user";
        Configuration conf = new Configuration(Configuration.getVersion());
        conf.setDefaultEncoding("UTF-8");
        //加载模板文件(模板的路径)
        conf.setDirectoryForTemplateLoading(new File(dir));
        conf.setTemplateUpdateDelayMilliseconds(0);
        // 加载模板
        Template template = conf.getTemplate("/editMyAddress.ftl");
        // 定义数据

        Map root = new HashMap();
        root.put("myAddressInfo", userAddressJson);
        // 定义输出
        File file = new File(dir + "/editMyAddress/" + userId + myAddressId);
        file.mkdirs();
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir + "/editMyAddress/" + userId + myAddressId + "/editMyAddress.html"), "UTF-8"));
        template.process(root, out);
        out.flush();
        out.close();
        File file1 = new File("");
        try {
            file1 = new File(dir + "/editMyAddress/" + userId + myAddressId + "/editMyAddress.html");
        } catch (Exception e) {
        } finally {
            if (file1.exists()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        //返回模型与视图
        modelAndView.addObject("map", modelMap);
        modelAndView.setViewName("/user/editMyAddress/" + userId + myAddressId + "/editMyAddress");

        return modelAndView;
    }

    @RequestMapping(value = "/getMyAddress")
    @ResponseBody
    public Map<String, Object> getMyAddress(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取userUUID
        String userUUID = request.getParameter("userUUID");
        userUUID = userUUID.replace("userUUID", "userId");
        //json->userInfo
        JSONObject jsonObject = JSONObject.fromObject(userUUID);
        UserInfo userInfo = (UserInfo) JSONObject.toBean(jsonObject, UserInfo.class);
        if (userInfo == null) {
            modelMap.put("success", false);
            modelMap.put("myAddressInfo", "获取失败！");
            return modelMap;
        }
        //获取地址列表
        String userAddressJson = userAddressServiceimpl.getUserAddressList(userInfo.getUserId());
        modelMap.put("success", true);
        modelMap.put("myAddressInfo", userAddressJson);
        return modelMap;
    }

    @RequestMapping(value = "/applyForShop")
    @ResponseBody
    public Map<String, Object> applyForShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取提交的shop信息
        String shopJson = request.getParameter("shop");
        shopJson = shopJson.replace("userUUID", "shopUserId");
        //json->shop
        JSONObject jsonObject = JSONObject.fromObject(shopJson);
        Shop shop = (Shop) JSONObject.toBean(jsonObject, Shop.class);
        //图片获取
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("thumbnail");
        } else {
            modelMap.put("success", false);
            modelMap.put("errormessage", "上传的图片不能为空！");
            return modelMap;
        }
        Integer is_applyShop = 0;
        try {
            //保存店铺图片
            addShopImg(shop, shopImg);
            //申请，返回修改行数
            is_applyShop = userInfoServiceimpl.applyShop(shop.getShopUserId());
            //初始化shop
            userInfoServiceimpl.initShop(shop);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("applyInfo", "申请失败！");
            return modelMap;
        }

        if (is_applyShop == null) {
            modelMap.put("success", false);
            modelMap.put("applyInfo", "信息有误！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("applyInfo", "申请成功！");
        return modelMap;
    }

    //后面再做
    @RequestMapping(value = "/managerOrders")
    @ResponseBody
    public Map<String, Object> myOrders(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userId = request.getParameter("userId");
        if (userId == null) {
            modelMap.put("success", false);
            modelMap.put("orderInfo", "获取订单失败！");
            return modelMap;
        }
        String orders = orderProductServiceimpl.getOrdersByShop(userId);
        if (orders == null) {
            modelMap.put("success", false);
            modelMap.put("orderInfo", "获取订单失败！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("orderInfo", orders);
        return modelMap;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取登录的userCheck的json数据
        String userCheck_str = request.getParameter("userCheck");
        userCheck_str = userCheck_str.replace("userUUID", "userId");
        //json->userCheck
        JSONObject jsonObject = JSONObject.fromObject(userCheck_str);
        UserCheck userCheck = (UserCheck) JSONObject.toBean(jsonObject, UserCheck.class);
        if (userCheck == null) {
            modelMap.put("success", false);
            modelMap.put("loginInfo", "用户名或密码错误！");
            return modelMap;
        }
        UserCheck user = userCheckServiceimpl.login(userCheck);
        if (user == null) {
            modelMap.put("success", false);
            modelMap.put("loginInfo", "用户名或密码错误！");
            return modelMap;
        }
        UserInfo userInfo = userInfoServiceimpl.selectUser(user.getUserId());
        if (userInfo.getUserStatus().equals(0)) {
            modelMap.put("success", false);
            modelMap.put("loginInfo", "请先激活账户！");
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("loginInfo", "登录成功！");
        //设置cookie
        Cookie cookie = new Cookie("userUUID", user.getUserId());
        cookie.setPath("/");
        response.addCookie(cookie);
        return modelMap;
    }

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public Map<String, Object> userInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取用户的userId
        String userUUID = request.getParameter("userUUID");
        userUUID = userUUID.replace("userUUID", "userId");
        //将userUUID转成对象
        JSONObject jsonObject = JSONObject.fromObject(userUUID);
        UserCheck userCheck = (UserCheck) JSONObject.toBean(jsonObject, UserCheck.class);
        UserInfo userInfo = userInfoServiceimpl.selectUser(userCheck.getUserId());
        if (userInfo == null) {
            modelMap.put("success", false);
            modelMap.put("userInfo", "获取用户信息失败！");
            return modelMap;
        }
        //管理员账户操作
        if (userInfo.getUserType() == 2) {
            modelMap.put("success", true);
            modelMap.put("userInfo", JSONObject.fromObject(userInfo).toString());
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("userInfo", JSONObject.fromObject(userInfo).toString());
        return modelMap;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userRegister(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取userInfo的json数据
        String user = request.getParameter("userInfo");
        //将userInfo中的键userUUID替换为userId
        user = user.replace("userUUID", "userId");
        //将字符串的userInfo转换为userInfo对象
        JSONObject jsonObject = JSONObject.fromObject(user);
        UserInfo userInfo = (UserInfo) JSONObject.toBean(jsonObject, UserInfo.class);
        //获取用户注册的账号密码
        String userc = request.getParameter("userCheck");
        //将userInfo中的键userUUID替换为userId
        userc = userc.replace("userUUID", "userId");
        //将字符串的userCheck转换为userCheck对象
        UserCheck userCheck = (UserCheck) JSONObject.toBean(JSONObject.fromObject(userc), UserCheck.class);
        //图片获取
        CommonsMultipartFile userInfoHeadImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            userInfoHeadImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("thumbnail");
        } else {
            modelMap.put("success", false);
            modelMap.put("errormessage", "上传的图片不能为空！");
            return modelMap;
        }

        if (userInfo != null && userInfoHeadImg != null) {
            //设置userInfo的一系列默认值
            userInfo.setUserStatus(0);
            userInfo.setUserType(0);
            userInfo.setUserApplyShop(0);
            userInfo.setUserDefaultAddress(0);
            userInfo.setUserCreatetime(new Date());
            userInfo.setUserLastEditTime(new Date());
            userInfo.setUserId(UUID.randomUUID().toString());
            //保存userInfo
            try{
                userInfoServiceimpl.insertUser(userInfo, userCheck, userInfoHeadImg);
            }catch (Exception e){
                modelMap.put("success", false);
                modelMap.put("info", "注册失败！");
                return modelMap;
            }
            //发送邮件
            // 收件人电子邮箱
            String to = userInfo.getUserEmail();

            // 发件人电子邮箱
            String from = "597973086@qq.com";

            Properties props = new Properties(); // SSL 加密
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();      // 设置信任所有的主机
                sf.setTrustAllHosts(true);
                props.put("mail.smtp.ssl.enable", "true");
                props.put("mail.smtp.ssl.socketFactory", sf);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            props.setProperty("mail.smtp.auth", "true");// 请求身份认证

            props.put("mail.smtp.auth", "true");
            // 获取默认 session 对象
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("597973086@qq.com", "hyaphesbqoesbbcb"); // 发件人邮件用户名、授权码
                }
            });

            try {
                // 创建默认的 MimeMessage 对象
                MimeMessage message = new MimeMessage(session);

                // Set From: 头部头字段
                message.setFrom(new InternetAddress(from));

                // Set To: 头部头字段
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to));

                // Set Subject: 头部头字段
                message.setSubject("用户激活");


                // 设置消息体
                message.setContent("<a href='http://lixingyu.cn/Apache/activation?userUUID=" + userInfo.getUserId() + "'>点我激活账户</a>",
                        "text/html;charset=utf-8");
                message.setHeader("charset", "utf-8");
                // 发送消息
                Transport.send(message);

            } catch (MessagingException mex) {
                System.out.println(mex);
                mex.printStackTrace();
                modelMap.put("success", false);
                modelMap.put("info", "注册失败！" + mex);
                return modelMap;
            }
            modelMap.put("success", true);
            modelMap.put("info", "注册成功！");
        } else {
            modelMap.put("success", false);
            modelMap.put("info", "注册失败！");
        }
        return modelMap;
    }

    public void addShopImg(Shop shop, CommonsMultipartFile headImg) {
        //获取店铺图片路径
        String dest = PathUtil.getShopImgPath(shop.getShopUserId());
        //获取店铺图片绝对路径并保存图片
        String ShopImgAddr = ImageUtil.generateThumbnail(headImg, dest);
        //把店铺图片绝对路径存入数据库
        shop.setShopImage(ShopImgAddr);
    }

    public void addProductImg(Product product, CommonsMultipartFile productImg) {
        //获取保存商品图片路径
        String dest = PathUtil.getProductImgPath(product.getProductUserId());
        //获取商品图片绝对路径并保存图片
        String ProductImgAddr = ImageUtil.generateThumbnail(productImg, dest);
        //把商品图片绝对路径存入数据库
        product.setProductImage(ProductImgAddr);
    }
}
