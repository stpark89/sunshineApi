package com.sun.api.server.module.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.api.server.module.service.ModuleService;
import com.sun.api.server.vo.module.ModuleInfoVo;

import lombok.extern.java.Log;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value="/searchModule")
	public List<ModuleInfoVo> searchModule(){
        log.info("searchModule");
        return moduleService.searchModule();
        
    }
	
	@RequestMapping(value="/searchModuleOne")
	public Optional<ModuleInfoVo> searchModuleOne(@RequestBody long id){
        log.info("searchModuleOne");
        return moduleService.searchModuleOne(id);
        
    }
	
}
