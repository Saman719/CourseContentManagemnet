package com.example.demo.service;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;

@Service
public class FileService {

    private final String uploadDir = System.getProperty("user.dir").concat("\\files");

    private final String downloadDir = System.getProperty("user.dir").concat("\\files\\userFiles");

    public String uploadFile(MultipartFile file) {
        String path = uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path copyLocation = Paths
                .get(path);
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public void downloadFile (String url) {
        File file = new File(url);
        String myDir = downloadDir +File.separator + file.getName();
        Path src = Paths.get(url);
        Path dest = Paths.get(myDir);
        try {
            Files.copy(src,dest,REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile (String url) {
        File file = new File(url);
        file.delete();
    }

    public String getDownloadDir() {
        return downloadDir;
    }
}
