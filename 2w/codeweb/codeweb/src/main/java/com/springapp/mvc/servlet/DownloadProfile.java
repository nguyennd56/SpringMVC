package com.springapp.mvc.servlet;

import org.hibernate.result.Output;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by nguyennd on 7/18/2014.
 */
public class DownloadProfile extends HttpServlet {
    protected void doGet(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException{
        //read input file from absolute path
        String filepath = "C:/Users/nguyennd/Desktop/Enroll.mobileconfig";
        File downloadFile = new File(filepath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        //context
        ServletContext context = getServletContext();
        //mime object
        String mimeType = context.getMimeType(filepath);
        if(mimeType == null){
            mimeType = "application/octet-stream";
        }
        System.out.println("Mime type: " + mimeType);
        //modify response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        //force download\
//        String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename= ", downloadFile.getName() );
//        response.setHeader(headerKey, headerValue);
        response.setHeader("Content-Disposition", "attachment; filename=\"Enroll.mobileconfig\"");
        //obtain response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int byteRead = -1;
        while((byteRead = inStream.read(buffer))!= -1){
            outStream.write(buffer, 0, byteRead);
        }
        inStream.close();
        outStream.close();
    }
}
