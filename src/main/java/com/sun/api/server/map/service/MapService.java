package com.sun.api.server.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.api.server.map.repository.ZoneSunshineRepository;
import com.sun.api.server.map.vo.ZoneSunshine;

@Service
public class MapService {

	@Autowired
	private ZoneSunshineRepository zoneSunshineRepository;
	
	

	/**
	 *  일조량 전체 조회 
	 */
	
	public List<ZoneSunshine> listZoneSunshines(){
		return zoneSunshineRepository.findAll();
	}
	
	/**
	 * 일조량 조회
	 * @param sggNm
	 * @param siNm
	 */
	public ZoneSunshine searchZoneSunshine(String sggNm, String siNm) {
		return zoneSunshineRepository.findBySearchZoneSunshine(sggNm, siNm);
	}
	
	/**
	 * 일조량 저장(임시) 
	 */
	public void saveZoneSunshine() {
		ZoneSunshine zoneSunshine1 = new ZoneSunshine("서울","서울",2.76, 3.01, 4.54, 4.68, 4.75, 4.56, 3.07, 3.40, 4.16, 3.23, 1.76, 1.93, 3.49);
		zoneSunshineRepository.save(zoneSunshine1);
	}
}
