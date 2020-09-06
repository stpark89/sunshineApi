package com.sun.api.server.subdivision.controller;

import java.util.List;
import java.util.Optional;

import com.sun.api.server.subdivision.vo.SubdivisionRequestVo;
import com.sun.api.server.trade.vo.TradeRequestVo;
import com.sun.api.server.trade.vo.TradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.api.server.subdivision.service.SubdivisionService;
import com.sun.api.server.subdivision.vo.SubdivisionVo;

import lombok.extern.java.Log;
import org.springframework.web.servlet.view.RedirectView;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/subdivision")
public class SubdivisionController {


	@Autowired
	private SubdivisionService subdivisionService;

    
    /**
     * 발전소 분양 조회 
     * @return
     */
    @RequestMapping(value="/searchSubdivision")
	public List<SubdivisionVo> searchSubdivision(){
        log.info("searchSubdivision");
        return subdivisionService.searchSubdivisionVo();
        
    }
    /**
     * 발전소 분양 단건 조회 
     * @param newId
     * @return
     */
    @RequestMapping(value="/searchSubdivisionOne")
	public Optional<SubdivisionVo> searchSubdivisionOne(String newId){
        log.info("searchSubdivisionOne");
        return subdivisionService.searchSubdivisionVoOne(Long.parseLong(newId));
    }

    /**
     * 리액트 호출
     * @param vo
     * @return
     */
    @RequestMapping(value="/frontSearchSubdivisionOne")
    public Optional<SubdivisionVo> frontSearchSubdivisionOne(@RequestBody SubdivisionRequestVo vo){
        log.info("frontSearchSubdivisionOne : "+vo.getNewId());
        return subdivisionService.searchSubdivisionVoOne(Long.parseLong(vo.getNewId()));
    }




    /**
     * 발전소 분양 수정 저장 
     * @param subdivisionVo
     */
    @RequestMapping(value="/saveSubdivision")
	public Object saveSubdivision(SubdivisionVo subdivisionVo){
        log.info("saveSubdivision");
        try {
            subdivisionService.saveSubdivisionVo(subdivisionVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new RedirectView("/admin/subdivisionView");
        
    }    
    
    /**
     * 발전소 분양 삭제 
     * @param subdivisionVo
     */
    @RequestMapping(value="/deleteSubdivision")
	public void deleteSubdivision(@RequestBody SubdivisionVo subdivisionVo){
        log.info("deleteSubdivision");
        subdivisionService.deleteSubdivisionVo(subdivisionVo);
        
    }      
    
}
