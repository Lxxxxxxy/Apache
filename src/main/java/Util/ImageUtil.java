package Util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author lxxxxxxy
 * @time 2019/3/22 08:36
 */
public class ImageUtil {

//    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("src/watermark_null.png").getPath();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();

    public static String generateThumbnail(CommonsMultipartFile userInfoHeadImg, String targetAddress){
        //把/D:/IdeaProjects/o2o/target/test-classes/改成D:/IdeaProjects/o2o/target/test-classes/resource/
//        basePath = basePath.substring(1,basePath.length())+"";
        //获取随机文件名
        String realFileName = getRandomFileName();
        //获取文件扩展名
        String extension = getFileExtension(userInfoHeadImg);
        //创建文件夹
        makeDirPath(targetAddress);
        //获取绝对路径
        String relativeAddress = targetAddress + realFileName + extension;
        //在目录新建一个文件
        File dest = new File(PathUtil.getImgBasePath() + relativeAddress);
//        System.out.println(basePath);
        //图片上传
        MultipartFile multipartFile = userInfoHeadImg;
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return relativeAddress;
    }

    public static void makeDirPath(String targetAddress) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddress;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    public static String getRandomFileName() {
        int randomNum = random.nextInt(89999)+10000;
        String fileName = sdf.format(new Date())+randomNum;
        return fileName;
    }
}
