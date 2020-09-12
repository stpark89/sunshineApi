package com.sun.api.server.inquire.repository;

import com.sun.api.server.inquire.vo.InQuireVo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InQuireRepository extends JpaRepository<InQuireVo, Long> {
	@Query(value = "SELECT * FROM in_quire_vo where inquire_type=:inquireType", nativeQuery = true)
	List<InQuireVo> findInQuireType(@Param("inquireType") String inquireType);
}
