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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
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



    @RequestMapping(value = "/upload",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object fileUpload(@RequestParam(value = "headImage",required = false)MultipartFile headImage, HttpServletRequest request) {
        try {

            request.getServerName();//获取服务器域名

            request.getServerPort();//获取服务器端口

            InetAddress address= InetAddress.getByName(request.getServerName());

            address.getHostAddress(  );//获取服务器IP地址
            System.out.println(request.getServerName()+":"+request.getServerPort() +address.getHostAddress(  ));
            StorePath storePath = fastFileStorageClient.uploadFile(null,headImage.getInputStream(), headImage.getSize(), "jpg");
             String filepath = fastdfsUrl+"/"+ storePath.getFullPath();
             return FileResult.success(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
