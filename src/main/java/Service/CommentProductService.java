package Service;

import Entity.Comment;
import Entity.CommentProduct;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/16 19:59
 */
public interface CommentProductService {
    Integer getProductId(String orderId);
    String getUserId(String orderId);
    Integer insertComment(Comment comment);
    void insertCommentProduct(CommentProduct commentProduct);
    void updateOrderComment(String orderId);
    String getCommentById(String productId);
}
