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
		
		ZoneSunshine zoneSunshine1 = new ZoneSunshine("서울","서울특별시",2.76, 3.01, 4.54, 4.68, 4.75, 4.56, 3.07, 3.40, 4.16, 3.23, 1.76, 1.93, 3.49);
		ZoneSunshine zoneSunshine2 = new ZoneSunshine("경기도","파주",2.78,3.11,4.57,4.79,4.97,4.68,3.20,3.35,4.54,3.34,1.89,1.99,3.60);
		ZoneSunshine zoneSunshine3 = new ZoneSunshine("경기도","포천",2.78,3.11,4.57,4.79,4.97,4.68,3.20,3.35,4.54,3.34,1.89,1.99,3.60);
		ZoneSunshine zoneSunshine4 = new ZoneSunshine("경기도","양주",2.78,3.11,4.57,4.79,4.97,4.68,3.20,3.35,4.54,3.34,1.89,1.99,3.60);
		ZoneSunshine zoneSunshine5 = new ZoneSunshine("경기도","의정부",2.78,3.11,4.57,4.79,4.97,4.68,3.20,3.35,4.54,3.34,1.89,1.99,3.60); 
		ZoneSunshine zoneSunshine6 = new ZoneSunshine("강원도","원주",2.83,2.99,4.47,4.55,4.86,5.15,3.47,3.97,4.24,3.51,2.08,2.23,3.70);
		ZoneSunshine zoneSunshine7 = new ZoneSunshine("강원도","횡성",2.83,2.99,4.47,4.55,4.86,5.15,3.47,3.97,4.24,3.51,2.08,2.23,3.70);
		ZoneSunshine zoneSunshine8 = new ZoneSunshine("강원도","평창",2.83,2.99,4.47,4.55,4.86,5.15,3.47,3.97,4.24,3.51,2.08,2.23,3.70);
		ZoneSunshine zoneSunshine9 = new ZoneSunshine("강원도","정선",2.83,2.99,4.47,4.55,4.86,5.15,3.47,3.97,4.24,3.51,2.08,2.23,3.70);
		ZoneSunshine zoneSunshine10 = new ZoneSunshine("강원도","태백",2.83,2.99,4.47,4.55,4.86,5.15,3.47,3.97,4.24,3.51,2.08,2.23,3.70);
		ZoneSunshine zoneSunshine11 = new ZoneSunshine("강원도","영월",2.83,2.99,4.47,4.55,4.86,5.15,3.47,3.97,4.24,3.51,2.08,2.23,3.70);
		ZoneSunshine zoneSunshine12 = new ZoneSunshine("강원도","춘천",2.72,3.15,4.54,4.57,4.99,5.31,3.31,3.92,4.21,3.46,2.05,2.20,3.70);
		ZoneSunshine zoneSunshine13 = new ZoneSunshine("강원도","화천",2.72,3.15,4.54,4.57,4.99,5.31,3.31,3.92,4.21,3.46,2.05,2.20,3.70);
		ZoneSunshine zoneSunshine14 = new ZoneSunshine("강원도","인제",2.72,3.15,4.54,4.57,4.99,5.31,3.31,3.92,4.21,3.46,2.05,2.20,3.70);
		ZoneSunshine zoneSunshine15 = new ZoneSunshine("강원도","강릉",2.97,2.98,4.56,4.78,4.27,5.42,3.22,4.20,3.62,3.36,1.87,2.14,3.62);
		ZoneSunshine zoneSunshine16 = new ZoneSunshine("강원도","속초",2.97,2.98,4.56,4.78,4.27,5.42,3.22,4.20,3.62,3.36,1.87,2.14,3.62);
		ZoneSunshine zoneSunshine17 = new ZoneSunshine("강원도","양양",2.97,2.98,4.56,4.78,4.27,5.42,3.22,4.20,3.62,3.36,1.87,2.14,3.62);
		ZoneSunshine zoneSunshine18 = new ZoneSunshine("강원도","고성",2.97,2.98,4.56,4.78,4.27,5.42,3.22,4.20,3.62,3.36,1.87,2.14,3.62);
		ZoneSunshine zoneSunshine19 = new ZoneSunshine("강원도","동해",2.97,2.98,4.56,4.78,4.27,5.42,3.22,4.20,3.62,3.36,1.87,2.14,3.62);
		ZoneSunshine zoneSunshine20 = new ZoneSunshine("강원도","삼척",2.97,2.98,4.56,4.78,4.27,5.42,3.22,4.20,3.62,3.36,1.87,2.14,3.62);
		ZoneSunshine zoneSunshine21 = new ZoneSunshine("충청북도","청주",2.62,2.86,4.54,4.66,4.81,4.92,3.56,3.68,4.04,3.37,2.15,2.12,3.61);
		ZoneSunshine zoneSunshine22 = new ZoneSunshine("충청북도","오창",2.62,2.86,4.54,4.66,4.81,4.92,3.56,3.68,4.04,3.37,2.15,2.12,3.61);
		ZoneSunshine zoneSunshine23 = new ZoneSunshine("충청북도","청원",2.62,2.86,4.54,4.66,4.81,4.92,3.56,3.68,4.04,3.37,2.15,2.12,3.61);
		ZoneSunshine zoneSunshine24 = new ZoneSunshine("충청북도","보은",2.62,2.86,4.54,4.66,4.81,4.92,3.56,3.68,4.04,3.37,2.15,2.12,3.61);
		ZoneSunshine zoneSunshine25 = new ZoneSunshine("충청북도","옥천",2.62,2.86,4.54,4.66,4.81,4.92,3.56,3.68,4.04,3.37,2.15,2.12,3.61);
		ZoneSunshine zoneSunshine26 = new ZoneSunshine("충청북도","영동",2.62,2.86,4.54,4.66,4.81,4.92,3.56,3.68,4.04,3.37,2.15,2.12,3.61);
		ZoneSunshine zoneSunshine27 = new ZoneSunshine("충청북도","단양",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine28 = new ZoneSunshine("충청북도","제천",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine29 = new ZoneSunshine("충청북도","충주",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine30 = new ZoneSunshine("충청북도","괴산",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine31 = new ZoneSunshine("충청북도","음성",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine32 = new ZoneSunshine("충청북도","증평",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine33 = new ZoneSunshine("충청북도","진천",2.66,2.90,4.50,4.67,4.85,4.87,3.46,3.78,4.10,3.28,2.22,2.20,3.62);
		ZoneSunshine zoneSunshine34 = new ZoneSunshine("충청남도","서산",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine35 = new ZoneSunshine("충청남도","태안",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine36 = new ZoneSunshine("충청남도","당진",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine37 = new ZoneSunshine("충청남도","예산",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine38 = new ZoneSunshine("충청남도","청양",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine39 = new ZoneSunshine("충청남도","부여",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine40 = new ZoneSunshine("충청남도","보령",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine41 = new ZoneSunshine("충청남도","서천",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine42 = new ZoneSunshine("충청남도","홍성",2.77,3.22,4.67,4.81,4.99,4.74,3.36,3.40,4.39,3.55,2.21,2.07,3.68);
		ZoneSunshine zoneSunshine43 = new ZoneSunshine("충청남도","대전",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine44 = new ZoneSunshine("충청남도","금산",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine45 = new ZoneSunshine("충청남도","공주",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine46 = new ZoneSunshine("충청남도","연기",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine47 = new ZoneSunshine("충청남도","천안",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine48 = new ZoneSunshine("충청남도","계룡",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine49 = new ZoneSunshine("충청남도","논산",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine50 = new ZoneSunshine("충청남도","아산",2.91,3.18,4.89,5.06,5.00,5.23,3.78,3.74,4.25,3.63,2.28,2.22,3.85);
		ZoneSunshine zoneSunshine51 = new ZoneSunshine("경상북도","영주",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine52 = new ZoneSunshine("경상북도","봉화",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine53 = new ZoneSunshine("경상북도","안동",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine54 = new ZoneSunshine("경상북도","예천",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine55 = new ZoneSunshine("경상북도","문경",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine56 = new ZoneSunshine("경상북도","상주",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine57 = new ZoneSunshine("경상북도","의성",2.78,2.94,4.84,5.12,4.87,4.96,3.98,3.54,3.78,3.54,2.10,1.98,3.70);
		ZoneSunshine zoneSunshine58 = new ZoneSunshine("경상북도","대구",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine59 = new ZoneSunshine("경상북도","김천",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine60 = new ZoneSunshine("경상북도","구미",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine61 = new ZoneSunshine("경상북도","칠곡",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine62 = new ZoneSunshine("경상북도","성주",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine63 = new ZoneSunshine("경상북도","군위",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine64 = new ZoneSunshine("경상북도","영천",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine65 = new ZoneSunshine("경상북도","경산",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine66 = new ZoneSunshine("경상북도","청도",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine67 = new ZoneSunshine("경상북도","고령",2.98,2.97,4.78,4.90,4.79,5.06,4.09,3.60,3.83,3.30,2.03,2.02,3.70);
		ZoneSunshine zoneSunshine68 = new ZoneSunshine("경상북도","포항",3.18,2.89,5.07,5.28,4.91,5.51,4.88,3.95,3.92,3.69,2.26,2.57,4.01);
		ZoneSunshine zoneSunshine69 = new ZoneSunshine("경상북도","울진",3.18,2.89,5.07,5.28,4.91,5.51,4.88,3.95,3.92,3.69,2.26,2.57,4.01);
		ZoneSunshine zoneSunshine70 = new ZoneSunshine("경상북도","영덕",3.18,2.89,5.07,5.28,4.91,5.51,4.88,3.95,3.92,3.69,2.26,2.57,4.01);
		ZoneSunshine zoneSunshine71 = new ZoneSunshine("경상북도","청송",3.18,2.89,5.07,5.28,4.91,5.51,4.88,3.95,3.92,3.69,2.26,2.57,4.01);
		ZoneSunshine zoneSunshine72 = new ZoneSunshine("경상북도","영양",3.18,2.89,5.07,5.28,4.91,5.51,4.88,3.95,3.92,3.69,2.26,2.57,4.01);
		ZoneSunshine zoneSunshine73 = new ZoneSunshine("경상북도","경주",3.18,2.89,5.07,5.28,4.91,5.51,4.88,3.95,3.92,3.69,2.26,2.57,4.01);
		ZoneSunshine zoneSunshine74 = new ZoneSunshine("경상남도","진주",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine75 = new ZoneSunshine("경상남도","거창",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine76 = new ZoneSunshine("경상남도","함양",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine77 = new ZoneSunshine("경상남도","함천",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine78 = new ZoneSunshine("경상남도","의령",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine79 = new ZoneSunshine("경상남도","하동",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine80 = new ZoneSunshine("경상남도","산청",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine81 = new ZoneSunshine("경상남도","남해",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine82 = new ZoneSunshine("경상남도","사천",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine83 = new ZoneSunshine("경상남도","고성",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine84 = new ZoneSunshine("경상남도","함안",3.41,3.41,5.12,5.70,5.11,5.14,4.63,3.80,4.56,3.80,2.29,2.66,4.14);
		ZoneSunshine zoneSunshine85 = new ZoneSunshine("경상남도","부산",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine86 = new ZoneSunshine("경상남도","울산",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine87 = new ZoneSunshine("경상남도","양산",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine88 = new ZoneSunshine("경상남도","김해",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine89 = new ZoneSunshine("경상남도","밀양",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine90 = new ZoneSunshine("경상남도","창원",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine91 = new ZoneSunshine("경상남도","창녕",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine92 = new ZoneSunshine("경상남도","거제",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine93 = new ZoneSunshine("경상남도","통영",3.15,3.18,5.03,5.40,4.79,4.66,5.10,4.00,4.29,3.60,2.29,2.54,4.00);
		ZoneSunshine zoneSunshine94 = new ZoneSunshine("전라북도","전주",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine95 = new ZoneSunshine("전라북도","익산",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine96 = new ZoneSunshine("전라북도","군산",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine97 = new ZoneSunshine("전라북도","김제",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine98 = new ZoneSunshine("전라북도","완주",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine99 = new ZoneSunshine("전라북도","정읍",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine100 = new ZoneSunshine("전라북도","부안",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine101 = new ZoneSunshine("전라북도","고창",2.73,3.04,4.83,5.12,4.92,5.14,3.88,3.49,4.26,3.65,2.27,2.08,3.78);
		ZoneSunshine zoneSunshine102 = new ZoneSunshine("전라북도","진안",2.75,3.02,4.82,5.22,4.97,5.09,3.90,3.51,4.21,3.59,2.19,2.11,3.78);
		ZoneSunshine zoneSunshine103 = new ZoneSunshine("전라북도","무주",2.75,3.02,4.82,5.22,4.97,5.09,3.90,3.51,4.21,3.59,2.19,2.11,3.78);
		ZoneSunshine zoneSunshine104 = new ZoneSunshine("전라북도","장수",2.75,3.02,4.82,5.22,4.97,5.09,3.90,3.51,4.21,3.59,2.19,2.11,3.78);
		ZoneSunshine zoneSunshine105 = new ZoneSunshine("전라북도","남원",2.75,3.02,4.82,5.22,4.97,5.09,3.90,3.51,4.21,3.59,2.19,2.11,3.78);
		ZoneSunshine zoneSunshine106 = new ZoneSunshine("전라북도","임실",2.75,3.02,4.82,5.22,4.97,5.09,3.90,3.51,4.21,3.59,2.19,2.11,3.78);
		ZoneSunshine zoneSunshine107 = new ZoneSunshine("전라북도","순창",2.75,3.02,4.82,5.22,4.97,5.09,3.90,3.51,4.21,3.59,2.19,2.11,3.78);
		ZoneSunshine zoneSunshine108 = new ZoneSunshine("전라남도","목포",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine109 = new ZoneSunshine("전라남도","신안",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine110 = new ZoneSunshine("전라남도","무안",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine111 = new ZoneSunshine("전라남도","해남",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine112 = new ZoneSunshine("전라남도","영암",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine113 = new ZoneSunshine("전라남도","강진",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine114 = new ZoneSunshine("전라남도","완도",2.63,3.32,4.97,5.50,5.19,4.86,4.77,3.53,4.81,3.95,2.22,2.03,3.98);
		ZoneSunshine zoneSunshine115 = new ZoneSunshine("전라남도","여수",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine116 = new ZoneSunshine("전라남도","광양",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine117 = new ZoneSunshine("전라남도","순천",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine118 = new ZoneSunshine("전라남도","구례",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine119 = new ZoneSunshine("전라남도","곡성",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine120 = new ZoneSunshine("전라남도","보성",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine121 = new ZoneSunshine("전라남도","장흥",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine122 = new ZoneSunshine("전라남도","고흥",2.66,3.41,5.00,5.41,5.15,4.90,4.72,3.55,4.85,4.01,2.23,2.08,4.00);
		ZoneSunshine zoneSunshine123 = new ZoneSunshine("전라남도","광주",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine124 = new ZoneSunshine("전라남도","영광",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine125 = new ZoneSunshine("전라남도","장성",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine126 = new ZoneSunshine("전라남도","담양",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine127 = new ZoneSunshine("전라남도","화순",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine128 = new ZoneSunshine("전라남도","나주",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine129 = new ZoneSunshine("전라남도","함평",2.94,3.30,5.02,5.44,5.10,4.88,4.27,3.53,4.62,3.64,1.89,1.81,3.87);
		ZoneSunshine zoneSunshine130 = new ZoneSunshine("제주도","제주",1.32,2.81,4.48,5.72,5.32,4.62,5.71,4.55,4.63,3.70,1.99,1.24,3.84);
		ZoneSunshine zoneSunshine131 = new ZoneSunshine("제주도","서귀포",1.32,2.80,4.45,5.74,5.32,4.61,5.68,4.55,4.65,3.69,2.00,1.25,3.84);
		zoneSunshineRepository.save(zoneSunshine1);
		zoneSunshineRepository.save(zoneSunshine2);
		zoneSunshineRepository.save(zoneSunshine3);
		zoneSunshineRepository.save(zoneSunshine4);
		zoneSunshineRepository.save(zoneSunshine5);
		zoneSunshineRepository.save(zoneSunshine6);
		zoneSunshineRepository.save(zoneSunshine7);
		zoneSunshineRepository.save(zoneSunshine8);
		zoneSunshineRepository.save(zoneSunshine9);
		zoneSunshineRepository.save(zoneSunshine10);
		zoneSunshineRepository.save(zoneSunshine11);
		zoneSunshineRepository.save(zoneSunshine12);
		zoneSunshineRepository.save(zoneSunshine13);
		zoneSunshineRepository.save(zoneSunshine14);
		zoneSunshineRepository.save(zoneSunshine15);
		zoneSunshineRepository.save(zoneSunshine16);
		zoneSunshineRepository.save(zoneSunshine17);
		zoneSunshineRepository.save(zoneSunshine18);
		zoneSunshineRepository.save(zoneSunshine19);
		zoneSunshineRepository.save(zoneSunshine20);
		zoneSunshineRepository.save(zoneSunshine21);
		zoneSunshineRepository.save(zoneSunshine22);
		zoneSunshineRepository.save(zoneSunshine23);
		zoneSunshineRepository.save(zoneSunshine24);
		zoneSunshineRepository.save(zoneSunshine25);
		zoneSunshineRepository.save(zoneSunshine26);
		zoneSunshineRepository.save(zoneSunshine27);
		zoneSunshineRepository.save(zoneSunshine28);
		zoneSunshineRepository.save(zoneSunshine29);
		zoneSunshineRepository.save(zoneSunshine30);
		zoneSunshineRepository.save(zoneSunshine31);
		zoneSunshineRepository.save(zoneSunshine32);
		zoneSunshineRepository.save(zoneSunshine33);
		zoneSunshineRepository.save(zoneSunshine34);
		zoneSunshineRepository.save(zoneSunshine35);
		zoneSunshineRepository.save(zoneSunshine36);
		zoneSunshineRepository.save(zoneSunshine37);
		zoneSunshineRepository.save(zoneSunshine38);
		zoneSunshineRepository.save(zoneSunshine39);
		zoneSunshineRepository.save(zoneSunshine40);
		zoneSunshineRepository.save(zoneSunshine41);
		zoneSunshineRepository.save(zoneSunshine42);
		zoneSunshineRepository.save(zoneSunshine43);
		zoneSunshineRepository.save(zoneSunshine44);
		zoneSunshineRepository.save(zoneSunshine45);
		zoneSunshineRepository.save(zoneSunshine46);
		zoneSunshineRepository.save(zoneSunshine47);
		zoneSunshineRepository.save(zoneSunshine48);
		zoneSunshineRepository.save(zoneSunshine49);
		zoneSunshineRepository.save(zoneSunshine50);
		zoneSunshineRepository.save(zoneSunshine51);
		zoneSunshineRepository.save(zoneSunshine52);
		zoneSunshineRepository.save(zoneSunshine53);
		zoneSunshineRepository.save(zoneSunshine54);
		zoneSunshineRepository.save(zoneSunshine55);
		zoneSunshineRepository.save(zoneSunshine56);
		zoneSunshineRepository.save(zoneSunshine57);
		zoneSunshineRepository.save(zoneSunshine58);
		zoneSunshineRepository.save(zoneSunshine59);
		zoneSunshineRepository.save(zoneSunshine60);
		zoneSunshineRepository.save(zoneSunshine61);
		zoneSunshineRepository.save(zoneSunshine62);
		zoneSunshineRepository.save(zoneSunshine63);
		zoneSunshineRepository.save(zoneSunshine64);
		zoneSunshineRepository.save(zoneSunshine65);
		zoneSunshineRepository.save(zoneSunshine66);
		zoneSunshineRepository.save(zoneSunshine67);
		zoneSunshineRepository.save(zoneSunshine68);
		zoneSunshineRepository.save(zoneSunshine69);
		zoneSunshineRepository.save(zoneSunshine70);
		zoneSunshineRepository.save(zoneSunshine71);
		zoneSunshineRepository.save(zoneSunshine72);
		zoneSunshineRepository.save(zoneSunshine73);
		zoneSunshineRepository.save(zoneSunshine74);
		zoneSunshineRepository.save(zoneSunshine75);
		zoneSunshineRepository.save(zoneSunshine76);
		zoneSunshineRepository.save(zoneSunshine77);
		zoneSunshineRepository.save(zoneSunshine78);
		zoneSunshineRepository.save(zoneSunshine79);
		zoneSunshineRepository.save(zoneSunshine80);
		zoneSunshineRepository.save(zoneSunshine81);
		zoneSunshineRepository.save(zoneSunshine82);
		zoneSunshineRepository.save(zoneSunshine83);
		zoneSunshineRepository.save(zoneSunshine84);
		zoneSunshineRepository.save(zoneSunshine85);
		zoneSunshineRepository.save(zoneSunshine86);
		zoneSunshineRepository.save(zoneSunshine87);
		zoneSunshineRepository.save(zoneSunshine88);
		zoneSunshineRepository.save(zoneSunshine89);
		zoneSunshineRepository.save(zoneSunshine90);
		zoneSunshineRepository.save(zoneSunshine91);
		zoneSunshineRepository.save(zoneSunshine92);
		zoneSunshineRepository.save(zoneSunshine93);
		zoneSunshineRepository.save(zoneSunshine94);
		zoneSunshineRepository.save(zoneSunshine95);
		zoneSunshineRepository.save(zoneSunshine96);
		zoneSunshineRepository.save(zoneSunshine97);
		zoneSunshineRepository.save(zoneSunshine98);
		zoneSunshineRepository.save(zoneSunshine99);
		zoneSunshineRepository.save(zoneSunshine100);
		zoneSunshineRepository.save(zoneSunshine101);
		zoneSunshineRepository.save(zoneSunshine102);
		zoneSunshineRepository.save(zoneSunshine103);
		zoneSunshineRepository.save(zoneSunshine104);
		zoneSunshineRepository.save(zoneSunshine105);
		zoneSunshineRepository.save(zoneSunshine106);
		zoneSunshineRepository.save(zoneSunshine107);
		zoneSunshineRepository.save(zoneSunshine108);
		zoneSunshineRepository.save(zoneSunshine109);
		zoneSunshineRepository.save(zoneSunshine110);
		zoneSunshineRepository.save(zoneSunshine111);
		zoneSunshineRepository.save(zoneSunshine112);
		zoneSunshineRepository.save(zoneSunshine113);
		zoneSunshineRepository.save(zoneSunshine114);
		zoneSunshineRepository.save(zoneSunshine115);
		zoneSunshineRepository.save(zoneSunshine116);
		zoneSunshineRepository.save(zoneSunshine117);
		zoneSunshineRepository.save(zoneSunshine118);
		zoneSunshineRepository.save(zoneSunshine119);
		zoneSunshineRepository.save(zoneSunshine120);
		zoneSunshineRepository.save(zoneSunshine121);
		zoneSunshineRepository.save(zoneSunshine122);
		zoneSunshineRepository.save(zoneSunshine123);
		zoneSunshineRepository.save(zoneSunshine124);
		zoneSunshineRepository.save(zoneSunshine125);
		zoneSunshineRepository.save(zoneSunshine126);
		zoneSunshineRepository.save(zoneSunshine127);
		zoneSunshineRepository.save(zoneSunshine128);
		zoneSunshineRepository.save(zoneSunshine129);
		zoneSunshineRepository.save(zoneSunshine130);
		zoneSunshineRepository.save(zoneSunshine131);
		
	}
}
