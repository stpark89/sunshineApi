package com.sun.api.server.subdivision.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.api.server.subdivision.service.SubdivisionService;
import com.sun.api.server.subdivision.vo.SubdivisionVo;

import lombok.extern.java.Log;

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
     * @param id
     * @return
     */
    @RequestMapping(value="/searchSubdivisionOne")
	public Optional<SubdivisionVo> searchSubdivisionOne(@RequestBody long id){
        log.info("searchSubdivisionOne");
        return subdivisionService.searchSubdivisionVoOne(id);
        
    }
    
    /**
     * 발전소 분양 수정 저장 
     * @param SubdivisionVo
     */
    @RequestMapping(value="/saveSubdivision")
	public void saveSubdivision(@RequestBody SubdivisionVo subdivisionVo){
        log.info("saveSubdivision");
        subdivisionService.saveSubdivisionVo(subdivisionVo);
        
    }    
    
    /**
     * 발전소 분양 삭제 
     * @param SubdivisionVo
     */
    @RequestMapping(value="/deleteSubdivision")
	public void deleteSubdivision(@RequestBody SubdivisionVo subdivisionVo){
        log.info("deleteSubdivision");
        subdivisionService.deleteSubdivisionVo(subdivisionVo);
        
    }      
    
}
