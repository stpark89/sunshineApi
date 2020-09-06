package com.sun.api.server.subdivision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.api.server.subdivision.repository.SubdivisionVoRepository;
import com.sun.api.server.subdivision.vo.SubdivisionVo;

import lombok.extern.java.Log;

@Log
@Service
public class SubdivisionService {
	
	@Autowired
	private SubdivisionVoRepository subdivisionVoRepository;
	
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
	public void saveSubdivisionVo(SubdivisionVo subdivisionVo) {
		subdivisionVoRepository.save(subdivisionVo);
	}

	/**
	 * 발전소 분양 삭제 
	 * @param SubdivisionVo
	 */
	public void deleteSubdivisionVo(SubdivisionVo subdivisionVo) {
		subdivisionVoRepository.delete(subdivisionVo);
	}
}
