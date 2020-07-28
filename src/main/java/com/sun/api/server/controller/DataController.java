package com.sun.api.server.controller;

import com.sun.api.server.vo.LoadApiVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.api.server.service.DataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@Log
@CrossOrigin(origins = {"http://116.123.117.59:18280", "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping(value="/api")
public class DataController {

    // 행안부 - 주소검색 API KEY
    private static String ROAD_API_KEY = "devU01TX0FVVEgyMDIwMDcyODAwMzcyMDEwOTk5NzY=";

    @Autowired
    private DataService dataService;
    /**
     * Smp Data 조회
     * @return
     */
    @RequestMapping(value="/selectSmpData")
    public Map<String,Object> selectSmpData(){
        log.info("Select Smp Data");
        return dataService.selectSmpData();
    }

    /**
     * Smp Data 조회
     * @return
     */
    @RequestMapping(value="/selectRecData")
    public Map<String,Object> selectRecData(){
        log.info("Select Rec Data");
        return dataService.selectRecData();
    }

    @RequestMapping(value="/getAddrApi")
    public void getAddrApi(@RequestBody LoadApiVo loadApiVo, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
        log.info("/api - getAddrApi");

        // 요청변수 설정
        String currentPage = req.getParameter("currentPage");    //요청 변수 설정 (현재 페이지. currentPage : n > 0)
        String countPerPage = req.getParameter("countPerPage");  //요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
        String resultType = req.getParameter("resultType");      //요청 변수 설정 (검색결과형식 설정, json)
        String confmKey = req.getParameter("confmKey");          //요청 변수 설정 (승인키)
        String keyword = req.getParameter("keyword");            //요청 변수 설정 (키워드)


        // OPEN API 호출 URL 정보 설정
        String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+loadApiVo.getCurrentPage()+"&countPerPage="+loadApiVo.getCountPerPage()+"&keyword="+ URLEncoder.encode(loadApiVo.getKeyword(),"UTF-8")+"&confmKey="+ROAD_API_KEY+"&resultType="+loadApiVo.getResultType();
        URL url = new URL(apiUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        StringBuffer sb = new StringBuffer();
        String tempStr = null;

        while(true){
            tempStr = br.readLine();
            if(tempStr == null) break;
            sb.append(tempStr);								// 응답결과 JSON 저장
        }
        br.close();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        response.getWriter().write(sb.toString());			// 응답결과 반환
    }
}
