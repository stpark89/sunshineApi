package com.sun.api.server.service;

import com.sun.api.server.vo.RecVo;
import com.sun.api.server.vo.SmpVo;
import lombok.extern.java.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
@Service
public class DataService {

    // Smp Data File - 육상
    private static ClassPathResource smpData = new ClassPathResource("data/timeSmp.xls");

    // Smp Data File
    private static ClassPathResource smpJejuData = new ClassPathResource("data/timeSmpJeju.xls");

    // REC Data File
    private static ClassPathResource recData = new ClassPathResource("data/newRecData.xlsx");
    /**
     * Resource 내부에 있는 Smp 데이터 조회
     * @return
     */
    public Map<String, Object> selectSmpData(){

        log.info("DataService-selectSmpData ");
        Map<String, Object> returnData = new HashMap<>();

        // Smp DATA - 육상
        List<SmpVo> returnSmpList = new ArrayList<>();

        // Smp Data - 제주
        List<SmpVo> returnSmpJejuList = new ArrayList<>();

        // Rec Data
        List<RecVo> returnRecList = new ArrayList<>();

        Sheet worksheet = getSheet();
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4
            Row row = worksheet.getRow(i);
            SmpVo data = new SmpVo();
            data.setTerm(row.getCell(0).getStringCellValue());
            data.setWeightedAverage(row.getCell(27).getNumericCellValue());
            returnSmpList.add(data);
        }
        returnData.put("smp", returnSmpList);

        // 제주 데이터 조회
        Sheet worksheetJeju = getJejuSheet();
        for (int i = 1; i < worksheetJeju.getPhysicalNumberOfRows(); i++) { // 4
            Row row = worksheetJeju.getRow(i);
            SmpVo data = new SmpVo();
            data.setTerm(row.getCell(0).getStringCellValue());
            data.setWeightedAverage(row.getCell(27).getNumericCellValue());
            returnSmpJejuList.add(data);
        }
        returnData.put("smpJeju", returnSmpJejuList);

        // .XlSX 파일 읽기.
        XSSFSheet recWorksheet = getXssFsheet();
        for (int i = 2; i < recWorksheet.getPhysicalNumberOfRows(); i++) { // 4
            Row row = recWorksheet.getRow(i);
            RecVo rec = new RecVo();

            String tmpTerm = Double.toString(row.getCell(0).getNumericCellValue());
            tmpTerm = tmpTerm.substring(0,9).replaceAll("E", "0").replaceAll("\\.", "");

            // 기간
            rec.setTerm(tmpTerm);

            double recValue = row.getCell(2).getNumericCellValue();
            rec.setRecValue(recValue);
            returnRecList.add(rec);
        }
        returnData.put("rec", returnRecList);

        return returnData;
    }

    // .xls
    private Sheet getSheet(){
        Sheet workSheet = null;
        try {
            Workbook workbook = new HSSFWorkbook(smpData.getInputStream());
            workSheet = workbook.getSheetAt(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return workSheet;
    }

    // .xls
    private Sheet getJejuSheet(){
        Sheet workSheet = null;
        try {
            Workbook workbook = new HSSFWorkbook(smpJejuData.getInputStream());
            workSheet = workbook.getSheetAt(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return workSheet;
    }

    // .xlsx
    private XSSFSheet getXssFsheet(){
        XSSFSheet workSheet = null;
        try{

            XSSFWorkbook workbook = new XSSFWorkbook(recData.getInputStream());
            workSheet = workbook.getSheetAt(0);

        }catch (Exception e){
            e.printStackTrace();
        }
        return workSheet;
    }

}
