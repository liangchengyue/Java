package com.itrug.mobile.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.sql.*;

public class FileUtils {
    /**
     * 文件上传文件夹
     */
    public static final String UPLOAD_DIRECTORY = "images";
    public static final String SAVE_DIRECTORY_KEY = "uploadPath";
    private static DiskFileItemFactory diskFileItemFactory = null;
    private static ServletFileUpload servletFileUpload = null;

    public static void init(String fileSaveDir){
        diskFileItemFactory = new DiskFileItemFactory();
        servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        File file = new File(fileSaveDir);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    public static void saveFile(FileItem fileItem,String fileFullPath){
        try {
            fileItem.write(new File(fileFullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
