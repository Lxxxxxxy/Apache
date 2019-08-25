package Service.impl;

import Dao.CommentProductDao;
import Dao.UserInfoDao;
import Entity.Comment;
import Entity.CommentProduct;
import Service.CommentProductService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/16 19:59
 */
@Service
public class CommentProductServiceImpl implements CommentProductService {

    @Autowired
    private CommentProductDao commentProductDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Integer getProductId(String orderId) {
        if (orderId == null) {
            return null;
        }
        Integer productId = commentProductDao.getProductId(orderId);
        return productId;
    }

    @Override
    public String getUserId(String orderId) {
        if (orderId == null) {
            return null;
        }
        String userId = commentProductDao.getUserId(orderId);
        return userId;
    }

    @Override
    public Integer insertComment(Comment comment) {
        if (comment == null) {
            return null;
        }
        Integer commentId = commentProductDao.insertComment(comment);
        return commentId;
    }

    @Override
    public void insertCommentProduct(CommentProduct commentProduct) {
        if (commentProduct == null) {
            throw new RuntimeException("评价订单失败！");
        }
        commentProductDao.insertCommentProduct(commentProduct);
    }

    @Override
    public void updateOrderComment(String orderId) {
        if (orderId == null) {
            throw new RuntimeException("评价订单失败！");
        }
        commentProductDao.updateOrderComment(orderId);
    }

    @Override
    public String getCommentById(String productId) {
        if (productId == null) {
            return null;
        }
        List<Comment> commentById = commentProductDao.getCommentById(productId);
        JSONArray json = JSONArray.fromObject(commentById);
        String commentJson = json.toString();
        return commentJson;
    }
}
