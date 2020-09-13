package com.sun.api.server.inquire.controller;

import com.sun.api.server.inquire.service.InQuirePlantService;
import com.sun.api.server.inquire.vo.InQuirePlantVo;
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

/**
 * 자산관리 - 발전소 매각 페이지 담당 문의하기 컨트롤러
 */
@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/inquirePlant")
public class InQuirePlantController {


    @Autowired
    private InQuirePlantService inquirePlantService;

    /**
     * 문의하기 등록 - 발전소 매각
     * @param vo
     * @return
     */
    @RequestMapping(value="/inquirePlantRequest")
    public String inquirePlantRequest(@RequestBody InQuirePlantVo vo){
        log.info("InQuirePlantController.inquirePlantRequest");
        log.info(vo.toString());
        return inquirePlantService.inquirePlantRequest(vo);
    }

    /**
     * 발전소 매각 - 문의하기 전체 조회
     * @return
     */
    @RequestMapping(value="/selectAllPlantInQuire")
    public List<InQuirePlantVo> selectAllPlantInQuire(){
        log.info("InQuirePlantController.selectAllPlantInQuire");
        return inquirePlantService.selectAllPlantInQuire();
    }

    /**
     * 문의내역 상세 조회
     * @param vo
     * @return
     */
    @RequestMapping(value="/selectPlantInQuireDetailInfo")
    public InQuirePlantVo selectPlantInQuireDetailInfo(InQuirePlantVo vo){
        log.info("데이터 확인중 ----");
        return inquirePlantService.selectPlantInQuireDetailInfo(vo);
    }


}
