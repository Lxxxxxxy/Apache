package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/12 10:10
 */
public class BigCategory {
    private Integer productBigCategoryId;
    private String productBigCategoryName;

    @Override
    public String toString() {
        return "BigCategory{" +
                "productBigCategoryId=" + productBigCategoryId +
                ", productBigCategoryName='" + productBigCategoryName + '\'' +
                '}';
    }

    public Integer getProductBigCategoryId() {
        return productBigCategoryId;
    }

    public void setProductBigCategoryId(Integer productBigCategoryId) {
        this.productBigCategoryId = productBigCategoryId;
    }

    public String getProductBigCategoryName() {
        return productBigCategoryName;
    }

    public void setProductBigCategoryName(String productBigCategoryName) {
        this.productBigCategoryName = productBigCategoryName;
    }

    public BigCategory(Integer productBigCategoryId, String productBigCategoryName) {
        this.productBigCategoryId = productBigCategoryId;
        this.productBigCategoryName = productBigCategoryName;
    }

    public BigCategory() {
    }
}
