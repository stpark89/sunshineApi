package com.sun.api.server.admin.service;

import com.sun.api.server.admin.repository.AdminRepository;
import com.sun.api.server.admin.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
