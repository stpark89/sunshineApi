package com.sun.api.server.trade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.api.server.trade.repository.TradeVoRepository;
import com.sun.api.server.trade.vo.TradeVo;

import lombok.extern.java.Log;

@Log
@Service
public class TradeService {
	
	@Autowired
	TradeVoRepository tradeVoRepository;
	
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
	public void saveTradeVo(TradeVo tradeVo) {
		tradeVoRepository.save(tradeVo);
	}

	/**
	 * 발전소 매매 삭제 
	 * @param tradeVo
	 */
	public void deleteTradeVo(TradeVo tradeVo) {
		tradeVoRepository.delete(tradeVo);
	}
}
