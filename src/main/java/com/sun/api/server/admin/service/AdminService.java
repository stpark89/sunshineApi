package com.sun.api.server.admin.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sun.api.server.admin.repository.AdminRepository;
import com.sun.api.server.admin.vo.AdminUserVo;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    /**
     * 관리자 로그인
     * @param adminUserVo
     * @return
     */
    public AdminUserVo fetchLoginUserInfo(AdminUserVo adminUserVo){
       String userId = adminUserVo.getUserId();
       String userPwd = adminUserVo.getUserPwd();

       return adminRepository.fetchLoginUserInfo(userId, userPwd);
    }
    
    public void saveFiole(MultipartFile file, String directoryPath) throws IOException {
    	//directoryPath = "/home";
    	// parent directory를 찾는다.
    	Path directory = Paths.get(directoryPath).toAbsolutePath().normalize();

    	// directory 해당 경로까지 디렉토리를 모두 만든다.
    	Files.createDirectories(directory);
        
    	// 파일명을 바르게 수정한다.
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    	// 파일명에 '..' 문자가 들어 있다면 오류를 발생하고 아니라면 진행(해킹및 오류방지)
    	Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
    	// 파일을 저장할 경로를 Path 객체로 받는다.
    	Path targetPath = directory.resolve(fileName).normalize();

    	// 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
    	Assert.state(!Files.exists(targetPath), fileName + " File alerdy exists.");
    	file.transferTo(targetPath);
    }
    
    public void deleteFolder(String directoryPath) throws IOException {
    	File folder = new File(directoryPath);
    	try {
    	    while(folder.exists()) {
    		File[] folder_list = folder.listFiles(); //파일리스트 얻어오기
    				
    		for (int j = 0; j < folder_list.length; j++) {
    			folder_list[j].delete(); //파일 삭제 
    			System.out.println("파일이 삭제되었습니다.");
    					
    		}
    				
    		if(folder_list.length == 0 && folder.isDirectory()){ 
    			folder.delete(); //대상폴더 삭제
    			System.out.println("폴더가 삭제되었습니다.");
    		}
                }
    	 } catch (Exception e) {
    		e.getStackTrace();
    	}
    }

}
