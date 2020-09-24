package com.sun.api.server.fs.service;

import com.sun.api.server.fs.repository.FsRepository;
import com.sun.api.server.fs.vo.FsInQuireVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class FsService {

    @Autowired
    private FsRepository fsRepository;

    public String fsResultQuestion(FsInQuireVo inQuireVo) {
        try{
            fsRepository.save(inQuireVo);
            return "SUCCESS";
        }catch (Exception e){
            e.printStackTrace();
            return "FAIL";
        }
    }
}
