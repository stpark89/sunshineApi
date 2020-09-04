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
	
	
}
