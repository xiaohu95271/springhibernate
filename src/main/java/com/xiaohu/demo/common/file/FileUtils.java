package com.xiaohu.demo.common.file;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;

/**
 * 〈一句话功能简述〉<br>
 * 〈文件工具〉
 *
 * @author HuTao
 * @create 2019/7/18 15:08
 * @since 1.0.0
 */
public class FileUtils {

    /**
     * 删除文件夹下面的内容
     * @param path 文件路径
     * @return
     */
    public static boolean deleteDir(String path){
        deleteDir(new File(path));
        return true;
    }

    /**
     * 删除文件夹下面的内容
     * @param file 文件夹对象
     * @return
     */
 public static boolean deleteDir(File file){
//        判断是否待删除目录是否存在
        if(!file.exists()){
            System.err.println("The dir are not exists!");
            return false;
        }

        //取得当前目录下所有文件和文件夹
        String[] content = file.list();
        for(String name : content){
            File temp = new File(file.getPath(), name);
            //判断是否是目录
            if(temp.isDirectory()){
                //递归调用，删除目录里的内容
                deleteDir(temp.getAbsolutePath());
                temp.delete();//删除空目录
            }else{
                //直接删除文件
                if(!temp.delete()){
                    System.err.println("Failed to delete " + name);
                }
            }
        }
        return true;
    }

}