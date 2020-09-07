package com.sun.api.server.trade.service;

import java.util.List;
import java.util.Optional;

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
	 * 발전소 매매 단건 조회 
	 * @param id
	 * @return
	 */
	public Optional<TradeVo> searchTradeVoOne(long id){
		return tradeVoRepository.findById(id);
	}
	
	/**
	 * 발전소 매매 수정, 저장 
	 * @param tradeVo
	 */
	public void saveTradeVo(TradeVo tradeVo, MultipartFile file) {
		try {
			if(tradeVo.getId() != 0L) {
				adminservice.deleteFolder("Users/inina/"+tradeVo.getId());
			}
			TradeVo resultVo =  tradeVoRepository.save(tradeVo);
			String directoryPath = "C:/subdivision/"+resultVo.getId();
			
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
