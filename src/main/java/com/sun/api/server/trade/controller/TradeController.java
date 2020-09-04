package com.sun.api.server.trade.controller;

import com.sun.api.server.trade.vo.TradeVo;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/module")
public class TradeController {

    @RequestMapping(value="/fetchTradeInfo")
    public TradeVo fetchTradeInfo(int id){
        log.info("id : " +id);

        return null;
    }

}
