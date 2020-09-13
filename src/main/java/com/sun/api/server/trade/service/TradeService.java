package com.sun.api.server.trade.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sun.api.server.subdivision.vo.SubdivisionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sun.api.server.admin.service.AdminService;
import com.sun.api.server.trade.repository.TradeVoRepository;
import com.sun.api.server.trade.vo.TradeVo;

import lombok.extern.java.Log;

@Log
@Service
public class TradeService {
	
	@Autowired
	TradeVoRepository tradeVoRepository;

	@Autowired
	private AdminService adminservice;
	
	/**
	 * 발전소 매매 전체 조회 
	 * @return
	 */
	public List<TradeVo> searchTradeVo(){
		return tradeVoRepository.findAll();
	}

	/**
	 * 발전소 매매 - 프론트 요청 조회
	 * @return
	 */
	public List<TradeVo> fetchFrontSearchTrade(){
		log.info("fetchFrontSearchTrade");
		List<TradeVo> tradeVoList = tradeVoRepository.findAll();
		for(int i = 0; i < tradeVoList.size() ; i++){
			if(new File("C:/Users/test/Documents/build/images/trade/"+tradeVoList.get(i).getId()).exists()){
				List<String> imgList = new ArrayList<String>();
				for (File info : new File("C:/Users/test/Documents/build/images/trade/"+tradeVoList.get(i).getId()).listFiles()) {
					imgList.add("/images/trade/"+tradeVoList.get(i).getId()+"/"+info.getName());
				}
				tradeVoList.get(i).setImageUrl(imgList);
			}
		}
		return tradeVoList;
	}

	/**
	 * 발전소 매매 단건 조회 
	 * @param id
	 * @return
	 */
	public Optional<TradeVo> searchTradeVoOne(long id){
		log.info("searchTradeVoOne");
		Optional<TradeVo> vo = tradeVoRepository.findById(id);
		if(new File("C:/Users/test/Documents/build/images/trade/"+vo.get().getId()).exists()) {
			List<String> imgList = new ArrayList<String>();
			for(File info : new File("C:/Users/test/Documents/build/images/trade/"+vo.get().getId()).listFiles()){
				imgList.add("/images/trade/"+vo.get().getId()+"/"+info.getName());
			}
			vo.get().setImageUrl(imgList);
		}
		return vo;
	}
	
	/**
	 * 발전소 매매 수정, 저장 
	 * @param tradeVo
	 */
	public void saveTradeVo(TradeVo tradeVo, MultipartFile file) {
		try {
			if(tradeVo.getId() != 0L) {
				adminservice.deleteFolder("C:/Users/test/Documents/build/images/trade/"+tradeVo.getId());
			}
			TradeVo resultVo =  tradeVoRepository.save(tradeVo);
;
			String directoryPath = "C:/Users/test/Documents/build/images/trade/"+resultVo.getId();
			
			adminservice.saveFiole(file, directoryPath);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * 발전소 매매 삭제 
	 * @param tradeVo
	 */
	public void deleteTradeVo(TradeVo tradeVo) {
		tradeVoRepository.delete(tradeVo);
	}
}
