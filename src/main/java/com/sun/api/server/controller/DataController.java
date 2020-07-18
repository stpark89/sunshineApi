package com.sun.api.server.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.api.server.service.DataService;

import java.util.Map;

@Log
@CrossOrigin(origins = {"http://116.123.117.59:18280", "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping(value="/api")
public class DataController {

    @Autowired
    private DataService dataService;


    /**
     * Smp Data 조회
     * @return
     */
    @RequestMapping(value="/selectSmpData")
    public Map<String,Object> selectSmpData(){
        log.info("Select Smp Data");
        return dataService.selectSmpData();
    }

}
