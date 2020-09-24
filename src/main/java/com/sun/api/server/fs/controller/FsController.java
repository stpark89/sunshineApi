package com.sun.api.server.fs.controller;

import com.sun.api.server.fs.service.FsService;
import com.sun.api.server.fs.vo.FsInQuireVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/fs")
public class FsController {

    @Autowired
    private FsService fsService;


    @RequestMapping(value="/fsResultQuestion")
    public String fsResultQuestion(@RequestBody FsInQuireVo inQuireVo){
        log.info("FsController - fsResultQuestion : 내부지 직접하기  문의 하기");
        return fsService.fsResultQuestion(inQuireVo);
    }

}
