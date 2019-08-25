package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/16 19:55
 */
public class CommentProduct {
    private Integer commentId;
    private Integer productId;

    @Override
    public String toString() {
        return "CommentProduct{" +
                "commentId=" + commentId +
                ", productId=" + productId +
                '}';
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public CommentProduct(Integer commentId, Integer productId) {
        this.commentId = commentId;
        this.productId = productId;
    }

    public CommentProduct() {
    }
}
