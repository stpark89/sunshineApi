package com.sun.api.server.admin.repository;

import com.sun.api.server.admin.vo.AdminUserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<AdminUserVo, Long> {

    @Query(value = "SELECT * FROM admin_user_vo WHERE user_id =:userId AND user_pwd =:userPwd", nativeQuery = true)
    AdminUserVo fetchLoginUserInfo(@Param("userId") String userId, @Param("userPwd") String userPwd);

}
