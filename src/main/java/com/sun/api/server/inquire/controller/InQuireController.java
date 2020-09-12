package com.sun.api.server.inquire.controller;

import com.sun.api.server.inquire.service.InQuireService;
import com.sun.api.server.inquire.vo.InQuireVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 문의하기 전체 조회 
     * @return
     */
    @RequestMapping(value="/selectAllInQuire")
    public List<InQuireVo> selectAllInQuire(){
        log.info("inquire.selectAllInQuire");
        return inquireService.selectAllInQuire();
    }
    
    /**
     * 문의하기 타입 조회 
     * @param vo
     * @return
     */
    @RequestMapping(value="/selectInQuireType")
    public List<InQuireVo> selectInQuireType(InQuireVo vo){
        log.info("inquire.selectInQuireType");
        System.out.println(vo.toString());

        return inquireService.selectInQuireType(vo);
    }

    @RequestMapping(value="/selectInQuireDetailInfo")
    public Map<String, Object> selectInQuireDetailInfo(InQuireVo vo){
        log.info("데이터 확인중 ----");
        Map<String, Object> returnMap = new HashMap<>();

        returnMap = inquireService.selectInQuireDetailInfo(vo);
        return returnMap;
    }
    

}
