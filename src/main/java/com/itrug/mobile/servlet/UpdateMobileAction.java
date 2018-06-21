package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.impl.MobileServiceImp;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(urlPatterns = "/updateMobile")
public class UpdateMobileAction extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Mobile mobile=saveFile(request);
        MobileService mobileService=new MobileServiceImp();
        mobileService.update(mobile);
        response.sendRedirect("listMobile");
    }
    private Mobile saveFile(HttpServletRequest request) throws UnsupportedEncodingException {
        Mobile mobile=new Mobile();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        String uploadPath = getServletContext().getRealPath("img/");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            List<FileItem> items = upload.parseRequest(request);
            if(items != null)
            {
                for(FileItem item:items)
                {
                    if(!item.isFormField())
                    {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        mobile.setImage(fileName);
                        try {
                            item.write(storeFile);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // File target = new File("D:/temp/"+fileName);
                        //target.createNewFile();
                    }else {
                        String fieldName = item.getFieldName();//得到表单中name的值
                        String values = item.getString("UTF-8");//得到表单中value的值
                        if (fieldName.equals("vendor"))
                            mobile.setVendor(values);
                        if (fieldName.equals("model"))
                            mobile.setModel(values);
                        if (fieldName.equals("id"))
                            mobile.setId(Integer.parseInt(values));
                        if (fieldName.equals("price"))
                            mobile.setPrice(Double.parseDouble(values));
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return mobile;
    }
}
