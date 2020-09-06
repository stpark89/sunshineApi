package com.sun.api.server.inquire.controller;

import com.sun.api.server.inquire.service.InQuireService;
import com.sun.api.server.inquire.vo.InQuireVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/inquire")
public class InQuireController {

    @Autowired
    private InQuireService inquireService;

    /**
     * 문의 하기 등록  - 발전소 분양, 발전소 매매
     * @return
     */
    @RequestMapping(value="/inquireRequest")
    public String inquireRequest(@RequestBody InQuireVo vo){
        log.info("inquire.inquireRequest");
        log.info(vo.toString());
        return inquireService.inquireRequest(vo);
    }

    @RequestMapping(value="/selectAllInQuire")
    public List<InQuireVo> selectAllInQuire(){
        log.info("inquire.selectAllInQuire");
        return null;
    }

}
