package com.sun.api.server.inquire.service;

import com.sun.api.server.inquire.repository.InQuireRepository;
import com.sun.api.server.inquire.vo.InQuirePlantVo;
import com.sun.api.server.inquire.vo.InQuireVo;
import com.sun.api.server.subdivision.service.SubdivisionService;
import com.sun.api.server.subdivision.vo.SubdivisionVo;
import com.sun.api.server.trade.service.TradeService;
import com.sun.api.server.trade.vo.TradeVo;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class InQuireService {

    @Autowired
    private InQuireRepository repository;

    @Autowired
    private SubdivisionService subdivisionService;

    @Autowired
    private TradeService tradeService;

    /**
     * 발전소 매매, 분양 문의 등록
     * @param inquireVo
     * @return
     */
    public String inquireRequest(InQuireVo inquireVo){
        log.info("InQuireService.inquireRequest");
        try{
            repository.save(inquireVo);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    public List<InQuireVo> selectAllInQuire(){
    	return repository.findAll();
    }
    
    public List<InQuireVo> selectInQuireType(InQuireVo inQuireVo){
    	return repository.findInQuireType(inQuireVo.getInquireType());
    }

    // 상세 보기
    public Map<String, Object> selectInQuireDetailInfo (InQuireVo inQuireVo){
        Map<String, Object> returnMap = new HashMap<>();
        Optional<InQuireVo> searchVo = repository.findById(inQuireVo.getId());

        log.info("여기 확인좀 해야해요 ---------");
        log.info(searchVo.toString());
        // SubDivision
        if(searchVo.get().getInquireType().equals("분양")){
            log.info("분양 정보 조회");
            Optional<SubdivisionVo> returnVo = subdivisionService.searchSubdivisionVoOne(Long.parseLong(searchVo.get().getInquireKey()));
            returnMap.put("resultType", "분양");
            returnMap.put("result", returnVo);
        }else{
            log.info("구매 정보 조회");
            Optional<TradeVo> returnVo = tradeService.searchTradeVoOne(Long.parseLong(searchVo.get().getInquireKey()));
            returnMap.put("dataType", "구매");
            returnMap.put("result", returnVo);
        }

        // 문의 내역
        returnMap.put("resultUser", searchVo);

        return returnMap;
    }
    

}
