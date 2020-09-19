package com.sun.api.server.rec.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.api.server.rec.repository.SmpRepository;
import com.sun.api.server.vo.SmpVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.sun.api.server.rec.repository.RecRepository;
import com.sun.api.server.vo.RecVo;

import lombok.extern.java.Log;
import org.springframework.web.multipart.MultipartFile;

@Log
@Service
public class RecService {

	@Autowired
	RecRepository recRepository;

	@Autowired
	private SmpRepository smpRepository;

	public Map<String, Object> findRecData(){
		Map<String, Object> returnData = new HashMap<>();
		returnData.put("rec", recRepository.findBySearchRecData());
		returnData.put("recJeju", recRepository.findBySearchJejuRecdData());
		
		
		return returnData;
		
	}
	
	public Map<String, Object> finLastRecData(){
		Map<String, Object> returnData = new HashMap<>();
		returnData.put("rec", recRepository.findBySearchLastRecData());
		returnData.put("recJeju", recRepository.findBySearchLastJejuRecdData());
		
		
		return returnData;
		
	}

	public void saveRecData (MultipartFile file, String originalFileName)  {


		log.info("Service ---");

		// Rec DATA - 육상
		RecVo recVo = new RecVo();
		RecVo jejuRecVo = new RecVo();
		Sheet worksheet = getSheet(file);
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

	public void saveSmpData (MultipartFile file, int division)  {

		XSSFSheet sheet = getXlsxSheet(file);
		List<SmpVo> smpVoList = new ArrayList<>();

		int rowindex=0;
		int columnindex=0;
		int rows=sheet.getPhysicalNumberOfRows();
		for(rowindex=1;rowindex<rows;rowindex++){
			//행을읽는다
			XSSFRow row=sheet.getRow(rowindex);
			if(row !=null){

				SmpVo smpVo = new SmpVo();

				//셀의 수
				int cells=row.getPhysicalNumberOfCells();
				for(columnindex=0;columnindex<=cells;columnindex++){

					if(columnindex == 0) {
						//셀값을 읽는다
						XSSFCell cell=row.getCell(columnindex);
						String value="";
						//셀이 빈값일경우를 위한 널체크
						if(cell==null){
							continue;
						}else{
							smpVo.setTerm(cell.getStringCellValue().replaceAll("/", "-"));
						}

					}else if(columnindex == 27){
						//셀값을 읽는다
						XSSFCell cell=row.getCell(columnindex);
						String value="";
						//셀이 빈값일경우를 위한 널체크
						if(cell==null){
							continue;
						}else{
							smpVo.setWeightedAverage(cell.getNumericCellValue());
						}
					}

					smpVo.setDivision(division);
					smpVoList.add(smpVo);
				}
			}
		}
		smpRepository.saveAll(smpVoList);
	}
	
	public Map<String, Object> findIndicators(){
		
		Map<String, Object> returnData = new HashMap<>();
		returnData.put("indicators", recRepository.findIndicators());
		returnData.put("jejuIndicators", recRepository.findJejuIndicators());
		
		return returnData;
	}

	private XSSFSheet getXlsxSheet(MultipartFile file){

		XSSFSheet sheet = null;
		try{
			XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
			sheet=workbook.getSheetAt(0);
		}catch (Exception e){
			e.printStackTrace();
		}
		return sheet;
	}
	
	private Sheet getSheet(MultipartFile file){
		Sheet workSheet = null;
		try {

			System.out.println("확인중 ----");
			System.out.println(file.getOriginalFilename().toString());
			Workbook workbook = new HSSFWorkbook(file.getInputStream());
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
