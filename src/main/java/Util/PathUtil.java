package Util;

/**
 * @author lxxxxxxy
 * @time 2019/3/22 08:55
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/Images/";
        }else{
            basePath = "/home/Images/";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    public static String getUserImgPath(String userId){
        String imagePath = "/Apache/upload/item/user/head/" + userId + "/";
        return imagePath;
    }

    public static String getShopImgPath(String userId){
        String imagePath = "/Apache/upload/item/user/shop/" + userId + "/";
        return imagePath;
    }

    public static String getProductImgPath(String userId){
        String imagePath = "/Apache/upload/item/user/product/" + userId + "/";
        return imagePath;
    }
}
