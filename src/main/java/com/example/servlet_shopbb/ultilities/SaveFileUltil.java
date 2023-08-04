package com.example.servlet_shopbb.ultilities;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;

public class SaveFileUltil {
    public static void saveFile(HttpServletRequest request, HttpServletResponse response, File file, Part photo) {
        // Xác định đường dẫn tương đối từ thư mục gốc của ứng dụng web
        String relativePath = "/";

        // Lấy đường dẫn gốc của ứng dụng web
        String appPath = request.getServletContext().getRealPath("/");

        // Loại bỏ phần tên tệp tin (để nhận được đường dẫn thư mục gốc)
        String rootPath = appPath.substring(0, appPath.indexOf("target"));

        // Đường dẫn thư mục lưu trữ tệp tin
        String uploadPath = rootPath +"src/main/webapp/"+ file;
        String uploadPath2 = appPath + file;
        System.out.println(uploadPath2);



        // Tạo thư mục nếu chưa tồn tại
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            System.out.println("đã tạo đường dẫn");
            uploadDir.mkdirs(); // Sử dụng mkdirs() để tạo các thư mục con nếu cần
        }

        File uploadDir2= new File(uploadPath2);
        if (!uploadDir2.exists()) {
            System.out.println("đã tạo đường dẫn");
            uploadDir2.mkdirs(); // Sử dụng mkdirs() để tạo các thư mục con nếu cần
        }


        try {

            String fileName = photo.getSubmittedFileName();

            String filePath = uploadPath + File.separator + fileName;
            String filePath2 = uploadPath2+File.separator + fileName;

            // Lưu tệp tin vào thư mục lưu trữ
//            photo.write(filePath);
            photo.write(filePath2);
            System.out.println(filePath);
            System.out.println(filePath2);
            System.out.println("upload ảnh ok");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Tải lên thất bại: " + ex.getMessage());
        }
    }
}
