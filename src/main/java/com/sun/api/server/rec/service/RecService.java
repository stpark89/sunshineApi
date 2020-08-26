package com.sun.api.server.rec.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.sun.api.server.rec.repository.RecRepository;
import com.sun.api.server.vo.RecVo;

import lombok.extern.java.Log;

@Log
@Service
public class RecService {

	@Autowired
	RecRepository recRepository;
	
	public Map<String, Object> lastRecData(){
		Map<String, Object> returnData = new HashMap<>();
		returnData.put("rec", recRepository.findBySearchLastRecData());
		returnData.put("recJeju", recRepository.findBySearchLastJejuRecdData());
		
		
		return returnData;
		
	}
	public void saveRecData (File file)  {
		
		ClassPathResource recFile = new ClassPathResource(file.getParent()+"/"+file.getName());
		//ClassPathResource recFile = new ClassPathResource("data/200820현물속보.xls");
		
		// Rec DATA - 육상
		RecVo recVo = new RecVo();
		RecVo jejuRecVo = new RecVo();
		Sheet worksheet = getSheet(recFile);
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//중복체크
		if(0 < recRepository.findByTradeDateCheck(getCell(worksheet,5,3).getStringCellValue())) {
			log.info("rec data to duplicate");
			System.out.println("rec data to duplicate");
			return;
		}
		
		try {
			recVo.setTradeDate(transFormat.parse("20"+getCell(worksheet,5,3).getStringCellValue().replace("'", "").replace("년", "-").replace("월", "-").replace(" ", "").split("일")[0]));
			recVo.setTradeDateString(getCell(worksheet,5,3).getStringCellValue());
			recVo.setRecAveragePrice(Double.parseDouble(getCell(worksheet,34,2).getStringCellValue().replace(",","")));
			recVo.setRecLowestPrice(Double.parseDouble(getCell(worksheet,35,2).getStringCellValue().trim().split("/")[0].replace(",","")));
			recVo.setRecHighestPrice(Double.parseDouble(getCell(worksheet,35,2).getStringCellValue().trim().split("/")[1].replace(",","")));
			recVo.setPriceDifference(Double.parseDouble(getCell(worksheet,34,2).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,34,12).getStringCellValue().replace(",","")));
			recVo.setTradingVolume(Double.parseDouble(getCell(worksheet,17,17).getStringCellValue().replace(",","")));
			recVo.setSellOrderVolume(Double.parseDouble(getCell(worksheet,17,9).getStringCellValue().replace(",","")));
			recVo.setPurchaseOrderVolume(Double.parseDouble(getCell(worksheet,17,13).getStringCellValue().replace(",","")));
			recVo.setVolumeDifference(Double.parseDouble(getCell(worksheet,17,17).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,20,17).getStringCellValue().replace(",","")));
			recVo.setDivision(0);
			System.out.println(recVo.toString());
			
			recRepository.save(recVo);
			
			jejuRecVo.setTradeDate(transFormat.parse("20"+getCell(worksheet,5,3).getStringCellValue().replace("'", "").replace("년", "-").replace("월", "-").replace(" ", "").split("일")[0]));
			jejuRecVo.setTradeDateString(getCell(worksheet,5,3).getStringCellValue());
			jejuRecVo.setRecAveragePrice(Double.parseDouble(getCell(worksheet,34,8).getStringCellValue().replace(",","")));
			jejuRecVo.setRecLowestPrice(Double.parseDouble(getCell(worksheet,35,8).getStringCellValue().trim().split("/")[0].replace(",","")));
			jejuRecVo.setRecHighestPrice(Double.parseDouble(getCell(worksheet,35,8).getStringCellValue().trim().split("/")[1].replace(",","")));
			jejuRecVo.setPriceDifference(Double.parseDouble(getCell(worksheet,34,8).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,34,16).getStringCellValue().replace(",","")));
			jejuRecVo.setTradingVolume(Double.parseDouble(getCell(worksheet,18,17).getStringCellValue().replace(",","")));
			jejuRecVo.setSellOrderVolume(Double.parseDouble(getCell(worksheet,18,9).getStringCellValue().replace(",","")));
			jejuRecVo.setPurchaseOrderVolume(Double.parseDouble(getCell(worksheet,17,13).getStringCellValue().replace(",","")));
			jejuRecVo.setVolumeDifference(Double.parseDouble(getCell(worksheet,18,17).getStringCellValue().replace(",","")) - Double.parseDouble(getCell(worksheet,21,17).getStringCellValue().replace(",","")));
			jejuRecVo.setDivision(1);
			System.out.println(jejuRecVo.toString());
			recRepository.save(jejuRecVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
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
	
}
