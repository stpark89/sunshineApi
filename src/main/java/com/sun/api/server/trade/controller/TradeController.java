package com.sun.api.server.trade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.api.server.trade.service.TradeService;
import com.sun.api.server.trade.vo.TradeVo;

import lombok.extern.java.Log;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/trade")
public class TradeController {

	
	@Autowired
	private TradeService tradeService;
	
    @RequestMapping(value="/fetchTradeInfo")
    public TradeVo fetchTradeInfo(int id){
        log.info("id : " +id);

        return null;
    }
    
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
     * @param id
     * @return
     */
    @RequestMapping(value="/searchTradeOne")
	public Optional<TradeVo> searchTradeOne(@RequestBody long id){
        log.info("searchTradeOne");
        return tradeService.searchTradeVoOne(id);
        
    }
    
    /**
     * 발전소 매매 수정 저장 
     * @param tradeVo
     */
    @RequestMapping(value="/saveTrade")
	public void saveTrade(@RequestBody TradeVo tradeVo){
        log.info("saveTrade");
        tradeService.saveTradeVo(tradeVo);
        
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
