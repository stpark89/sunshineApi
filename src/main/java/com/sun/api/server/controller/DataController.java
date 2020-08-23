package com.sun.api.server.controller;

import com.sun.api.server.vo.*;
import com.sun.api.server.vo.fs.*;
import lombok.extern.java.Log;
import org.osgeo.proj4j.BasicCoordinateTransform;
import org.osgeo.proj4j.CRSFactory;
import org.osgeo.proj4j.CoordinateReferenceSystem;
import org.osgeo.proj4j.ProjCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.api.server.service.DataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.HttpURLConnection;
import javax.xml.xpath.*;


// @CrossOrigin(origins = {"http://116.123.117.59:18280", "http://localhost:8080", "http://localhost:3000", "http://13.124.51.180:8080" })

@Log
@CrossOrigin(origins = "*")
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

        log.info(("ConfmKey - " +confmKey + " // Vo :  " +loadApiVo.toString()));

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
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Fme5h1A7V%2FpidUohmsSaThadKOjWD1uzoovGYVhGtOhwcs5pIMxrOVHuHnBpH0FLspGWQorec8u7o6xAnUaXLQ%3D%3D"); /*Service Key*/
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

    /**
     * 토지 상세 정보 .
     * @param requestVo
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/fetchBsdPrice")
    public void bsdPrice(@RequestBody BsdPriceRequestVo requestVo, HttpServletResponse response) throws Exception{

        log.info("bsdPrice >>>!!!!!!!!!!!!!!!!!!!!");

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1611000/nsdi/StatsIndicatorService/attr/getIndvdLandPrice"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Fme5h1A7V%2FpidUohmsSaThadKOjWD1uzoovGYVhGtOhwcs5pIMxrOVHuHnBpH0FLspGWQorec8u7o6xAnUaXLQ%3D%3D"); /*Service Key*/
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
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream() , "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
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

    @RequestMapping(value="/convertXY")
    public ConvertXYmapVo convertXY (@RequestBody Map<String, String> paramData) {
        log.info("행안부 좌표 x, y -> KaKaoMap 용 좌표 converting >>>");
        log.info(paramData.toString());
        log.info(paramData.get("xPoint"));
        log.info(paramData.get("yPoint"));

        ConvertXYmapVo returnVo = new ConvertXYmapVo();

        double x = Double.parseDouble(paramData.get("xpoint"));//x좌표
        double y = Double.parseDouble(paramData.get("ypoint"));//y좌표

        CRSFactory factory = new CRSFactory();
        CoordinateReferenceSystem srcCrs = factory.createFromName("EPSG:5179");//현재 좌표
        CoordinateReferenceSystem dstCrs = factory.createFromName("EPSG:4326");//변경할 좌표

        BasicCoordinateTransform transform = new BasicCoordinateTransform(srcCrs, dstCrs);

        ProjCoordinate srcCoord = new ProjCoordinate(x, y);
        ProjCoordinate dstCoord = new ProjCoordinate();

        transform.transform(srcCoord, dstCoord);//좌표변환
        System.out.println(dstCoord.x + "," + dstCoord.y);//변환된 좌표

        returnVo.setXPoint(String.valueOf(dstCoord.y));
        returnVo.setYPoint(String.valueOf(dstCoord.x));

        return returnVo;
    }


    /**
     * 발전량
     * @throws Exception
     */
    @RequestMapping(value="/testDisPowerConfig")
    public void testDisPowerConfig() throws Exception{

        String ServiceKey = "Fme5h1A7V%2FpidUohmsSaThadKOjWD1uzoovGYVhGtOhwcs5pIMxrOVHuHnBpH0FLspGWQorec8u7o6xAnUaXLQ%3D%3D";
       //  URLDecoder.decode(ServiceKey, "UTF-8");

        log.info(ServiceKey);
        log.info(URLEncoder.encode(ServiceKey, "UTF-8"));

        log.info("test ----");
        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/dispersedGenerationService/getDispersedGerSearch"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" +URLEncoder.encode(ServiceKey, "UTF-8")); /*Service Key*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("addrDo","UTF-8") + "=" + URLEncoder.encode("전라남도", "UTF-8")); /*시/도*/
        urlBuilder.append("&" + URLEncoder.encode("addrSi","UTF-8") + "=" + URLEncoder.encode("나주시", "UTF-8")); /*시*/
        urlBuilder.append("&" + URLEncoder.encode("addrGu","UTF-8") + "=" + URLEncoder.encode("서구", "UTF-8")); /*구/군*/
        urlBuilder.append("&" + URLEncoder.encode("addrLidong","UTF-8") + "=" + URLEncoder.encode("경현동", "UTF-8")); /*동/면*/
        urlBuilder.append("&" + URLEncoder.encode("AddrLi","UTF-8") + "=" + URLEncoder.encode("석전리", "UTF-8")); /*리*/
        urlBuilder.append("&" + URLEncoder.encode("addrJibun","UTF-8") + "=" + URLEncoder.encode("337-4", "UTF-8")); /*상세번지*/
        urlBuilder.append("&" + URLEncoder.encode("substCd","UTF-8") + "=" + URLEncoder.encode("5063", "UTF-8")); /*변전소코드*/
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
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }

    /**
     * 건축물 대장 서비스 .
     * @param requestVo
     * @throws Exception
     */
    @RequestMapping(value="/fetchBuildingDetailInfo")
    public BuildingDetailResponseVo fetchBuildingDetailInfo(@RequestBody BuildingDetailRequestVo requestVo, HttpServletResponse response) throws Exception{
        log.info("건축물대장 정보 서비스 ");
        log.info(requestVo.toString());

        BuildingDetailResponseVo returnVo = new BuildingDetailResponseVo();

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1611000/BldRgstService/getBrRecapTitleInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Fme5h1A7V%2FpidUohmsSaThadKOjWD1uzoovGYVhGtOhwcs5pIMxrOVHuHnBpH0FLspGWQorec8u7o6xAnUaXLQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("sigunguCd","UTF-8") + "=" + URLEncoder.encode(requestVo.getSigunguCd(), "UTF-8")); /*행정표준코드*/
        urlBuilder.append("&" + URLEncoder.encode("bjdongCd","UTF-8") + "=" + URLEncoder.encode(requestVo.getBjdongCd(), "UTF-8")); /*행정표준코드*/
        urlBuilder.append("&" + URLEncoder.encode("platGbCd","UTF-8") + "=" + URLEncoder.encode(requestVo.getPlatGbCd(), "UTF-8")); /*0:대지 1:산 2:블록*/
        urlBuilder.append("&" + URLEncoder.encode("bun","UTF-8") + "=" + URLEncoder.encode(requestVo.getBun(), "UTF-8")); /*번*/
        urlBuilder.append("&" + URLEncoder.encode("ji","UTF-8") + "=" + URLEncoder.encode(requestVo.getJi(), "UTF-8")); /*지*/
   
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
            sb.append(line + "\n");
        }

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

        XPathExpression expr = xpath.compile("//response/body/items/item");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);


        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();

            for (int j = 0; j < child.getLength(); j++) {
                log.info("여기 두번째 포문 들어오나 ================");
                Node node = child.item(j);


                if(node.getNodeType() == Node.ELEMENT_NODE){
                    // 법정 동명
                    if(node.getNodeName().equals("archArea")){
                        log.info("archArea 일떄 ?? " +node.getTextContent());
                        returnVo.setArchArea(Double.parseDouble(node.getTextContent()));
                    }

                    if(node.getNodeName().equals("bcRat")){
                        log.info("bcRat 일떄 ?? " +node.getTextContent());
                        returnVo.setBcRat(Double.parseDouble(node.getTextContent()));
                    }

                    if(node.getNodeName().equals("totArea")){
                        log.info("totArea 일떄 ?? " +node.getTextContent());
                        returnVo.setTotArea(Double.parseDouble(node.getTextContent()));
                    }

                    if(node.getNodeName().equals("vlRat")){
                        log.info("vlRat 일떄 ?? " +node.getTextContent());
                        returnVo.setVlRat(Double.parseDouble(node.getTextContent()));
                    }

                    if(node.getNodeName().equals("etcPurps")){
                        returnVo.setEtcPurps(node.getTextContent());
                    }

                    // 건축물명
                    if(node.getNodeName().equals("bldNm")){
                        returnVo.setBldNm(node.getTextContent());
                    }

                }	// for end
            }
        }

        log.info("최종 결과 확인 ----->>");
        log.info(returnVo.toString());

        rd.close();
        conn.disconnect();
        return returnVo;
    }

    /**
     * 한국전력공사 분산전원 연계정보
     * @param requestVo
     * @throws Exception
     */
    @RequestMapping(value="/fetchFsStrategicInformation")
    public List<StrategicInformationResponseVo> fetchFsStrategicInformation(@RequestBody StrategicInformationRequestVo requestVo) throws Exception{
        log.info("fetchFsStrategicInformation");

        List<StrategicInformationResponseVo> returnData = new ArrayList<StrategicInformationResponseVo>();

        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/dispersedGenerationService/getDispersedGerSearch"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Fme5h1A7V%2FpidUohmsSaThadKOjWD1uzoovGYVhGtOhwcs5pIMxrOVHuHnBpH0FLspGWQorec8u7o6xAnUaXLQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(String.valueOf(requestVo.getPageNo()), "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(String.valueOf(requestVo.getNumOfRows()), "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("addrDo","UTF-8") + "=" + URLEncoder.encode(requestVo.getAddrDo(), "UTF-8")); /*시/도*/
        urlBuilder.append("&" + URLEncoder.encode("addrSi","UTF-8") + "=" + URLEncoder.encode(requestVo.getAddrSi(), "UTF-8")); /*시*/
        urlBuilder.append("&" + URLEncoder.encode("addrGu","UTF-8") + "=" + URLEncoder.encode(requestVo.getAddrGu(), "UTF-8")); /*구/군*/
        urlBuilder.append("&" + URLEncoder.encode("addrLidong","UTF-8") + "=" + URLEncoder.encode(requestVo.getAddrLidong(), "UTF-8")); /*동/면*/
        urlBuilder.append("&" + URLEncoder.encode("AddrLi","UTF-8") + "=" + URLEncoder.encode(requestVo.getAddrLi(), "UTF-8")); /*리*/
        urlBuilder.append("&" + URLEncoder.encode("addrJibun","UTF-8") + "=" + URLEncoder.encode(requestVo.getAddrJibun(), "UTF-8")); /*상세번지*/
        urlBuilder.append("&" + URLEncoder.encode("substCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*변전소코드*/
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

        XPathExpression expr = xpath.compile("//response/body/items/item");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        System.out.println("처음 리턴 데이터 렝스 확인중 -------");
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();
            StrategicInformationResponseVo returnVo = new StrategicInformationResponseVo();
            for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);

                System.out.println("node.getTextContent() == 약; 버ㅣ애힘/"+node.getTextContent());

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    // 발전소
                    if (node.getNodeName().equals("substNm")) {
                        returnVo.setSubstNm(node.getTextContent());
                    }

                    // 변전소 여유용량
                    if (node.getNodeName().equals("vol_1")) {
                        returnVo.setVol_2(node.getTextContent());
                    }

                    if (node.getNodeName().equals("vol_2")) {
                        returnVo.setVol_3(node.getTextContent());
                    }

                    if (node.getNodeName().equals("vol_3")) {
                        returnVo.setVol_1(node.getTextContent());
                    }

                    // 변전소 누적연계용량
                    if (node.getNodeName().equals("substPwr")) {
                        returnVo.setSubstPwr(node.getTextContent());
                    }

                    // 변압기 누적연계용량
                    if (node.getNodeName().equals("mtrPwr")) {
                        returnVo.setMtrPwr(node.getTextContent());
                    }

                    // Dl
                    if (node.getNodeName().equals("dlNm")) {
                        returnVo.setDlNm(node.getTextContent());
                    }

                    // DL누적연계용량
                    if (node.getNodeName().equals("dlPwr")) {
                        returnVo.setDlPwr(node.getTextContent());
                    }
                }
            }

            returnData.add(returnVo);
        }

        for(int i =0; i < returnData.size() ; i++){
            System.out.println(returnData.get(i).toString());
        }

        rd.close();
        conn.disconnect();
        return returnData;
    }

}
