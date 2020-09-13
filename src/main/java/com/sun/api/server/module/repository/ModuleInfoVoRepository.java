package com.sun.api.server.module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sun.api.server.vo.module.ModuleInfoVo;

public interface ModuleInfoVoRepository extends JpaRepository<ModuleInfoVo, Long>{
	
	@Query(value = "select * from module_info_vo group by manufacturer, product_name", nativeQuery = true)
	List<ModuleInfoVo> findByModuleGroup();
}
