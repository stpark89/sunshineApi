package com.sun.api.server.inquire.service;

import com.sun.api.server.inquire.repository.InQuireRepository;
import com.sun.api.server.inquire.vo.InQuireVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class InQuireService {

    @Autowired
    private InQuireRepository repository;

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

}
