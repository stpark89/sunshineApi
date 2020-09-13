package com.sun.api.server.subdivision.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sun.api.server.admin.service.AdminService;
import com.sun.api.server.subdivision.repository.SubdivisionVoRepository;
import com.sun.api.server.subdivision.vo.SubdivisionVo;

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
	 * 발전소 분양 전체 조회
	 * @return
	 */
	public List<SubdivisionVo> searchFrontSubdivision(){
		log.info("searchFrontSubdivision");
		List<SubdivisionVo>  list = subdivisionVoRepository.findAll();

		for(int i = 0; i < list.size() ; i++){
			if(new File("C:/Users/test/Documents/build/images/subdivision/"+list.get(i).getId()).exists()){
				List<String> imgList = new ArrayList<String>();
				for (File info : new File("C:/Users/test/Documents/build/images/subdivision/"+list.get(i).getId()).listFiles()) {
					System.out.println("파일 확인중 --------------");
					log.info(info.getName());
					imgList.add("/images/subdivision/"+list.get(i).getId()+"/"+info.getName());
				}
				list.get(i).setImageUrl(imgList);
			}
		}

		return list;
	}

	/**
	 * 발전소 분양 단건 조회 
	 * @param id
	 * @return
	 */
	public Optional<SubdivisionVo> searchSubdivisionVoOne(long id){

		Optional<SubdivisionVo> vo = subdivisionVoRepository.findById(id);
		if(new File("C:/Users/test/Documents/build/images/subdivision/"+vo.get().getId()).exists()) {
			List<String> imgList = new ArrayList<String>();
			for(File info : new File("C:/Users/test/Documents/build/images/subdivision/"+vo.get().getId()).listFiles()){
				imgList.add("/images/subdivision/"+vo.get().getId()+"/"+info.getName());
			}
			vo.get().setImageUrl(imgList);
		}

		return vo;
	}
	
	/**
	 * 발전소 분양 수정, 저장 
	 * @param subdivisionVo, file
	 */
	public void saveSubdivisionVo(SubdivisionVo subdivisionVo,MultipartFile file) {
		try {
			if(subdivisionVo.getId() != 0L) {
				adminService.deleteFolder("C:/Users/test/Documents/build/images/subdivision/"+subdivisionVo.getId());
			}
			SubdivisionVo resultVo =  subdivisionVoRepository.save(subdivisionVo);

			// String directoryPath = "C:/subdivision/"+resultVo.getId();

			String directoryPath = "C:/Users/test/Documents/build/images/subdivision/"+resultVo.getId();
			adminService.saveFiole(file, directoryPath);

		}catch(Exception e){
			e.printStackTrace();
		}


	}

	/**
	 * 발전소 분양 삭제 
	 * @param subdivisionVo
	 */
	public void deleteSubdivisionVo(SubdivisionVo subdivisionVo) {
		subdivisionVoRepository.delete(subdivisionVo);
	}
}
