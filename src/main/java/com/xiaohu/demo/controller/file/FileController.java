package com.xiaohu.demo.controller.file;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.sun.xml.internal.ws.encoding.policy.FastInfosetFeatureConfigurator;
import com.xiaohu.demo.common.file.FileUtils;
import com.xiaohu.demo.common.result.FileResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

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



    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Object fileUpload(HttpServletRequest request) {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Set factory constraints
            // 设置缓冲区大小，这里是4kb
            factory.setSizeThreshold(4096);
//            // 设置缓冲区目录
            factory.setRepository(new File("D:\\developMent\\work\\recognition"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            //设置最大文件尺寸，这里是4MB
            upload.setSizeMax(4194304);

//            得到所有的文件
            List<FileItem> items = upload.parseRequest(request);

            StorePath storePath = fastFileStorageClient.uploadFile(null,items.get(0).getInputStream(), items.get(0).getSize(), "jpg");
             String filepath = fastdfsUrl+"/"+ storePath.getFullPath();
             return FileResult.success(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }
}
