package com.sun.api.server.inquire.service;

import com.sun.api.server.inquire.repository.InQuirePlantRepository;
import com.sun.api.server.inquire.vo.InQuirePlantVo;
import com.sun.api.server.subdivision.vo.SubdivisionVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class InQuirePlantService {

    @Autowired
    private InQuirePlantRepository inQuirePlantRepository;

    /**
     * 프론트 -> 발전소 매각 등록
     * @param vo
     * @return
     */
    public String inquirePlantRequest(InQuirePlantVo vo){
        log.info("InQuirePlantService.inquirePlantRequest");
        try{
            inQuirePlantRepository.save(vo);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    /**
     * 관리자 - 발전소 매각 전체 조회
     * @return
     */
    public List<InQuirePlantVo> selectAllPlantInQuire() {
        log.info("InQuirePlantService.selectAllPlantInQuire");
        return inQuirePlantRepository.findAll();
    }

    /**
     * 관리자 - 발전소 매각 상세조회
     * @param vo
     * @return
     */
    public InQuirePlantVo selectPlantInQuireDetailInfo(InQuirePlantVo vo){
        log.info("InQuirePlantService.selectPlantInQuireDetailInfo");
        Optional<InQuirePlantVo> returnVo = inQuirePlantRepository.findById(vo.getId());
        return returnVo.get();
    }

}
