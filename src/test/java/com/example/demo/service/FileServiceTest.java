package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FileServiceTest {
    @Autowired
    FileService service;
    @Test
    void uploadFile() {
        Path path = Paths.get("D:\\Saman\\Programming\\web\\SpringBoot\\demo\\files\\test\\test.txt");
        String name = "test.txt";
        String originalFileName = "test.txt";
        String contentType = "text/plain";
        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        MultipartFile result = new MockMultipartFile(name,
            originalFileName, contentType, content);
        service.uploadFile(result);
        Path path2 = Paths.get("D:\\Saman\\Programming\\web\\SpringBoot\\demo\\files\\test.txt");
        byte[] content2 = null;
        try {
            content2 = Files.readAllBytes(path2);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(content,content2);
        service.deleteFile("D:\\Saman\\Programming\\web\\SpringBoot\\demo\\files\\test.txt");
    }

    @Test
    void downloadFile() {
        service.downloadFile("D:\\Saman\\Programming\\web\\SpringBoot\\demo\\files\\test\\test.txt");
        String myDir = service.getDownloadDir() +File.separator + "test.txt";
        File file = new File(myDir);
        assert(file.exists());
        service.deleteFile(myDir);
        assert(!file.exists());
    }
}