package com.xiaohu.demo.controller.file;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.sun.xml.internal.ws.encoding.policy.FastInfosetFeatureConfigurator;
import com.xiaohu.demo.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 〈一句话功能简述〉<br>
 * 〈文件上传〉
 *
 * @author HuTao
 * @create 2019/7/18 12:58
 * @since 1.0.0
 */
@Controller
@RequestMapping("/file/upload")
public class FileController {

    @Value("${fastdfs.ip}")
    private String fastIp;

    @Value("${fastdf.port}")
    private String fastPort;

    @Value("${fastdfs.viewUrl}")
    private String fastdfsUrl;

    @Autowired
    FastFileStorageClient fastFileStorageClient;



    @RequestMapping("/upload")
    @ResponseBody
    public Object fileUpload() {
        File file = new File("D:\\下载\\57c51b3af9a0a143110b7660a7c30a75.jpg");
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "jpg");
            System.out.println("getFullPath==>" + storePath.getFullPath());
            System.out.println("getPath==>" + storePath.getPath());
            return fastdfsUrl+ storePath.getFullPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
