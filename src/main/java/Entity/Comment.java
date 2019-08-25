package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/16 20:05
 */
public class Comment {
    /*
    * comment_detail	text
comment_user_id	int

    * */
    private Integer commentId;
    private String commentDetail;
    private String commentUserId;
    private String userHeadImage;
    private String userName;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentDetail='" + commentDetail + '\'' +
                ", commentUserId='" + commentUserId + '\'' +
                ", userHeadImage='" + userHeadImage + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getUserHeadImage() {
        return userHeadImage;
    }

    public void setUserHeadImage(String userHeadImage) {
        this.userHeadImage = userHeadImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Comment(Integer commentId, String commentDetail, String commentUserId, String userHeadImage, String userName) {
        this.commentId = commentId;
        this.commentDetail = commentDetail;
        this.commentUserId = commentUserId;
        this.userHeadImage = userHeadImage;
        this.userName = userName;
    }

    public Comment() {
    }
}
