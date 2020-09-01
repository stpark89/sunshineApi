package com.sun.api.server.module.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.api.server.module.repository.ModuleInfoVoRepository;
import com.sun.api.server.vo.module.ModuleInfoVo;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleInfoVoRepository moduleInfoVoRepository;
	
	public List<ModuleInfoVo> searchModule(){
		return moduleInfoVoRepository.findAll();
	}
	
	public Optional<ModuleInfoVo> searchModuleOne(long id) {
		return moduleInfoVoRepository.findById(id);
	}
	
}
