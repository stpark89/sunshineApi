package com.sun.api.server.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.api.server.map.service.MapService;
import com.sun.api.server.map.vo.ZoneSunshine;

import lombok.extern.java.Log;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/map")
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	@RequestMapping(value="/saveZoneSunshine")
    public void saveZoneSunshine(){
        log.info("saveZoneSunshine");
        mapService.saveZoneSunshine();
    }
	
	@RequestMapping(value="/searchZoneSunshine")
	public ZoneSunshine searchZoneSunshine(@RequestBody ZoneSunshine zoneSunshine){
        log.info("searchZoneSunshine");
        return mapService.searchZoneSunshine(zoneSunshine.getSggNm(), zoneSunshine.getSiNm());
        
    }

}
