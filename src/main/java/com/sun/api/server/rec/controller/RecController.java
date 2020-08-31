/**
 * 
 */
/**
 * @author moyeong-gyu
 *
 */
package com.sun.api.server.rec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.api.server.rec.service.RecService;

import lombok.extern.java.Log;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/rec")
public class RecController {
	
	@Autowired
	RecService recService = new RecService();

	/**
     * Smp Data 조회
     * @return

    @RequestMapping(value="/saveRecData")
    public Map<String,Object> saveRecData(){
        log.info("save Rec Data");
        recService.saveRecData(null);
        return null;
    }
     */

    /**
     * 최근 Smp Data 조회
     * @return
     */
    @RequestMapping(value="/findLastRecData")
    public Map<String,Object> findLastRecData(){
        log.info("find Last Rec Data");
        return recService.finLastRecData();
    }
    
    /**
     * Smp Data 조회
     * @return
     */
    @RequestMapping(value="/findRecData")
    public Map<String,Object> findRecData(){
        log.info("find Rec Data");
        return recService.findRecData();
    }
    
    
}