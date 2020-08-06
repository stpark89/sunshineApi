package com.sun.api.server.controller;

import com.sun.api.server.vo.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.api.server.service.DataService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.net.HttpURLConnection;
import javax.xml.xpath.*;


@Log
@CrossOrigin(origins = {"http://116.123.117.59:18280", "http://localhost:8080", "http://localhost:3000", "http://13.124.51.180:8080" })
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

    /**
     * 주소 API 검색하기 용도.
     * @param loadApiVo
     * @param req
     * @param model
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/getAddrApi")
    public void getAddrApi(@RequestBody LoadApiVo loadApiVo, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
        log.info("/api - getAddrApi");

        // 요청변수 설정
        String currentPage = req.getParameter("currentPage");    //요청 변수 설정 (현재 페이지. currentPage : n > 0)
        String countPerPage = req.getParameter("countPerPage");  //요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
        String resultType = req.getParameter("resultType");      //요청 변수 설정 (검색결과형식 설정, json)
        String confmKey = req.getParameter("confmKey");          //요청 변수 설정 (승인키)
        String keyword = req.getParameter("keyword");            //요청 변수 설정 (키워드)

        log.info(("ConfmKey - " +confmKey + " // Vo :  " +loadApiVo.getConfmKey().toString()));

        // OPEN API 호출 URL 정보 설정
        String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+loadApiVo.getCurrentPage()+"&countPerPage="+loadApiVo.getCountPerPage()+"&keyword="+ URLEncoder.encode(loadApiVo.getKeyword(),"UTF-8")+"&confmKey="+loadApiVo.getConfmKey()+"&resultType="+loadApiVo.getResultType();
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

    /**
     * 좌표 API 호출 작업.
     * @throws Exception
     */
    @RequestMapping(value="/getAddrLocationApi")
    public void getAddrLocationApi(@RequestBody LocationApiVo locationApiVo, HttpServletResponse response) throws Exception{
        log.info("/api - LocationApi");
        System.out.println("Location :: " +locationApiVo.toString());
        String apiUrl = "http://www.juso.go.kr/addrlink/addrCoordApi.do?confmKey="+locationApiVo.getConfmKey()+"&admCd="+locationApiVo.getAdmCd()+"&rnMgtSn="+locationApiVo.getRnMgtSn()+"&udrtYn="+locationApiVo.getUdrtYn()+"&buldMnnm="+locationApiVo.getBuldMnnm()+"&buldSlno="+locationApiVo.getBuldSlno()+"&resultType="+locationApiVo.getResultType();
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

    /**
     * 토지 임야 정보 API 호출
     */
    @RequestMapping(value="/ladfrlList")
    public LadfrlResponseVo ladfrlList(@RequestBody LadfrlRequestVo ladfrlRequestVo, HttpServletResponse response) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1611000/nsdi/eios/LadfrlService/ladfrlList.xml"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=%2B5vcuNVXk3gsadPH5UG5IalKrqI6jb1PL68PlxHf6R36phxavyKGAIuKJ9yVqoLOcCPptwroicpU9jxyISW5FA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pnu","UTF-8") + "=" + URLEncoder.encode(ladfrlRequestVo.getPnu(), "UTF-8")); /*각 필지를 서로 구별하기 위하여 필지마다 붙이는 고유한 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*검색건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }


        System.out.println("SB----------");
        System.out.println(sb.toString());

        // 리턴해줄 데이터 .
        LadfrlResponseVo responseVo = new LadfrlResponseVo();


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        // xml 파싱하기
        InputSource is = new InputSource(new StringReader(sb.toString()));
        builder = factory.newDocumentBuilder();
        doc = builder.parse(is);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        XPathExpression expr = xpath.compile("/fields/ladfrlVOList");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();

            for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);

                // 법정 동명
                if(node.getNodeName().equals("ldCodeNm")){
                    responseVo.setLdCodeNm(node.getTextContent());
                }

                // 지번주소)
                if(node.getNodeName().equals("mnnmSlno")){
                    responseVo.setMnnmSlno(node.getTextContent());
                }

                // 지목
                if(node.getNodeName().equals("lndcgrCodeNm")){
                    responseVo.setLndcgrCodeNm(node.getTextContent());
                }

                // 면적 (m2)
                if(node.getNodeName().equals("lndpclAr")){
                    responseVo.setLndpclAr(node.getTextContent());
                }

                // 소유 구
                if(node.getNodeName().equals("posesnSeCodeNm")){
                    responseVo.setPosesnSeCodeNm(node.getTextContent());
                }

                // 소유 명
                if(node.getNodeName().equals("cnrsPsnCo")){
                    responseVo.setCnrsPsnCo(node.getTextContent());
                }
                /**
                System.out.println("현재 노드 이름 : " + node.getNodeName());
                System.out.println("현재 노드 타입 : " + node.getNodeType());
                System.out.println("현재 노드 값 : " + node.getTextContent());
                 */
            }
        }

        // 평수 계산 작업.
        double pyung = Double.parseDouble(responseVo.getLndpclAr()) / 3.305785;

        System.out.println("평수 ::::" +pyung);

        responseVo.setLndpclArPyung(String.format("%.2f", pyung));

        rd.close();
        conn.disconnect();
        return responseVo;
    }


    @RequestMapping(value="/bsdPrice")
    public void bsdPrice(@RequestBody BsdPriceRequestVo requestVo, HttpServletResponse response) throws Exception{
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1611000/nsdi/StatsIndicatorService/attr/getIndvdLandPrice"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=%2B5vcuNVXk3gsadPH5UG5IalKrqI6jb1PL68PlxHf6R36phxavyKGAIuKJ9yVqoLOcCPptwroicpU9jxyISW5FA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("stdrYear","UTF-8") + "=" + URLEncoder.encode(requestVo.getStdrYear(), "UTF-8")); /*기준년도(YYYY: 4자리)*/
        urlBuilder.append("&" + URLEncoder.encode("reqLvl","UTF-8") + "=" + URLEncoder.encode(requestVo.getReqLvl(), "UTF-8")); /*요청구분(1: 시도단위, 2: 시군구단위, 3: 읍면동리단위)*/
        urlBuilder.append("&" + URLEncoder.encode("ldCode","UTF-8") + "=" + URLEncoder.encode(requestVo.getLdCode(), "UTF-8")); /*법정동코드(reqLvl값이 1일 경우: 해당 없음, 2일 경우: 2~5자리, 3일 경우: 2~10자리)*/
        urlBuilder.append("&" + URLEncoder.encode("format","UTF-8") + "=" + URLEncoder.encode(requestVo.getFormat(), "UTF-8")); /*응답결과 형식(xml 또는 json)*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(String.valueOf(requestVo.getNumOfRows()), "UTF-8")); /*검색건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(String.valueOf(requestVo.getPageNo()), "UTF-8")); /*페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        response.getWriter().write(sb.toString());			// 응답결과 반환
    }

}
