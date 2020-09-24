package com.sun.api.server.fs.service;

import com.sun.api.server.fs.repository.FsRepository;
import com.sun.api.server.fs.vo.FsInQuireVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class FsService {

    @Autowired
    private FsRepository fsRepository;

    public String fsResultQuestion(FsInQuireVo inQuireVo) {
        log.info("fsResultQuestion");
        try{
            fsRepository.save(inQuireVo);
            return "SUCCESS";
        }catch (Exception e){
            e.printStackTrace();
            return "FAIL";
        }
    }

    /**
     * 리스트 조회
     * @return
     */
    public List<FsInQuireVo> fetchResultQuestionList(){
        log.info("fetchResultQuestionList");
        List<FsInQuireVo> returnList = new ArrayList<>();
        try{

            returnList = fsRepository.findAll();

        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    /**
     * 내부지 직접하기 - 문의하기 상세내용 조회
     * @param fsInQuireVo
     * @return
     */
    public FsInQuireVo fetchDetailRequestQuestion(FsInQuireVo fsInQuireVo) {
        log.info("fetchDetailRequestQuestion");
        Optional<FsInQuireVo> returnVo = fsRepository.findById(fsInQuireVo.getId());
        return returnVo.get();
    }
}
