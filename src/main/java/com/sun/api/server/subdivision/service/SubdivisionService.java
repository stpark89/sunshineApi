package com.sun.api.server.subdivision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sun.api.server.admin.service.AdminService;
import com.sun.api.server.subdivision.repository.SubdivisionVoRepository;
import com.sun.api.server.subdivision.vo.SubdivisionVo;
import com.sun.api.server.trade.vo.TradeVo;

import lombok.extern.java.Log;

@Log
@Service
public class SubdivisionService {
	
	@Autowired
	private SubdivisionVoRepository subdivisionVoRepository;

	@Autowired
	private AdminService adminService;
	
	/**
	 * 발전소 분양 전체 조회 
	 * @return
	 */
	public List<SubdivisionVo> searchSubdivisionVo(){
		return subdivisionVoRepository.findAll();
	}

	/**
	 * 발전소 분양 단건 조회 
	 * @param id
	 * @return
	 */
	public Optional<SubdivisionVo> searchSubdivisionVoOne(long id){
		return subdivisionVoRepository.findById(id);
	}
	
	/**
	 * 발전소 분양 수정, 저장 
	 * @param SubdivisionVo
	 */
	public void saveSubdivisionVo(SubdivisionVo subdivisionVo,MultipartFile file) {
		try {
			if(subdivisionVo.getId() != 0L) {
				adminService.deleteFolder("Users/inina/subdivision/"+subdivisionVo.getId());
			}
			SubdivisionVo resultVo =  subdivisionVoRepository.save(subdivisionVo);
			String directoryPath = "Users/inina/subdivision/"+resultVo.getId();

			log.info("잠시 확인좀요 ----------------");
			log.info(file.getOriginalFilename());

			adminService.saveFiole(file, directoryPath);
		}catch(Exception e){
			e.printStackTrace();
		}


	}

	/**
	 * 발전소 분양 삭제 
	 * @param SubdivisionVo
	 */
	public void deleteSubdivisionVo(SubdivisionVo subdivisionVo) {
		subdivisionVoRepository.delete(subdivisionVo);
	}
}
