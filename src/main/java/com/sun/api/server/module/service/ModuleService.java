package com.sun.api.server.module.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.api.server.module.repository.InverterInfoVoRepository;
import com.sun.api.server.module.repository.ModuleInfoVoRepository;
import com.sun.api.server.module.vo.InverterInfoVo;
import com.sun.api.server.vo.module.ModuleInfoVo;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleInfoVoRepository moduleInfoVoRepository;
	
	@Autowired
	private InverterInfoVoRepository inverterInfoVoRepository;
	
	
	/**
	 * 모듈 전체 조회 
	 * @return
	 */
	public List<ModuleInfoVo> searchModule(){
		return moduleInfoVoRepository.findAll();
	}
	
	/**
	 * 모듈 단건 조회 
	 * @param id
	 * @return
	 */
	public Optional<ModuleInfoVo> searchModuleOne(long id) {
		return moduleInfoVoRepository.findById(id);
	}
	
	/**
	 * 인버터 전체 조회
	 * @return
	 */
	public List<InverterInfoVo> searchInverter(){
		return inverterInfoVoRepository.findAll();
	}
	
	/**
	 * 인버터 단건 조회 
	 * @param id
	 * @return
	 */
	public Optional<InverterInfoVo> searchInverterOne(long id){
		return inverterInfoVoRepository.findById(id);
	}
	
	/**
	 * 인버터 데이터 저장 임시 
	 */
	public void saveInverter() {
		 InverterInfoVo in1 = new InverterInfoVo("현대중공업그린에너지","HPC-050HL-U1-OU",50,"KS",1000,"480~850","3MPPT",71,98.54,"600x260x1,000","5",4500000,4725000);
		 InverterInfoVo in2 = new InverterInfoVo("효성중공업","HS-P36GLO",36,"",1100,"200~1,000","4MPPT",55,98.6,"930x550x260","5",2800000,2940000);
		 InverterInfoVo in3 = new InverterInfoVo("효성중공업","HS-P50GLO",50,"",1100,"200~1,000","6MPPT",74,98.4,"1075x555x300","5",4500000,4725000);
		 InverterInfoVo in4 = new InverterInfoVo("효성중공업","HS-P100GLO",100,"",1100,"200~1,000","10MPPT",85,98.6,"1035x700x365","5",7600000,7980000);
		 InverterInfoVo in5 = new InverterInfoVo("금비전자","ST36K",36,"KS",1000,"400~800","3MPPT",68,98.2,"688x755x295","7",3400000,3570000);
		 InverterInfoVo in6 = new InverterInfoVo("금비전자","ST50K",50,"KS",1000,"480~800","4/3포트(D채널2포트)",65,98,"688x760x284.5","7",4300000,4515000);
		 InverterInfoVo in7 = new InverterInfoVo("다쓰테크","DSP-123K6V2-OD",3.5,"KS",500,"100~400","1MPPT",9,97,"358x376x150","5",330000,346500);
		 InverterInfoVo in8 = new InverterInfoVo("다쓰테크","DSP-3315K-J",15,"KS",1000,"480~800","2MPPT",50,98.1,"550x565x280","5",3000000,3150000);
		 InverterInfoVo in9 = new InverterInfoVo("다쓰테크","DSP-3320K-J",20,"KS",1000,"480~800","2MPPT",50,98,"550x565x280","5",3200000,3360000);
		 InverterInfoVo in10 = new InverterInfoVo("다쓰테크","DSP-3325K-J",25,"KS",1000,"480~800","2MPPT",50,98,"550x565x280","5",3400000,3570000);
		 InverterInfoVo in11 = new InverterInfoVo("다쓰테크","DSP-3334K2-J",34,"KS",1000,"480~800","3MPPT",60,98,"550x770x320","5",3900000,4095000);
		 InverterInfoVo in12 = new InverterInfoVo("다쓰테크","DSP-33100K-OD-HV",105,"KS",1000,"580~800","1MPPT",85,98,"650x910x360","5",6800000,7140000);
		 InverterInfoVo in13 = new InverterInfoVo("다쓰테크","DSP-33100K-OD-LV",100,"KS",1000,"500~800","4MPPT",250,98,"660x1260x651","5",10500000,11025000);
		 InverterInfoVo in14 = new InverterInfoVo("동양이엔피","ESP3K5-KRA/B",3.5,"KS",500,"60~500","1MPPT(2ch)",10.5,97.4,"355x140x450","5",360000,378000);
		 InverterInfoVo in15 = new InverterInfoVo("썬그로우","SG33CX",33,"KS",1100,"550~850","3MPPT(6ch)",50,98.6,"702x595x310","5",3400000,3570000);
		 InverterInfoVo in16 = new InverterInfoVo("썬그로우","SG50CX",50,"KS",1100,"550~850","5MPPT(10ch)",62,98.7,"782x645x310","5",4400000,4620000);
		 InverterInfoVo in17 = new InverterInfoVo("썬그로우","SG110CX",100,"KS",1100,"550~850","9MPPT(18ch)",85,98.7,"1051x660x362.5","5",8000000,8400000);
		 InverterInfoVo in18 = new InverterInfoVo("신성","SSE-S33",33,"",1000,"480~800","2MPPT(6ch)",45,98.8,"553x860x240","5(7)",3200000,3360000);
		 InverterInfoVo in19 = new InverterInfoVo("신성","SSE-S50",50,"",1000,"480~800","3MPPT(9ch)",68,98.6,"636x958x260","5(7)",4300000,4515000);
		 InverterInfoVo in20 = new InverterInfoVo("카코","BP50.0TL3",50,"",1100,"580~900","1MPPT(10ch)",73,97.81,"760x500x425","5",5300000,5565000);
		 InverterInfoVo in21 = new InverterInfoVo("델타","M50A-12s",50,"",1000,"520~800","2MPPT(12ch)",74,98.6,"612x740x278","5",4900000,5145000);
		 inverterInfoVoRepository.save(in1);
		 inverterInfoVoRepository.save(in2);
		 inverterInfoVoRepository.save(in3);
		 inverterInfoVoRepository.save(in4);
		 inverterInfoVoRepository.save(in5);
		 inverterInfoVoRepository.save(in6);
		 inverterInfoVoRepository.save(in7);
		 inverterInfoVoRepository.save(in8);
		 inverterInfoVoRepository.save(in9);
		 inverterInfoVoRepository.save(in10);
		 inverterInfoVoRepository.save(in11);
		 inverterInfoVoRepository.save(in12);
		 inverterInfoVoRepository.save(in13);
		 inverterInfoVoRepository.save(in14);
		 inverterInfoVoRepository.save(in15);
		 inverterInfoVoRepository.save(in16);
		 inverterInfoVoRepository.save(in17);
		 inverterInfoVoRepository.save(in18);
		 inverterInfoVoRepository.save(in19);
		 inverterInfoVoRepository.save(in20);
		 inverterInfoVoRepository.save(in21);
		 
	}
	
	
	/**
	 * 모듈 저장 (임시) 
	 */
	public void saveModule() {
		ModuleInfoVo moduleInfoVo1 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",390,15,11,3,14.85,14.85,  175500 ,  184275 ,"");
		ModuleInfoVo moduleInfoVo2 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",0,15,0,0,0,14.85,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo3 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",390,20,11,4,19.8,19.8,  175500 ,  184275 ,"");
		ModuleInfoVo moduleInfoVo4 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",0,20,11,4,19.8,19.8,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo5 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",390,30,13,5,29.25,29.25,  175500 ,  184275 ,"");
		ModuleInfoVo moduleInfoVo6 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",0,30,0,0,0,29.25,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo7 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",390,50,14,6,37.8,49.5,  175500 ,  184275 ,"");
		ModuleInfoVo moduleInfoVo8 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",0,50,13,2,11.7,49.5,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo9 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",390,100,14,12,75.6,99,  175500 ,  184275 ,"");
		ModuleInfoVo moduleInfoVo10 = new ModuleInfoVo("한화큐셀","한화 450Wp","Q.PEAK DUO XL0G9.3 450",450,53.18,10.65,20.1,1500,"2171 x 1030 x 35",25.5,12,"25년 83% 효율보증",0,100,13,4,23.4,99,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo11 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",370,15,12,3,15.12,15.12,  155400 ,  163170 ,"");
		ModuleInfoVo moduleInfoVo12 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",0,15,0,0,0,15.12,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo13 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",370,20,11,2,9.24,19.32,  155400 ,  163170 ,"");
		ModuleInfoVo moduleInfoVo14 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",0,20,12,2,10.08,19.32,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo15 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",370,30,14,5,29.4,29.4,  155400 ,  163170 ,"");
		ModuleInfoVo moduleInfoVo16 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",0,30,0,0,0,29.4,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo17 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",370,50,13,8,43.68,49.56,  155400 ,  163170 ,"");
		ModuleInfoVo moduleInfoVo18 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",0,50,14,1,5.88,49.56,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo19 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",370,100,13,16,87.36,99.12,  155400 ,  163170 ,"");
		ModuleInfoVo moduleInfoVo20 = new ModuleInfoVo("한화큐셀","한화 420Wp","Q.PEAK DUO XL0G9.3 420",420,0,0,0,0,"",0,0,"",0,100,14,2,11.76,99.12,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo21 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",350,15,14,3,15.75,15.75,  131250 ,  137813 ,"가정용태양광용");
		ModuleInfoVo moduleInfoVo22 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",0,15,0,0,0,15.75,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo23 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",350,20,12,2,9,19.5,  131250 ,  137813 ,"가정용태양광용");
		ModuleInfoVo moduleInfoVo24 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",0,20,14,2,10.5,19.5,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo25 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",350,30,13,6,29.25,29.25,  131250 ,  137813 ,"가정용태양광용");
		ModuleInfoVo moduleInfoVo26 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",0,30,0,0,0,29.25,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo27 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",350,50,13,8,39,49.5,  131250 ,  137813 ,"가정용태양광용");
		ModuleInfoVo moduleInfoVo28 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",0,50,14,2,10.5,49.5,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo29 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",350,100,13,16,78,99,  131250 ,  137813 ,"가정용태양광용");
		ModuleInfoVo moduleInfoVo30 = new ModuleInfoVo("한화큐셀","한화 375Wp","Q.PEAK L0G4.4",375,48.44,10,18.8,1000,"1994 x 1000 x 35",23,12,"25년 83% 효율보증",0,100,14,4,21,99,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo31 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",390,15,12,3,15.66,15.66,  169650 ,  178133 ,"");
		ModuleInfoVo moduleInfoVo32 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",0,15,0,0,0,15.66,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo33 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",390,20,11,4,19.14,19.14,  169650 ,  178133 ,"");
		ModuleInfoVo moduleInfoVo34 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",0,20,0,0,0,19.14,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo35 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",390,30,14,4,24.36,29.58,  169650 ,  178133 ,"");
		ModuleInfoVo moduleInfoVo36 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",0,30,12,1,5.22,29.58,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo37 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",390,50,13,5,28.275,49.155,  169650 ,  178133 ,"");
		ModuleInfoVo moduleInfoVo38 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",0,50,12,4,20.88,49.155,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo39 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",390,100,13,12,67.86,99.18,  169650 ,  178133 ,"");
		ModuleInfoVo moduleInfoVo40 = new ModuleInfoVo("현대에너지솔루션","현대 435Wp","HID0S435SI0COM",435,0,0,0,0,"",0,0,"",0,100,12,6,31.32,99.18,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo41 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",370,15,12,3,14.94,14.94,  153550 ,  161228 ,"썬파워");
		ModuleInfoVo moduleInfoVo42 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",0,15,0,0,0,14.94,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo43 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",370,20,12,4,19.92,19.92,  153550 ,  161228 ,"썬파워");
		ModuleInfoVo moduleInfoVo44 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",0,20,0,0,0,19.92,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo45 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",370,30,14,5,29.05,29.05,  153550 ,  161228 ,"썬파워");
		ModuleInfoVo moduleInfoVo46 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",0,30,0,0,0,29.05,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo47 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",370,50,12,10,49.8,49.8,  153550 ,  161228 ,"썬파워");
		ModuleInfoVo moduleInfoVo48 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",0,50,0,0,0,49.8,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo49 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",370,100,12,20,99.6,99.6,  153550 ,  161228 ,"썬파워");
		ModuleInfoVo moduleInfoVo50 = new ModuleInfoVo("현대에너지솔루션","현대 415Wp","HID0S415SI0COM",415,0,0,0,0,"",0,0,"",0,100,0,0,0,99.6,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo51 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",370,15,12,3,14.76,14.76,  151700 ,  159285 ,"썬파워");
		ModuleInfoVo moduleInfoVo52 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,15,0,0,0,14.76,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo53 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",370,20,12,4,19.68,19.68,  151700 ,  159285 ,"썬파워");
		ModuleInfoVo moduleInfoVo54 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,20,0,0,0,19.68,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo55 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",370,30,12,6,29.52,29.52,  151700 ,  159285 ,"썬파워");
		ModuleInfoVo moduleInfoVo56 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,30,0,0,0,29.52,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo57 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",370,50,12,10,49.2,49.2,  151700 ,  159285 ,"썬파워");
		ModuleInfoVo moduleInfoVo58 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,50,0,0,0,49.2,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo59 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",370,100,13,14,74.62,99.22,  151700 ,  159285 ,"썬파워");
		ModuleInfoVo moduleInfoVo60 = new ModuleInfoVo("현대에너지솔루션","현대 410Wp","HID0S410SI0COM",410,54.5,9.55,19.9,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,100,12,5,24.6,99.22,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo61 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",360,15,13,3,15.795,15.795,  145800 ,  153090 ,"썬파워");
		ModuleInfoVo moduleInfoVo62 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,15,0,0,0,15.795,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo63 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",360,20,12,4,19.44,19.44,  145800 ,  153090 ,"썬파워");
		ModuleInfoVo moduleInfoVo64 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,20,0,0,0,19.44,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo65 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",360,30,12,6,29.16,29.16,  145800 ,  153090 ,"썬파워");
		ModuleInfoVo moduleInfoVo66 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,30,0,0,0,29.16,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo67 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",360,50,12,8,38.88,49.41,  145800 ,  153090 ,"썬파워");
		ModuleInfoVo moduleInfoVo68 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,50,13,2,10.53,49.41,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo69 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",360,100,12,14,68.04,99.63,  145800 ,  153090 ,"썬파워");
		ModuleInfoVo moduleInfoVo70 = new ModuleInfoVo("현대에너지솔루션","현대 405Wp","HID0S405SI0COM",405,54,9.53,19.6,1500,"2067 x 998 x 40",23.1,25,"30년 82.6% 효율보증",0,100,13,6,31.59,99.63,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo71 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",590,15,12,3,15.3,15.3,  250750 ,  263288 ,"양면모듈");
		ModuleInfoVo moduleInfoVo72 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",0,15,0,0,0,15.3,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo73 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",590,20,12,2,10.2,19.55,  250750 ,  263288 ,"양면모듈");
		ModuleInfoVo moduleInfoVo74 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",0,20,11,2,9.35,19.55,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo75 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",590,30,14,5,29.75,29.75,  250750 ,  263288 ,"양면모듈");
		ModuleInfoVo moduleInfoVo76 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",0,30,0,0,0,29.75,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo77 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",590,50,13,9,49.725,49.725,  250750 ,  263288 ,"양면모듈");
		ModuleInfoVo moduleInfoVo78 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",0,50,0,0,0,49.725,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo79 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",590,100,13,18,99.45,99.45,  250750 ,  263288 ,"양면모듈");
		ModuleInfoVo moduleInfoVo80 = new ModuleInfoVo("LG전자","LG 425Wp","LG425N2T0V5",425,49.7,10.22,19.3,1000,"2024 x 1024 x 40",20.3,25,"25년 95.4% 효율보증",0,100,0,0,0,99.45,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo81 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",550,15,12,3,14.94,14.94,  228250 ,  239663 ,"");
		ModuleInfoVo moduleInfoVo82 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",0,15,0,0,0,14.94,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo83 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",550,20,12,4,19.92,19.92,  228250 ,  239663 ,"");
		ModuleInfoVo moduleInfoVo84 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",0,20,0,0,0,19.92,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo85 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",550,30,12,6,29.88,29.88,  228250 ,  239663 ,"");
		ModuleInfoVo moduleInfoVo86 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",0,30,0,0,0,29.88,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo87 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",550,50,12,10,49.8,49.8,  228250 ,  239663 ,"");
		ModuleInfoVo moduleInfoVo88 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",0,50,0,0,0,49.8,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo89 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",550,100,12,20,99.6,99.6,  228250 ,  239663 ,"");
		ModuleInfoVo moduleInfoVo90 = new ModuleInfoVo("LG전자","LG 415Wp","LG415N2T0V5",415,0,0,0,0,"",0,0,"",0,100,0,0,0,99.6,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo91 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",380,15,13,3,15.6,15.6,  152000 ,  159600 ,"");
		ModuleInfoVo moduleInfoVo92 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",0,15,0,0,0,15.6,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo93 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",380,20,12,4,19.2,19.2,  152000 ,  159600 ,"");
		ModuleInfoVo moduleInfoVo94 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",0,20,0,0,0,19.2,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo95 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",380,30,12,4,19.2,29.6,  152000 ,  159600 ,"");
		ModuleInfoVo moduleInfoVo96 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",0,30,13,2,10.4,29.6,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo97 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",380,50,13,4,20.8,49.6,  152000 ,  159600 ,"");
		ModuleInfoVo moduleInfoVo98 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",0,50,12,6,28.8,49.6,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo99 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",380,100,13,4,20.8,99.2,  152000 ,  159600 ,"");
		ModuleInfoVo moduleInfoVo100 = new ModuleInfoVo("LG전자","LG 400Wp","LG400N2T0V5",400,0,0,0,0,"",0,0,"",0,100,14,14,78.4,99.2,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo101 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,15,12,3,15.3,15.3,  148750 ,  156188 ,"");
		ModuleInfoVo moduleInfoVo102 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,15,0,0,0,15.3,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo103 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,20,11,2,9.35,19.55,  148750 ,  156188 ,"");
		ModuleInfoVo moduleInfoVo104 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,20,12,2,10.2,19.55,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo105 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,30,14,5,29.75,29.75,  148750 ,  156188 ,"");
		ModuleInfoVo moduleInfoVo106 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,30,0,0,0,29.75,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo107 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,50,13,9,49.725,49.725,  148750 ,  156188 ,"");
		ModuleInfoVo moduleInfoVo108 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,50,0,0,0,49.725,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo109 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,100,13,18,99.45,99.45,  148750 ,  156188 ,"");
		ModuleInfoVo moduleInfoVo110 = new ModuleInfoVo("한솔테크닉스","한솔 425Wp","HS425UE0AH2",425,53.6,10.15,19.3,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,100,0,0,0,99.45,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo111 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,15,12,3,15.12,15.12,  147000 ,  154350 ,"");
		ModuleInfoVo moduleInfoVo112 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,15,0,0,0,15.12,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo113 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,20,12,2,10.08,19.32,  147000 ,  154350 ,"");
		ModuleInfoVo moduleInfoVo114 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,20,11,2,9.24,19.32,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo115 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,30,14,5,29.4,29.4,  147000 ,  154350 ,"");
		ModuleInfoVo moduleInfoVo116 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,30,0,0,0,29.4,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo117 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,50,13,8,43.68,49.56,  147000 ,  154350 ,"");
		ModuleInfoVo moduleInfoVo118 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,50,14,1,5.88,49.56,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo119 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",350,100,14,4,23.52,99.96,  147000 ,  154350 ,"");
		ModuleInfoVo moduleInfoVo120 = new ModuleInfoVo("한솔테크닉스","한솔 420Wp","HS420UE0AH2",420,53.2,10.13,19.49,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,100,13,14,76.44,99.96,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo121 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",340,15,12,3,14.94,14.94,  141100 ,  148155 ,"");
		ModuleInfoVo moduleInfoVo122 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,15,0,0,0,14.84,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo123 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",340,20,12,4,19.92,19.92,  141100 ,  148155 ,"");
		ModuleInfoVo moduleInfoVo124 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,20,0,0,0,19.92,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo125 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",340,30,12,6,29.88,29.88,  141100 ,  148155 ,"");
		ModuleInfoVo moduleInfoVo126 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,30,0,0,0,29.88,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo127 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",340,50,12,10,49.8,49.8,  141100 ,  148155 ,"");
		ModuleInfoVo moduleInfoVo128 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,50,0,0,0,49.8,  0 ,  0 ,"");
		ModuleInfoVo moduleInfoVo129 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",340,100,14,6,34.86,99.6,  141100 ,  148155 ,"");
		ModuleInfoVo moduleInfoVo130 = new ModuleInfoVo("한솔테크닉스","한솔 415Wp","HS415UE0AH2",415,52.8,10.1,19.26,1500,"2155 x 1000 x 40",23.8,12,"25년 82.2% 효율보증",0,100,13,12,64.74,99.6,  0 ,  0 ,"");
		
		moduleInfoVoRepository.save(moduleInfoVo1);
		moduleInfoVoRepository.save(moduleInfoVo2);
		moduleInfoVoRepository.save(moduleInfoVo3);
		moduleInfoVoRepository.save(moduleInfoVo4);
		moduleInfoVoRepository.save(moduleInfoVo5);
		moduleInfoVoRepository.save(moduleInfoVo6);
		moduleInfoVoRepository.save(moduleInfoVo7);
		moduleInfoVoRepository.save(moduleInfoVo8);
		moduleInfoVoRepository.save(moduleInfoVo9);
		moduleInfoVoRepository.save(moduleInfoVo10);
		moduleInfoVoRepository.save(moduleInfoVo11);
		moduleInfoVoRepository.save(moduleInfoVo12);
		moduleInfoVoRepository.save(moduleInfoVo13);
		moduleInfoVoRepository.save(moduleInfoVo14);
		moduleInfoVoRepository.save(moduleInfoVo15);
		moduleInfoVoRepository.save(moduleInfoVo16);
		moduleInfoVoRepository.save(moduleInfoVo17);
		moduleInfoVoRepository.save(moduleInfoVo18);
		moduleInfoVoRepository.save(moduleInfoVo19);
		moduleInfoVoRepository.save(moduleInfoVo20);
		moduleInfoVoRepository.save(moduleInfoVo21);
		moduleInfoVoRepository.save(moduleInfoVo22);
		moduleInfoVoRepository.save(moduleInfoVo23);
		moduleInfoVoRepository.save(moduleInfoVo24);
		moduleInfoVoRepository.save(moduleInfoVo25);
		moduleInfoVoRepository.save(moduleInfoVo26);
		moduleInfoVoRepository.save(moduleInfoVo27);
		moduleInfoVoRepository.save(moduleInfoVo28);
		moduleInfoVoRepository.save(moduleInfoVo29);
		moduleInfoVoRepository.save(moduleInfoVo30);
		moduleInfoVoRepository.save(moduleInfoVo31);
		moduleInfoVoRepository.save(moduleInfoVo32);
		moduleInfoVoRepository.save(moduleInfoVo33);
		moduleInfoVoRepository.save(moduleInfoVo34);
		moduleInfoVoRepository.save(moduleInfoVo35);
		moduleInfoVoRepository.save(moduleInfoVo36);
		moduleInfoVoRepository.save(moduleInfoVo37);
		moduleInfoVoRepository.save(moduleInfoVo38);
		moduleInfoVoRepository.save(moduleInfoVo39);
		moduleInfoVoRepository.save(moduleInfoVo40);
		moduleInfoVoRepository.save(moduleInfoVo41);
		moduleInfoVoRepository.save(moduleInfoVo42);
		moduleInfoVoRepository.save(moduleInfoVo43);
		moduleInfoVoRepository.save(moduleInfoVo44);
		moduleInfoVoRepository.save(moduleInfoVo45);
		moduleInfoVoRepository.save(moduleInfoVo46);
		moduleInfoVoRepository.save(moduleInfoVo47);
		moduleInfoVoRepository.save(moduleInfoVo48);
		moduleInfoVoRepository.save(moduleInfoVo49);
		moduleInfoVoRepository.save(moduleInfoVo50);
		moduleInfoVoRepository.save(moduleInfoVo51);
		moduleInfoVoRepository.save(moduleInfoVo52);
		moduleInfoVoRepository.save(moduleInfoVo53);
		moduleInfoVoRepository.save(moduleInfoVo54);
		moduleInfoVoRepository.save(moduleInfoVo55);
		moduleInfoVoRepository.save(moduleInfoVo56);
		moduleInfoVoRepository.save(moduleInfoVo57);
		moduleInfoVoRepository.save(moduleInfoVo58);
		moduleInfoVoRepository.save(moduleInfoVo59);
		moduleInfoVoRepository.save(moduleInfoVo60);
		moduleInfoVoRepository.save(moduleInfoVo61);
		moduleInfoVoRepository.save(moduleInfoVo62);
		moduleInfoVoRepository.save(moduleInfoVo63);
		moduleInfoVoRepository.save(moduleInfoVo64);
		moduleInfoVoRepository.save(moduleInfoVo65);
		moduleInfoVoRepository.save(moduleInfoVo66);
		moduleInfoVoRepository.save(moduleInfoVo67);
		moduleInfoVoRepository.save(moduleInfoVo68);
		moduleInfoVoRepository.save(moduleInfoVo69);
		moduleInfoVoRepository.save(moduleInfoVo70);
		moduleInfoVoRepository.save(moduleInfoVo71);
		moduleInfoVoRepository.save(moduleInfoVo72);
		moduleInfoVoRepository.save(moduleInfoVo73);
		moduleInfoVoRepository.save(moduleInfoVo74);
		moduleInfoVoRepository.save(moduleInfoVo75);
		moduleInfoVoRepository.save(moduleInfoVo76);
		moduleInfoVoRepository.save(moduleInfoVo77);
		moduleInfoVoRepository.save(moduleInfoVo78);
		moduleInfoVoRepository.save(moduleInfoVo79);
		moduleInfoVoRepository.save(moduleInfoVo80);
		moduleInfoVoRepository.save(moduleInfoVo81);
		moduleInfoVoRepository.save(moduleInfoVo82);
		moduleInfoVoRepository.save(moduleInfoVo83);
		moduleInfoVoRepository.save(moduleInfoVo84);
		moduleInfoVoRepository.save(moduleInfoVo85);
		moduleInfoVoRepository.save(moduleInfoVo86);
		moduleInfoVoRepository.save(moduleInfoVo87);
		moduleInfoVoRepository.save(moduleInfoVo88);
		moduleInfoVoRepository.save(moduleInfoVo89);
		moduleInfoVoRepository.save(moduleInfoVo90);
		moduleInfoVoRepository.save(moduleInfoVo91);
		moduleInfoVoRepository.save(moduleInfoVo92);
		moduleInfoVoRepository.save(moduleInfoVo93);
		moduleInfoVoRepository.save(moduleInfoVo94);
		moduleInfoVoRepository.save(moduleInfoVo95);
		moduleInfoVoRepository.save(moduleInfoVo96);
		moduleInfoVoRepository.save(moduleInfoVo97);
		moduleInfoVoRepository.save(moduleInfoVo98);
		moduleInfoVoRepository.save(moduleInfoVo99);
		moduleInfoVoRepository.save(moduleInfoVo100);
		moduleInfoVoRepository.save(moduleInfoVo101);
		moduleInfoVoRepository.save(moduleInfoVo102);
		moduleInfoVoRepository.save(moduleInfoVo103);
		moduleInfoVoRepository.save(moduleInfoVo104);
		moduleInfoVoRepository.save(moduleInfoVo105);
		moduleInfoVoRepository.save(moduleInfoVo106);
		moduleInfoVoRepository.save(moduleInfoVo107);
		moduleInfoVoRepository.save(moduleInfoVo108);
		moduleInfoVoRepository.save(moduleInfoVo109);
		moduleInfoVoRepository.save(moduleInfoVo110);
		moduleInfoVoRepository.save(moduleInfoVo111);
		moduleInfoVoRepository.save(moduleInfoVo112);
		moduleInfoVoRepository.save(moduleInfoVo113);
		moduleInfoVoRepository.save(moduleInfoVo114);
		moduleInfoVoRepository.save(moduleInfoVo115);
		moduleInfoVoRepository.save(moduleInfoVo116);
		moduleInfoVoRepository.save(moduleInfoVo117);
		moduleInfoVoRepository.save(moduleInfoVo118);
		moduleInfoVoRepository.save(moduleInfoVo119);
		moduleInfoVoRepository.save(moduleInfoVo120);
		moduleInfoVoRepository.save(moduleInfoVo121);
		moduleInfoVoRepository.save(moduleInfoVo122);
		moduleInfoVoRepository.save(moduleInfoVo123);
		moduleInfoVoRepository.save(moduleInfoVo124);
		moduleInfoVoRepository.save(moduleInfoVo125);
		moduleInfoVoRepository.save(moduleInfoVo126);
		moduleInfoVoRepository.save(moduleInfoVo127);
		moduleInfoVoRepository.save(moduleInfoVo128);
		moduleInfoVoRepository.save(moduleInfoVo129);
		moduleInfoVoRepository.save(moduleInfoVo130);
	}
}
