package com.sun.api.server.trade.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sun.api.server.trade.vo.TradeRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.api.server.admin.service.AdminService;
import com.sun.api.server.subdivision.vo.SubdivisionVo;
import com.sun.api.server.trade.service.TradeService;
import com.sun.api.server.trade.vo.TradeVo;

import lombok.extern.java.Log;
import org.springframework.web.servlet.view.RedirectView;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/trade")
public class TradeController {


	@Autowired
	private TradeService tradeService;


	/**
	 * 발전소 매매 조회 
	 * @return
	 */
	@RequestMapping(value="/searchTrade")
	public List<TradeVo> searchTrade(){
		log.info("searchTrade");
		return tradeService.searchTradeVo();

	}
	/**
	 * 발전소 매매 단건 조회 
	 * @param newId
	 * @return
	 */
	@RequestMapping(value="/searchTradeOne")
	public Optional<TradeVo> searchTradeOne(String newId){
		log.info("searchTradeOne"+newId);
		List<String> imgList = new ArrayList<String>();
        for (File info : new File("Users/inina/trade/"+newId).listFiles()) {
        	imgList.add(info.getPath());
        }
        //imageUrl
        Optional<TradeVo> returnVo = tradeService.searchTradeVoOne(Long.parseLong(newId));
        returnVo.get().setImageUrl(imgList);
        
		return tradeService.searchTradeVoOne(Long.parseLong(newId));
	}

	/**
	 * 리액트 호출
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/frontSearchTradeOne")
	public Optional<TradeVo> frontSearchTradeOne(@RequestBody TradeRequestVo vo){
		log.info("searchTradeOne : "+vo.getNewId());
		return tradeService.searchTradeVoOne(Long.parseLong(vo.getNewId()));
	}

	/**
	 * 발전소 매매 수정 저장 
	 * @param tradeVo
	 */
	@RequestMapping(value="/saveTrade")
	public Object saveTrade(TradeVo tradeVo, MultipartFile file){
		log.info("saveTrade");
		try {
			
			tradeService.saveTradeVo(tradeVo, file);
		}catch (Exception e){
			e.printStackTrace();
		}
		return new RedirectView("/admin/tradeView");
	}    

	/**
	 * 발전소 매매 삭제 
	 * @param tradeVo
	 */
	@RequestMapping(value="/deleteTrade")
	public void deleteTrade(@RequestBody TradeVo tradeVo){
		log.info("deleteTrade");
		tradeService.deleteTradeVo(tradeVo);

	}      



}
