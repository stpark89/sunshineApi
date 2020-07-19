package com.sun.api.server.service;

import com.sun.api.server.vo.RecVo;
import com.sun.api.server.vo.SmpVo;
import lombok.extern.java.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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

	// Rec Data File - 육상
	private static ClassPathResource recXls = new ClassPathResource("data/rec.xls");


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

		Sheet worksheet = getSheet(smpData);
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
			rec.setRecAveragePrice(recValue);
			returnRecList.add(rec);
		}
		returnData.put("rec", returnRecList);

		return returnData;
	}

	// .xls
	private Sheet getSheet(ClassPathResource classPathResource){
		Sheet workSheet = null;
		try {
			Workbook workbook = new HSSFWorkbook(classPathResource.getInputStream());
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

	public Cell getCell(Sheet sheet, int rownum, int cellnum) {
		Row row = getRow(sheet, rownum);
		return getCell(row, cellnum);
	}

	public Row getRow(Sheet sheet, int rownum) {
		Row row = sheet.getRow(rownum);
		if (row == null) {
			row = sheet.createRow(rownum);
		}
		return row;
	}
	public Cell getCell(Row row, int cellnum) {
		Cell cell = row.getCell(cellnum);
		if (cell == null) {
			cell = row.createCell(cellnum);
		}
		return cell;
	}


	/**
	 * Resource 내부에 있는 Rec 데이터 조회
	 * @return
	 */
	public Map<String, Object> selectRecData() {
		log.info("DataService-selectRecData ");
		Map<String, Object> returnData = new HashMap<>();

		// Rec DATA - 육상
		RecVo returnRec = new RecVo();

		// Rec Data - 제주
		RecVo returnRecJeju = new RecVo();

		Sheet worksheet = getSheet(recXls);

//		System.out.println(getCell(worksheet,34,2).getStringCellValue());
//		System.out.println(getCell(worksheet,35,2).getStringCellValue());
//		System.out.println(getCell(worksheet,34,12).getStringCellValue());
//		System.out.println(getCell(worksheet,17,17).getStringCellValue());
//		System.out.println(getCell(worksheet,17,9).getStringCellValue());
//		System.out.println(getCell(worksheet,17,13).getStringCellValue());		
//		System.out.println(getCell(worksheet,20,17).getStringCellValue());
		
		returnRec.setRecAveragePrice(Double.parseDouble(getCell(worksheet,34,2).getStringCellValue().replace(",","")));
		returnRec.setRecLowestPrice(Double.parseDouble(getCell(worksheet,35,2).getStringCellValue().trim().split("/")[0].replace(",","")));
		returnRec.setRecHighestPrice(Double.parseDouble(getCell(worksheet,35,2).getStringCellValue().trim().split("/")[1].replace(",","")));
		returnRec.setPriceDifference(Double.parseDouble(getCell(worksheet,34,2).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,34,12).getStringCellValue().replace(",","")));
		returnRec.setTradingVolume(Double.parseDouble(getCell(worksheet,17,17).getStringCellValue().replace(",","")));
		returnRec.setSellOrderVolume(Double.parseDouble(getCell(worksheet,17,9).getStringCellValue().replace(",","")));
		returnRec.setPurchaseOrderVolume(Double.parseDouble(getCell(worksheet,17,13).getStringCellValue().replace(",","")));
		System.out.println(getCell(worksheet,20,15).getStringCellValue());
		returnRec.setPriceDifference(Double.parseDouble(getCell(worksheet,17,17).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,20,17).getStringCellValue().replace(",","")));
		
//		System.out.println(getCell(worksheet,34,8).getStringCellValue());
//		System.out.println(getCell(worksheet,35,8).getStringCellValue());
//		System.out.println(getCell(worksheet,34,17).getStringCellValue());		
//		System.out.println(getCell(worksheet,18,17).getStringCellValue());
//		System.out.println(getCell(worksheet,18,9).getStringCellValue());
//		System.out.println(getCell(worksheet,17,14).getStringCellValue());
//		System.out.println(getCell(worksheet,21,17).getStringCellValue());
		
		returnRecJeju.setRecAveragePrice(Double.parseDouble(getCell(worksheet,34,8).getStringCellValue().replace(",","")));
		returnRecJeju.setRecLowestPrice(Double.parseDouble(getCell(worksheet,35,8).getStringCellValue().trim().split("/")[0].replace(",","")));
		returnRecJeju.setRecHighestPrice(Double.parseDouble(getCell(worksheet,35,8).getStringCellValue().trim().split("/")[1].replace(",","")));
		//returnRecJeju.setPriceDifference(Double.parseDouble(getCell(worksheet,34,8).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,34,17).getStringCellValue().replace(",","")));
		returnRecJeju.setTradingVolume(Double.parseDouble(getCell(worksheet,18,17).getStringCellValue().replace(",","")));
		returnRecJeju.setSellOrderVolume(Double.parseDouble(getCell(worksheet,18,9).getStringCellValue().replace(",","")));
		returnRecJeju.setPurchaseOrderVolume(Double.parseDouble(getCell(worksheet,17,13).getStringCellValue().replace(",","")));
		returnRecJeju.setPriceDifference(Double.parseDouble(getCell(worksheet,18,17).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,21,17).getStringCellValue().replace(",","")));
		
		System.out.println(returnRec.toString());
		System.out.println(returnRecJeju.toString());
		
		//육상데이터
		
		returnData.put("rec", returnRec);
		returnData.put("recJeju", returnRecJeju);


		return returnData;
	}

}
