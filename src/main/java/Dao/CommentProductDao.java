package Dao;

import Entity.Comment;
import Entity.CommentProduct;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/16 19:58
 */
public interface CommentProductDao {
    Integer getProductId(String orderId);
    String getUserId(String orderId);
    Integer insertComment(Comment comment);
    void insertCommentProduct(CommentProduct commentProduct);
    void updateOrderComment(String orderId);
    List<Comment> getCommentById(String productId);
}
