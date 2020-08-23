package com.sun.api.server.admin.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import java.io.File;

@Log
@RequestMapping(value="/adminData")
@RestController
public class AdminDataController {

    @RequestMapping(value="/recExcelUpload")
    public String recExcelUpload(MultipartFile file){
        log.info("Rec 파일 업로드");
        log.info(file.getOriginalFilename());
        log.info("Rec 파일 업로드");

        File targetFile = new File("/Users/inina/fileTemp/" + file.getOriginalFilename());
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Success";
    }

}
